package database;

public class TestDatabasePackage {

    public static void main(String args[]){
        DBCliente cliente = new DBCliente();
        cliente.caricaPerEmailDaDB("alessandro.c@libero.it");
    }
}
