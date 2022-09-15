public class AeropuertoPublico extends Aeropuerto{

    private double dineroNacion;

    public AeropuertoPublico(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }
    public AeropuertoPublico(String nombre, String ciudad, String pais, Company[] listCompanies, double dineroNacion) {
        super(nombre, ciudad, pais, listCompanies);
        this.dineroNacion = dineroNacion;
    }

    public  AeropuertoPublico(String nombre, String ciudad, String pais, double dineroNacion){
        super(nombre, ciudad, pais);
        this.dineroNacion = dineroNacion;
    }
    public double getDineroNacion() {
        return dineroNacion;
    }
}
