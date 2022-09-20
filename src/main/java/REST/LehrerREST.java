package REST;
import DAO.LehrerDao;
import Model.Lehrer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class LehrerREST {
    private LehrerDao lDao = LehrerDao.getInstance();

    @GetMapping("/lehrer")
    public ArrayList<Lehrer> getAllLehrer() {
        return lDao.readAllLehrer();
    }

    @GetMapping("/lehrer/{lehrerID}")
    public Lehrer getLehrerWithLehrerID(@PathVariable int lehrerID) {
        return lDao.readLehrerWithLehrerID(lehrerID);
    }

    @GetMapping("/lehrer/{vorname}/{nachname}")
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
