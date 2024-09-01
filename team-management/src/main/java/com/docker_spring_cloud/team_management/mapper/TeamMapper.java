package com.docker_spring_cloud.team_management.mapper;

import com.docker_spring_cloud.team_management.entity.Team;
import com.docker_spring_cloud.team_management.model.TeamDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamMapper {

        public Team convertToEntity(TeamDTO teamDTO) {

            if (teamDTO == null) {
                return null;
            }
            Team theTeam = new Team();
            if (teamDTO.getId() != null){
                theTeam.setId(teamDTO.getId());
            }
            theTeam.setName(teamDTO.getName());

            return theTeam;
        }

        public TeamDTO convertToDTO(Team team) {
            if (team == null) {
                return null;
            }
            TeamDTO theTeam = new TeamDTO();
            theTeam.setId(team.getId());
            theTeam.setName(team.getName());
            return theTeam;
        }

        public List<TeamDTO> convertToDTOs(List<Team> teams) {
            return teams.stream()
//                .map(team -> convertToDTO(team))
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }
    }