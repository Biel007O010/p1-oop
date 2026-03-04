package prog2.model;

public class Client implements InClient{

    private String nom;
    private String dni;

    public Client(String nom_, String dni_){
        this.nom = nom_;
        this.dni = dni_;
    };

    public String getNom(){return nom;};

    public String getDni(){return dni;};

    public void setNom(String nom){this.nom = nom;};

    public void setDni(String dni){this.dni = dni;};

    @Override
    public String toString(){
        return nom + " amb DNI: " + dni + ". ";
    }

}
