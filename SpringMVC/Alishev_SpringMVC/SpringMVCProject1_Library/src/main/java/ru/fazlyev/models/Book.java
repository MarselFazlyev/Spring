package ru.fazlyev.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private int id;

    private int owner_Id;

    private String title;

    private String author;

    private int year_of_release;

    // todo навесить аннотации!!!

}
