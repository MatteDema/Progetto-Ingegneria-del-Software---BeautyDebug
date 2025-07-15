package entity;

import dto.DTOTrattamento;

import java.util.ArrayList;

public class CentroEstetico {
    //classe singleton
    private static CentroEstetico centroEstetico = null; //riferimento all'unica istanza

    private RegistroClienti registroClienti;

    void associaRegistroClienti(RegistroClienti registroClienti) {
        this.registroClienti = registroClienti;
    }

    public static CentroEstetico getCentroEstetico(){ //metodo per ottenere l'istanza di CentroEstetico
        if(centroEstetico == null){
            centroEstetico = new CentroEstetico();
        }
        return centroEstetico;
    }

    private CentroEstetico(){} //costruttore privato

    public ArrayList<DTOTrattamento> visualizzaTuttiTrattamentiDisponibili(){
        return null;
    }

    public ArrayList<DTOTrattamento> visualizzaTrattamentoPerNome(String nomeTrattamento){
        return null;
    }

    public ArrayList<DTOTrattamento> visualizzaTrattamentiPerCosto(int costo){
        return null;
    }

    public boolean aggiungiTrattamento(String nome, String descrizione, int costo, String ripetizionePeriodica){

        boolean esitoAggiunta = false;

        //ambaradan

        return esitoAggiunta;
    }

    boolean verificaSeTrattamentoGiaEsistente(String nomeTrattamento){

    }

    /*
    public boolean rimuoviTrattamento(String nomeTrattamento){
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */

    /*
    public boolean modificaTrattamento(String nomeTrattamento){
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */

    /*
    public boolean definisciDisponibilitaOrarie(ArrayList<DTOGiornoSettimanale> disponibilitaOrarieSettimanali){
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */

    /*
    public ArrayList<DTOSeduta> consultaSedutePerData(LocalDate data){
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */

    /*
    public int visualizzaIncassoGiornaliero(LocalDate data){
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */
}
