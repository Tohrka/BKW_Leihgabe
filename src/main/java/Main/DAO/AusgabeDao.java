package Main.DAO;

import Main.Model.Ausgabe;
import Main.e2e.E2eConnection;

import java.util.ArrayList;

public class AusgabeDao {
    //logger
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LehrerDao.class);
    private static final AusgabeDao instance = new AusgabeDao();
    private E2eConnection con = E2eConnection.getInstance();

    private AusgabeDao() {
    }

    public static AusgabeDao getInstance() {
        return instance;
    }

    //read all ausgabe from the table
    public ArrayList<Ausgabe> readAllAusgabe() {
        ArrayList<Ausgabe> list = new ArrayList<Ausgabe>();
        try {
            con.getJdbcTemplate().query("SELECT * FROM Ausgabe", (rs, rowNum) ->
                    new Ausgabe(rs.getInt("schueler_ID"),
                            rs.getInt("seriennummer"),
                            rs.getDate("ausgabe_bis"),
                            rs.getDate("ausgabe_ab"))
            ).forEach((Ausgabe a) -> list.add(a));
            return list;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    //read all ausgabe with specific schueler_id form the table
    public ArrayList<Ausgabe> readAllAusgabeWithSchuelerID(int schueler_id) {
        ArrayList<Ausgabe> list = new ArrayList<Ausgabe>();
        try {
            con.getJdbcTemplate().query("SELECT * FROM Ausgabe WHERE schueler_ID = ?", new Object[]{schueler_id}, (rs, rowNum) ->
                    new Ausgabe(rs.getInt("schueler_ID"),
                            rs.getInt("seriennummer"),
                            rs.getDate("ausgabe_bis"),
                            rs.getDate("ausgabe_ab"))
            ).forEach((Ausgabe a) -> list.add(a));
            return list;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    //read all ausgabe with specific seriennummer form the table
    public ArrayList<Ausgabe> readAllAusgabeWithSeriennummer(int seriennummer) {
        ArrayList<Ausgabe> list = new ArrayList<Ausgabe>();
        try {
            con.getJdbcTemplate().query("SELECT * FROM Ausgabe WHERE seriennummer = ?", new Object[]{seriennummer}, (rs, rowNum) ->
                    new Ausgabe(rs.getInt("schueler_ID"),
                            rs.getInt("seriennummer"),
                            rs.getDate("ausgabe_bis"),
                            rs.getDate("ausgabe_ab"))
            ).forEach((Ausgabe a) -> list.add(a));
            return list;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    //read all ausgabe with specific schueler_id and seriennummer from the table
    public Ausgabe readAusgabeWithSchuelerIDSeriennummer(int schueler_id, int seriennummer) {
        try {
            return con.getJdbcTemplate().queryForObject("SELECT * FROM Ausgabe WHERE schueler_ID = ? AND seriennummer = ?", new Object[]{schueler_id, seriennummer}, (rs, rowNum) ->
                    new Ausgabe(rs.getInt("schueler_ID"),
                            rs.getInt("seriennummer"),
                            rs.getDate("ausgabe_bis"),
                            rs.getDate("ausgabe_ab"))
            );
        } catch (Exception e) {
            return null;
        }
    }

    //insert into ausgabe
    public void insertAusgabe(Ausgabe a) {
        try {
            con.getJdbcTemplate().update("INSERT INTO Ausgabe (schueler_ID, seriennummer, ausgabe_bis, ausgabe_ab) VALUES (?, ?, ?, ?)", a.getSchueler_id(), a.getSeriennummer(), a.getAusgabe_bis(), a.getAusgabe_ab());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    //update ausgabe with specific schueler_id and seriennummer
    public void updateAusgabe(Ausgabe a) {
        try {
            con.getJdbcTemplate().update("UPDATE Ausgabe SET ausgabe_bis = ?, ausgabe_ab = ? WHERE schueler_ID = ? AND seriennummer = ?", a.getAusgabe_bis(), a.getAusgabe_ab(), a.getSchueler_id(), a.getSeriennummer());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    //delete ausgabe with specific schueler_id and seriennummer
    public void deleteAusgabe(int schueler_id, int seriennummer) {
        try {
            con.getJdbcTemplate().update("DELETE FROM Ausgabe WHERE schueler_ID = ? AND seriennummer = ?", schueler_id, seriennummer);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}

