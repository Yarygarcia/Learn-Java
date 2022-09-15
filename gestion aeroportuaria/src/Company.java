import java.nio.charset.CoderMalfunctionError;

public class Company{
    private String nameCompany;
    private Vuelo listaVuelos[] = new Vuelo[10];
    private int numVuelo=0;

    public Company(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Company(String nameCompany, Vuelo v[]){
        this.nameCompany = nameCompany;
        listaVuelos = v;
        numVuelo = listaVuelos.length;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    

    public void listarVuelos(Vuelo vuelo){
        System.out.println("Id: " + vuelo.getIdVuelo() + " Ciudad origen: " + vuelo.getCiudadOrigen() + " ciudad de destino: " + vuelo.getCiudadDestino() + " precio: $" + vuelo.getPrecioVuelo());
    }
}
