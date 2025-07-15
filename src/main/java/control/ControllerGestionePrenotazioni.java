package control;

import entity.InfoClientiEPrenotazioni;

import java.time.LocalDateTime;
import java.util.ArrayList;



public class ControllerGestionePrenotazioni {
    //classe Singleton
    private static ControllerGestionePrenotazioni controller_prenotazioni;

    //metodo per ottenere l'istanza di ControllerGestionePrenotazioni
    public static ControllerGestionePrenotazioni getControllerGestione_prenotazioni(){
        if(controller_prenotazioni == null){
            controller_prenotazioni = new ControllerGestionePrenotazioni();
        }
        return controller_prenotazioni;

    }
    private ControllerGestionePrenotazioni(){} //costruttore privato
    public ArrayList<LocalDateTime> prenotaTrattamento(String nomeTrattamento,String usernameCliente){
        //Recupero la lista delle fsce orarie libere dal metodo prenotaTrattamento della classe facade InfoClientiEPrenotazioni
        ArrayList<LocalDateTime>lista_fasce_orarie_libere=InfoClientiEPrenotazioni.prenotaTrattamento(nomeTrattamento,usernameCliente);

        return lista_fasce_orarie_libere;
    }
    public boolean selezionaFasciaOraria(LocalDateTime fasciaOraria){
       //Delego la verifica della validità della fascia oraria inserita alla classe facade InfoClientiEPrenotazioni
       boolean fascia_valida= InfoClientiEPrenotazioni.selezionaFasciaOraria(fasciaOraria);
       return fascia_valida;
    }
    public boolean aggiungiNuovaPrenotazione(LocalDateTime fasciaOraria,String nomeTrattamento,String usernameCliente){
        //Delego l'aggiunta di una nuova prenotazione alla classe facade InfoClientiEPrenotazioni
        boolean esito_prenotazione=InfoClientiEPrenotazioni.aggiungiNuovaPrenotazione(fasciaOraria,nomeTrattamento,usernameCliente);
        return esito_prenotazione;
    }




    // Di seguito i metodi che non implementeremo;
    /*

    public boolean disdiciPrenotazioneAttiva(){}
    public ArrayList<DTOPrenotazioni> visualizzaPrenotazioniAttive()
     */
}
