package com.caglayan.departmentservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    private long id;
    private String name;
    private long cityId;
}
