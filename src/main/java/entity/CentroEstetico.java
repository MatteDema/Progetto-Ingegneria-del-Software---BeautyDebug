package entity;

import database.DBTrattamento;
import dto.DTOTrattamento;

import java.util.ArrayList;

public class CentroEstetico {
    // classe Singleton: in tutta l'applicazione avremo una sola istanza di CentroEstetico
    private static CentroEstetico centroEstetico = null; // attributo statico che rappresenta l'unica istanza della classe CentroEstetico

    // private RegistroClienti registroClienti;
    // private ArrayList<Trattamento> trattamentiDisponibili;
    // private ArrayList<GiornoSettimanale> disponibilitaOrarieSettimanali;
    // i precedenti attributi commentati sono legati ai ruoli delle associazioni di CentroEstetico con RegistroClienti, Trattamento e GiornoSettimanale,
    // ed sono commentati poiché non li useremo nei metodi implementati

    public static CentroEstetico getCentroEstetico(){ //metodo per ottenere l'istanza di CentroEstetico
        if(centroEstetico == null){
            centroEstetico = new CentroEstetico();
        }
        return centroEstetico;
    }

    private CentroEstetico(){} //costruttore privato

    private static ArrayList<DTOTrattamento>  creaListaDTOTrattamento(ArrayList<DBTrattamento> DB_trattamenti_disponibili){
        // inizializzo una lista di DTOTrattamento
        ArrayList<DTOTrattamento> trattamenti_disponibili = new ArrayList<>();

        for(DBTrattamento dbTrattamento : DB_trattamenti_disponibili){
            // creazione del DTOTrattamento di appoggio
            DTOTrattamento dtoTrattamento = new DTOTrattamento();

            // estrapolo le informazioni che mi servono attraverso setDati che richiama i set di tutti i campi
            dtoTrattamento.setDati(dbTrattamento.getNome(),dbTrattamento.getDescrizione(),dbTrattamento.getCosto(),dbTrattamento.getRipetizionePeriodica());

            // aggiungo il DTO alla lista dei DTO
            trattamenti_disponibili.add(dtoTrattamento);
        }

        return trattamenti_disponibili;
    }

    public ArrayList<DTOTrattamento> visualizzaTuttiTrattamentiDisponibili(){
        // creazione del DAO DBTrattamento per caricare la lista di tutti i trattamenti
        DBTrattamento trattamento = new DBTrattamento();

        // carico la lista dei trattamenti disponibili tramite il DAO
        ArrayList<DBTrattamento> DB_trattamenti_disponibili = trattamento.caricaListaTrattamentiDaDB();

        // chiamo il metodo che crea una lista di DTOTrattamento da restituire al Controller
        return creaListaDTOTrattamento(DB_trattamenti_disponibili);
    }

    public ArrayList<DTOTrattamento> visualizzaTrattamentoPerNome(String nomeTrattamento){
        // creazione del DAO DBTrattamento per caricare il singolo DAO sulla base della sua PK (nomeTrattamento)
        DBTrattamento DBtrattamento = new DBTrattamento(nomeTrattamento);

        // inizializzo un ArrayList di DBTrattamento
        ArrayList<DBTrattamento> DB_trattamenti_disponibili = new ArrayList<>();

        // aggiungo il DBtrattamento trovato all'ArrayList di DBTrattamento
        DB_trattamenti_disponibili.add(DBtrattamento);

        // chiamo il metodo che crea una lista di DTOTrattamento da restituire al Controller
        return creaListaDTOTrattamento(DB_trattamenti_disponibili);
    }

    public ArrayList<DTOTrattamento> visualizzaTrattamentiPerCosto(int costo){
        // creazione del DAO DBTrattamento per caricare la lista dei trattamenti per costo
        DBTrattamento trattamento = new DBTrattamento();

        // carico la lista dei trattamenti per costo tramite il DAO
        ArrayList<DBTrattamento> DB_trattamenti_disponibili = trattamento.caricaTrattamentiPerCostoDaDB(costo);

        // chiamo il metodo che crea una lista di DTOTrattamento da restituire al Controller
        return creaListaDTOTrattamento(DB_trattamenti_disponibili);
    }

    public boolean aggiungiTrattamento(String nome, String descrizione, int costo, String ripetizionePeriodica){

        boolean esitoAggiunta = false;

        // verifica se il trattamento esiste già nel database
        boolean trattamento_esistente = verificaSeTrattamentoGiaEsistente(nome);

        if (!trattamento_esistente){
            // creazione di un nuovo oggetto Trattamento chiamando il costruttore con parametri
            Trattamento nuovoTrattamento = new Trattamento(nome, descrizione, costo, ripetizionePeriodica);

            // avvio la scrittura sul database chiamando scriviSuDB sull'oggetto Trattamento Entity
            int esito_scrittura_suDB = nuovoTrattamento.scriviSuDB(nome);

            if(esito_scrittura_suDB == 0){
                // scrittura del nuovo trattamento sul database andata a buon fine
                esitoAggiunta = true;
                System.out.println("Trattamento aggiunto!");
            } else if(esito_scrittura_suDB == -1){
                System.out.println("Errore nell'aggiunta del trattamento!");
            }
        }

        return esitoAggiunta;
    }

    boolean verificaSeTrattamentoGiaEsistente(String nomeTrattamento){
        // creazione di un DAO DBTrattamento
        DBTrattamento dbTrattamento = new DBTrattamento();

        // usa il DAO per verificare se il trattamento esiste
        return dbTrattamento.trattamentoPresenteInDB(nomeTrattamento);
    }

    /*
    public boolean rimuoviTrattamento(String nomeTrattamento){
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */

    /*
    public boolean modificaTrattamento(String nomeTrattamento){
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */

    /*
    public boolean definisciDisponibilitaOrarie(ArrayList<DTOGiornoSettimanale> disponibilitaOrarieSettimanali){
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */

    /*
    public ArrayList<DTOSeduta> consultaSedutePerData(LocalDate data){
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */

    /*
    public float visualizzaIncassoGiornaliero(LocalDate data){
        non implementato perché non facente parte delle funzionalità che abbiamo implementato
    } */
}
