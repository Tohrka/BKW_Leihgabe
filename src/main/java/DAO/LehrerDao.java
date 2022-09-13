package DAO;

import Model.Lehrer;
import e2e.E2eConnection;

import java.util.ArrayList;

public class LehrerDao {
    private static final LehrerDao instance = new LehrerDao();
    private E2eConnection con = E2eConnection.getInstance();

    private LehrerDao() {
    }

    public static LehrerDao getInstance() {
        return instance;
    }

    //read all Lehrer from the table
    public ArrayList<Lehrer> readAllLehrer() {
        ArrayList<Lehrer> list = new ArrayList<Lehrer>();
        con.getJdbcTemplate().query("SELECT * FROM Lehrer", (rs, rowNum) ->
                new Lehrer(rs.getInt("LehrerID"),
                        rs.getString("Vorname"),
                        rs.getString("Nachname"),
                        rs.getString("Email"),
                        rs.getString("Telefonnummer"),
                        rs.getBoolean("Admin"),
                        rs.getString("adresse"))
        ).forEach((Lehrer l) -> list.add(l));
        return list;
    }
    //read a specific Lehrer with LehrerID from the table
    public Lehrer readLehrerWithLehrerID(int lehrerID) {
        Lehrer l = con.getJdbcTemplate().queryForObject("SELECT * FROM Lehrer WHERE LehrerID = ?", new Object[]{lehrerID}, (rs, rowNum) ->
                new Lehrer(rs.getInt("LehrerID"),
                        rs.getString("Vorname"),
                        rs.getString("Nachname"),
                        rs.getString("Email"),
                        rs.getString("Telefonnummer"),
                        rs.getBoolean("Admin"),
                        rs.getString("adresse"))
        );
        return l;
    }
    //read a specigic lehrer with vorname and nachname from the table
    public Lehrer readLehrerWithVornameNachname(String vorname, String nachname) {
        Lehrer l = con.getJdbcTemplate().queryForObject("SELECT * FROM Lehrer WHERE Vorname = ? AND Nachname = ?", new Object[]{vorname, nachname}, (rs, rowNum) ->
                new Lehrer(rs.getInt("LehrerID"),
                        rs.getString("Vorname"),
                        rs.getString("Nachname"),
                        rs.getString("Email"),
                        rs.getString("Telefonnummer"),
                        rs.getBoolean("Admin"),
                        rs.getString("adresse"))
        );
        return l;
    }
}

