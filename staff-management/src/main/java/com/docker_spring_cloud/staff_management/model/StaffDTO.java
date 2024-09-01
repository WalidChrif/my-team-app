package com.docker_spring_cloud.staff_management.model;

public class StaffDTO {
    
    private Long id;
    private String name;
    private String job;
    private String teamId;

    public StaffDTO() {
    }

    public StaffDTO(Long id, String name, String job, String teamId) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.teamId = teamId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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
                ", job=" + job +
                ", teamId='" + teamId + '\'' +
                '}';
    }
}
