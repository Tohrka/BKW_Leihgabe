package DAO;

import Model.Lehrer;
import e2e.E2eConnection;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;

public class LehrerDao {
    //logger
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LehrerDao.class);
    private static final LehrerDao instance = new LehrerDao();
    private E2eConnection con = E2eConnection.getInstance();

    private LehrerDao() {
    }

    public static LehrerDao getInstance() {
        return instance;
    }

    //read all Lehrer from the table
    public ArrayList<Lehrer> readAllLehrer() {
        try {
            ArrayList<Lehrer> list = new ArrayList<Lehrer>();
            con.getJdbcTemplate().query("SELECT * FROM Lehrer", (rs, rowNum) ->
                    new Lehrer(rs.getInt("lehrer_id"),
                            rs.getString("Vorname"),
                            rs.getString("Nachname"),
                            rs.getString("Email"),
                            rs.getString("Telefonnummer"),
                            rs.getBoolean("Admin"))
            ).forEach((Lehrer l) -> list.add(l));
            return list;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    //read a specific Lehrer with LehrerID from the table
    public Lehrer readLehrerWithLehrerID(int lehrerID) {
        try {
            Lehrer l = con.getJdbcTemplate().queryForObject("SELECT * FROM Lehrer WHERE lehrer_id = ?", new Object[]{lehrerID}, (rs, rowNum) ->
                    new Lehrer(rs.getInt("lehrer_id"),
                            rs.getString("Vorname"),
                            rs.getString("Nachname"),
                            rs.getString("Email"),
                            rs.getString("Telefonnummer"),
                            rs.getBoolean("Admin"))
            );
            return l;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    //read a specigic lehrer with vorname and nachname from the table
    public Lehrer readLehrerWithVornameNachname(String vorname, String nachname) {
        try {
            Lehrer l = con.getJdbcTemplate().queryForObject("SELECT * FROM Lehrer WHERE Vorname = ? AND Nachname = ?", new Object[]{vorname, nachname}, (rs, rowNum) ->
                    new Lehrer(rs.getInt("lehrer_id"),
                            rs.getString("Vorname"),
                            rs.getString("Nachname"),
                            rs.getString("Email"),
                            rs.getString("Telefonnummer"),
                            rs.getBoolean("Admin"))
            );
            return l;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    //insert a new Lehrer into the table
    public void insertLehrer(Lehrer l) {
        try {
            con.getJdbcTemplate().update("INSERT INTO Lehrer (Vorname, Nachname, Email, Telefonnummer, Admin) VALUES (?, ?, ?, ?, ?)",
                    l.getVorname(), l.getNachname(), l.getEmail(), l.getTelefonnummer(), l.isAdmin());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    //update a Lehrer
    public void updateLehrer(Lehrer l) {
        try {
            con.getJdbcTemplate().update("UPDATE Lehrer SET Vorname = ?, Nachname = ?, Email = ?, Telefonnummer = ?, Admin = ? WHERE lehrer_id = ?",
                    l.getVorname(), l.getNachname(), l.getEmail(), l.getTelefonnummer(), l.isAdmin(), l.getLehrer_id());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}