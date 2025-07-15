package control;

import entity.InfoClientiEPrenotazioni;

import java.time.LocalDateTime;
import java.util.ArrayList;



public class ControllerGestionePrenotazioni {
    // classe Singleton: in tutta l'applicazione avremo una sola istanza di ControllerGestionePrenotazioni
    private static ControllerGestionePrenotazioni controller_prenotazioni; // attributo statico che rappresenta l'unica istanza della classe ControllerGestionePrenotazioni

    // metodo statico che nasconde la creazione dell'unica istanza di ControllerGestionePrenotazioni
    public static ControllerGestionePrenotazioni getControllerGestione_prenotazioni(){
        if(controller_prenotazioni == null){
            controller_prenotazioni = new ControllerGestionePrenotazioni();
        }
        return controller_prenotazioni;
    }

    private ControllerGestionePrenotazioni(){} // costruttore privato

    public ArrayList<LocalDateTime> prenotaTrattamento(String nomeTrattamento,String usernameCliente){
        // Avvio la richiesta di prenotazione, recuperando la lista delle fasce orarie libere dal metodo prenotaTrattamento della classe façade InfoClientiEPrenotazioni
        ArrayList<LocalDateTime> lista_fasce_orarie_libere = InfoClientiEPrenotazioni.prenotaTrattamento(nomeTrattamento, usernameCliente);

        return lista_fasce_orarie_libere;
    }

    public boolean verificaFasciaOraria(LocalDateTime fasciaOraria){
       // Delego la verifica della fascia oraria inserita alla classe façade InfoClientiEPrenotazioni
       boolean fascia_valida= InfoClientiEPrenotazioni.verificaFasciaOraria(fasciaOraria);

       return fascia_valida;
    }

    public boolean aggiungiNuovaPrenotazione(LocalDateTime fasciaOraria,String nomeTrattamento,String usernameCliente){
        // Delego l'aggiunta di una nuova prenotazione alla classe façade InfoClientiEPrenotazioni
        boolean esito_aggiunta_prenotazione = InfoClientiEPrenotazioni.aggiungiNuovaPrenotazione(fasciaOraria,nomeTrattamento,usernameCliente);

        return esito_aggiunta_prenotazione;
    }


    // Di seguito i metodi che non implementeremo;
    /*
    public boolean disdiciPrenotazioneAttiva(){}
    public ArrayList<DTOPrenotazione> visualizzaPrenotazioniAttive()
    */
}
