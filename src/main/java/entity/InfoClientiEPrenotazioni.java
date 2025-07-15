package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class InfoClientiEPrenotazioni {

    // classe Façade -> usa le classi Agenda, Cliente e RegistroClienti
    // consente di disaccoppiare maggiormente il livello Control dal livello Entity

    // fornisce dei metodi pubblici che saranno invocati dai Controller, e che richiamano i metodi con visibilità di package
    // delle classi Entity con le quali essa interagisce

    public static ArrayList<LocalDateTime> prenotaTrattamento(String nomeTrattamento, String usernameCliente) {
        return Cliente.prenotaTrattamento(nomeTrattamento, usernameCliente); // metodo statico
    }

    public static boolean selezionaFasciaOraria(LocalDateTime fasciaOraria) {
        return Cliente.selezionaFasciaOraria(fasciaOraria);
    }

    public static boolean aggiungiNuovaPrenotazione(LocalDateTime fasciaOraria, String nomeTrattamento, String usernameCliente) {
        // ricava l'unica istanza della classe Singleton Agenda, e su di essa invoca il metodo per aggiungere una prenotazione
        Agenda agenda = Agenda.getAgenda();

        return agenda.aggiungiNuovaPrenotazione(fasciaOraria, nomeTrattamento, usernameCliente);
    }
}
