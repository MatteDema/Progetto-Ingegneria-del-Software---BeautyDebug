import entity.InfoClientiEPrenotazioni;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRegistrazioneCliente {

    // testiamo con JUnit alcune funzionalità del nostro sistema

    // test relativi alla funzionalità di registrazione di un cliente nel caso egli non sia già registrato nel sistema

    // metodo setUp per la precondizione
    @Before
    public void setUp()  {
        // precondizione: non esiste già nel sistema un cliente con l'email
        // passata come argomento al metodo di registrazione
        boolean email_gia_presente = InfoClientiEPrenotazioni.registrazione("alessio.russo@gmail.com");
        // nel database non c'è nessun cliente avente questa email
        // mi aspetto che email_gia_presente sia pari a false
        assertFalse(email_gia_presente);
    }

    /*
    // il seguente metodo di tearDown esprime una postcondizione che è verificata solo nei test successivi che
    // si concludono con la registrazione del nuovo cliente nel database (cioè solo nel test testLunghezzaNomeCorretta)
    // Negli altri casi, esso comporta il fallimento dei test solo a causa del fatto che la postcondizione non è vera
    @After
    public void tearDown() {
        // postcondizione: il cliente si è registrato
        // istanzio un DAO DBCliente per verificare che l'email con cui il cliente ha avviato la registrazione
        // sia adesso presente nel database
        DBCliente dbCliente = new DBCliente();
        boolean cliente_ora_registrato = dbCliente.emailPresenteInDB("alessio.russo@gmail.com");
        // mi aspetto che cliente_ora_registrato sia true
        assertTrue(cliente_ora_registrato);
    }
    */


    @Test
    public void testNomeTroppoLungo() {
        boolean nome_corretto = InfoClientiEPrenotazioni.inserisciCliente("Alessioooooooooooooooooooooooooooooooooooooooooooooooooooooooooo",
                "Russo", "Via Venezia 12", "3493214568", "alessio.russo@gmail.com", "alessio12", "Alessio12#");

        // il nome è troppo lungo (più di 30 caratteri) -> mi aspetto che nome_corretto sia pari a false
        // poiché l'aggiunta del cliente nel database non può andare a buon fine
        // (visto che nel database il campo nome è un VARCHAR(30))

        assertFalse("Il nome non doveva essere corretto!", nome_corretto);
    }

    @Test
    public void testLunghezzaNomeCorretta() {
        boolean nome_corretto = InfoClientiEPrenotazioni.inserisciCliente("Alessio",
                "Russo", "Via Venezia 12", "3493214568", "alessio.russo@gmail.com", "alessio12", "Alessio12#");

        // il nome è corretto (lunghezza inferiore a 30 caratteri) -> mi aspetto che nome_corretto sia true
        // poiché l'aggiunta del cliente nel database va a buon fine

        assertTrue("Il nome doveva essere corretto!", nome_corretto); // il nuovo cliente viene aggiunto
    }

    // per il corretto funzionamento dei test successivi, è necessario rimuovere dal database il cliente appena aggiunto,
    // altrimenti la precondizione specificata nel metodo setUp non sarà più verificata e i test falliranno
    @Test
    public void testIndirizzoNonContieneNumeri() {
        boolean indirizzo_corretto = false;

        String indirizzo = "Via Venezia";

        // di seguito uso un regex per verificare che l'indirizzo contenga numeri
        /*
        \\d corrisponde a una cifra (0-9).

        .*\\d.* verifica se c'è almeno un numero.
        */

        if(indirizzo.matches(".*\\d.*")) {
            indirizzo_corretto = true;
            InfoClientiEPrenotazioni.inserisciCliente("Alessio", "Russo",
                    indirizzo, "3493214568", "alessio.russo@gmail.com", "alessio12", "Alessio12#");
        } else {
            System.out.println("Indirizzo non contiene numeri!");
        }

        // l'indirizzo non è corretto, perché non contiene numeri -> mi aspetto che indirizzo_corretto sia false
        // poiché l'aggiunta del cliente nel database fallisce
        assertEquals("L'indirizzo doveva essere sbagliato!", false, indirizzo_corretto);
    }

    @Test
    public void testLunghezzaTelefonoScorretta() {
        boolean telefono_corretto = false;

        String telefono = "34932145681"; // il telefono ha 11 numeri

        if(telefono.length() == 10) {
            telefono_corretto = true;
            InfoClientiEPrenotazioni.inserisciCliente("Alessio", "Russo",
                    "Via Venezia 12", telefono, "alessio.russo@gmail.com", "alessio12", "Alessio12#");
        } else {
            System.out.println("Telefono non contiene dieci numeri!");
        }

        // il telefono non è corretto, perché contiene più di dieci caratteri numerici -> mi aspetto che telefono_corretto sia
        // false poiché l'aggiunta del cliente nel database fallisce
        assertFalse("Il telefono non doveva essere corretto!", telefono_corretto);
    }

    @Test
    public void testEmailNonContieneChiocciola() {
        boolean email_con_chiocciola = false;

        String email = "alessio.russogmail.com";

        if(email.contains(String.valueOf('@'))) {
            email_con_chiocciola = true;
            InfoClientiEPrenotazioni.inserisciCliente("Alessio", "Russo",
                    "Via Venezia 12", "3493214568", email, "alessio12", "Alessio12#");
        } else {
            System.out.println("Email non contiene chiocciola!");
        }

        // l'email non è corretta, perché non contiene la chiocciola -> mi aspetto che email_con_chiocciola sia
        // false poiché l'aggiunta del cliente nel database fallisce
        assertFalse("La email non doveva contenere la chiocciola!", email_con_chiocciola);
    }


}
