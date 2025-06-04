package com.example.attendance.service;

import com.example.attendance.dto.AttendanceDto;
import com.example.attendance.entity.Attendance;
import com.example.attendance.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public ResponseEntity<?> markAttendance(AttendanceDto dto) {
        if (attendanceRepository.findByEmployeeIdAndDate(dto.getEmployeeId(), LocalDate.now()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already marked");
        }
        Attendance attendance = new Attendance(null, dto.getEmployeeId(), LocalDate.now(), dto.getStatus());
        return ResponseEntity.ok(attendanceRepository.save(attendance));
    }
}
