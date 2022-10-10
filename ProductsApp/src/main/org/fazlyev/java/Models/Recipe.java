package Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recipe {

    private int id;

    private RecipeCathegory recipeCathegory;

    private int calories;

    private String kitchen;

    private List<Ingridient> ingridientsList;

}
