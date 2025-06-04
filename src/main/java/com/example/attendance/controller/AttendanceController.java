package com.example.attendance.controller;
import com.example.attendance.dto.AttendanceDto;
import com.example.attendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/mark")
    public ResponseEntity<?> mark(@RequestBody AttendanceDto dto) {
        return attendanceService.markAttendance(dto);
    }
}

