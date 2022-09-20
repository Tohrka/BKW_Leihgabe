package Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class Schueler {
    int schueler_id;
    String vorname;
    String nachname;
    int klassen_id;
    Date geburtsdatum;
    String email;
    String telefonnummer;
}
