package entity;

public class RegistroClienti {
    // classe Singleton: in tutta l'applicazione avremo una sola istanza di RegistroClienti
     private static RegistroClienti registroClienti; // attributo statico che rappresenta l'unica istanza della classe RegistroClienti

     //Costruttore vuoto
     private RegistroClienti(){}
     private static RegistroClienti getRegistroClienti(){
        if (registroClienti == null) {
            registroClienti= new RegistroClienti();
        }
        return registroClienti;
    }

    /*
    boolean registrazione(String nome,String cognome,String indirizzo,String telefono,String email){}
    private boolean verificaSeEmailGiaPresente(String email){}
    boolean verificaSeUtenteGiaRegistrato(String email){}
    boolean inserisciCliente(String nome,String cognome,String indirizzo,String telefono,String email,String username,String password){}
    */
    //Di seguito il metodo che non implementeremo:
    // void accesso(String email,String password){}


}
