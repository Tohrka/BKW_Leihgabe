package DAO;

import e2e.E2eConnection;

public class LoginDao {
    private static final LoginDao instance = new LoginDao();
    private E2eConnection con = E2eConnection.getInstance();
    private LoginDao() {}
    public static LoginDao getInstance() {
        return instance;
    }
public boolean checkLogin(String username, String password) {
        //get the password from the database
        try{
            String dbPassword = con.getJdbcTemplate().queryForObject("SELECT password FROM login WHERE username = ?", new Object[]{username}, String.class);
            //check if the password is correct
            if(dbPassword.equals(password)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }


}
