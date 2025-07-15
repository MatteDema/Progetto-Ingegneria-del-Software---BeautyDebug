package entity;

import database.DBFasceOrarieLavorative;
import database.DBPrenotazione;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Agenda {

    // classe Singleton: in tutta l'applicazione avremo una sola istanza di Agenda

    private static Agenda agenda; // attributo statico che rappresenta l'unica istanza della classe Agenda
    private static ArrayList<LocalDateTime> fasceOrarieLibere;
    private static ArrayList<Prenotazione> slotOccupati;

    // costruttore privato
    private Agenda() {
        // inizializzazione Array List
        fasceOrarieLibere = new ArrayList<>();
        slotOccupati = new ArrayList<>();
    }

    // metodo statico (con visibilità di package) che nasconde la creazione dell'unica istanza di Agenda
    static Agenda getAgenda() {
        if (agenda == null) {
            agenda = new Agenda();
        }
        return agenda;
    }

    // metodo di utilità per caricare la lista di disponibilità orarie dal DB
    private static ArrayList<LocalDateTime> getFasceOrarieLavorative() {

        // istanzio un DAO DBFasceOrarieLavorative
        DBFasceOrarieLavorative DBfasceOrarieLavorative = new DBFasceOrarieLavorative();
        // uso il DAO per recuperare l'elenco disponibilità orarie dal DB
        ArrayList<DBFasceOrarieLavorative> DBfasceOrarieComplessive = DBfasceOrarieLavorative.caricaElencoDisponibilitaDaDB();


        // costruisco la lista di LocalDateTime da restituire, iterando sulla lista di oggetti DBFasceOrarieLavorative
        ArrayList<LocalDateTime> fasceOrarieComplessive = new ArrayList<>();

        for (int i = 0; i < DBfasceOrarieComplessive.size(); i++) {
            fasceOrarieComplessive.add(DBfasceOrarieComplessive.get(i).getDisponibilitaOraria());
        }

        return fasceOrarieComplessive; // restituisce la lista ottenuta
    }

    // metodo di utilità per caricare le fasce orarie occupate dal DB
    private static void getSlotOccupati() {

        // istanzio un DAO DBPrenotazione
        DBPrenotazione dbPrenotazione = new DBPrenotazione();
        // uso il DAO per recuperare la lista di prenotazioni attive dal DB
        ArrayList<DBPrenotazione> DBprenotazioniAttive = dbPrenotazione.caricaListaPrenotazioniAttiveDaDB();


        // costruisco la lista di oggetti Entity Prenotazione corrispondenti alle prenotazioni attive di livello DAO,
        // iterando sulla lista DBPrenotazioniAttive
        ArrayList<Prenotazione> prenotazioniAttive = new ArrayList<>();
        for (int i = 0; i < DBprenotazioniAttive.size(); i++) {

            // creo una Prenotazione di appoggio
            Prenotazione prenotazione = new Prenotazione();
            prenotazione.setID(DBprenotazioniAttive.get(i).getID());
            prenotazione.setData(DBprenotazioniAttive.get(i).getData());
            prenotazione.setStato(DBprenotazioniAttive.get(i).getStato());
            prenotazione.setTipologiaTrattamento(new Trattamento(DBprenotazioniAttive.get(i).getTipologiaTrattamento()));
            prenotazione.setCliente(new Cliente(DBprenotazioniAttive.get(i).getUsernameCliente()));

            // aggiungo la prenotazione alla lista di prenotazioni attive
            prenotazioniAttive.add(prenotazione);
        }

        slotOccupati = prenotazioniAttive;
    }

    ArrayList<LocalDateTime> cercaFasceOrarieLibere() {

        // recupera tutte le disponibilità orarie del centro estetico (fasce orarie prenotate e non)
        ArrayList<LocalDateTime> fasce_orarie_complessive = getFasceOrarieLavorative();

        // recupera le fasce orarie occupate (legate alle prenotazioni attive)
        // recupera le prenotazioni attive
        getSlotOccupati();

        // inizializzo le fasce orarie libere con tutte le disponibilità orarie del centro estetico
        fasceOrarieLibere.clear();
        for (LocalDateTime localDateTime : fasce_orarie_complessive) {
            fasceOrarieLibere.add(localDateTime);
        }

        // for per aggiornare le fasce orarie libere, sottraendo alle disponibilità orarie complessive
        // le fasce orarie già occupate

        // elimino le fasce orarie corrispondenti agli slot occupati dall'elenco delle fasce orarie libere
        // per farlo, itero sulle prenotazioni attive (variabile statica slotOccupati), e ne prendo le fasce orarie corrispondenti
        for (int i = 0; i < slotOccupati.size(); i++) {
            fasceOrarieLibere.remove(slotOccupati.get(i).getData());
        }

        // restiruisco le fasce orarie libere
        return fasceOrarieLibere;
    }

    boolean verificaFasciaOraria(LocalDateTime fasciaOraria) {

        boolean fascia_valida = false;

        // abbiamo impostato data_limite aggiungendo tre giorni alla data corrente
        LocalDateTime data_limite = LocalDateTime.now().plusDays(3);

        // la data per la quale ci si prenota, per essere considerata valida, deve rientrare tra le fasce orarie libere
        // e non deve essere antecedente a tre giorni dalla data corrente
        if(fasceOrarieLibere.contains(fasciaOraria) && (fasciaOraria.isAfter(data_limite))) {
            fascia_valida = true;
        }

        return fascia_valida;
    }

    boolean aggiungiNuovaPrenotazione(LocalDateTime fasciaOraria, String nomeTrattamento, String usernameCliente) {

        boolean prenotazione_aggiunta = false;

        // creazione di un oggetto Prenotazione
        Prenotazione nuovaPrenotazione = new Prenotazione(fasciaOraria, nomeTrattamento, usernameCliente);

        // avvio la scrittura sul database chiamando scriviSuDB sull'oggetto Prenotazione Entity
        int esito_scrittura_suDB = nuovaPrenotazione.scriviSuDB();

        if(esito_scrittura_suDB == 0) {
            // scrittura della nuova prenotazione sul database andata a buon fine
            prenotazione_aggiunta = true;
            System.out.println("Prenotazione aggiunta!");
        } else if (esito_scrittura_suDB == -1) {
            System.out.println("Errore nell'aggiunta della prenotazione!");
        }

        return prenotazione_aggiunta;
    }

}
