package Versuch;

import Model.Ausgabe;
import Model.Gereat;
import org.springframework.jdbc.core.JdbcTemplate;

public class ReadJDBCData {

        public static void main(String[] args) {
            //cockroachdb connection
            String url = "jdbc:postgresql://free-tier13.aws-eu-central-1.cockroachlabs.cloud:26257/defaultd?sslmode=disable";
            String username = "tohrka";
            String password = "0qGV21S4DcrX-cs717Ooww";
            //create a new JdbcTemplate
            JdbcTemplate jdbcTemplate = new JdbcTemplate();
            //set the data source properties

            org.postgresql.ds.PGSimpleDataSource ds = new org.postgresql.ds.PGSimpleDataSource();
            ds.setUrl("jdbc:postgresql://free-tier13.aws-eu-central-1.cockroachlabs.cloud:26257/defaultdb?options=--cluster%3Dbkw-devices-3271&sslmode=verify-full&sslrootcert=C:\\Users\\M-Kub\\AppData\\Roaming\\postgresql\\root.crt");
            ds.setUser("tohrka");
            ds.setPassword("0qGV21S4DcrX-cs717Ooww");


            jdbcTemplate.setDataSource(ds);
            //read all geareate from the table
            jdbcTemplate.query("SELECT * FROM Geraete", (rs, rowNum) ->
                    new Gereat(rs.getInt("Seriennummer"),
                            rs.getString("Marke"),
                            rs.getString("Modell"),
                            rs.getString("Schaeden"),
                            rs.getInt("Baujahr"))
            ).forEach(System.out::println);
            //close the connection
            try {
                ds.getConnection().close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

}
