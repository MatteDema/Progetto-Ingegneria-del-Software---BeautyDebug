package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

import static database.DatabaseDateUtils.TIME_FORMATTER;

public class DBDisponibilitaOrarieSettimanali {
    private String giorno;
    private boolean apertura;
    private LocalTime orarioPrimoAppuntamento;
    private LocalTime orarioUltimoAppuntamento;


    //costruttore che prende in ingresso la PK di DisponibilitaOrarieSettimanali
    public DBDisponibilitaOrarieSettimanali(String giorno) {
        this.giorno = giorno;
        caricaDaDB();
    }

    public void caricaDaDB() {
        //definisco la query di select
        String query="SELECT * FROM DisponibilitaOrarieSettimanali WHERE giorno='"+this.giorno+"';";
        System.out.println(query);

        try{
            //eseguo la query
            ResultSet rs=DBConnectionManager.selectQuery(query);

            if(rs.next()) { //se ho un risultato

                //prelevo i dati accedendo tramite il giorno
                this.setApertura(rs.getBoolean("apertura"));
                this.setOrarioPrimoAppuntamento(rs.getObject("orarioPrimoAppuntamento", LocalTime.class));
                this.setOrarioUltimoAppuntamento(rs.getObject("orarioUltimoAppuntamento", LocalTime.class));
            }
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public int SalvaInDB(String giorno){
        int esitoQuery = 0;

        String query = "INSERT INTO DisponibilitaOrarieSettimanali(giorno,apertura,orarioPrimoAppuntamento,orarioUltimoAppuntamento) " +
                "VALUES ('"+ this.giorno +"',"+this.apertura+",'"+this.orarioPrimoAppuntamento.format(TIME_FORMATTER)+"','"+this.orarioUltimoAppuntamento.format(TIME_FORMATTER)+"')";
        System.out.println(query);

        try {

            esitoQuery = DBConnectionManager.updateQuery(query);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            esitoQuery = -1; //per segnalare l'errore di scrittura
        }

        return esitoQuery;
    }

    /*
    public int aggiornaInDB(String giorno){
        metodo per aggiornare una disponibilità oraria nel DB
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */

    /*
    public int caricaDisponibilitàOrarieSettimanaliDaDB(String giorno){
        metodo per caricare l'elenco completo delle disponibilità orarie da DB
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */

    public DBDisponibilitaOrarieSettimanali() {
    }

    public String getGiorno() { return giorno; }
    public void setGiorno(String giorno) { this.giorno = giorno; }
    public boolean isApertura() { return apertura; }
    public void setApertura(boolean apertura) { this.apertura = apertura; }
    public LocalTime getOrarioPrimoAppuntamento() { return orarioPrimoAppuntamento; }
    public void setOrarioPrimoAppuntamento(LocalTime orarioPrimoAppuntamento) { this.orarioPrimoAppuntamento = orarioPrimoAppuntamento; }
    public LocalTime getOrarioUltimoAppuntamento() { return orarioUltimoAppuntamento; }
    public void setOrarioUltimoAppuntamento(LocalTime orarioUltimoAppuntamento) { this.orarioUltimoAppuntamento = orarioUltimoAppuntamento; }
}
