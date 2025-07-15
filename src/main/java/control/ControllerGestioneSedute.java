package control;

public class ControllerGestioneSedute {
    //classe Singleton
    private  static ControllerGestioneSedute controller_sedute;

    //metodo per ottenere l'istanza di ControllerGestioneSedute
    public static ControllerGestioneSedute getControllerGestioneSedute(){
        if(controller_sedute == null){
            controller_sedute = new ControllerGestioneSedute();
        }
        return controller_sedute;
    }
    private ControllerGestioneSedute(){} //costruttore privato


    //Di seguito i metodi che non implementeremo:
    /*
     public void registraDatiSeduta(){}
     public boolean inviaNotificaNuovoAppuntamento(){}
     public ArrayList<DTOTrattamento> consultaStoricoTrattamenti(){}
     */


}
