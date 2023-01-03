package ru.fazlyev.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    private int id;

    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 symbols")
    private String name;

    @Min(value = 0, message = "Age should be greater than 0!")
    private int age;

    @NotEmpty(message = "Email should not be empty!")
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}",message = "Your address should be in this format: Country, City, Postal Code (6 digits)")
    private String address;

}
