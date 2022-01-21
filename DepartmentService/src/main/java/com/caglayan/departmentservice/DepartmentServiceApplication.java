package com.caglayan.departmentservice;

import com.caglayan.departmentservice.entity.Department;
import com.caglayan.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DepartmentServiceApplication implements CommandLineRunner {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentServiceApplication(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        departmentService.insertDepartment(new Department(110L, "Bilgi İşlem", 1001L));
        departmentService.insertDepartment(new Department(120L, "Satış", 1002L));
        departmentService.insertDepartment(new Department(130L, "Pazarlama", 1002L));
        departmentService.insertDepartment(new Department(140L, "Operasyon", 1001L));
        departmentService.insertDepartment(new Department(150L, "İnsan Kaynakları", 1002L));
        departmentService.insertDepartment(new Department(160L, "Lojistik", 1003L));
    }
}
