package ru.fazlyev.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    private int id;

    @NotEmpty
    @Size(min = 2,max = 30,message = "Name should be between 2 and 30 symbols")
    private String name;

    @Min(value = 0, message = "Age should be greater than 0!")
    private int age;

    @NotEmpty(message = "Email should not be empty!")
    @Email(message = "Email should be valid")
    private String email;
     
}
