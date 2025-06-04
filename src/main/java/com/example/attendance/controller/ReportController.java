package com.example.attendance.controller;

//package com.attendance.controller;

import com.example.attendance.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeeReport(@PathVariable Long id) {
        return ResponseEntity.ok(reportService.getEmployeeReport(id));
    }

    @GetMapping("/department/{name}")
    public ResponseEntity<?> getDepartmentReport(@PathVariable String name) {
        return ResponseEntity.ok(reportService.getDepartmentReport(name));
    }
}

