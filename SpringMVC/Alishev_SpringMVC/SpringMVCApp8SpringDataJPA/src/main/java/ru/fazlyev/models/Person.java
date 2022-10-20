package ru.fazlyev.models;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Person1")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 symbols")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Age should be greater than 0!")
    @Column(name = "age")
    private Integer age;

    @NotEmpty(message = "Email should not be empty!")
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

}
