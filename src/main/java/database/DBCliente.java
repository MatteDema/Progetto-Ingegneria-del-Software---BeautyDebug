package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DBCliente {

    private String nome;
    private String cognome;
    private String indirizzo;
    private String telefono;
    private String email;
    private String username;
    private String password;
    /*
        uno dei problemi principali è il passaggio in chiaro della password
        possiamo prevedere di usare Hash e salt andando a criptare
        la password all'interno del DBP
     */

    /*
        Passo al costruttore la chiave primaria della tabella, nel nostro
        caso è l'username
     */
    public DBCliente(String idUsername) {
        this.username = idUsername;
        this.caricaDaDB();
    }

    /*
        Costruttore vuoto
    */
    public DBCliente(){}


    /*
        Questo metodo va a inserire nella tabella clienti un cliente andando a verificare se questo è già presente
        a livello entity vengono effettuate le assegnazioni delle variabili
     */
    public int salvaInDB(String username){
        int ret = 0;
        String query = "INSERT INTO clienti (nome, cognome, indirizzo, telefono, email, username, password) VALUES ('" + this.nome + "', '" + this.cognome + "', '" + this.indirizzo + "', '" + this.telefono + "', '" + this.email + "', '" + username + "', '" + this.password + "');";
        System.out.println(query);

        try {
            ret = DBConnectionManager.updateQuery(query); // se la query di UPDATE va a buon fine, ret diventa 1
            // updateQuery restituisce il numero di righe inserite
        } catch (SQLException | ClassNotFoundException e) {
            ((Exception)e).printStackTrace();
            ret = -1;
        }

        return ret;
    }

    /*
        il metodo caricaDaDB non fa altro che prendere i dati del cliente dal database dato l'username
     */
    public void caricaDaDB() {
        String query = "SELECT * FROM clienti WHERE username='" + this.username + "';";
        System.out.println(query);

        try {
            ResultSet rs = DBConnectionManager.selectQuery(query);
            if (rs.next()) {
                this.setNome(rs.getString("nome"));
                this.setCognome(rs.getString("cognome"));
                this.setIndirizzo(rs.getString("indirizzo"));
                this.setTelefono(rs.getString("telefono"));
                this.setEmail(rs.getString("email"));
                this.setPassword(rs.getString("password"));
            } else{}
        } catch (SQLException | ClassNotFoundException e) {
            ((Exception)e).printStackTrace();
        }

    }

    /*
        Il metodo emailPresenteInDB restituisce true se la mail è presente nella
        tabella clienti, false altrimenti
     */
    public boolean emailPresenteInDB(String email) {
        boolean emailpresente = false;
        String query = "SELECT * FROM clienti WHERE email='"+email+"';";
        System.out.println(query);

        try {
            ResultSet rs = DBConnectionManager.selectQuery(query);
            if (rs.next()) {
                System.out.println("Esiste già una mail nel sistema come quella indicata");
                emailpresente = true;
            }
            else{
                System.out.println("Non esiste una mail nel sistema come quella indicata");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return emailpresente;
    }

    /*
        Il metodo usernamePresenteInDB restituisce true se l'username
        è presente nella tabella clienti, false altrimenti
     */
    public boolean usernamePresenteInDB(String username) {
        boolean usernamepresente = false;
        String query = "SELECT * FROM clienti WHERE username='"+username+"';";
        System.out.println(query);

        try {
            ResultSet rs = DBConnectionManager.selectQuery(query);
            if (rs.next()) {
                System.out.println("Esiste già un username nel sistema come quello indicato");
                usernamepresente = true;
            }
            else{
                System.out.println("Non esiste un username nel sistema come quello indicato");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return usernamepresente;
    }

    /*
        Il metodo caricaListaClientiDaDB prende tutti i clienti dalla
        tabella clienti e li mette all'interno di un arraylist che
        successivamente ritorna

        Metodo commentato perché non facente parte delle funzionalità implementate

    public ArrayList<DBCliente> caricaListaClientiDaDB() {
        ArrayList<DBCliente> clienti_lista_temp = new ArrayList();
        String query = "SELECT * FROM clienti;";
        System.out.println(query);

        try {
            ResultSet rs = DBConnectionManager.selectQuery(query);

            while(rs.next()) {
                DBCliente studente_temp = new DBCliente();
                studente_temp.setNome(rs.getString("nome"));
                studente_temp.setCognome(rs.getString("cognome"));
                studente_temp.setIndirizzo(rs.getString("indirizzo"));
                studente_temp.setTelefono(rs.getString("telefono"));
                studente_temp.setEmail(rs.getString("email"));
                studente_temp.setUsername(rs.getString("username"));
                studente_temp.setPassword(rs.getString("password"));
                clienti_lista_temp.add(studente_temp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            ((Exception)e).printStackTrace();
        }

        return clienti_lista_temp;
    }
     */

    /*
    public void aggiornaInDB(){
        metodo per aggiornare i dati personali del cliente
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    }

    */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    /*
        Metodo toString di clienti usato per verificare l'output
     */
    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
