package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static database.DatabaseDateUtils.DATE_TIME_FORMATTER;


public class DBPrenotazione {

    private int ID;
    private LocalDateTime data;
    private String stato;
    private String tipologiaTrattamento;
    private String usernameCliente;

    // costruttore che prende in ingresso la chiave primaria, ossia l'ID della prenotazione
    // viene usato dall'entity per effettuare la lettura dal database
    public DBPrenotazione(int ID) {
        this.ID = ID;
        caricaDaDB();
    }

    // costruttore vuoto
    public DBPrenotazione() {}

    public void caricaDaDB() {

        // definisco la query
        String query = "SELECT * FROM Prenotazioni WHERE ID = " + this.ID +";";

        System.out.println(query); // stampa di debug della query

        try {
            // faccio la query di SELECT sfruttando il DBConnectionManager
            ResultSet rs = DBConnectionManager.selectQuery(query);

            // se la query dà risultati, prendo i dati della prenotazione dai campi-colonne della tabella
            // Prenotazioni e li uso per settare gli attributi dell'oggetto DBPrenotazione
            if(rs.next()) {
                this.ID = rs.getInt("ID");
                this.data = rs.getObject("data", LocalDateTime.class);
                this.stato = rs.getString("stato");
                this.tipologiaTrattamento = rs.getString("Trattamenti_nome");
                this.usernameCliente = rs.getString("Clienti_username");
            }

        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public int salvaInDB() {

        int esitoQuery = 0; // 0 = nessun errore di scrittura sul database

        // definisco la query
        String query = "INSERT INTO Prenotazioni(data, stato, Clienti_username, Trattamenti_nome) VALUES ('"
                + this.data.format(DATE_TIME_FORMATTER) + "', '" + this.stato + "', '" + this.usernameCliente + "', '" + this.tipologiaTrattamento + "');";

        System.out.println(query); // stampa di debug della query

        try {

            // eseguo la query di INSERT sfruttando il DBConnectionManager
            esitoQuery = DBConnectionManager.updateQuery(query);

        }
        /*
        // il primo catch per l'eccezione di violazione del vincolo di primary key è stato aggiunto da me
        catch(SQLIntegrityConstraintViolationException e) {
            esitoQuery = -1;
            System.out.println("Esiste già una prenotazione" + matricola + "!");
            e.printStackTrace();
        }*/
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            esitoQuery = -1; //per segnalare l'errore di scrittura
        }

        return esitoQuery;
    }

    public boolean esistePrenotazioneAttivaClientePerTrattamentoDaDB(String nomeTrattamento, String usernameCliente) {

        boolean esitoQuery = false; // false = il cliente non ha già una prenotazione attiva per la tipologia di trattamento indicata

        // definisco la query
        String query = "SELECT * FROM Prenotazioni WHERE Trattamenti_nome = '" + nomeTrattamento + "' AND Clienti_username = '" + usernameCliente + "' AND stato = 'attivo';";

        System.out.println(query); // stampa di debug della query

        try {
            // faccio la query di SELECT sfruttando il DBConnectionManager
            ResultSet rs = DBConnectionManager.selectQuery(query);

            if (rs.next()) {
                // la query di SELECT dà un risultato -> il cliente avente l'username passato come parametro
                // ha già una prenotazione attiva per la tipologia di trattamento specificata nell'altro parametro
                esitoQuery = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return esitoQuery;
    }

    public ArrayList<DBPrenotazione> caricaListaPrenotazioniAttiveDaDB() {

        // lista di appoggio contenente tutte le prenotazioni attive
        ArrayList<DBPrenotazione> prenotazioni_attive = new ArrayList<>();

        String query = "SELECT * FROM Prenotazioni WHERE stato = 'attivo';";

        System.out.println(query); // stampa di debug della query

        try {
            ResultSet rs = DBConnectionManager.selectQuery(query);

            while(rs.next()) {
                // finché ho un risultato, prelevo dalla tabella Prenotazioni i valori delle sue colonne, e li uso
                // per settare gli attributi di ogni oggetto DBPrenotazione che aggiungerò alla lista di appoggio da restituire

                // creo un DAO di tipo DBPrenotazione
                DBPrenotazione dbPrenotazione = new DBPrenotazione();
                dbPrenotazione.setID(rs.getInt("ID"));
                dbPrenotazione.setData(rs.getObject("data", LocalDateTime.class));
                dbPrenotazione.setStato(rs.getString("stato"));
                dbPrenotazione.setUsernameCliente(rs.getString("Clienti_username"));
                dbPrenotazione.setTipologiaTrattamento(rs.getString("Trattamenti_nome"));

                // aggiungo il nuovo DAO Prenotazione alla lista da restituire
                prenotazioni_attive.add(dbPrenotazione);
            }
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return prenotazioni_attive;
    }

    /*
    public ArrayList<DBPrenotazione> caricaPrenotazioniAttivePerClienteDaDB(String usernameCliente) {
        metodo per caricare dal database tutte le prenotazioni attive effettuate dal cliente avente l'username passato come parametro
        non implementato poiché non fa parte delle funzionalità implementate
    }
     */

    /*
    public int aggiornaInDB(int ID) {
        metodo per aggiornare una prenotazione, usando una query di UPDATE (ad esempio, per cambiarne lo stato)
        non implementato poiché non fa parte delle funzionalità implementate
    }
     */

    // getter e setter per recuperare e impostare i valori degli attributi di un DAO DBPrenotazione
    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getStato() {
        return this.stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getTipologiaTrattamento() {
        return this.tipologiaTrattamento;
    }

    public void setTipologiaTrattamento(String tipologiaTrattamento) {
        this.tipologiaTrattamento = tipologiaTrattamento;
    }

    public String getUsernameCliente() {
        return this.usernameCliente;
    }

    public void setUsernameCliente(String usernameCliente) {
        this.usernameCliente = usernameCliente;
    }

    @Override
    public String toString() {
        return "DBPrenotazione{" +
                "ID=" + ID +
                ", data=" + data.format(DATE_TIME_FORMATTER) +
                ", stato='" + stato + '\'' +
                ", tipologiaTrattamento='" + tipologiaTrattamento + '\'' +
                ", usernameCliente='" + usernameCliente + '\'' +
                '}';
    }
}
