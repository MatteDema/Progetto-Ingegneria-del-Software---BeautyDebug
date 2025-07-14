package entity;

import java.time.LocalTime;

public class GiornoSettimanale {
    private String giorno;
    private boolean apertura;
    private LocalTime orarioPrimoAppuntamento;
    private LocalTime orarioUltimoAppuntamento;

    //Costruttore
    public GiornoSettimanale(String giorno,boolean apertura,LocalTime orarioPrimoAppuntamento,LocalTime orarioUltimoAppuntamento) {
        this.apertura = apertura;
        this.giorno=giorno;
        this.orarioPrimoAppuntamento = orarioPrimoAppuntamento;
        this.orarioUltimoAppuntamento = orarioUltimoAppuntamento;
    }

    //GETTER E SETTER

    boolean isApertura() {return apertura;}
    void setApertura(boolean apertura) {this.apertura = apertura;}
    String getGiorno() {return giorno;}
    void setGiorno(String giorno) {this.giorno = giorno;}
    LocalTime getOrarioPrimoAppuntamento() {return orarioPrimoAppuntamento;}
    LocalTime getOrarioUltimoAppuntamento() {return orarioUltimoAppuntamento;}
    void setOrarioUltimoAppuntamento(LocalTime orarioUltimoAppuntamento) {this.orarioUltimoAppuntamento = orarioUltimoAppuntamento;}
    void setOrarioPrimoAppuntamento(LocalTime orarioPrimoAppuntamento) {this.orarioPrimoAppuntamento = orarioPrimoAppuntamento;}
}
