package control;

import entity.InfoClientiEPrenotazioni;

public class ControllerGestioneProfiloCliente {
    //classe Singleton
    private static ControllerGestioneProfiloCliente controller_profilo_cliente;

    //metodo per ottenere l'istanza di ControllerGestioneProfiloCliente
    public static ControllerGestioneProfiloCliente getControllerGestioneProfiloCliente(){
        if(controller_profilo_cliente == null){
            controller_profilo_cliente = new ControllerGestioneProfiloCliente();
        }
        return controller_profilo_cliente;
    }
    private ControllerGestioneProfiloCliente(){} //costruttore privato

    public boolean registrazione(String nome,String cognome,String indirizzo,String telefono,String email){
        //Delego alla classe facade InfoClientiEPrenotazioni la registrazione di un nuovo cliente
       boolean esito_registrazione= InfoClientiEPrenotazioni.registrazione(email);

       return esito_registrazione;

    }
    public boolean verificaSeUtenteGiaRegistrato(String email){
        //Delego alla classe facade InfoClientiEPrenotazioni la verifica se l'utente è già registrato
        boolean esito_verifica=InfoClientiEPrenotazioni.verificaSeUtenteGiaRegistrato(email);

        return esito_verifica;
    }
    public boolean inserisciCliente(String nome,String cognome,String indirizzo,String telefono,String email,String username,String password){
        //Delego alla classe facade InfoClientiEPrenotazioni l'inserimento di un nuovo cliente
       boolean esito_inserimento_cliente= InfoClientiEPrenotazioni.inserisciCliente(nome,cognome,indirizzo,telefono,email,username,password);

       return esito_inserimento_cliente;

    }




    //Di seguito riporto i metodi che non implementeremo:
    /* public void accesso(String email,String password){}
       public ArrayList<DTOCliente> visualizzaDatiPersonali(){}
       public boolean modificaDatiPersonali(){}
       */



}
