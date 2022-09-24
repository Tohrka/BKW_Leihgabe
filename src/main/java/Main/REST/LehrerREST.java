package Main.REST;
import Main.DAO.LehrerDao;
import Main.Model.Lehrer;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@CrossOrigin
public class LehrerREST {
    private LehrerDao lDao = LehrerDao.getInstance();

    // rest aufruf: http://localhost:8080/lehrer
    @GetMapping("/lehrer")
    public ArrayList<Lehrer> getAllLehrer() {
        return lDao.readAllLehrer();
    }

    @GetMapping("/lehrer/{lehrerID}")
    public Lehrer getLehrerWithLehrerID(@PathVariable int lehrerID) {
        return lDao.readLehrerWithLehrerID(lehrerID);
    }

    @GetMapping("/lehrer/name/{vorname}/{nachname}")
    public Lehrer getLehrerWithVornameNachname(@PathVariable String vorname, @PathVariable String nachname) {
        return lDao.readLehrerWithVornameNachname(vorname, nachname);
    }
    @PostMapping("/lehrer")
    public void createLehrer(@RequestBody Lehrer l) {
        lDao.insertLehrer(l);
    }
    @PostMapping("/lehrer/update")
    public void updateLehrer(@RequestBody Lehrer l) {
        lDao.updateLehrer(l);
    }

}
