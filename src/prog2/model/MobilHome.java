package prog2.model;

public class MobilHome extends Casa{

    private boolean terrassaBBQ;

    public MobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                     boolean terrassaBarbacoa){
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 5, 3);
        this.terrassaBBQ = terrassaBarbacoa;
    }

    @Override
    public boolean correcteFuncionament() {
        return this.terrassaBBQ;
    }
}
