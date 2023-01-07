package ru.fazlyev.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    private Integer id;

    @NotEmpty(message = "Name cannot be empty.")
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, [A-Z]\\w+", message = "Full name should be in this format: lastname, firstname, patronymic")
    private String full_name;

    @Size(min = 4, max = 4, message = "wrong input,size of year should be 4 digits")
    private int year;
}
