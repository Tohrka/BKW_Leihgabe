package Main.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Gereat {
    int seriennummer;
    String marke;
    String modell;
    String schaeden;
    int baujahr;
    GereateStatus status;
}
