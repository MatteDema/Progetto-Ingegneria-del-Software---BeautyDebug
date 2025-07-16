package database;

import com.mysql.cj.protocol.a.LocalDateTimeValueEncoder;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestMainDB {

    public static void main(String[] args) {

        //TEST PER DBTrattamento
        // TEST 1 DI SALVA IN DB e CARICA DA DB con Costruttore
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


        //TEST PER DBPrenotazione
        // TEST 1 DI CARICA DA DB con Costruttore, SALVA IN DB
//        DBPrenotazione p = new DBPrenotazione(6);
//        System.out.println(p);
//
//        DBPrenotazione p2 = new DBPrenotazione();
//        p2.setData(LocalDateTime.of(2025, 7, 22, 14, 0));
//        p2.setStato("attivo");
//        p2.setTipologiaTrattamento("Manicuree");
//        p2.setUsernameCliente("pippozzo");
//
//        System.out.println("valore ritorno query insert:" + p2.salvaInDB());

        // TEST 2 DI ESISTEPRENOTAZIONEATTIVACLIENTEPERTRATTAMENTODADB
//        DBPrenotazione p = new DBPrenotazione();
//        boolean esiste_pren_pippo_mani=p.esistePrenotazioneAttivaClientePerTrattamentoDaDB("Manicuree", "pippozo");
//        System.out.println(esiste_pren_pippo_mani); //ritorna false con pippozo e manicure

        // TEST 3 PER CARICALISTAPRENOTAZIONIATTIVEDADB
//        DBPrenotazione p = new DBPrenotazione();
//        ArrayList<DBPrenotazione> lista_p_attive = p.caricaListaPrenotazioniAttiveDaDB();
//
//        for(DBPrenotazione p1: lista_p_attive){
//            System.out.println(p1);
//        }


        //TEST DBFasceOrarieLavorative
        //TEST 1 DI CARICAELENCODISPONIBILITADADB
//        DBFasceOrarieLavorative dbf = new DBFasceOrarieLavorative();
//        ArrayList<DBFasceOrarieLavorative> elenco_fasce= dbf.caricaElencoDisponibilitaDaDB();
//
//        int i=0;
//        for(DBFasceOrarieLavorative una_dbf: elenco_fasce){
//            System.out.println(una_dbf);
//            i++;
//        }
//        System.out.println(i);


        //TEST DBCliente
        //TEST 1 SU CARICA DA DB con Costruttore, SALVA IN DB
//        DBCliente cliente = new DBCliente("pippozzo");
//        System.out.println(cliente);

//        DBCliente cliente = new DBCliente();
//        cliente.setUsername("ciaosonoio2");
//        cliente.setPassword("Ciao12#");
//        cliente.setNome("Jhonny");
//        cliente.setCognome("Bravo'dai");
//        cliente.setIndirizzo("Via Claudio 104");
//        cliente.setTelefono("1231231231");
//        cliente.setEmail("jhonny2@gmail.com");
//
//        System.out.println("valore ritorno query insert:" + cliente.salvaInDB("ciaosonoio2"));

        //TEST 2 EMAIL PRESENTE IN DB
//        DBCliente cliente = new DBCliente();
//        boolean email_presente=cliente.emailPresenteInDB("jhonnay@gmail.com");
//        System.out.println(email_presente);

        //TEST 3 USERNAME PRESENTE IN DB
//        DBCliente cliente = new DBCliente();
//        boolean username_presente=cliente.usernamePresenteInDB("ciaAosonoio");
//        System.out.println(username_presente);

        //fine classi DAO EHEH
    }
}
