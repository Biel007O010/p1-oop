package prog2.model;

import java.time.LocalDate;
import java.util.ArrayList;


public class Camping implements InCamping{
    //Creació de totes les variables privades de la classe.

    private String nom;
    private ArrayList<Allotjament> allotjamentsDisp;
    private ArrayList<Client> clients;
    private InLlistaReserves reserves;

    //Creem el constructor

    public Camping(String nom) {
        this.nom = nom;
        this.allotjamentsDisp = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.reserves = new ArrayList<>();
    }

    private String buscarClient(String dni){

    }

    public static InAllotjament.Temp getTemporada(LocalDate data){

    }

    public String buscarAllotjament(String identificador) {

    }

    @Override
    public String getNom() {

        return nom;
    }

    @Override
    public LlistaReserves getLlistaReserves() {
        return null;
    }

    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return null;
    }

    @Override
    public ArrayList<Client> getLlistaClients() {
        return null;
    }

    @Override
    public int getNumAllotjaments() {
        return 0;
    }

    @Override
    public int getNumReserves() {
        return 0;
    }

    @Override
    public int getNumClients() {
        return 0;
    }

    @Override
    public void afegirClient(String nom_, String dni_) {

    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida){

    }

    @Override
    public int calculAllotjamentsOperatius() {
        return 0;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        return null;
    }


    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica){

    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred){

    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi){

    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {

    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {

    }


}
