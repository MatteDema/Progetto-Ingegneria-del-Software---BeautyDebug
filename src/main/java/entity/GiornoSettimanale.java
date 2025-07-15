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

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public boolean isApertura() {
        return apertura;
    }

    public void setApertura(boolean apertura) {
        this.apertura = apertura;
    }

    public LocalTime getOrarioPrimoAppuntamento() {
        return orarioPrimoAppuntamento;
    }

    public void setOrarioPrimoAppuntamento(LocalTime orarioPrimoAppuntamento) {
        this.orarioPrimoAppuntamento = orarioPrimoAppuntamento;
    }

    public LocalTime getOrarioUltimoAppuntamento() {
        return orarioUltimoAppuntamento;
    }

    public void setOrarioUltimoAppuntamento(LocalTime orarioUltimoAppuntamento) {
        this.orarioUltimoAppuntamento = orarioUltimoAppuntamento;
    }
}
