package com.caglayan.staffservice.repository;

import com.caglayan.staffservice.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
