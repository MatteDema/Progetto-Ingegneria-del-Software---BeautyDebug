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

        int esitoQuery = 0;

        String query = "INSERT INTO Prenotazioni(ID, data, stato, tipologiaTrattamento, usernameCliente) VALUES (" + ID + ", " + this.data + ", '" + this.stato + "', '" + this.tipologiaTrattamento + "', '" + this.usernameCliente + "')";

        System.out.println(query); // stampa di debug

        try {

            // eseguo la query
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
            // TODO Auto-generated catch block
            e.printStackTrace();
            esitoQuery = -1; //per segnalare l'errore di scrittura
        }

        return esitoQuery;


    }
}
