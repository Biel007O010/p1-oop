package prog2.model;

public class Parcela extends Allotjament{

    private float metres;
    private boolean connexioElectrica;

    public Parcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica){
        super(nom_, idAllotjament_, 4, 2);
        this.metres = metres;
        this.connexioElectrica = connexioElectrica;
    };

    public boolean correcteFuncionament(){return connexioElectrica;
    };

    public void setConnexioElectrica(boolean b) {
        this.connexioElectrica = b;
    }

    public boolean isConnexioElectrica() {
        return connexioElectrica;
    }

    public float getMida() {
        return this.metres;
    }

    public void setMida(float v) {
        this.metres = v;
    }
}
