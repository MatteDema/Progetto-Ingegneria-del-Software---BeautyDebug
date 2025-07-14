package entity;

import database.DBFasceOrarieLavorative;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Agenda {

    // classe Singleton: in tutta l'applicazione avremo una sola istanza di Agenda

    private static Agenda agenda; // attributo statico che rappresenta l'unica istanza della classe Agenda
    private ArrayList<LocalDateTime> fasceOrarieLibere;

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

        // recupera le fasce orarie occupate



    }




}
