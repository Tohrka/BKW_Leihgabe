package Versuch;

import DAO.KlasseDao;
import Model.Gereat;
import Model.Klasse;
import e2e.E2eConnection;

public class ReadJDBCData {

        public static void main(String[] args) {
            //cockroachdb connection
            E2eConnection con = E2eConnection.getInstance();



            //read all geareate from the table

            con.getJdbcTemplate().query("SELECT * FROM Geraete", (rs, rowNum) ->
                    new Gereat(rs.getInt("Seriennummer"),
                            rs.getString("Marke"),
                            rs.getString("Modell"),
                            rs.getString("Schaeden"),
                            rs.getInt("Baujahr"))
            ).forEach(System.out::println);
            }
        }
