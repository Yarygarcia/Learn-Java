public class Company {
    private String nameCompany;
    private Vuelo listaVuelos[] = new Vuelo[10];
    private int numVuelo = 0;

    public Company(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Company(String nameCompany, Vuelo v[]) {
        this.nameCompany = nameCompany;
        listaVuelos = v;
        numVuelo = v.length;
    }

    public Vuelo[] listarVuelos() {
        return listaVuelos;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public int getNumVuelo() {
        return numVuelo;
    }

    public void insertarVuelo(Vuelo vuelo) {
        listaVuelos[numVuelo] = vuelo;
        numVuelo++;
    }

    public Vuelo obtenerVuelo(int identificador) {
        Vuelo vuelo = null;
        for (int i = 0; i < listaVuelos.length; i++) {
            if (listaVuelos[i].getIdVuelo() == identificador) {
                vuelo = listaVuelos[i];
            }
        }
        return vuelo;
    }

    public Vuelo obtenerVuelo(String ciudadO, String ciudadD) {
        boolean encontrado = false;
        Vuelo vuelo = null;
        int i =0;
        while((!encontrado)&& (i < listaVuelos.length)) {
            if (listaVuelos[i].getCiudadOrigen()== ciudadO && listaVuelos[i].getCiudadDestino()==ciudadD) {
                encontrado = true;
                vuelo = listaVuelos[i];
            }
            i++;
        }
        return vuelo;
    }
}
