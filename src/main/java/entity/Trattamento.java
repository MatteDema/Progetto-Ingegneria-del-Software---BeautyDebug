package entity;

import database.DBTrattamento;

public class Trattamento {
    private String nome;
    private String descrizione;
    private int costo;
    private String ripetizionePeriodica="non prevista";

    // Costruttore con chiave primaria per la lettura dal database di un trattamento
    Trattamento(String nome) {
        // chiama il costruttore con chiave primaria della classe DAO associata
        DBTrattamento dbTrattamento = new DBTrattamento(nome);

        this.nome = nome;
        this.descrizione = dbTrattamento.getDescrizione();
        this.costo = dbTrattamento.getCosto();
        this.ripetizionePeriodica = dbTrattamento.getRipetizionePeriodica();
    }

    // Costruttore
    public Trattamento(String nome,String descrizione,int costo,String ripetizionePeriodica){
        this.nome=nome;
        this.descrizione=descrizione;
        this.costo=costo;
        if (ripetizionePeriodica.isEmpty()){
            ripetizionePeriodica="Non prevista";
        }
        this.ripetizionePeriodica=ripetizionePeriodica;
    }

    int scriviSuDB(String nome){
        DBTrattamento dbTrattamento= new DBTrattamento(); //DAO

        dbTrattamento.setDescrizione(this.descrizione);
        dbTrattamento.setCosto(this.costo);
        dbTrattamento.setDescrizione(this.descrizione);
        int i = dbTrattamento.salvaInDB(nome);

        return i;
    }

    // GETTER E SETTER

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getRipetizionePeriodica() {
        return ripetizionePeriodica;
    }

    public void setRipetizionePeriodica(String ripetizionePeriodica) {
        this.ripetizionePeriodica = ripetizionePeriodica;
    }
}
