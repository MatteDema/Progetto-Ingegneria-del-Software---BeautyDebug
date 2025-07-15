package entity;

import java.time.LocalDate;

public class Seduta {
    private String noteCliente;
    private String prodottiUtilizzati;
    private float costoEffettivo;
    private LocalDate dataConsigliata;
    private Prenotazione trattamentoEseguito;

    //Costruttore
    public Seduta(String noteCliente,String prodottiUtilizzati,float costoEffettivo,LocalDate dataConsigliata) {
        this.noteCliente = noteCliente;
        this.prodottiUtilizzati = prodottiUtilizzati;
        this.costoEffettivo = costoEffettivo;
        this.dataConsigliata = dataConsigliata;
        this.trattamentoEseguito = new Prenotazione();
    }

    //Di seguito il metodo che non implementeremo:
    // boolean inviaNotificaNuovoAppuntamento(){}

    //GETTER E SETTER

    public String getNoteCliente() {
        return noteCliente;
    }

    public void setNoteCliente(String noteCliente) {
        this.noteCliente = noteCliente;
    }

    public String getProdottiUtilizzati() {
        return prodottiUtilizzati;
    }

    public void setProdottiUtilizzati(String prodottiUtilizzati) {
        this.prodottiUtilizzati = prodottiUtilizzati;
    }

    public float getCostoEffettivo() {
        return costoEffettivo;
    }

    public void setCostoEffettivo(float costoEffettivo) {
        this.costoEffettivo = costoEffettivo;
    }

    public LocalDate getDataConsigliata() {
        return dataConsigliata;
    }

    public void setDataConsigliata(LocalDate dataConsigliata) {
        this.dataConsigliata = dataConsigliata;
    }

    public Prenotazione getTrattamentoEseguito() {
        return trattamentoEseguito;
    }

    public void setTrattamentoEseguito(Prenotazione trattamentoEseguito) {
        this.trattamentoEseguito = trattamentoEseguito;
    }
}
