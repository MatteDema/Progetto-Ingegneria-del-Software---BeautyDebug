package dto;

public class DTOTrattamento {
    private String campo1;
    private String campo2;
    private int campo3;
    private String campo4;

    // costruttore
    public DTOTrattamento() {
    }

    // Getter e Setter
    public String getCampo1() {
        return campo1;
    }
    public String getCampo2() {
        return campo2;
    }
    public int getCampo3() {
        return campo3;
    }
    public String getCampo4() {
        return campo4;
    }
    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }
    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }
    public void setCampo3(int campo3) {
        this.campo3 = campo3;
    }
    public void setCampo4(String campo4) {
        this.campo4 = campo4;
    }
    public void setDati(String campo1, String campo2, int campo3, String campo4){
        setCampo1(campo1);
        setCampo2(campo2);
        setCampo3(campo3);
        setCampo4(campo4);
    }

    @Override
    public String toString() {
        return "Trattamento [campo1=" + campo1 + ", campo2=" + campo2 + ", campo3=" + campo3 + ", campo4=" + campo4 + "]";
    }
}
