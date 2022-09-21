package DAO;

import Model.Ausgabe;
import e2e.E2eConnection;

import java.util.ArrayList;

public class AusgabeDao {
    private static final AusgabeDao instance = new AusgabeDao();
    private E2eConnection con = E2eConnection.getInstance();
    private AusgabeDao() {}
    public static AusgabeDao getInstance() {
        return instance;
    }
    //read all ausgabe from the table
    public ArrayList<Ausgabe> readAllAusgabe() {
        ArrayList<Ausgabe> list = new ArrayList<Ausgabe>();
        con.getJdbcTemplate().query("SELECT * FROM Ausgabe", (rs, rowNum) ->
                new Ausgabe(rs.getInt("schueler_ID"),
                        rs.getInt("seriennummer"),
                        rs.getDate("ausgabe_bis"),
                        rs.getDate("ausgabe_ab"))
        ).forEach((Ausgabe a) -> list.add(a));
        return list;
    }
    //read all ausgabe with specific schueler_id form the table
    public ArrayList<Ausgabe> readAusgabeWithSchuelerID(int schueler_id) {
        ArrayList<Ausgabe> list = new ArrayList<Ausgabe>();
        con.getJdbcTemplate().query("SELECT * FROM Ausgabe WHERE schueler_ID = ?", new Object[]{schueler_id}, (rs, rowNum) ->
                new Ausgabe(rs.getInt("schueler_ID"),
                        rs.getInt("seriennummer"),
                        rs.getDate("ausgabe_bis"),
                        rs.getDate("ausgabe_ab"))
        ).forEach((Ausgabe a) -> list.add(a));
        return list;
    }
    //read all ausgabe with specific seriennummer form the table
    public ArrayList<Ausgabe> readAusgabeWithSeriennummer(int seriennummer) {
        ArrayList<Ausgabe> list = new ArrayList<Ausgabe>();
        con.getJdbcTemplate().query("SELECT * FROM Ausgabe WHERE seriennummer = ?", new Object[]{seriennummer}, (rs, rowNum) ->
                new Ausgabe(rs.getInt("schueler_ID"),
                        rs.getInt("seriennummer"),
                        rs.getDate("ausgabe_bis"),
                        rs.getDate("ausgabe_ab"))
        ).forEach((Ausgabe a) -> list.add(a));
        return list;
    }
    //read all ausgabe with specific schueler_id and seriennummer from the table
    public Ausgabe readAusgabeWithSchuelerIDSeriennummer(int schueler_id, int seriennummer) {
        return con.getJdbcTemplate().queryForObject("SELECT * FROM Ausgabe WHERE schueler_ID = ? AND seriennummer = ?", new Object[]{schueler_id, seriennummer}, (rs, rowNum) ->
                new Ausgabe(rs.getInt("schueler_ID"),
                        rs.getInt("seriennummer"),
                        rs.getDate("ausgabe_bis"),
                        rs.getDate("ausgabe_ab"))
        );
    }
    //insert into ausgabe
    public void insertAusgabe(Ausgabe a) {
        con.getJdbcTemplate().update("INSERT INTO Ausgabe (schueler_ID, seriennummer, ausgabe_bis, ausgabe_ab) VALUES (?, ?, ?, ?)", a.getSchueler_id(), a.getSeriennummer(), a.getAusgabe_bis(), a.getAusgabe_ab());
    }
    //update ausgabe with specific schueler_id and seriennummer
    public void updateAusgabe(Ausgabe a) {
        con.getJdbcTemplate().update("UPDATE Ausgabe SET ausgabe_bis = ?, ausgabe_ab = ? WHERE schueler_ID = ? AND seriennummer = ?", a.getAusgabe_bis(), a.getAusgabe_ab(), a.getSchueler_id(), a.getSeriennummer());
    }
    //delete ausgabe with specific schueler_id and seriennummer
    public void deleteAusgabe(int schueler_id, int seriennummer) {
        con.getJdbcTemplate().update("DELETE FROM Ausgabe WHERE schueler_ID = ? AND seriennummer = ?", schueler_id, seriennummer);
    }
}

