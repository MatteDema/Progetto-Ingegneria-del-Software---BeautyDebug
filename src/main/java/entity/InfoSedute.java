package entity;

import java.time.LocalDate;

public class InfoSedute {

    // classe Façade -> usa le classi Seduta, Cliente e Prenotazione
    // consente di disaccoppiare maggiormente il livello Control dal livello Entity

    // fornisce dei metodi pubblici che saranno invocati dai Controller, e che richiamano i metodi con visibilità di package
    // delle classi Entity con le quali essa interagisce


    // metodi commentati perché non usati nella nostra applicazione
    /*
    public boolean registraDatiSeduta(String noteCliente, String prodottiUtilizzati, float costoEffettivo, LocalDate dataConsigliata){
        return Prenotazione.registraDatiSeduta(noteCliente, prodottiUtilizzati, costoEffettivo, dataConsigliata); // metodo statico
    }

    public boolean inviaNotificaNuovoAppuntamento(){
        return Seduta.inviaNotificaNuovoAppuntamento();
    }

    public ArrayList<DTOSeduta> conultaStoricoTrattamenti(){
        return Cliente.consultaStoricoTrattamenti();
    }
    */



}
