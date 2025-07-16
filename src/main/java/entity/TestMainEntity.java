package entity;

import com.mysql.cj.xdevapi.Client;
import dto.DTOTrattamento;

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

        //TEST CLASSE ENTITY REGISTRO CLIENTI
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
//        boolean pren_aggiunta = Agenda.getAgenda().aggiungiNuovaPrenotazione(LocalDateTime.of(2025,7,24,8,0),"pesche","pippozzo");
//        System.out.println(pren_aggiunta);

        //TEST 2 CERCA FASCE ORARIE LIBERE, SLOT OCCUPATI
//        ArrayList<LocalDateTime> array = Agenda.getAgenda().cercaFasceOrarieLibere();
//        ArrayList<Prenotazione> slot_occupati = Agenda.getSlotOccupati();
//        System.out.println("Di seguito le prenotazioni attive");
//        for (Prenotazione p : slot_occupati) {
//            System.out.println(p);
//        }
//        System.out.println("Di seguito le fasce orarie libere");
//        for (LocalDateTime ldt : array) {
//            System.out.println(ldt);
//        }

        //TEST 3 VERIFICA FASCIA ORARIA
//        Agenda.getAgenda().cercaFasceOrarieLibere();
//        for(LocalDateTime data : Agenda.getFasceOrarieLibere()){
//            System.out.println(data.toString());
//        }
//        boolean fascia_valida = Agenda.getAgenda().verificaFasciaOraria(LocalDateTime.of(2025,7,25,10,0));
//        System.out.println(fascia_valida); //true
//        boolean fascia_valida2 = Agenda.getAgenda().verificaFasciaOraria(LocalDateTime.of(2025,7,25,16,0));
//        System.out.println(fascia_valida2); //false


        //TEST CLIENTE ENTITY
        //TEST 1 PRENOTA TRATTAMENTO
//        ArrayList<LocalDateTime> array = Cliente.prenotaTrattamento("Manicuree","pippozzo");
//        if(array==null){
//            System.out.println("Trattamento scelto non esiste!");
//        } else if(!array.isEmpty()){
//            System.out.println("Cliente si può prenotare!");
//            for(LocalDateTime dato : array){
//                System.out.println(dato);
//            }
//        }else if(array.isEmpty()){
//            System.out.println("Ha già una prenotazione attiva!");
//        }


        //TEST CLASSE CENTRO ESTETICO ENTITY
        //TEST 1 AGGIUNTA TRATTAMENTO
//        boolean trattamento_aggiunto = CentroEstetico.getCentroEstetico().aggiungiTrattamento("Percoche", "E quant'è bello magna", 5, "Giornaliero");
//        System.out.println(trattamento_aggiunto);

        //TEST 2 VISUALIZZA TUTTI I TRATTAMENTI
//        ArrayList<DTOTrattamento> dtoTrattamento = CentroEstetico.getCentroEstetico().visualizzaTuttiTrattamentiDisponibili();
//        int i=0;
//        for (DTOTrattamento dtoTrattamento1: dtoTrattamento) {
//            System.out.println(dtoTrattamento1 + "numero" + i++);
//        }

        //TEST 2 VISUALIZZA TRATTAMENTO PER NOME
//        ArrayList<DTOTrattamento> dtoTrattamento = CentroEstetico.getCentroEstetico().visualizzaTrattamentoPerNome("PercAoche");
//        int i=0;
//        if(dtoTrattamento!=null) {
//            for (DTOTrattamento dtoTrattamento1: dtoTrattamento) {
//                System.out.println(dtoTrattamento1 + "numero" + i++);
//            }
//        }

        //TEST 3 VISUALIZZA TRATTAMENTI PER COSTO
//        ArrayList<DTOTrattamento> dtoTrattamento = CentroEstetico.getCentroEstetico().visualizzaTrattamentiPerCosto(80);
//        int i=0;
//        if(dtoTrattamento!=null) {
//            for (DTOTrattamento dtoTrattamento1: dtoTrattamento) {
//                System.out.println(dtoTrattamento1 + "numero" + i++);
//            }
//        }
    }
}
