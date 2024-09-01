package com.docker_spring_cloud.player_management.controller;

import com.docker_spring_cloud.player_management.mapper.PlayerMapper;
import com.docker_spring_cloud.player_management.model.PlayerDTO;
import com.docker_spring_cloud.player_management.repo.PlayerRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

    private final PlayerRepo playerRepo;
    private final PlayerMapper playerMapper;

    public PlayerController(PlayerRepo playerRepo, PlayerMapper playerMapper) {
        this.playerRepo = playerRepo;
        this.playerMapper = playerMapper;
    }

    @GetMapping
    public List<PlayerDTO> findAllPlayers() {
        return playerMapper.convertToDTOs(playerRepo.findAll());
    }

    @GetMapping("/{id}")
    public PlayerDTO findPlayerById(@PathVariable String id) {
        return playerMapper.convertToDTO(playerRepo.findById(id).orElseThrow(() -> new RuntimeException("Player not found")));
    }

    @PostMapping
    public PlayerDTO addPlayer(@RequestBody PlayerDTO playerDTO) {
        return playerMapper.convertToDTO(playerRepo.save(playerMapper.convertToEntity(playerDTO)));
    }

}
