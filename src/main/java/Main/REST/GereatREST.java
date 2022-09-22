package Main.REST;
import Main.DAO.GereatDao;
import Main.Model.Gereat;
import Main.Model.GereateStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

public class GereatREST {
    private GereatDao gDao = GereatDao.getInstance();

    @GetMapping("/gereat")
    public ArrayList<Gereat> getAllGereat() {
        return gDao.readAllGereate();
    }

    @GetMapping("/gereat/{seriennummer}")
    public Gereat getGereatWithSeriennummer(@PathVariable int seriennummer) {
        return gDao.readGereatWithSeriennummer(seriennummer);
    }

    @GetMapping("/gereat/marke/{marke}")
    public ArrayList<Gereat> getGereatWithMarke(@PathVariable String marke) {
        return gDao.readGereatWithMarke(marke);
    }
    @GetMapping("/gereat/marke/{marke}/{modell}")
    public ArrayList<Gereat> getGereatWithModell(@PathVariable String marke, @PathVariable String modell) {
        return gDao.readGereatWithModell(marke, modell);
    }
    @GetMapping("/gereat/baujahr/{baujahr}")
    public ArrayList<Gereat> getGereatWithBaujahr(@PathVariable int baujahr) {
        return gDao.readGereatWithBaujahr(baujahr);
    }
    @GetMapping("/gereat/status/{status}")
    public ArrayList<Gereat> getGereatWithStatus(@PathVariable String status) {
        return gDao.readGereatWithStatus(GereateStatus.getStatus(status));
    }
    @PostMapping("/gereat")
    public void createGereat(@RequestBody Gereat g) {
        gDao.insertGereat(g);
    }
    @PostMapping("/gereat/update")
    public void updateGereat(@RequestBody Gereat g) {
        gDao.updateGereat(g);
    }

}
