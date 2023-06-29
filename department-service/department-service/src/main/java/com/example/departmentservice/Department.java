package com.example.departmentservice;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
