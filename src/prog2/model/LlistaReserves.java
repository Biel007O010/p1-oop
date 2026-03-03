package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class LlistaReserves implements InLlistaReserves{

    private ArrayList<Reserva> llistaReserves;

    public LlistaReserves(){
        this.llistaReserves = new ArrayList<>();
    };

    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{

        //Aquí faltan poner las condiciones para agregar una nueva reserva. Se usan los dos últimos métodos de esta misma clase.

        Reserva reserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
        llistaReserves.add(reserva);
    };

    public int getNumReserves(){
        return llistaReserves.toArray().length;
    };

    public boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){

        return false;
    };

    public boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){


        return false;
    };

}
