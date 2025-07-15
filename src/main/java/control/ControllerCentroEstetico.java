package control;

import dto.DTOTrattamento;
import entity.CentroEstetico;

import java.util.ArrayList;

public class ControllerCentroEstetico {
    //classe singleton
    private static ControllerCentroEstetico controller_centro_Estetico;

    //metodo per ottenere l'istanza di ControllerCentroEstetico
    public static ControllerCentroEstetico getControllerCentroEstetico(){
        if(controller_centro_Estetico == null){
            controller_centro_Estetico = new ControllerCentroEstetico();
        }
        return controller_centro_Estetico;
    }
    private ControllerCentroEstetico(){} //costruttore privato

    public boolean aggiungiTrattamento(String nome,String descrizione,int costo,String ripetizionePeriodica){
        //Ottengo l'instanza della classe singleton centroEstetico
        CentroEstetico centroEsteticoEntity= CentroEstetico.getCentroEstetico();
        //Delego alla classe Entity CentroEstetico l'aggiunta di un nuovo trattamento
       boolean esito_aggiunta= centroEsteticoEntity.aggiungiTrattamento(nome,descrizione,costo,ripetizionePeriodica);

       return esito_aggiunta;
    }
    public ArrayList<DTOTrattamento> visualizzaTuttiTrattamentiDisponibili(){
        //Ottengo l'instanza della classe singleton centroEstetico
        CentroEstetico centroEsteticoEntity= CentroEstetico.getCentroEstetico();
        //Recupero la lista di tutti i trattamenti disponibili da visualizzare dal livello Entity
       ArrayList<DTOTrattamento> lista_dei_trattamenti= centroEsteticoEntity.visualizzaTuttiTrattamentiDisponibili();

       return lista_dei_trattamenti;

    }
    public ArrayList<DTOTrattamento> visualizzaTrattamentiPerNome(String nomeTrattamento){
        //Ottengo l'instanza della classe singleton centroEstetico
        CentroEstetico centroEsteticoEntity= CentroEstetico.getCentroEstetico();
        //Recupero il trattamento da visualizzare dal livello Entity
        ArrayList<DTOTrattamento> trattamentoPerNome= centroEsteticoEntity.visualizzaTrattamentoPerNome(nomeTrattamento);

        return trattamentoPerNome;
    }
    public ArrayList<DTOTrattamento> visualizzaTrattamentiPerCosto(int costo){
        //Ottengo l'instanza della classe singleton centroEstetico
        CentroEstetico centroEsteticoEntity= CentroEstetico.getCentroEstetico();
        //Recupero la lista dei trattamenti per costo da visualizzare dal livello Entity
        ArrayList<DTOTrattamento> trattamentiPerCosto= centroEsteticoEntity.visualizzaTrattamentiPerCosto(costo);

        return trattamentiPerCosto;

    }



   // Di seguito i metodi che non implementeremo:
   /* public boolean rimuoviMetodo(){}
      public boolean modificaTrattamento(){}
      public void definisciDisponibilitaOrarie(){}
      public float visualizzaIncassoGiornaliero(){}
      public ArrayList<DTOSeduta> consultaSedutaPerData(LocalDate data){}
    */




}
