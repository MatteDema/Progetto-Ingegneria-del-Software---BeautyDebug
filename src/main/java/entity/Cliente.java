package entity;

import database.DBPrenotazione;

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
    private ArrayList<Prenotazione> prenotazioni;
    private ArrayList<Trattamento> storicoTrattamenti;

    Cliente(String nome, String cognome, String indirizzo, String telefono, String email, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.telefono = telefono;
        this.email = email;
        this.username = username;
        this.password = password;
        //this.prenotazioni = new ArrayList<>();
        //this.storicoTrattamenti = new ArrayList<>();
    }

    void visualizzaDatiPersonali(){

    }

    void modificaDatiPersonali(){

    }

    ArrayList<LocalDateTime> prenotaTrattamento(String nomeTrattamento){

    }

    private boolean verificaSeGiaPrenotazioneAttiva(String nomeTrattamento){
        DBPrenotazione prenotazione = new DBPrenotazione();

        int risultato = prenotazione.caricaPrenotazioneAttivaClientePerTrattamentoDaDB(nomeTrattamento, this.username);

        if(risultato == 0){
            // 0 = il cliente non ha già una prenotazione attiva per la tipologia di trattamento indicata
            return false;
        }
        else{
            return true;
        }
    }

    boolean selezionaFasciaOraria(LocalDateTime fasciaOraria){

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
