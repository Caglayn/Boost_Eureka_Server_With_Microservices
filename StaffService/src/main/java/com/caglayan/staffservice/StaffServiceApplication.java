package com.caglayan.staffservice;

import com.caglayan.staffservice.entity.Staff;
import com.caglayan.staffservice.repository.StaffRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StaffServiceApplication implements CommandLineRunner {

    private final StaffRepository staffRepository;

    public StaffServiceApplication(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(StaffServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        staffRepository.save(new Staff(10001L,"Ali","Can",110L));
        staffRepository.save(new Staff(10002L,"Veli","Can",120L));
        staffRepository.save(new Staff(10003L,"Hasan","Can",140L));
        staffRepository.save(new Staff(10004L,"Hüseyin","Can",150L));
        staffRepository.save(new Staff(10005L,"Osman","Can",130L));
    }
}
