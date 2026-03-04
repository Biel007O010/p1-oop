package prog2.model;

import prog2.vista.ExcepcioReserva;
import prog2.model.Reserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class LlistaReserves implements InLlistaReserves{

    private ArrayList<Reserva> llistaReserves;

    public LlistaReserves(){
        this.llistaReserves = new ArrayList<Reserva>();
    };

    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{

        Reserva novaReserva = new Reserva(allotjament, client, dataEntrada, dataSortida);

        if (!allotjamentDisponible(allotjament, dataEntrada, dataSortida)) {
            throw new ExcepcioReserva("L'allotjament amb ID " + allotjament.getId() + " no està disponible.");
        }

        if (!isEstadaMinima(allotjament, dataEntrada, dataSortida)) {
            throw new ExcepcioReserva("Estada mínima no assolida per al client " + client.getNom());
        }

        llistaReserves.add(novaReserva);
        System.out.println("La reserva es va agendar correctament.");
    }

    public int getNumReserves(){
        return llistaReserves.size();
    }

    public boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {

        for (Reserva reserva : llistaReserves){
            if (reserva.getAllotjament_().getId().equals(allotjament.getId())){
                if (dataEntrada.isBefore(reserva.getDataSortida()) && dataSortida.isAfter(reserva.getDataEntrada())){
                    return false;
                }
            }
        }

        return true;
        }

    public boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){

        long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);

        int mesEntrada = dataEntrada.getMonthValue();
        int diaEntrada = dataEntrada.getDayOfMonth();

        if ((mesEntrada > 3 && mesEntrada < 9) || (mesEntrada == 3 && diaEntrada >= 21) || (mesEntrada == 9 && diaEntrada <= 21)){

            return allotjament.getEstadaMinima(InAllotjament.Temp.ALTA) <= estada;

        }else{
            return allotjament.getEstadaMinima(InAllotjament.Temp.BAIXA) <= estada;

        }
    }
}
