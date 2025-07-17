package entity;

import database.DBPrenotazione;

import java.time.LocalDateTime;

public class Prenotazione {
    private int ID;
    private LocalDateTime data;
    private String stato;
    private Trattamento tipologiaTrattamento;
    private Cliente cliente;

    //Costruttore
    public Prenotazione(LocalDateTime data, String tipologiaTrattamento, String usernameCliente) {
        //this.ID = ID; // l'ID viene aggiunto automaticamente nel database
        this.data = data;
        this.stato = "attivo";
        // recupero Trattamento e Cliente associati alla Prenotazione dal DB, usando i loro costruttori con chiave primaria
        this.tipologiaTrattamento = new Trattamento(tipologiaTrattamento);
        this.cliente = new Cliente(usernameCliente);
    }

    // costruttore vuoto
    public Prenotazione() {
        this.stato = "attivo";
    }

    int scriviSuDB(){
        DBPrenotazione dbPrenotazione = new DBPrenotazione(); // DAO
        dbPrenotazione.setData(this.data);
        dbPrenotazione.setStato(this.stato);
        dbPrenotazione.setTipologiaTrattamento(this.tipologiaTrattamento.getNome());
        dbPrenotazione.setUsernameCliente(this.cliente.getUsername());

        // chiama salvaInDB sul DAO DBPrenotazione per la scrittura sul database
        return dbPrenotazione.salvaInDB();
    }


    // Di seguito i metodi che non implementeremo:
    /*
    boolean registraDatiSeduta(String noteCliente, String prodottiUtilizzati, float costoEffettivo, LocalDate dataConsigliata){}
    void annullaPrenotazione(int id){}
    */

    //GETTER E SETTER

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Trattamento getTipologiaTrattamento() {
        return tipologiaTrattamento;
    }

    public void setTipologiaTrattamento(Trattamento tipologiaTrattamento) {
        this.tipologiaTrattamento = tipologiaTrattamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "ID=" + ID +
                ", data=" + data +
                ", stato='" + stato + '\'' +
                ", tipologiaTrattamento=" + tipologiaTrattamento +
                ", cliente=" + cliente +
                '}';
    }
}
