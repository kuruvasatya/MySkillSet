package com.learning.service;

import com.learning.dao.EmployeeRepository;
import com.learning.dto.EmployeeRequest;
import com.learning.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> findEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(EmployeeRequest request) {
        int randomInt = new Random().nextInt(1, 100);
        if(randomInt %3 == 0) {
            throw new CannotGetJdbcConnectionException("DB overloaded!");
        } else {
            Employee emp = new Employee(0, request.getName(), "dept" + randomInt, request.getAge(), request.getEmail(), request.getName()+randomInt+"@ms.com", request.getPassword());
            return employeeRepository.save(emp);
        }
    }
}
