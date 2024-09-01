package com.docker_spring_cloud.team_management.model;

public class TeamDTO {
    
    private String id;
    private String name;

    public TeamDTO() {
    }

    public TeamDTO(String id, String name, String teamId) {
        this.id = id;
        this.name = name;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
