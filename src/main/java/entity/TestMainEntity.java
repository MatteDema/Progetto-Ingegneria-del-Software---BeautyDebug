package entity;

import com.mysql.cj.xdevapi.Client;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestMainEntity {

    public static void main(String[] args) {

        // TEST CLASSE ENTITY TRATTAMENTO
        //TEST 1 SCRIVI SU DB
//        Trattamento trattamento = new Trattamento("banane", "banane in testa", 5, "");
//        Trattamento trattamento2 = new Trattamento("pesche", "pesche in testa", 10, "Mensile");
//
//        System.out.println(trattamento.scriviSuDB("banane"));
//        System.out.println(trattamento2.scriviSuDB("pesche"));

//        Trattamento trattamento = new Trattamento("banane");
//        System.out.println(trattamento);

        //TEST CLASSE ENTITY REGISTRO RegistroClienti
        //TEST 1 INSERISCI CLIENTE
//        boolean cliente_aggiunto = RegistroClienti.getRegistroClienti().inserisciCliente("aaaaa","aaaaa","aaaaaa 3","1231231231","alessandro@gmail.com", "daje","DAIperfavore12#");
//        System.out.println(cliente_aggiunto);

        //TEST 2 VERFICA SE UTENTE GIA REGISTRATO
//        boolean username_presente = RegistroClienti.getRegistroClienti().verificaSeUtenteGiaRegistrato("ciaosaonoio");
//        System.out.println("Username: " + username_presente);

        //TEST 3 VERIFICA SE EMAIL GIA PRESENTE
        //fa il return di emailPresenteInDB già testato

        //TEST 4 REGISTRAZIONE
//        boolean email_ok = RegistroClienti.getRegistroClienti().registrazione("alessandro@gmail.com");
//        System.out.println(email_ok);


        //TEST PRENOTAZIONE ENTITY
        //TEST 1 SCRIVI SU DB
//        Prenotazione prenotazione = new Prenotazione(LocalDateTime.of(2025,7,23,12,0),"Pedicuree","pippozzo");
//        System.out.println(prenotazione.scriviSuDB());


        //TEST AGENDA ENTITY
        //TEST 1 AGGIUNGI NUOVA PRENOTAZIONE
        boolean pren_aggiunta = Agenda.getAgenda().aggiungiNuovaPrenotazione(LocalDateTime.of(2025,7,24,8,0),"pesche","pippozzo");
        System.out.println(pren_aggiunta);

        //TEST CLIENTE ENTITY
        //TEST 1 PRENOTA TRATTAMENTO
//        ArrayList<LocalDateTime> array = Cliente.prenotaTrattamento("banane","marcus2");
//        if(!array.isEmpty()){
//            System.out.println("Cliente si può prenotare!");
//            for(LocalDateTime dato : array){
//                System.out.println(dato);
//            }
//        }else if(array.isEmpty()){
//            System.out.println("Ha già una prenotazione attiva!");
//        }else if(array==null){
//            System.out.println("Trattamento scelto non esiste!");
//        }

    }
}
