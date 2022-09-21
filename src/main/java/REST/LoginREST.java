
package REST;
import DAO.LoginDao;
import Model.Login;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@RestController
public class LoginREST {
    private LoginDao lDao = LoginDao.getInstance();
    @GetMapping("/CheckLogin/{username}/{password}")
    public boolean checkLogin(@PathVariable String username, @PathVariable String password) {
        return lDao.checkLogin(username, password);
    }
}
