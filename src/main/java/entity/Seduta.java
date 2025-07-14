package entity;

import java.time.LocalDate;

public class Seduta {
    private String noteCliente;
    private String prodottiUtilizzati;
    private float costoEffettivo;
    private LocalDate dataConsigliata;

    public Seduta(String noteCliente,String prodottiUtilizzati,float costoEffettivo,LocalDate dataConsigliata) {}
    void inviaNotificaNuovoAppuntamemto(){}
}
