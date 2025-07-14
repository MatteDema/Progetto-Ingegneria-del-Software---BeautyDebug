package database;

import java.time.LocalDate;

public class DBSeduta {
    private String noteCliente;
    private String prodottiUtilizzati;
    private float costoEffettivo;
    private LocalDate dataConsigliata;
    private int idPrenotazione;
    private String usernameCliente;

    public DBSeduta() {
    }

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

    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public String getUsernameCliente() {
        return usernameCliente;
    }

    public void setUsernameCliente(String usernameCliente) {
        this.usernameCliente = usernameCliente;
    }

    /*
    public void caricaDaDB(){
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */

    /*
    public int salvaInDB(int idPrenotazione){
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */

    /*
    public ArrayList<DBSeduta> caricaSedutePerClienteDaDB(){
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */

    /*
    public ArrayList<DBSeduta> caricaListaSedutePerDataDaDB(){
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */
}
