package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String cognome;
    private String indirizzo;
    private String telefono;
    private String email;
    private String username;
    private String password;
    private Prenotazione[] prenotazioni;
    private Seduta[] storico_trattamenti;

    void visualizzaDatiPersonali(){

    }

    void modificaDatiPersonali(){

    }

    ArrayList<LocalDateTime> prenotaTrattamento(String nomeTrattamento){

    }

    private boolean verificaSeGiaPrenotazioneAttiva(String nomeTrattamento){
        boolean ris = false;

        return ris;
    }

    boolean selezionaFasciaOraria(LocalDateTime fasciaOraria){
        boolean ris = false;

        return ris;

    }

    void visualizzaPrenotazioniAttive(){

    }

    void consultaStoricoTrattamenti(){

    }

    void disdiciPrenotazioneAttiva(){

    }

    private Prenotazione ricercaPrenotazioneDaDisdire(){

    }

    void scriviSuDB(){

    }
}
