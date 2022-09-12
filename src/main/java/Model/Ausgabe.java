package Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class Ausgabe {

    int schueler_id;
    int seriennummer;
    Date ausgabe_bis;
    Date ausgabe_von;
}
