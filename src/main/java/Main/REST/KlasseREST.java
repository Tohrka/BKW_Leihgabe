package Main.REST;
import Main.DAO.KlasseDao;
import Main.Model.Klasse;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@CrossOrigin
public class KlasseREST {
    private KlasseDao kDao = KlasseDao.getInstance();

    // rest aufruf: http://localhost:8080/klasse
    @GetMapping("/klasse")
    public ArrayList<Klasse> getAllKlasse() {
        return kDao.readAllKlasse();
    }

    @GetMapping("/klasse/{klasseID}")
    public Klasse getKlasseWithKlasseID(@PathVariable int klasseID) {
        return kDao.readKlasseWithKlasseID(klasseID);
    }

    @GetMapping("/klasse/bezeichnung/{bezeichnung}")
    public Klasse getKlasseWithBezeichnung(@PathVariable String bezeichnung) {
        return kDao.readKlasseWithBezeichnung(bezeichnung);
    }
    @PostMapping("/klasse")
    public void createKlasse(@RequestBody Klasse k) {
        kDao.insertKlasse(k);
    }
    @PostMapping("/klasse/update")
    public void updateKlasse(@RequestBody Klasse k) {
        kDao.updateKlasse(k);
    }

}

