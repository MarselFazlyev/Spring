package DAO;

import Models.RecipeCathegory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "products.recipe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category")
    private RecipeCathegory category;

    @Column(name = "calories")
    private int calories;

    @Column(name = "kitchen")
    private String kitchen;

    @ManyToMany
    @JoinTable(name = "products.quantity_of_ingridients",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingridient_id"))
    private List<IngridientDAO> ingridientsDAOList;


}
