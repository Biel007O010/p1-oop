package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;


public class Camping implements InCamping{
    //Creació de totes les variables privades de la classe.

    private String nom;
    private ArrayList<Allotjament> allotjamentsDisp;
    private ArrayList<Client> clients;
    private LlistaReserves reserves;

    //Creem el constructor

    public Camping(String nom) {
        this.nom = nom;
        this.allotjamentsDisp = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.reserves = new LlistaReserves();
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public LlistaReserves getLlistaReserves() {
        return reserves;
    }

    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return allotjamentsDisp;
    }

    @Override
    public ArrayList<Client> getLlistaClients() {
        return clients;
    }

    @Override
    public int getNumAllotjaments() {
        return allotjamentsDisp.size();
    }

    @Override
    public int getNumReserves() {
        return reserves.getNumReserves();
    }

    @Override
    public int getNumClients() {
        return clients.size();
    }

    @Override
    public void afegirClient(String nom_, String dni_) {
        Client c = new Client(nom_, dni_);
        this.clients.add(c);
    }

    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela p = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        this.allotjamentsDisp.add(p);
    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow b = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.allotjamentsDisp.add(b);
    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        BungalowPremium bp = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        this.allotjamentsDisp.add(bp);
    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        Glamping g = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        this.allotjamentsDisp.add(g);
    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        MobilHome m = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        this.allotjamentsDisp.add(m);
    }


    public Allotjament buscarAllotjament(String identificador)throws ExcepcioReserva {
        Iterator <Allotjament> itAllotjaments = allotjamentsDisp.iterator();

        while (itAllotjaments.hasNext()){
            Allotjament a = itAllotjaments.next();
            if(a.getId().equals(identificador)){
                return a;
            }
        }
        throw new ExcepcioReserva("L'allotjament amb id " + identificador + " no existeix");
    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Client clientReserva = null;
        try {
            clientReserva = buscarClient(dni_);
        } catch (ExcepcioReserva e) {
            System.out.println(e.getMessage());
        }
        Allotjament allotjamentSolicitat = null;
        try {
            allotjamentSolicitat = buscarAllotjament(id_);
        } catch (ExcepcioReserva r) {
            System.out.println(r.getMessage());
        }
        reserves.afegirReserva(allotjamentSolicitat, clientReserva, dataEntrada, dataSortida);

    }

    @Override
    public int calculAllotjamentsOperatius() {
        Iterator<Allotjament> allOperatius = allotjamentsDisp.iterator();
        int comptador = 0;
        while (allOperatius.hasNext()){
            if (allOperatius.next().correcteFuncionament()){
                comptador++;
            }
        }
        return comptador;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        Iterator<Allotjament> iteradorCurta = allotjamentsDisp.iterator();
        long minimaA = 365;
        long minimaB = 365;
        Allotjament variableRetorn = null;
        while (iteradorCurta.hasNext()){
            Allotjament a = iteradorCurta.next();
            if (temp == InAllotjament.Temp.ALTA){
                if (a.getEstadaMinima(temp) < minimaA){
                    minimaA = a.getEstadaMinima(temp);
                    variableRetorn = a;
                }
            }
            if (temp == InAllotjament.Temp.BAIXA){
                if (a.getEstadaMinima(temp) < minimaB){
                    minimaB = a.getEstadaMinima(temp);
                    variableRetorn = a;
                }
            }
        }
        return variableRetorn;
    }

    private Client buscarClient(String dni)throws ExcepcioReserva{
        Iterator<Client> itClients = clients.iterator();
        while (itClients.hasNext()){
            Client c = itClients.next();
            if(c.getDni().equals(dni)){
                return c;
            }
        }
        throw new ExcepcioReserva("El client amb DNI " + dni + " no existeix");
    }

    public static InAllotjament.Temp getTemporada(LocalDate data){
        int mes = data.getMonthValue();
        int dia = data.getDayOfMonth();

        if ((mes == 3 && dia >= 21) || (mes == 11 && dia <= 20) ||  (mes > 3 && mes < 9)){
            return InAllotjament.Temp.ALTA;
        }
        else {
            return InAllotjament.Temp.BAIXA;
        }
    }

}
