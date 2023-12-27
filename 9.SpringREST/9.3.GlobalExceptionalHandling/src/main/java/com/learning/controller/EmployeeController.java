package com.learning.controller;

import com.learning.dao.EmployeeRepository;
import com.learning.dto.EmployeeRequest;
import com.learning.dto.EmployeeResponse;
import com.learning.entity.Employee;
import com.learning.exceptions.EmployeeNotFoundException;
import com.learning.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/api/v1/employees/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int id) {
        return employeeService.findEmployeeById(id)
                .map(employee -> ResponseEntity.status(HttpStatus.OK).body(new EmployeeResponse(employee)))
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping("/api/v1/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid EmployeeRequest request)  {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(request));
    }
}
