package com.docker_spring_cloud.player_management.mapper;

import com.docker_spring_cloud.player_management.entity.Player;
import com.docker_spring_cloud.player_management.model.PlayerDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerMapper {

        public Player convertToEntity(PlayerDTO playerDTO) {

            if (playerDTO == null) {
                return null;
            }
            Player thePlayer = new Player();
            if (playerDTO.getId() != null){
                thePlayer.setId(playerDTO.getId());
            }
            thePlayer.setName(playerDTO.getName());
            thePlayer.setTeamId(playerDTO.getTeamId());
            thePlayer.setJerseyNumber(playerDTO.getJerseyNumber());
            return thePlayer;
        }

        public PlayerDTO convertToDTO(Player player) {
            if (player == null) {
                return null;
            }
            PlayerDTO thePlayer = new PlayerDTO();
            thePlayer.setId(player.getId());
            thePlayer.setName(player.getName());
            thePlayer.setTeamId(player.getTeamId());
            thePlayer.setJerseyNumber(player.getJerseyNumber());
            return thePlayer;
        }

        public List<PlayerDTO> convertToDTOs(List<Player> players) {
            return players.stream()
//                .map(player -> convertToDTO(player))
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }
    }