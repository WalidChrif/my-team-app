package com.docker_spring_cloud.staff_management.controller;

import com.docker_spring_cloud.staff_management.mapper.StaffMapper;
import com.docker_spring_cloud.staff_management.model.StaffDTO;
import com.docker_spring_cloud.staff_management.repo.StaffRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {

    private final StaffRepo staffRepo;
    private final StaffMapper staffMapper;

    public StaffController(StaffRepo staffRepo, StaffMapper staffMapper) {
        this.staffRepo = staffRepo;
        this.staffMapper = staffMapper;
    }

    @GetMapping
    public List<StaffDTO> findAllStaff() {
        if ((staffMapper.convertToDTOs(staffRepo.findAll()).isEmpty())){
            throw new RuntimeException("No Staff was found");
        }
        return staffMapper.convertToDTOs(staffRepo.findAll());
    }

    @GetMapping("/{id}")
    public StaffDTO findStaffById(@PathVariable Long id) {
        return staffMapper.convertToDTO(staffRepo.findById(id).orElseThrow(() -> new RuntimeException("Staff not found")));
    }

    @PostMapping
    public StaffDTO addStaff(@RequestBody StaffDTO staffDTO) {
        return staffMapper.convertToDTO(staffRepo.save(staffMapper.convertToEntity(staffDTO)));
    }

}
