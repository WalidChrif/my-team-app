package com.docker_spring_cloud.staff_management.repo;

import com.docker_spring_cloud.staff_management.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo extends JpaRepository<Staff, Long> {
}
