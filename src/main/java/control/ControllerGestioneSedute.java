package control;

public class ControllerGestioneSedute {
    // classe Singleton: in tutta l'applicazione avremo una sola istanza di ControllerGestioneSedute
    private  static ControllerGestioneSedute controller_sedute; // attributo statico che rappresenta l'unica istanza della classe ControllerGestioneSedute

    // metodo statico che nasconde la creazione dell'unica istanza di ControllerGestioneSedute
    public static ControllerGestioneSedute getControllerGestioneSedute(){
        if(controller_sedute == null){
            controller_sedute = new ControllerGestioneSedute();
        }
        return controller_sedute;
    }

    private ControllerGestioneSedute(){} // costruttore privato


    //Di seguito i metodi che non implementeremo:
    /*
    public boolean registraDatiSeduta(String noteCliente, String prodottiUtilizzati, float costoEffettivo, LocalDate dataConsigliata){}
    public boolean inviaNotificaNuovoAppuntamento(){}
    public ArrayList<DTOSeduta> consultaStoricoTrattamenti(){}
    */


}
