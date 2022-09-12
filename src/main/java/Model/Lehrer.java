package Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Lehrer {
    int lehrer_id;
    String vorname;
    String nachname;
    String email;
    String telefonnummer;
    boolean admin;
    String adresse;
}
