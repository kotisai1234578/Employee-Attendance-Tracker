package com.example.attendance.dto;


import com.example.attendance.entity.Attendance.Status;
import lombok.*;

@Data
public class AttendanceDto {
    private Long employeeId;
    private Status status;
}
