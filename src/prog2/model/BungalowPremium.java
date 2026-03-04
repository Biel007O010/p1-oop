package prog2.model;

public class BungalowPremium extends Bungalow{

    private boolean serveisExtra;
    private String codiWifi;

    BungalowPremium(String nom_, String id_, String mida, int habitacions, int placesPersones,
                    int placesParquing_, boolean terrassa_, boolean tv_, boolean aireFred_,
                    boolean serveisExtra_, String codiWifi_){

        super(nom_, id_, mida, habitacions, placesPersones, placesParquing_, terrassa_, tv_, aireFred_);
        this.serveisExtra = serveisExtra_;
        this.codiWifi = codiWifi_;
    }
    @Override
    public boolean correcteFuncionament(){
        return super.correcteFuncionament() && (codiWifi.length() > 8 && codiWifi.length() < 16);
    }
}