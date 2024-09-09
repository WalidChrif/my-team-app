package com.docker_spring_cloud.player_management.model;

public class PlayerDTO {
    
    private String id;
    private String name;
    private int jerseyNumber;
    private String teamId;

    public PlayerDTO() {
    }

    public PlayerDTO(String id, String name, int jerseyNumber, String teamId) {
        this.id = id;
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.teamId = teamId;
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

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "PlayerDTOSTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", jerseyNumber=" + jerseyNumber +
                ", teamId='" + teamId + '\'' +
                '}';
    }
}
