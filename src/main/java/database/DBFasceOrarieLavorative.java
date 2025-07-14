package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DBFasceOrarieLavorative {

    private LocalDateTime disponibilitaOraria;

    public ArrayList<DBFasceOrarieLavorative> caricaElencoDisponibilitaDaDB() {

        // lista di appoggio di oggetti di tipo DBFasceOrarieLavorative
        ArrayList<DBFasceOrarieLavorative> fasce_orarie = new ArrayList<>();

        // definisco la query
        String query = "SELECT * FROM FasceOrarieLavorative";

        System.out.println(query); // stampa di debug della query

        try {

            // faccio la query di SELECT sfruttando il DBConnectionManager
            ResultSet rs = DBConnectionManager.selectQuery(query);

            while(rs.next()) {

                // itero sul ResultSet della query
                // finché ho un risultato, prendo i valori dell'unica colonna disponibilitaOraria della tabella
                // FasceOrarieLavorative, e li uso per valorizzare l'attributo disponibilitaOraria di ciascun DAO
                // che verrà poi aggiunto alla lista di appoggio

                // creo un DAO di tipo DBFasceOrarieLavorative
                DBFasceOrarieLavorative fascia_oraria = new DBFasceOrarieLavorative();

                fascia_oraria.setDisponibilitaOraria(rs.getObject("disponibilitaOraria", LocalDateTime.class));

                // aggiungo la nuova fascia oraria alla lista che devo restituire
                fasce_orarie.add(fascia_oraria);
            }
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return fasce_orarie;
    }

    /*
    public int aggiungiElencoDisponibilitaInDB(ArrayList<LocalDateTime> fasce_orarie) {
        metodo per creare delle disponibilità orarie nel DB
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    }
     */


    /*
    public int aggiornaElencoDisponibilitaInDB() {
        metodo per aggiornare alcune disponibilita orarie nel DB
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    }
     */

    public void setDisponibilitaOraria(LocalDateTime disponibilitaOraria) {
        this.disponibilitaOraria = disponibilitaOraria;
    }
}
