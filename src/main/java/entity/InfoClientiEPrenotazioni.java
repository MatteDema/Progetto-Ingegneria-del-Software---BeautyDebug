package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class InfoClientiEPrenotazioni {

    // classe Façade -> usa le classi Agenda, Cliente e RegistroClienti
    // consente di disaccoppiare maggiormente il livello Control dal livello Entity

    // fornisce dei metodi pubblici che saranno invocati dai Controller, e che richiamano i metodi con visibilità di package
    // delle classi Entity con le quali essa interagisce

    public static boolean registrazione(String email) {
        // ricava l'unica istanza della classe Singleton RegistroClienti,
        // e su di essa invoca il metodo per avviare le registrazione di un cliente
        RegistroClienti registroClienti = RegistroClienti.getRegistroClienti();

        return registroClienti.registrazione(email);
    }

    public static boolean verificaSeUtenteGiaRegistrato(String username) {
        // ricava l'unica istanza della classe Singleton RegistroClienti,
        // e su di essa invoca il metodo per verificare che non esista già nel sistema l'username passato come parametro
        RegistroClienti registroClienti = RegistroClienti.getRegistroClienti();

        return registroClienti.verificaSeUtenteGiaRegistrato(username);
    }

    public static boolean inserisciCliente(String nome, String cognome, String indirizzo, String telefono, String email, String username, String password) {
        // ricava l'unica istanza della classe Singleton RegistroClienti,
        // e su di essa invoca il metodo per completare la registrazione del nuovo cliente
        RegistroClienti registroClienti = RegistroClienti.getRegistroClienti();

        return registroClienti.inserisciCliente(nome, cognome, indirizzo, telefono, email, username, password);
    }

    public static ArrayList<LocalDateTime> prenotaTrattamento(String nomeTrattamento, String usernameCliente) {
        return Cliente.prenotaTrattamento(nomeTrattamento, usernameCliente); // metodo statico
    }

    public static boolean verificaFasciaOraria(LocalDateTime fasciaOraria) {

        // ricava l'unica istanza della classe Singleton Agenda, e su di essa invoca il metodo per verificare la fascia oraria inserita
        Agenda agenda = Agenda.getAgenda();

        return agenda.verificaFasciaOraria(fasciaOraria);
    }

    public static boolean aggiungiNuovaPrenotazione(LocalDateTime fasciaOraria, String nomeTrattamento, String usernameCliente) {
        // ricava l'unica istanza della classe Singleton Agenda, e su di essa invoca il metodo per aggiungere una prenotazione
        Agenda agenda = Agenda.getAgenda();

        return agenda.aggiungiNuovaPrenotazione(fasciaOraria, nomeTrattamento, usernameCliente);
    }

    //i metodi che non abbiamo inserito non verranno utilizzati per le funzionalità implementate
}
