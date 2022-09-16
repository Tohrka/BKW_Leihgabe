package DAO;

import Model.Schueler;
import e2e.E2eConnection;

import java.util.ArrayList;

public class SchuelerDao {
    private static final SchuelerDao instance = new SchuelerDao();
    private E2eConnection con = E2eConnection.getInstance();

    private SchuelerDao() {
    }

    public static SchuelerDao getInstance() {
        return instance;
    }

    //read all Schueler from the table
    public ArrayList<Schueler> readAllSchueler() {
        ArrayList<Schueler> list = new ArrayList<Schueler>();
        con.getJdbcTemplate().query("SELECT * FROM Schueler", (rs, rowNum) ->
                new Schueler(rs.getInt("Schueler_ID"),
                        rs.getString("Vorname"),
                        rs.getString("Nachname"),
                        rs.getInt("Klassen_ID"),
                        rs.getDate("Geburtsdatum"),
                        rs.getString("Adresse"),
                        rs.getString("EMail"),
                        rs.getString("telefonnummer"))
        ).forEach((Schueler l) -> list.add(l));
        return list;
    }
    //read a specific Schueler with SchuelerID from the table
    public Schueler readSchuelerWithSchuelerID(int schuelerID) {
        Schueler l = con.getJdbcTemplate().queryForObject("SELECT * FROM Schueler WHERE SchuelerID = ?", new Object[]{schuelerID}, (rs, rowNum) ->
                new Schueler(rs.getInt("Schueler_ID"),
                        rs.getString("Vorname"),
                        rs.getString("Nachname"),
                        rs.getInt("Klassen_ID"),
                        rs.getDate("Geburtsdatum"),
                        rs.getString("Adresse"),
                        rs.getString("EMail"),
                        rs.getString("telefonnummer"))
        );
        return l;
    }
    //read a specific Schueler with vorname and nachname from the table
    public Schueler readSchuelerWithVornameNachname(String vorname, String nachname) {
        Schueler l = con.getJdbcTemplate().queryForObject("SELECT * FROM Schueler WHERE Vorname = ? AND Nachname = ?", new Object[]{vorname, nachname}, (rs, rowNum) ->
                new Schueler(rs.getInt("Schueler_ID"),
                        rs.getString("Vorname"),
                        rs.getString("Nachname"),
                        rs.getInt("Klassen_ID"),
                        rs.getDate("Geburtsdatum"),
                        rs.getString("Adresse"),
                        rs.getString("EMail"),
                        rs.getString("telefonnummer"))
        );
        return l;
    }
}