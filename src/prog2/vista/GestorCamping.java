
package prog2.vista;


import prog2.model.Allotjament;
import prog2.model.Camping;
import prog2.model.InAllotjament;

import java.time.LocalDate;
import java.time.Month;

/**
 * Classe per gestionar els allotjaments del Càmping del Mar.
 * @author lauraigual
 */
public class GestorCamping {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Camping campingMar = new Camping("Camping del Mar");

        omplirDadesModel(campingMar);
        
        ferReserves(campingMar);

        int numAllotjaments, allotjamentsDisp;


        // Mostrar el número total d'allotjaments del Càmping i el número d'allotjaments que estan operatius amb el següent missatge:
        // >> El número total d'allotjaments del Càmping és X dels quals X allotjaments estan operatius.
        //--------------------------------------------------------------------------------------------------
        // Per completar

        numAllotjaments = campingMar.getNumAllotjaments();
        allotjamentsDisp = campingMar.calculAllotjamentsOperatius();

        System.out.println("El número total d'allotjaments del Càmping és " + numAllotjaments + " dels quals " + allotjamentsDisp + " allotjaments estan operatius");

        // Mostrar l'allotjament amb estada mínima de la temporada alta més curta amb el següent missatge:
        // >> L'allotjament amb estada mínima de la temporada alta més curta és el següent:
        //--------------------------------------------------------------------------------------------------
        // Per completar

        Allotjament altaCurta = campingMar.getAllotjamentEstadaMesCurta(InAllotjament.Temp.ALTA);
        System.out.print("L'allotjament amb estada mínima de la temporada alta més curta és el següent: ");
        System.out.println(altaCurta.toString());
       
    }

    /**
     * Mètode de classe per afegir parcel·les, bungalows, bungalows premium, glampings, mobil-home i clients al càmping.
     * @param camping L'objecte de tipus Camping que anem a omplir
     */
    private static void omplirDadesModel(Camping camping){


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "100P";

        float metres = 64.0f;
        boolean connexioElectrica = true;

        camping.afegirParcela(nom, idAllotjament, metres, connexioElectrica);

        nom = "Parcel·la Sud";
        idAllotjament = "101P";

        camping.afegirParcela(nom, idAllotjament, metres, connexioElectrica);


        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Est";
        idAllotjament = "102B";
        String mida = "Mitjana";

        int habitacions =2;
        int placesPersones = 6;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;


        camping.afegirBungalow(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);


        nom = "Bungalow Oest";
        idAllotjament = "103B";
        habitacions =2;
        placesPersones = 4;
        placesParquing = 1;
        terrassa = true;
        tv= false;
        aireFred = true;

        camping.afegirBungalow(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Nord";
        idAllotjament = "104BP";
        mida = "Gran";
        habitacions =2;
        placesPersones = 6;
        placesParquing = 2;
        terrassa = true;
        tv= false;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        camping.afegirBungalowPremium(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);


        nom = "Bungallow Sud";
        idAllotjament = "105BP";
        mida = "Gran";
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= false;
        aireFred = false;
        serveisExtra = true;
        codiWifi = "CampingDelMarBP2";

        camping.afegirBungalowPremium(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);


        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "106G";
        mida = "Petita";
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        camping.afegirGlamping(nom, idAllotjament, mida, habitacions, placesPersones, material, casaMascota);


        nom = "Glamping Sud";
        idAllotjament = "107G";
        mida = "Petita";
        habitacions =1;
        placesPersones = 2;
        material = "Tela";
        casaMascota = false;

        camping.afegirGlamping(nom, idAllotjament, mida, habitacions, placesPersones, material, casaMascota);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Nord";
        idAllotjament = "108MH";
        mida = "Petita";
        habitacions =1;
        placesPersones = 2;
        boolean terrassaBarbacoa = true;


        camping.afegirMobilHome(nom, idAllotjament, mida, habitacions, placesPersones, terrassaBarbacoa);

        nom = "Mobil-Home Sud";
        idAllotjament = "109MH";
        mida = "Mitjana";
        habitacions =2;
        placesPersones = 4;
        terrassaBarbacoa = false;

        camping.afegirMobilHome(nom, idAllotjament, mida, habitacions, placesPersones, terrassaBarbacoa);


        // Afegir clients:
        //------------------------------

        String nomClient="Patricia Fernandez";
        String dni="12345678X";
        camping.afegirClient(nomClient, dni);

        nomClient = "Lluís Plans";
        dni="78659101A";
        camping.afegirClient(nomClient, dni);

    }


    /**
     * Mètode per fer reserves d'allotjaments.
     * @param camping
     */
    private static void ferReserves(Camping camping){
        
        // Per completar:
        
        // 1. Afegeix una reserva pel client amb DNI "12345678X" de l'allotjament amb identificador "100P"
        // amb la data d'entrada 20 de Febrer del 2026 i data de sortida 28 de febrer del 2026.

        // Declarar les variables de tipus String idAllotjament i dni.
        // Per completar

        // Assigna els valors corresponents.
        // Per completar

        // Crear una LocalDate per definir la data de la reserva.
        // Per completar

        // Intentar afegir la reserva amb la informació indicada i si no és possible mostrar el missatge d'error.
        // Per completar

        String idAllotjament = "100P";
        String dni = "12345678X";
        LocalDate entrada = LocalDate.of(2026, Month.FEBRUARY, 20);
        LocalDate sortida = LocalDate.of(2026, Month.FEBRUARY, 28);

        try{
            camping.afegirReserva(idAllotjament, dni, entrada, sortida);
        } catch (ExcepcioReserva e) {
            throw new RuntimeException(e);
        }

        // 2. Afegeix una reserva pel client amb DNI "78659101A" de l'allotjament amb identificador "100P"
        // amb la data d'entrada 25 de Febrer del 2026 i data de sortida 28 de febrer del 2026.

        // Assigna els nous valors a les variables
        // Per completar

        // Intentar afegir la reserva amb la informació indicada i si no és possible mostrar el missatge d'error.
        // Per completar

        idAllotjament = "100P";
        dni = "78659101A";
        entrada = LocalDate.of(2026, Month.FEBRUARY, 25);
        sortida = LocalDate.of(2026, Month.FEBRUARY, 28);

        try{
            camping.afegirReserva(idAllotjament, dni, entrada, sortida);
        } catch (ExcepcioReserva e) {
            throw new RuntimeException(e);
        }
           
        // 3. Afegeix una reserva pel client amb DNI "789101A" de l'allotjament amb identificador "300Z"
        // amb la data d'entrada 25 de Febrer del 2026 i data de sortida 28 de febrer del 2026.

        // Assigna els nous valors a les variables.    
        // Per completar

        // Intentar afegir la reserva amb la informació indicada i si no és possible mostrar el missatge d'error.
        // Per completar

        idAllotjament = "300Z";
        dni = "789101A";
        entrada = LocalDate.of(2026, Month.FEBRUARY, 25);
        sortida = LocalDate.of(2026, Month.FEBRUARY, 28);

        try{
            camping.afegirReserva(idAllotjament, dni, entrada, sortida);
        } catch (ExcepcioReserva e) {
            throw new RuntimeException(e);
        }
        
    }
    
}
