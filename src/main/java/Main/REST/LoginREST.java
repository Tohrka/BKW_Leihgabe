
package Main.REST;
import Main.DAO.LoginDao;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginREST {
    private LoginDao lDao = LoginDao.getInstance();

    // rest aufruf: http://localhost:8080/login
    @GetMapping("/Checklogin/{username}/{password}")
    public boolean checkLogin(@PathVariable String username, @PathVariable String password) {
        return lDao.checkLogin(username, password);
    }
}
