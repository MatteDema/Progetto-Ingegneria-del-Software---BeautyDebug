package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBTrattamento {
    private String nome;
    private String descrizione;
    private int costo;
    private String ripetizionePeriodica;

    public DBTrattamento(String nome){
        this.nome=nome;
        caricaDaDB();

    }
    public int salvaInDB(String nome){
        int esitoQuery = 0;

        String query = "INSERT INTO Trattamenti(nome,descrizione,costo,ripetizionePeriodica) VALUES ( "+nome+","+this.descrizione+",'"+this.costo+",'"+this.ripetizionePeriodica+"')";
        System.out.println(query);
        try {

            esitoQuery = DBConnectionManager.updateQuery(query);


        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            esitoQuery = -1;
        }

        return esitoQuery;


    }

    public void caricaDaDB(){
        //1.Definisco la query

        String query = "SELECT * FROM Trattamenti WHERE nome='"+this.nome+"';";
        System.out.println(query); //per debug
        try {
            //2.Query di select
            ResultSet rs = DBConnectionManager.selectQuery(query);

            if(rs.next()) {
                //3.Accedo tramite il nome dell'attributo-colonna ai dati
                this.setNome(rs.getString("nome"));
                this.setDescrizione(rs.getString("descrizione"));
                this.setCosto(rs.getInt("costo"));
                this.setRipetizionePeriodica(rs.getString("ripetizionePeriodica"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
    public ArrayList<DBTrattamento> caricaTrattamentiPerCostoDaDB(int costo){
        //Creo una lista temporanea
        ArrayList<DBTrattamento> trattamenti_lista_temp = new ArrayList<>();
        //Definisco la query
        String query="SELECT * FROM Trattamenti WHERE costo<='"+costo+"';";
        System.out.println(query); //per debug
        try {

            ResultSet rs = DBConnectionManager.selectQuery(query);

            while(rs.next()) {

                DBTrattamento trattamento_temp = new DBTrattamento();
                //Accedo tramite il nome dell'attributo-colonna ai dati

                trattamento_temp.setNome(rs.getString("nome"));
                trattamento_temp.setDescrizione(rs.getString("descrizione"));
                trattamento_temp.setCosto(rs.getInt("costo"));
                trattamento_temp.setRipetizionePeriodica(rs.getString("ripetizionePeriodica"));
                //Aggiungo trattamento alla lista
                trattamenti_lista_temp.add(trattamento_temp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Ritorno la lista dei trattamenti
        return trattamenti_lista_temp;


    }


    public ArrayList<DBTrattamento> caricaListaTrattamentiDaDB(){
        //Creo una lista temporanea
        ArrayList<DBTrattamento> trattamenti_lista_temp = new ArrayList<>();
        //Definisco la query
        String query="SELECT * FROM Trattamenti";
        System.out.println(query);//per debug
        try {

            ResultSet rs = DBConnectionManager.selectQuery(query);

            while(rs.next()) {

                DBTrattamento trattamento_temp = new DBTrattamento();

                trattamento_temp.setNome(rs.getString("nome"));
                trattamento_temp.setDescrizione(rs.getString("descrizione"));
                trattamento_temp.setCosto(rs.getInt("costo"));
                trattamento_temp.setRipetizionePeriodica(rs.getString("ripetizionePeriodica"));
                //Aggiungo trattamento alla lista
                trattamenti_lista_temp.add(trattamento_temp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Ritorno la lista dei trattamenti
        return trattamenti_lista_temp;

    }

   /* public void aggiornaDB(){
     metodo per aggiornare un trattamento nel DB
        non implementato perché non facente parte delle funzionalità che abbiamo implementato}
    public void rimuoviDaDB(){
      metodo per rimuovere un trattamento nel DB
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    }
    */

    public DBTrattamento(){}
    public int getCosto() {return costo;}
    public String getDescrizione() {return descrizione;}
    public String getNome() {return nome;}
    public String getRipetizionePeriodica() {return ripetizionePeriodica;}
    public void setNome(String nome) {this.nome = nome;}
    public void setDescrizione(String descrizione) {this.descrizione = descrizione;}
    public void setCosto(int costo) {this.costo = costo;}
    public void setRipetizionePeriodica(String ripetizionePeriodica) {this.ripetizionePeriodica = ripetizionePeriodica;}
}
