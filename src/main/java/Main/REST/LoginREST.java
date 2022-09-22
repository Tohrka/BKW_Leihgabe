
package Main.REST;
import Main.DAO.LoginDao;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginREST {
    private LoginDao lDao = LoginDao.getInstance();
    @GetMapping("/CheckLogin/{username}/{password}")
    public boolean checkLogin(@PathVariable String username, @PathVariable String password) {
        return lDao.checkLogin(username, password);
    }
}
