package prog2.model;

public abstract class Casa extends Allotjament{

    private String mida;
    private int numHabitacions;
    private int Capacitat;

    public Casa(String nom, String id_, String mida,
                int numHabitacions, int Capacitat, long estadaMinimaALTA_, long estadaMinimaBAIXA_){

        super(nom, id_, estadaMinimaALTA_, estadaMinimaBAIXA_);
        this.mida = mida;
        this.numHabitacions = numHabitacions;
        this.Capacitat = Capacitat;
    }
};
