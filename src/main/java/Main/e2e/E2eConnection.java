package Main.e2e;

import org.springframework.jdbc.core.JdbcTemplate;

public class E2eConnection
{  private static final E2eConnection Con = new E2eConnection();
    private String username = "tohrka";
    private String password = "0qGV21S4DcrX-cs717Ooww";
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    private String path = "jdbc:postgresql://free-tier13.aws-eu-central-1.cockroachlabs.cloud:26257/defaultdb?options=--cluster%3Dbkw-devices-3271&sslmode=verify-full&sslrootcert="+System.getProperty("user.dir")+"\\src\\main\\resources\\root.crt";

   private E2eConnection() {
       org.postgresql.ds.PGSimpleDataSource ds = new org.postgresql.ds.PGSimpleDataSource();
       ds.setUrl(path);
       ds.setUser(username);
       ds.setPassword(password);
       jdbcTemplate.setDataSource(ds);
   }
    public static E2eConnection getInstance() { return Con; }
    public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }

}
