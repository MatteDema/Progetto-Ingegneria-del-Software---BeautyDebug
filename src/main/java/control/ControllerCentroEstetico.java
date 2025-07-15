package control;

import dto.DTOTrattamento;
import entity.CentroEstetico;

import java.util.ArrayList;

public class ControllerCentroEstetico {
    // classe Singleton: in tutta l'applicazione avremo una sola istanza di ControllerCentroEstetico
    private static ControllerCentroEstetico controller_centro_Estetico; // attributo statico che rappresenta l'unica istanza della classe ControllerCentroEstetico

    // metodo statico che nasconde la creazione dell'unica istanza di ControllerCentroEstetico
    public static ControllerCentroEstetico getControllerCentroEstetico(){
        if(controller_centro_Estetico == null){
            controller_centro_Estetico = new ControllerCentroEstetico();
        }
        return controller_centro_Estetico;
    }

    private ControllerCentroEstetico(){} // costruttore privato

    public boolean aggiungiTrattamento(String nome, String descrizione, int costo, String ripetizionePeriodica){
        // Ottengo l'istanza unica della classe Singleton CentroEstetico
        CentroEstetico centroEsteticoEntity= CentroEstetico.getCentroEstetico();

        // Delego alla classe Entity CentroEstetico l'aggiunta di un nuovo trattamento
        boolean esito_aggiunta= centroEsteticoEntity.aggiungiTrattamento(nome, descrizione, costo, ripetizionePeriodica);

        return esito_aggiunta;
    }

    public ArrayList<DTOTrattamento> visualizzaTuttiTrattamentiDisponibili(){
        // Ottengo l'istanza della classe Singleton CentroEstetico
        CentroEstetico centroEsteticoEntity= CentroEstetico.getCentroEstetico();

        // Recupero dal livello Entity la lista di tutti i trattamenti disponibili che si intende visualizzare
        ArrayList<DTOTrattamento> lista_dei_trattamenti= centroEsteticoEntity.visualizzaTuttiTrattamentiDisponibili();

        return lista_dei_trattamenti;
    }

    public ArrayList<DTOTrattamento> visualizzaTrattamentiPerNome(String nomeTrattamento){
        // Ottengo l'istanza della classe Singleton CentroEstetico
        CentroEstetico centroEsteticoEntity= CentroEstetico.getCentroEstetico();

        // Recupero dal livello Entity il trattamento, avente il nome passato come parametro, che si intende visualizzare
        ArrayList<DTOTrattamento> trattamentoPerNome= centroEsteticoEntity.visualizzaTrattamentoPerNome(nomeTrattamento);

        return trattamentoPerNome;
    }

    public ArrayList<DTOTrattamento> visualizzaTrattamentiPerCosto(int costo){
        // Ottengo l'istanza della classe Singleton CentroEstetico
        CentroEstetico centroEsteticoEntity= CentroEstetico.getCentroEstetico();

        // Recupero dal livello Entity la lista dei trattamenti, filtrati per costo, che si intende visualizzare
        ArrayList<DTOTrattamento> trattamentiPerCosto= centroEsteticoEntity.visualizzaTrattamentiPerCosto(costo);

        return trattamentiPerCosto;
    }


    // Di seguito i metodi che non implementeremo:
    /*
    public boolean rimuoviTrattamento(String nomeTrattamento){}
    public boolean modificaTrattamento(String nomeTrattamento){}
    public boolean definisciDisponibilitaOrarie(){}
    public float visualizzaIncassoGiornaliero(LocalDate data){}
    public ArrayList<DTOSeduta> consultaSedutaPerData(LocalDate data){}
    */


}
