package prog2.model;

public class Glamping extends Casa{

    private String material;
    private boolean casaMascotes;

    public Glamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                    String material, boolean casaMascota){
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 3, 3);
        this.material = material;
        this.casaMascotes = casaMascota;
    }

    @Override
    public boolean correcteFuncionament() {
        return this.casaMascotes;
    }
}
