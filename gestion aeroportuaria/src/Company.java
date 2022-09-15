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
        numVuelo = v.length;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public int getNumVuelo() {
        return numVuelo;
    }

    public void insertarVuelo(Vuelo vuelo){
        listaVuelos[numVuelo] = vuelo;
        numVuelo++;
    }
    public Vuelo obtenerVuelo(int identificador){
        Vuelo vuelo = null;
        for(int i =0; i <listaVuelos.length; i++){
            if(listaVuelos[i]. getIdVuelo() == identificador){
                vuelo = listaVuelos[i];
            }
        }
        return vuelo;
    }
    public Vuelo obtenerVuelo(String ciudadO, String ciudadD){
        Vuelo vuelo = null;
        for(int i =0; i < listaVuelos.length; i++){
            if(listaVuelos[i].getCiudadOrigen().equals(ciudadO) && listaVuelos[i].getCiudadDestino().equals(ciudadD)){
                vuelo = listaVuelos[i];
            }
        }
        return vuelo;
    }
}
