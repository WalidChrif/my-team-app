package com.docker_spring_cloud.player_management.repo;

import com.docker_spring_cloud.player_management.entity.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepo extends MongoRepository<Player, String> {
}
