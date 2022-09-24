package Main.REST;
import Main.DAO.SchuelerDao;
import Main.Model.Schueler;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@RestController
@CrossOrigin
public class SchuelerREST {
    private SchuelerDao sDao = SchuelerDao.getInstance();

    // rest aufruf: http://localhost:8080/schueler
    @GetMapping("/schueler")
    public @ResponseBody ArrayList<Schueler> getAllSchueler() {
        return sDao.readAllSchueler();
    }

    @GetMapping("/schueler/{schuelerID}")
    public Schueler getSchuelerWithSchuelerID(@PathVariable int schuelerID) {
        return sDao.readSchuelerWithSchuelerID(schuelerID);
    }

    @GetMapping("/schueler/name/{vorname}/{nachname}")
    public Schueler getSchuelerWithVornameNachname(@PathVariable String vorname, @PathVariable String nachname) {
        return sDao.readSchuelerWithVornameNachname(vorname, nachname);
    }
    @GetMapping("/schueler/klasse/{klassen_id}")
    public ArrayList<Schueler> getSchuelerWithKlassenID(@PathVariable int klassen_id) {
        return sDao.readAllSchuelerWithKlassenID(klassen_id);
    }
    @PostMapping("/schueler")
    public void createSchueler(@RequestBody Schueler s) {
        sDao.insertSchueler(s);
    }
    @PostMapping("/schueler/update")
    public void updateSchueler(@RequestBody Schueler s) {
        sDao.updateSchueler(s);
    }

}
