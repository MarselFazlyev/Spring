package DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "products.ingridient")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IngridientDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "proteins")
    private int proteins;

    @Column(name = "fat")
    private int fat;

    @Column(name = "carbonates")
    private int carbonates;

    @Column(name = "calories")
    private int calories;

    @Column(name = "amount")
    private int amount;

    @Column(name = "measure")
    private String measure;

    @ManyToMany(mappedBy = "ingridientsDAOList")
    List<RecipeDAO> recipeDAOList;


}
