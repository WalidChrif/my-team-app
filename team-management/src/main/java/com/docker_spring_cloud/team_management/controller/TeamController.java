package com.docker_spring_cloud.team_management.controller;


import com.docker_spring_cloud.team_management.entity.Team;
import com.docker_spring_cloud.team_management.mapper.TeamMapper;
import com.docker_spring_cloud.team_management.model.TeamDTO;
import com.docker_spring_cloud.team_management.repo.TeamRepo;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

    private final TeamRepo teamRepo;
    private final TeamMapper teamMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public TeamController(TeamRepo teamRepo, TeamMapper teamMapper, KafkaTemplate<String, String> kafkaTemplate) {
        this.teamRepo = teamRepo;
        this.teamMapper = teamMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping
    public List<TeamDTO> findAllTeams() {
        kafkaTemplate.send("notificationTopic", "Notification: retrieving teams...");
        if (teamRepo.findAll().isEmpty()){
            throw new RuntimeException("No teams were found");
        }
        return teamMapper.convertToDTOs(teamRepo.findAll());
    }

    @GetMapping("/{id}")
    public TeamDTO findTeamById(@PathVariable String id) {
        return teamMapper.convertToDTO(teamRepo.findById(id).orElseThrow(() -> new RuntimeException("Team not found")));
    }

    @PostMapping
    public TeamDTO addTeam(@RequestBody TeamDTO teamDTO) {
        return teamMapper.convertToDTO(teamRepo.save(teamMapper.convertToEntity(teamDTO)));
    }

}
