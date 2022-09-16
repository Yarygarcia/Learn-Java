public class AeropuertoPrivado extends Aeropuerto{
    private String empresas[] = new String[10];
    private int numEmpresas=0;

    public AeropuertoPrivado(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }
    public AeropuertoPrivado(String nombre, String ciudad, String pais, String[] empresas){
        super(nombre, ciudad, pais);
        this.empresas = empresas;
        this.numEmpresas = empresas.length;

    }
    public AeropuertoPrivado(String nombre, String ciudad, String pais, Company[] listCompanies, String[] empresas) {
        super(nombre, ciudad, pais, listCompanies);
        this.empresas = empresas;
        this.numEmpresas = empresas.length;
    }

    public String[] getEmpresas() {
        return empresas;
    }

    public int getNumEmpresas() {
        return numEmpresas;
    }

    public void insertarEmpresas(String empresa[]){
        this.empresas = empresa;
        this.numEmpresas = empresa.length;
    }

    public void insertarEmpresa(String empresa){
        empresas[numEmpresas] = empresa;
        numEmpresas++;
    }

}
