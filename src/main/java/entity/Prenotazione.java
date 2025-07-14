package entity;

import database.DBPrenotazione;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Prenotazione {
    private int ID;
    private LocalDateTime data;
    private String stato="attivo";

    //Costruttore
    public Prenotazione(int ID, LocalDateTime data, String stato) {
        this.ID = ID;
        this.data = data;
        this.stato = stato;
    }
    int scriviSuDB(int id){
        DBPrenotazione p= new DBPrenotazione(); //DAO
        p.setData(this.data);
        p.setStato(this.stato);
        int i = p.salvaInDB(id);

        return i;
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
}
