package Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ingridient {
    private int id;
    private String name;
    private int proteins;
    private int fat;
    private int carbonates;
    private int calories;
    private int amount;
    private String measure;
}
