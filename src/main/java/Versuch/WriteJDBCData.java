package Versuch;

import e2e.E2eConnection;
import org.springframework.jdbc.core.JdbcTemplate;


public class WriteJDBCData {
    public static void main(String[] args) {
        E2eConnection con = E2eConnection.getInstance();


        //create a new tables and fill them with data
        con.getJdbcTemplate().execute("CREATE TABLE IF NOT EXISTS " +
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
                "(Lehrer_ID INT PRIMARY KEY,Nutzername STRING," +
                " Passwort STRING);");


    }
}