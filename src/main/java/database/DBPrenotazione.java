package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;


public class DBPrenotazione {

    private int ID;
    private LocalDateTime data;
    private String stato;
    private String tipologiaTrattamento;
    private String usernameCliente;

    // costruttore che prende in ingresso la chiave primaria
    // viene usato dall'entity per effettuare la lettura dal database
    public DBPrenotazione(int ID) {
        this.ID = ID;
    }

    public void caricaDaDB() {

        // definisco la query
        String query = "SELECT * FROM Prenotazioni WHERE ID = " + this.ID;

        System.out.println(query); // stampa di debug della query

        try {

            // faccio la query di SELECT sfruttando il DBConnectionManager
            ResultSet rs = DBConnectionManager.selectQuery(query);

            // se la query dà risultati, prendo i dati della prenotazione dai campi-colonne della tabella
            // Prenotazioni e li uso per settare gli attributi dell'oggetto DBPrenotazione
            if(rs.next()) {
                this.data = rs.getObject("data", LocalDateTime.class);
                this.stato = rs.getString("stato");
                this.tipologiaTrattamento = rs.getString("Trattamenti_nome");
                this.usernameCliente = rs.getString("Clienti_username");
            }

        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public int salvaInDB(int ID) {

        int esitoQuery = 0; // 0 = nessun errore di scrittura sul database

        // definisco la query
        String query = "INSERT INTO Prenotazioni(ID, data, stato, usernameCliente, tipologiaTrattamento) VALUES (" + ID + ", '" + this.data.format(DatabaseDateUtils.DATE_TIME_FORMATTER) + "', '" + this.stato + "', '" + this.usernameCliente + "', '" + this.tipologiaTrattamento + "')";

        System.out.println(query); // stampa di debug della query

        try {

            // eseguo la query di INSERT sfruttando il DBConnectionManager
            esitoQuery = DBConnectionManager.updateQuery(query);

        }
        /*
        // il primo catch per l'eccezione di violazione del vincolo di primary key è stato aggiunto da me
        catch(SQLIntegrityConstraintViolationException e) {
            esitoQuery = -1;
            System.out.println("Esiste già uno studente con matricola " + matricola + "!");
            e.printStackTrace();
        }*/
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            esitoQuery = -1; //per segnalare l'errore di scrittura
        }

        return esitoQuery;

    }

    public int caricaPrenotazioneAttivaClientePerTrattamentoDaDB(String nomeTrattamento, String usernameCliente) {

        // definisco la query
        String query = "SELECT * FROM Prenotazioni WHERE Trattamenti_nome = "  nomeTrattamento " AND Clienti_username =

        System.out.println(query); // stampa di debug della query

        try {
            // faccio la query di SELECT sfruttando il DBConnectionManager
            ResultSet rs = DBConnectionManager.selectQuery(query);

            if(rs.next()) {
                // la query di SELECT dà un risultato -> esiste già una prenotazione attiva per
            }
        }






    }
}
