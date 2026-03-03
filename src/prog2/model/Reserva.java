package prog2.model;

import java.time.LocalDate;

public class Reserva implements InReserva{

    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    public Reserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida){
        this.allotjament = allotjament;
        this.client = client;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    };

    public Allotjament getAllotjament_(){return allotjament;};

    public Client getClient(){return client;};

    public LocalDate getDataEntrada(){return dataEntrada;};

    public LocalDate getDataSortida(){return dataSortida;};

    public void setAllotjament_(Allotjament allotjament_){
        allotjament = allotjament_;
    };

    public void setClient(Client client_){
        client = client_;
    };

    public void setDataEntrada(LocalDate dataEntrada_){
        dataEntrada = dataEntrada_;
    };

    public void setDataSortida(LocalDate dataSortida_){
        dataSortida = dataSortida_;
    };
}
