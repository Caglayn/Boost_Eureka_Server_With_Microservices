package com.caglayan.staffservice.service;

import com.caglayan.staffservice.entity.Staff;
import com.caglayan.staffservice.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Staff getStaffById(long id){
        return staffRepository.findById(id).orElse(new Staff());
    }

    public List<Staff> getAllStaff(){
        return staffRepository.findAll();
    }
}
