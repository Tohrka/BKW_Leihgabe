package DAO;
import Model.Gereat;
import e2e.E2eConnection;

import java.util.ArrayList;

public class GereatDao {
    private static final GereatDao instance = new GereatDao();
    private E2eConnection con = E2eConnection.getInstance();
    private GereatDao() {}
    public static GereatDao getInstance() {
        return instance;
    }
    //read all geareate from the table
    public ArrayList<Gereat> readAllGereate() {
        ArrayList<Gereat> list = new ArrayList<Gereat>();
        con.getJdbcTemplate().query("SELECT * FROM Geraete", (rs, rowNum) ->
                new Gereat(rs.getInt("Seriennummer"),
                        rs.getString("Marke"),
                        rs.getString("Modell"),
                        rs.getString("Schaeden"),
                        rs.getInt("Baujahr"))
        ).forEach((Gereat g) -> list.add(g));
        return list;
    }
    //read a specific geareat with seriennummer from the table
    public Gereat readGereatWithSeriennummer(int seriennummer) {
        Gereat g = con.getJdbcTemplate().queryForObject("SELECT * FROM Geraete WHERE Seriennummer = ?", new Object[]{seriennummer}, (rs, rowNum) ->
                new Gereat(rs.getInt("Seriennummer"),
                        rs.getString("Marke"),
                        rs.getString("Modell"),
                        rs.getString("Schaeden"),
                        rs.getInt("Baujahr"))
        );
        return g;
    }
    //read a specific gereat with marke from the table
    public ArrayList<Gereat> readGereatWithMarke(String marke) {
        ArrayList<Gereat> list = new ArrayList<Gereat>();
        con.getJdbcTemplate().query("SELECT * FROM Geraete WHERE Marke = ?", new Object[]{marke}, (rs, rowNum) ->
                new Gereat(rs.getInt("Seriennummer"),
                        rs.getString("Marke"),
                        rs.getString("Modell"),
                        rs.getString("Schaeden"),
                        rs.getInt("Baujahr"))
        ).forEach((Gereat g) -> list.add(g));
        return list;
    }
    //read a specific gereat with modell from the table
    public ArrayList<Gereat> readGereatWithModell(String marke, String modell) {
        ArrayList<Gereat> list = new ArrayList<Gereat>();
        con.getJdbcTemplate().query("SELECT * FROM Geraete WHERE Marke = ? AND Modell = ?", new Object[]{marke, modell}, (rs, rowNum) ->
                new Gereat(rs.getInt("Seriennummer"),
                        rs.getString("Marke"),
                        rs.getString("Modell"),
                        rs.getString("Schaeden"),
                        rs.getInt("Baujahr"))
        ).forEach((Gereat g) -> list.add(g));
        return list;
    }
    //read a specific gereat with baujahr from the table
    public ArrayList<Gereat> readGereatWithBaujahr(int baujahr) {
        ArrayList<Gereat> list = new ArrayList<Gereat>();
        con.getJdbcTemplate().query("SELECT * FROM Geraete WHERE Baujahr = ?", new Object[]{baujahr}, (rs, rowNum) ->
                new Gereat(rs.getInt("Seriennummer"),
                        rs.getString("Marke"),
                        rs.getString("Modell"),
                        rs.getString("Schaeden"),
                        rs.getInt("Baujahr"))
        ).forEach((Gereat g) -> list.add(g));
        return list;
    }
    //insert a new gereat into the table
    public void insertGereat(Gereat g) {
        con.getJdbcTemplate().update("INSERT INTO Geraete (Seriennummer, Marke, Modell, Schaeden, Baujahr) VALUES (?, ?, ?, ?, ?)", g.getSeriennummer(), g.getMarke(), g.getModell(), g.getSchaeden(), g.getBaujahr());
    }
}
