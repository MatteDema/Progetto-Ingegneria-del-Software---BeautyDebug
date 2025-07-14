package control;

import dto.DTOTrattamento;

import java.util.ArrayList;

public class ControllerCentroEstetico {
    private ControllerCentroEstetico controller_centro_Estetico=null;

    public static ControllerCentroEstetico getControllerCentroEstetico(){}
    private ControllerCentroEstetico(){}
    public boolean aggiungiTrattamento(String nome,String descrizione,int costo,String ripetizionePeriodica){}
    public ArrayList<DTOTrattamento> visualizzaTuttiTrattamentiDisponibili(){}
    public DTOTrattamento visualizzaTrattamentiPerNome(String nomeTrattamento){}
    public ArrayList<DTOTrattamento> visualizzaTrattamentiPerCosto(int costo){}
   // DI SEGUITO LE FIRME DEI METODI CHE NON IMPLEMENTEREMO
   /* public boolean rimuoviMetodo(){}
      public boolean modificaTrattamento(){}
      public void definisciDisponibilitaOrarie(){}
      public float visualizzaIncassoGiornaliero(){}
      public ArrayList<DTOSeduta> consultaSedutaPerData(LocalDate data){}
    */




}
