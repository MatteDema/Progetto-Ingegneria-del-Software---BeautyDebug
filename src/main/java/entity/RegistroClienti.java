package entity;

import database.DBCliente;

public class RegistroClienti {
    // classe Singleton: in tutta l'applicazione avremo una sola istanza di RegistroClienti
    private static RegistroClienti registroClienti; // attributo statico che rappresenta l'unica istanza della classe RegistroClienti
    // private ArrayList<Cliente> clientiRegistrati;
    // il precedente attributo commentato è legato al ruolo dell'aggregazione di RegistroClienti con Cliente,
    // e è commentato poiché non lo useremo nei metodi implementati

    // Costruttore privato
    private RegistroClienti(){}

    // metodo statico (con visibilità di package) che nasconde la creazione dell'unica istanza di RegistroClienti
    static RegistroClienti getRegistroClienti(){
        if (registroClienti == null) {
            registroClienti= new RegistroClienti();
        }
        return registroClienti;
    }

    boolean registrazione(String email){
        // la prima parte della registrazione l'utente inserisce i validi fino alla email
        // il sistema verifica che non sia già presente associata a un altro cliente
        boolean email_presente = verificaSeEmailGiaPresente(email);
        return email_presente;
    }

    private boolean verificaSeEmailGiaPresente(String email){
        // creazione DAO DBCliente
        DBCliente  dbCliente = new DBCliente();

        // usiamo il DAO per verificare se esiste già un cliente con la email passata come argomento
        return dbCliente.emailPresenteInDB(email);
    }

    boolean verificaSeUtenteGiaRegistrato(String username){
        // creazione DAO DBCliente
        DBCliente  dbCliente = new DBCliente();

        // usiamo il DAO per verificare se esiste già un cliente con l'username passato come parametro
        return dbCliente.usernamePresenteInDB(username);
    }

    boolean inserisciCliente(String nome, String cognome, String indirizzo, String telefono, String email, String username, String password){
        boolean cliente_aggiunto = false;
        // creazione di un oggetto Cliente
        Cliente cliente = new Cliente(nome,cognome,indirizzo,telefono,email,username,password);

        // avvio la scrittura su database chiamando scriviSuDB sull'oggetto Cliente Entity
        int esito_scrittura_suDB = cliente.scriviSuDB(username);

        if(esito_scrittura_suDB==0){
            // scrittura del nuovo cliente sul database è andata a buon fine
            cliente_aggiunto = true;
            System.out.println("Cliente aggiunto!");
        } else if(esito_scrittura_suDB==-1){
            System.out.println("Errore nell'aggiunta del cliente!");
        }

        return cliente_aggiunto;
    }

    //Di seguito il metodo che non implementeremo:
    // void accesso(String email,String password){}


}
