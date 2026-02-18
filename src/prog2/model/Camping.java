package prog2.model;

import java.time.LocalDate;
import java.util.ArrayList;


public class Camping implements InCamping{
    //Creació de totes les variables privades de la classe.

    private String nom;
    private ArrayList<InAllotjament> allotjamentsDisp;
    private ArrayList<InClient> clients;
    private ArrayList<InReserva> reserves;

    //Creem el constructor

    public Camping(String nom) {
        this.nom = nom;
        this.allotjamentsDisp = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.reserves = new ArrayList<>();
    }

    @Override
    public String getNom() {
        return nom;
    }


    public String buscarAllotjament(String identificador) {

    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida){

    }

    private String buscarClient(String dni){

    }

    public static InAllotjament.Temp getTemporada(LocalDate data){

    }

}
