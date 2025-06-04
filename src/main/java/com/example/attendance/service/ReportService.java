package com.example.attendance.service;

import com.example.attendance.entity.Attendance;
import com.example.attendance.repository.AttendanceRepository;
import com.example.attendance.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final AttendanceRepository attendanceRepo;
    private final EmployeeRepository employeeRepo;

    public Map<String, Long> getEmployeeReport(Long id) {
        List<Attendance> records = attendanceRepo.findByEmployeeId(id);
        return records.stream()
                .collect(Collectors.groupingBy(a -> a.getStatus().name(), Collectors.counting()));
    }

    public Map<String, Object> getDepartmentReport(String dept) {
        var employees = employeeRepo.findAll().stream().filter(e -> e.getDepartment().equalsIgnoreCase(dept)).toList();
        Map<String, Object> result = new HashMap<>();
        for (var emp : employees) {
            result.put(emp.getName(), getEmployeeReport(emp.getEmployeeId()));
        }
        return result;
    }
}
