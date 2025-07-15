package control;

import entity.InfoClientiEPrenotazioni;
import entity.RegistroClienti;

public class ControllerGestioneProfiloCliente {
    // classe Singleton: in tutta l'applicazione avremo una sola istanza di ControllerGestioneProfiloCliente
    private static ControllerGestioneProfiloCliente controller_profilo_cliente; // attributo statico che rappresenta l'unica istanza della classe ControllerGestioneProfiloCliente

    // metodo statico che nasconde la creazione dell'unica istanza di ControllerGestioneProfiloCliente
    public static ControllerGestioneProfiloCliente getControllerGestioneProfiloCliente(){
        if(controller_profilo_cliente == null){
            controller_profilo_cliente = new ControllerGestioneProfiloCliente();
        }
        return controller_profilo_cliente;
    }

    private ControllerGestioneProfiloCliente(){} // costruttore privato

    public boolean registrazione(String email){
        // Delego alla classe façade InfoClientiEPrenotazioni l'avvio della registrazione di un nuovo cliente
        boolean esito_verifica_email = InfoClientiEPrenotazioni.registrazione(email);

        return esito_verifica_email;
    }

    public boolean inserisciCliente(String nome, String cognome, String indirizzo, String telefono, String email, String username, String password){

        boolean esito_inserimento_cliente = false;

        // verifico se l'utente è già registrato (ovvero se il suo username è già presente nel sistema)
        // Chiamo il metodo della façade per verificare che non esista già nel sistema l'username passato come parametro
        boolean username_gia_presente = InfoClientiEPrenotazioni.verificaSeUtenteGiaRegistrato(username);

        if(!username_gia_presente){
            // Delego alla classe façade InfoClientiEPrenotazioni l'inserimento di un nuovo cliente
            esito_inserimento_cliente = InfoClientiEPrenotazioni.inserisciCliente(nome,cognome,indirizzo,telefono,email,username,password);
        }

        return esito_inserimento_cliente;
    }




    //Di seguito riporto i metodi che non implementeremo:
    /*
    public void accesso(String username, String password){}
    public DTOCliente visualizzaDatiPersonali(){}
    public boolean modificaDatiPersonali(){}
    */



}
