package entity;

import database.DBCliente;
import database.DBPrenotazione;

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

    // costruttore con chiave primaria per la lettura dal database di un cliente
    Cliente(String username) {
        // chiama il costruttore con chiave primaria della classe DAO associata
        DBCliente dbCliente = new DBCliente(username);

        // popolo gli attributi del Cliente a livello Entity
        this.nome = dbCliente.getNome();
        this.cognome = dbCliente.getCognome();
        this.indirizzo = dbCliente.getIndirizzo();
        this.telefono = dbCliente.getTelefono();
        this.email = dbCliente.getEmail();
        this.username = username;
        this.password = dbCliente.getPassword();
    }

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

    /*
    ArrayList<LocalDateTime> prenotaTrattamento(String nomeTrattamento){

    }
*/
    private boolean verificaSeGiaPrenotazioneAttiva(String nomeTrattamento){
        DBPrenotazione prenotazione = new DBPrenotazione();

        int risultato = prenotazione.esistePrenotazioneAttivaClientePerTrattamentoDaDB(nomeTrattamento, this.username);

        if(risultato == 0){
            // 0 = il cliente non ha già una prenotazione attiva per la tipologia di trattamento indicata
            return false;
        }
        else{
            return true;
        }
    }

    boolean selezionaFasciaOraria(LocalDateTime fasciaOraria){
    return true;
    }

    void visualizzaPrenotazioniAttive(){

    }

    void consultaStoricoTrattamenti(){

    }

    void disdiciPrenotazioneAttiva(){

    }

    /*
    private Prenotazione ricercaPrenotazioneDaDisdire(){

    }
*/
    void scriviSuDB(){

    }
}
