package entity;

public class Trattamento {
    private String nome;
    private String descrizione;
    private int costo;
    private String ripetizionePeriodica="non prevista";


    //Costruttore
    public Trattamento(String nome,String descrizione,int costo,String ripetizionePeriodica){
        this.nome=nome;
        this.descrizione=descrizione;
        this.costo=costo;
        this.ripetizionePeriodica=ripetizionePeriodica;

    }

     int scriviSuDB(String nome){}


    // GETTER E SETTER
    int getCosto() {return costo;}
    void setCosto(int costo) {this.costo = costo;}
    String getDescrizione() {return descrizione;}
    void setDescrizione(String descrizione) {this.descrizione = descrizione;}
    String getNome() {return nome;}
    void setNome(String nome) {this.nome = nome;}
    String getRipetizionePeriodica() {return ripetizionePeriodica;}
    void setRipetizionePeriodica(String ripetizionePeriodica) {this.ripetizionePeriodica = ripetizionePeriodica;}
}
