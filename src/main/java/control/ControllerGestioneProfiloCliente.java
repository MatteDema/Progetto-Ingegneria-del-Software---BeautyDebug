package control;

public class ControllerGestioneProfiloCliente {
    private ControllerGestioneProfiloCliente controller_profilo_cliente=null;

    public static ControllerGestioneProfiloCliente getControllerGestioneProfiloCliente(){}
    private ControllerGestioneProfiloCliente(){}

    public boolean registrazione(String nome,String cognome,String indirizzo,String telefono,String email){}
    public boolean verificaSeUtenteGiaRegistrato(String email){}
    public boolean inserisciCliente(String nome,String cognome,String indirizzo,String telefono,String email,String username,String password){}

    //Di seguito riporto i metodi che non implementeremo:
    /* public void accesso(String email,String password){}
       public ArrayList<DTOCliente> visualizzaDatiPersonali(){}
       public boolean modificaDatiPersonali(){}
       */

}
