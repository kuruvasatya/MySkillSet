package com.learning.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeRequest {
    @NotBlank(message = "Name can not be blank")
    String name;
    @Min(value = 18, message = "Required minimum age is 18")
    @Max(value = 45, message = "Maximum age elgigble is 45")
    int age;
    @Email(message = "Invalid email provided")
    String email;
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).+$", message = "password should contain atleast one number and one alphabet")
    String password;
}
