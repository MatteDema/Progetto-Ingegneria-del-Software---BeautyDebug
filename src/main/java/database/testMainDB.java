package database;

import java.util.ArrayList;

public class testMainDB {

    public static void main(String[] args) {

        // TEST 1 DU SALVA IN DB
//        DBTrattamento trattamento1 =  new DBTrattamento();
//        trattamento1.setNome("Manicuree");
//        trattamento1.setDescrizione("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        trattamento1.setCosto(500);
//        trattamento1.setRipetizionePeriodica("");
//
//        DBTrattamento trattamento2 =  new DBTrattamento();
//        trattamento2.setNome("Pedicuree");
//        trattamento2.setDescrizione("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        trattamento2.setCosto(500);
//        trattamento2.setRipetizionePeriodica("Mensile");
//
//        int i1= trattamento1.salvaInDB("Manicuree");
//        int i2= trattamento2.salvaInDB("Pedicuree");
//
//        System.out.println("trattamento1="+i1+ " dati: " + trattamento1.getNome());
//        System.out.println("trattamento2="+i2+ " dati: " + trattamento2.getNome());
//
//        trattamento1 = new DBTrattamento("Pedicuree");
//        System.out.println("trattamento1="+ trattamento1.getNome());


        // TEST 2 TRATTAMENTO PRESENTE IN DB
//        DBTrattamento trattamento1 =  new DBTrattamento();
//        System.out.println(trattamento1.trattamentoPresenteInDB("Manicure"));

        // TEST 3 CARICA TRATTAMENTI PER COSTO
//        DBTrattamento trattamento1 =  new DBTrattamento();
//        ArrayList<DBTrattamento> arraypercosto= trattamento1.caricaTrattamentiPerCostoDaDB(80);
//        for(DBTrattamento trattamento:arraypercosto){
//            System.out.println(trattamento);
//        }

        // TEST 4 CARICA LISTA TRATTAMENTI TUTTI
//        DBTrattamento trattamento1 =  new DBTrattamento();
//        ArrayList<DBTrattamento> arraytutti= trattamento1.caricaListaTrattamentiDaDB();
//        for(DBTrattamento trattamento:arraytutti){
//            System.out.println(trattamento);
//        }

    }
}
