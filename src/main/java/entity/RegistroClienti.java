package entity;

public class RegistroClienti {
    //Classe Singleton
     private RegistroClienti registroClienti=null;

     private RegistroClienti(){}


    boolean registrazione(String nome,String cognome,String indirizzo,String telefono,String email){}
    private boolean verificaSeEmailGiaPresente(String email){}
    boolean verificaSeUtenteGiaRegistrato(String email){}
    boolean inserisciCliente(String nome,String cognome,String indirizzo,String telefono,String email,String username,String password){}
    void accesso(String email,String password){}
    private static RegistroClienti getRegistroClienti(){}

}
