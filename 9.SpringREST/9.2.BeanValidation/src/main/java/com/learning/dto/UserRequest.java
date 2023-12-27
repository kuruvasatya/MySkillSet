package com.learning.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = "User name cannot be blank")
    String name;
    @Email(message = "Invalid email id!")
    String email;
    @Min(value = 18, message = "Min age required is 18")
    @Max(value = 86, message = "max age required is 86")
    int age;
}
