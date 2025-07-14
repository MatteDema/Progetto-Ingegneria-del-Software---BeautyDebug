package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Prenotazione {
    private int ID;
    private LocalDateTime data;
    private String stato="attivo";

    void registraDatiSeduta(String noteCliente, String prodottiUtilizzati, float costoEffettivo, LocalDate dataConsigliata){}
    void annullaPrenotazione(int id){}
    int scriviSuDB(int id){}
}
