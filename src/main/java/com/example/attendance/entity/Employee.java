package com.example.attendance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private Long employeeId;

    private String name;
    private String department;
    private String designation;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        EMPLOYEE, MANAGER
    }
}
