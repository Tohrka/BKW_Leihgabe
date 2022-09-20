package DAO;

import Model.Klasse;
import e2e.E2eConnection;

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
        Klasse k = con.getJdbcTemplate().queryForObject("SELECT * FROM Klasse WHERE KlassenID = ?", new Object[]{klassenID}, (rs, rowNum) ->
                new Klasse(rs.getInt("Klassen_ID"),
                        rs.getString("Klassenname"),
                        rs.getInt("Lehrer_ID"))
        );
        return k;
    }
    //read a specific klasse with Klassenname from the table
    public Klasse readKlasseWithVornameNachname(String klassenname) {
        Klasse k = con.getJdbcTemplate().queryForObject("SELECT * FROM Klasse WHERE Klassename = ?", new Object[]{klassenname}, (rs, rowNum) ->
                new Klasse(rs.getInt("Klassen_ID"),
                        rs.getString("Klassenname"),
                        rs.getInt("Lehrer_ID"))
        );
        return k;
    }
}

