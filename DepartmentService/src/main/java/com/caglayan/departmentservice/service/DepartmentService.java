package com.caglayan.departmentservice.service;

import com.caglayan.departmentservice.entity.Department;
import com.caglayan.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department insertDepartment(Department department){
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(long id){
        return departmentRepository.findById(id).orElse(new Department());
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
}
