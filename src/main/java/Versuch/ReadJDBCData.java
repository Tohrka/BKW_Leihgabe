package Versuch;

import DAO.GereatDao;
import Model.Gereat;
import e2e.E2eConnection;

public class ReadJDBCData {

        public static void main(String[] args) {
            //cockroachdb connection
            GereatDao dao = GereatDao.getInstance();
            //read all gereate from the table
            System.out.println("Alle Gereate aus der Tabelle:");
            dao.readAllGereate().forEach((Gereat g) -> System.out.println(g));
            //read a specific gereat with seriennummer from the table
            System.out.println("Gereat mit Seriennummer 1 aus der Tabelle:");
            System.out.println(dao.readGereatWithSeriennummer(1));
            //read a specific gereat with marke from the table
            System.out.println("Gereate mit Marke 'Apple' aus der Tabelle:");
            dao.readGereatWithMarke("Apple").forEach((Gereat g) -> System.out.println(g));
            //read a specific gereat with marke and modell from the table
            System.out.println("Gereate mit Marke 'Apple' und Modell 'iPhone 11' aus der Tabelle:");
            dao.readGereatWithModell("Apple", "iPhone 11").forEach((Gereat g) -> System.out.println(g));
            //read a specific gereat with baujahr from the table
            System.out.println("Gereate mit Baujahr 2014 aus der Tabelle:");
            dao.readGereatWithBaujahr(2014).forEach((Gereat g) -> System.out.println(g));
        }

}
