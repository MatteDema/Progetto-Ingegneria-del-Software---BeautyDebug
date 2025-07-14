package entity;

import database.DBFasceOrarieLavorative;
import database.DBPrenotazione;
import database.DatabaseDateUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Agenda {

    // classe Singleton: in tutta l'applicazione avremo una sola istanza di Agenda

    private static Agenda agenda; // attributo statico che rappresenta l'unica istanza della classe Agenda
    private ArrayList<LocalDateTime> fasceOrarieLibere;
    private ArrayList<LocalDateTime> slotOccupati;

    // costruttore privato
    private Agenda() {}

    // metodo statico (con visibilità di package) che nasconde la creazione dell'unica istanza di Agenda
    static Agenda getAgenda() {
        if (agenda == null) {
            agenda = new Agenda();
        }
        return agenda;
    }


    ArrayList<LocalDateTime> cercaFasceOrarieLibere() {

        // recupera tutte le disponibilità orarie del centro estetico (fasce orarie prenotate e non)
        DBFasceOrarieLavorative dbfasceOrarieLavorative = new DBFasceOrarieLavorative();

        ArrayList<DBFasceOrarieLavorative> fasce_orarie_complessive = dbfasceOrarieLavorative.caricaElencoDisponibilitaDaDB();

        // recupera le fasce orarie occupate (legate alle prenotazioni attive)
        DBPrenotazione dbPrenotazione = new DBPrenotazione();

        ArrayList<DBPrenotazione> prenotazioni_attive = dbPrenotazione.caricaListaPrenotazioniAttiveDaDB();

        boolean aggiunta_nuova_fascia_libera = false;

        // inizializzo le fasce orarie libere con tutte le disponibilità orarie del centro estetico
        for (int i = 0; i < fasce_orarie_complessive.size(); i++) {
            fasceOrarieLibere.add(fasce_orarie_complessive.get(i).getDisponibilitaOraria());
        }

        for (int i = 0; i < fasce_orarie_complessive.size(); i++) {

            for (int j = 0; j < prenotazioni_attive.size(); j++) {

                // se una certa fascia oraria è stata prenotata, la rimuovo dalla lista di fasce orarie libere
                if(prenotazioni_attive.get(j).getData().format(DatabaseDateUtils.DATE_TIME_FORMATTER).equals(fasce_orarie_complessive.get((i)))) {
                    fasceOrarieLibere.remove()
                }

            }
        }

    }




}
