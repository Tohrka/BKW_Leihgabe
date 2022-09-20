package DAO;

import Model.Schueler;
import e2e.E2eConnection;
import org.springframework.dao.EmptyResultDataAccessException;

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
                        rs.getString("EMail"),
                        rs.getString("telefonnummer"))
        ).forEach((Schueler s) -> list.add(s));
        return list;
    }
    //read a specific Schueler with SchuelerID from the table
    public Schueler readSchuelerWithSchuelerID(int schuelerID) {
        try {
            Schueler s = con.getJdbcTemplate().queryForObject("SELECT * FROM Schueler WHERE schueler_id = ?", new Object[]{schuelerID}, (rs, rowNum) ->
                    new Schueler(rs.getInt("Schueler_ID"),
                            rs.getString("Vorname"),
                            rs.getString("Nachname"),
                            rs.getInt("Klassen_ID"),
                            rs.getDate("Geburtsdatum"),
                            rs.getString("EMail"),
                            rs.getString("telefonnummer"))
            );
            return s;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    // read a specific Schueler with vorname and nachname from the table test for null
    public Schueler readSchuelerWithVornameNachname(String vorname, String nachname) {
        try {
            Schueler s = con.getJdbcTemplate().queryForObject("SELECT * FROM Schueler WHERE Vorname = ? AND Nachname = ?", new Object[]{vorname, nachname}, (rs, rowNum) ->
                    new Schueler(rs.getInt("Schueler_ID"),
                            rs.getString("Vorname"),
                            rs.getString("Nachname"),
                            rs.getInt("Klassen_ID"),
                            rs.getDate("Geburtsdatum"),
                            rs.getString("EMail"),
                            rs.getString("telefonnummer"))
            );
            return s;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    //insert a new Schueler into the table
    public void insertSchueler(Schueler s) {
        con.getJdbcTemplate().update("INSERT INTO Schueler (Vorname, Nachname, Klassen_ID, Geburtsdatum, EMail, telefonnummer) VALUES (?, ?, ?, ?, ?, ?)",
                s.getVorname(), s.getNachname(), s.getKlassen_id(), s.getGeburtsdatum(), s.getEmail(), s.getTelefonnummer());
    }
    //update a Schueler
public void updateSchueler(Schueler l) {
        con.getJdbcTemplate().update("UPDATE Schueler SET Vorname = ?, Nachname = ?, Klassen_ID = ?, Geburtsdatum = ?, EMail = ?, Telefonnummer = ? WHERE Schueler_ID = ?",
                l.getVorname(), l.getNachname(), l.getKlassen_id(), l.getGeburtsdatum(), l.getEmail(), l.getTelefonnummer(), l.getSchueler_id());
    }
}