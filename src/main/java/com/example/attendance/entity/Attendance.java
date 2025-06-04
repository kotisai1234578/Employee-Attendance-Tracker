package com.example.attendance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    private Long employeeId;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PRESENT, ABSENT
    }
}
