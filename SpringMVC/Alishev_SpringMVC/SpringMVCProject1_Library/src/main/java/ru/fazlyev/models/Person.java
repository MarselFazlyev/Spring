package ru.fazlyev.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    private Integer id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2,max = 100,message = "Имя должно быть от 2 до 100 символов длиной")
    private String full_name;

    @Min(value = 1900,message = "Год рождения должен быьб больше, чем 1900")
    private int year;
}
