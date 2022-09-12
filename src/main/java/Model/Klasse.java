package Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Klasse {
    int klassen_id;
    String klassenname;
    int lehrer_id;
}
