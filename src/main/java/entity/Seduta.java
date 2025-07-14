package entity;

import java.time.LocalDate;

public class Seduta {
    private String noteCliente;
    private String prodottiUtilizzati;
    private float costoEffettivo;
    private LocalDate dataConsigliata;


    //Costruttore
    public Seduta(String noteCliente,String prodottiUtilizzati,float costoEffettivo,LocalDate dataConsigliata) {
        this.noteCliente = noteCliente;
        this.prodottiUtilizzati = prodottiUtilizzati;
        this.costoEffettivo = costoEffettivo;
        this.dataConsigliata = dataConsigliata;
    }
    void inviaNotificaNuovoAppuntamemto(){}

    // GETTER E SETTER con visibilita di package
     float getCostoEffettivo() {return costoEffettivo;}
     void setCostoEffettivo(float costoEffettivo) {this.costoEffettivo = costoEffettivo;}
    LocalDate getDataConsigliata() {return dataConsigliata;}
     void setDataConsigliata(LocalDate dataConsigliata) {this.dataConsigliata = dataConsigliata;}
     String getNoteCliente() {return noteCliente;}
     void setNoteCliente(String noteCliente) {this.noteCliente = noteCliente;}
     String getProdottiUtilizzati() {return prodottiUtilizzati;}
     void setProdottiUtilizzati(String prodottiUtilizzati) {this.prodottiUtilizzati = prodottiUtilizzati;}
}
