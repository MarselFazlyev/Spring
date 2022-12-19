package ru.fazlyev.FirstSecurityApp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="Person")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "username")
    private String userName;

    @Column(name = "year_of_birth")
    private  Integer year_of_birth;

    @Column(name = "password")
    private String password;
}
