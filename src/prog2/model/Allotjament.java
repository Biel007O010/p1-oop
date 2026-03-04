package prog2.model;

public abstract class Allotjament implements InAllotjament{
    //Atributs:
    private String nom;
    private String id;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;

    //Constructor:
    public Allotjament(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA = estadaMinimaALTA_;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
    }

    public String getNom(){return nom;};

    public void setNom(String nom){this.nom = nom;};

    public String getId(){return id;};

    public void setId(String id){this.id = id;};

    public long getEstadaMinima(InAllotjament.Temp temp){
        if (temp.equals(Temp.ALTA)){
            return estadaMinimaALTA;
        }else{
            return estadaMinimaBAIXA;
        }
    };

    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        estadaMinimaALTA = estadaMinimaALTA_;
        estadaMinimaBAIXA = estadaMinimaBAIXA_;
    };

    @Override
    public String toString() {
        return "Nom=" + nom + ", Id=" + id + ", estada mínima en temp ALTA: " + estadaMinimaALTA + ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA + ".";
    }
}
