package com.learning.dto;

import com.learning.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    String name;
    String email;
    String dept;

    public EmployeeResponse(Employee employee) {
        this.name = employee.getName();
        this.email = employee.getCompEmail();
        this.dept = employee.getDept();
    }
}
