package com.caglayan.staffservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Staff {
    @Id
    private long id;
    private String name;
    private String lastName;
    private long departmentId;
}
