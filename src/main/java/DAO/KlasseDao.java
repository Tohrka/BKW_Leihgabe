package DAO;

import Model.Klasse;
import e2e.E2eConnection;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;

public class KlasseDao {
    private static final KlasseDao instance = new KlasseDao();
    private E2eConnection con = E2eConnection.getInstance();

    private KlasseDao() {
    }

    public static KlasseDao getInstance() {
        return instance;
    }

    //read all Klasse from the table
    public ArrayList<Klasse> readAllKlasse() {
        ArrayList<Klasse> list = new ArrayList<Klasse>();
        con.getJdbcTemplate().query("SELECT * FROM Klasse", (rs, rowNum) ->
                new Klasse(rs.getInt("Klassen_ID"),
                        rs.getString("Klassenname"),
                        rs.getInt("Lehrer_ID"))
        ).forEach((Klasse k) -> list.add(k));
        return list;
    }
    //read a specific Klasse with KlasseID from the table
    public Klasse readKlasseWithKlasseID(int klassenID) {
        try {
            Klasse k = con.getJdbcTemplate().queryForObject("SELECT * FROM Klasse WHERE klassen_id = ?", new Object[]{klassenID}, (rs, rowNum) ->
                    new Klasse(rs.getInt("Klassen_ID"),
                            rs.getString("Klassenname"),
                            rs.getInt("Lehrer_ID"))
            );
            return k;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    //read a specific klasse with Klassenname from the table
    public Klasse readKlasseWithBezeichnung(String klassenname) {
        try {
            Klasse k = con.getJdbcTemplate().queryForObject("SELECT * FROM Klasse WHERE Klassenname = ?", new Object[]{klassenname}, (rs, rowNum) ->
                    new Klasse(rs.getInt("Klassen_ID"),
                            rs.getString("Klassenname"),
                            rs.getInt("Lehrer_ID"))
            );
            return k;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //insert a new Klasse into the table
    public void insertKlasse(Klasse k) {
        con.getJdbcTemplate().update("INSERT INTO Klasse (Klassenname, Lehrer_ID) VALUES (?, ?)", k.getKlassenname(), k.getLehrer_id());
    }
    //update a Klasse
    public void updateKlasse(Klasse k) {
        con.getJdbcTemplate().update("UPDATE Klasse SET Klassenname = ?, Lehrer_ID = ? WHERE Klassen_ID = ?",
                k.getKlassenname(), k.getLehrer_id(), k.getKlassen_id());
    }
}

