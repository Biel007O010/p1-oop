package prog2.model;

public abstract class Casa extends Allotjament{

    private String mida;
    private int numHabitacions;
    private int Capacitat;

    public Casa(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        super(nom, id, estadaMinimaALTA_, estadaMinimaBAIXA_);
    }
};
