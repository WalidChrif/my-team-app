package com.docker_spring_cloud.staff_management.mapper;


import com.docker_spring_cloud.staff_management.entity.Staff;
import com.docker_spring_cloud.staff_management.model.StaffDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StaffMapper {

        public Staff convertToEntity(StaffDTO staffDTO) {
            if (staffDTO == null) {
                return null;
            }
            Staff theStaff = new Staff();
            if (staffDTO.getId() != null){
                theStaff.setId(staffDTO.getId());
            }
            theStaff.setName(staffDTO.getName());
            theStaff.setTeamId(staffDTO.getTeamId());
            theStaff.setJob(staffDTO.getJob());
            return theStaff;
        }

        public StaffDTO convertToDTO(Staff staff) {
            if (staff == null) {
                return null;
            }
            StaffDTO theStaff = new StaffDTO();
            theStaff.setId(staff.getId());
            theStaff.setName(staff.getName());
            theStaff.setTeamId(staff.getTeamId());
            theStaff.setJob(staff.getJob());
            return theStaff;
        }

        public List<StaffDTO> convertToDTOs(List<Staff> staffs) {
            return staffs.stream()
//                .map(staff -> convertToDTO(staff))
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }
    }