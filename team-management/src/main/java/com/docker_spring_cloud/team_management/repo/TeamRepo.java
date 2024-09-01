package com.docker_spring_cloud.team_management.repo;

import com.docker_spring_cloud.team_management.entity.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepo extends MongoRepository<Team, String> {
}
