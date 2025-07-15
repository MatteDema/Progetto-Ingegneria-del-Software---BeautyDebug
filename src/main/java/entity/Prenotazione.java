package entity;

import database.DBPrenotazione;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Prenotazione {
    private int ID;
    private LocalDateTime data;
    private String stato;
    private Trattamento tipologiaTrattamento;
    private Cliente cliente;

    //Costruttore
    public Prenotazione(/*int ID*/ LocalDateTime data, String tipologiaTrattamento, String usernameCliente) {
        //this.ID = ID;
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
        DBPrenotazione p= new DBPrenotazione(); //DAO
        p.setData(this.data);
        p.setStato(this.stato);
        p.setTipologiaTrattamento(this.tipologiaTrattamento.getNome());
        p.setUsernameCliente(this.cliente.getUsername());

        // chiama salvaInDB sul DAO DBPrenotazione per la scrittura sul database
        return p.salvaInDB();
    }


    //Di seguito i metodi che non implementeremo:
   /* void registraDatiSeduta(String noteCliente, String prodottiUtilizzati, float costoEffettivo, LocalDate dataConsigliata){}
    void annullaPrenotazione(int id){}
  */

    //GETTER E SETTER con visibilità di package

    LocalDateTime getData() {return data;}
    void setData(LocalDateTime data) {this.data = data;}
    int getID() {return ID;}
    void setID(int ID) {this.ID = ID;}
    String getStato() {return stato;}
    void setStato(String stato) {this.stato = stato;}
    void setTipologiaTrattamento(String tipologiaTrattamento) {
        this.tipologiaTrattamento = new Trattamento(tipologiaTrattamento);
    }
    Trattamento getTipologiaTrattamento() {
        return this.tipologiaTrattamento;
    }
    void setCliente(String usernameCliente) {
        this.cliente = new Cliente(usernameCliente);
    }
    Cliente getCliente() {
        return this.cliente;
    }
}
