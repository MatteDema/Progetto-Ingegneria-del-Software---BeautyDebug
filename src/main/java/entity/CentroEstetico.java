package entity;

import dto.DTOTrattamento;

import java.util.ArrayList;

public class CentroEstetico {
    //classe singleton
    private static CentroEstetico centroEstetico = null; //riferimento all'unica istanza

    public static CentroEstetico getCentroEstetico(){ //metodo per ottenere l'istanza di CentroEstetico
        if(centroEstetico == null){
            centroEstetico = new CentroEstetico();
        }
        return centroEstetico;
    }

    private CentroEstetico(){} //costruttore privato

    public ArrayList<DTOTrattamento> visualizzaTuttiTrattamentiDisponibili(){

    }
}
