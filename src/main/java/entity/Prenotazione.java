package entity;

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

    void registraDatiSeduta(String noteCliente, String prodottiUtilizzati, float costoEffettivo, LocalDate dataConsigliata){}
    void annullaPrenotazione(int id){}
    int scriviSuDB(int id){
        return 1; }

    //GETTER E SETTER con visibilità di package

    LocalDateTime getData() {return data;}
    void setData(LocalDateTime data) {this.data = data;}
    int getID() {return ID;}
    void setID(int ID) {this.ID = ID;}
    String getStato() {return stato;}
    void setStato(String stato) {this.stato = stato;}
}
