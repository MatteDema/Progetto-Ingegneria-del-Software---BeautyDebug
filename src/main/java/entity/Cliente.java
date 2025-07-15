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
    // private ArrayList<Prenotazione> prenotazioni;
    // private ArrayList<Seduta> storicoTrattamenti;
    // i precedenti attributi commentati sono legati ai ruoli delle associazioni di Cliente con Prenotazione e Seduta,
    // e sono commentati poiché non li useremo nei metodi implementati

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
    }


    static ArrayList<LocalDateTime> prenotaTrattamento(String nomeTrattamento, String usernameCliente){

        // ricavo l'unica istanza della classe Singleton CentroEstetico
        CentroEstetico centro_estetico = CentroEstetico.getCentroEstetico();

        // uso l'unica istanza di CentroEstetico per verificare se il trattamento che si intende prenotare esiste
        boolean trattamento_esiste = centro_estetico.verificaSeTrattamentoGiaEsistente(nomeTrattamento);

        if(trattamento_esiste) {
            // verifica se il cliente ha già una prenotazione attiva per quella tipologia di trattamento
            boolean prenotazione_gia_attiva = verificaSeGiaPrenotazioneAttiva(nomeTrattamento, usernameCliente);

            if(!prenotazione_gia_attiva) {
                // il cliente si può prenotare
                // ricavo l'unica istanza della classe Singleton Agenda
                Agenda agenda = Agenda.getAgenda();

                // uso l'unica istanza di Agenda per cercare le fasce orarie libere, e quindi prenotabili, e le ritorno
                return agenda.cercaFasceOrarieLibere();
            }
        }

        return null;
    }

    private static boolean verificaSeGiaPrenotazioneAttiva(String nomeTrattamento, String usernameCliente){
        DBPrenotazione prenotazione = new DBPrenotazione();

        return prenotazione.esistePrenotazioneAttivaClientePerTrattamentoDaDB(nomeTrattamento, usernameCliente);

    }

    static boolean selezionaFasciaOraria(LocalDateTime fasciaOraria){

        // verifica se la fascia oraria per la quale ci si vuole prenotare è valida

        // ricavo l'unica istanza della classe Singleton Agenda
        Agenda agenda = Agenda.getAgenda();

        boolean fascia_valida = agenda.verificaData(fasciaOraria);

        return fascia_valida;
    }

    /*
    void visualizzaDatiPersonali(){}

    void modificaDatiPersonali(){}

    void visualizzaPrenotazioniAttive(){}

    ArrayList<DTOSeduta> consultaStoricoTrattamenti(){}

    void disdiciPrenotazioneAttiva(){}

    private Prenotazione ricercaPrenotazioneDaDisdire(){}
    */

    int scriviSuDB(String username){

        // creazione DAO DBCliente
        DBCliente dbCliente = new DBCliente();

        dbCliente.setNome(this.nome);
        dbCliente.setCognome(this.cognome);
        dbCliente.setIndirizzo(this.indirizzo);
        dbCliente.setTelefono(this.telefono);
        dbCliente.setEmail(this.email);
        dbCliente.setPassword(this.password);

        // chiama salvaInDB sul DAO DBCliente per la scrittura sul database
        return dbCliente.salvaInDB(username);

    }

    // setter e getter
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
    public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    public void setStoricoTrattamenti(ArrayList<Trattamento> storicoTrattamenti) {
        this.storicoTrattamenti = storicoTrattamenti;
    }
    */
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    /*
    public ArrayList<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public ArrayList<Trattamento> getStoricoTrattamenti() {
        return storicoTrattamenti;
    }
    */

}
