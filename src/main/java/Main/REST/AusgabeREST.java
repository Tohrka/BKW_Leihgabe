package Main.REST;
import Main.DAO.AusgabeDao;
import Main.Model.Ausgabe;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class AusgabeREST {
    private AusgabeDao aDao = AusgabeDao.getInstance();

    // rest aufruf: http://localhost:8080/ausgabe
    @GetMapping("/ausgabe")
    public ArrayList<Ausgabe> getAllAusgabe() {
        return aDao.readAllAusgabe();
    }

    @GetMapping("/ausgabe/{schuelerID}/{seriennummer}")
    public Ausgabe getAusgabeWithSchuelerIDSeriennummer(@PathVariable int schuelerID, @PathVariable int seriennummer) {
        return aDao.readAusgabeWithSchuelerIDSeriennummer(schuelerID, seriennummer);
    }

    @GetMapping("/ausgabe/schueler/{schuelerID}")
    public ArrayList<Ausgabe> getAusgabeWithSchuelerID(@PathVariable int schuelerID) {
        return aDao.readAllAusgabeWithSchuelerID(schuelerID);
    }
    @GetMapping("/ausgabe/seriennummer/{seriennummer}")
    public ArrayList<Ausgabe> getAusgabeWithSeriennummer(@PathVariable int seriennummer) {
        return aDao.readAllAusgabeWithSeriennummer(seriennummer);
    }
    @PostMapping("/ausgabe")
    public void createAusgabe(@RequestBody Ausgabe a) {
        aDao.insertAusgabe(a);
    }
    @PostMapping("/ausgabe/update")
    public void updateAusgabe(@RequestBody Ausgabe a) {
        aDao.updateAusgabe(a);
    }

}
