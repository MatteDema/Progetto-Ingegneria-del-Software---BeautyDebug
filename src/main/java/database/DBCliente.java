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
    Passo al costruttore la chiave primaria della tabella, nel nostro
    caso è l'username
     */
    public DBCliente(String idUsername) {
        this.username = idUsername;
        this.caricaDaDB();
    }

    public DBCliente(){}

    public int salvaInDB(String username){
        int ret = 0;
        String query = "INSERT INTO clienti(nome,cognome,indirizzo,telefono,email,username,password) VALUES ('" + this.nome + "'," + "'" + this.cognome + "'," + "'" + this.indirizzo + "'," + "'" + this.telefono + "'," + "'" + this.email + "'," + "'" + username + "'," + "'" + this.password + "')";
        System.out.println(query);

        try {
            ret = DBConnectionManager.updateQuery(query);
        } catch (SQLException | ClassNotFoundException e) {
            ((Exception)e).printStackTrace();
            ret = -1;
        }

        return ret;
    }

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

            }
        } catch (SQLException | ClassNotFoundException e) {
            ((Exception)e).printStackTrace();
        }

    }

    public void caricaPerEmailDaDB(String email) {
        String query = "SELECT * FROM clienti WHERE email='" + email + "';";
        System.out.println(query);

        try {
            ResultSet rs = DBConnectionManager.selectQuery(query);
            if (rs.next()) {
                this.setNome(rs.getString("nome"));
                this.setCognome(rs.getString("cognome"));
                this.setIndirizzo(rs.getString("indirizzo"));
                this.setTelefono(rs.getString("telefono"));
                this.setUsername(rs.getString("username"));
                this.setPassword(rs.getString("password"));

            }
        } catch (SQLException | ClassNotFoundException e) {
            ((Exception)e).printStackTrace();
        }

    }

    public ArrayList<DBCliente> getListaStudenti() {
        ArrayList<DBCliente> clienti_lista_temp = new ArrayList();
        String query = "SELECT * FROM clienti;";

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
}
