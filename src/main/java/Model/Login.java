package Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Login {
    int lehrer_id;
    String passwort;
    String user;
}
