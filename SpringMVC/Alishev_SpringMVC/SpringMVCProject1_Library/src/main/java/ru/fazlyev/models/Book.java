package ru.fazlyev.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Integer id;

    private Integer owner_id;

    @NotEmpty(message = "Название книги не должно быть пустым")
    @Size(min = 2,max = 100,message = "Название книги должно быть  от 2 до 100 символов длиной")
    private String title;

    private String author;
    @Min(value=1500,message = "Год издания книги должен быть больше, чем 1500")
    private Integer year_of_release;


}
