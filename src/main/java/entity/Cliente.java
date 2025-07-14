package entity;

public class Cliente {

    private String nome;
    private String cognome;
    private String indirizzo;
    private String telefono;
    private String email;
    private String username;
    private String password;
    private Prenotazione[] prenotazioni;
    private Seduta[] storico_trattamenti;

    void visualizzaDatiPersonali(){

    }

    void modificaDatiPersonali(){

    }

    LocalDateTime prenotaTrattamento(String nomeTrattamento){}

}
