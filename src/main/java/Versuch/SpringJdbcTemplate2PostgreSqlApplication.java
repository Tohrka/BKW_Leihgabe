package Versuch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;






public class SpringJdbcTemplate2PostgreSqlApplication {
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

        //create a new table
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS " +
                "Geraete (Seriennummer INT PRIMARY KEY, Marke STRING" +
                ", Modell STRING, Schaeden STRING,Baujahr INT);" +
                "CREATE TABLE IF NOT EXISTS " +
                "Ausgabe (Schueler_ID INT, Seriennummer INT," +
                " Ausgabe_ab DATE, Ausgabe_bis DATE," +
                " PRIMARY KEY (Schueler_ID, Seriennummer));" +
                "CREATE TABLE IF NOT EXISTS " +
                "Schueler (Schueler_ID INT PRIMARY KEY, Nachname STRING," +
                "Vorname String, Klassen_ID INT," +
                "Geburtsdatum DATE, Adresse STRING," +
                "Email STRING, Telefonnummer STRING);" +
                "CREATE TABLE IF NOT EXISTS Klasse" +
                "(Klassen_ID INT PRIMARY KEY, Klassenname STRING," +
                "Lehrer_ID INT);" +
                "CREATE TABLE IF NOT EXISTS Lehrer" +
                "(Lehrer_ID INT PRIMARY KEY, Nachname STRING," +
                "Vorname STRING, Email STRING," +
                "Telefonnummer STRING,Admin BOOLEAN," +
                "Adresse STRING);" +
                "CREATE TABLE IF NOT EXISTS Login" +
                "(Leher_ID INT PRIMARY KEY,Nutzername STRING," +
                " Passwort STRING);");


    }
}