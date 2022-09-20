import java.lang.reflect.GenericArrayType;

public class Aeropuerto {
    private String nombre;
    private String ciudad;
    private String pais;
    private Company listCompanies[]= new Company[10];
    private int numCompany;

    public Aeropuerto(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.numCompany = 0;
    }

    public Aeropuerto(String nombre, String ciudad, String pais, Company[] listCompanies) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        listCompanies = listCompanies;
        this.numCompany = listCompanies.length;
    }

    public void insertarCompany(Company company) {
        listCompanies[numCompany] = company;
        numCompany++;
    }
    public Company traerComapy(String nombre){
        boolean encontrado = false;
        int i =0;
        Company company=null;
        while ((!encontrado)&& (i < listCompanies.length)){
            if(nombre == listCompanies[i].getNameCompany()){
                encontrado = true;
                company = listCompanies[i];
            }
            i++;
        }
        return company;
    }

    public Company[] getListCompanies() {
        return listCompanies;
    }
    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public int getNumCompany() {
        return numCompany;
    }
}
