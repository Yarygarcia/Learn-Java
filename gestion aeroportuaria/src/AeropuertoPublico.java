public class AeropuertoPublico extends Aeropuerto{

    private double dineroNacion;
    public AeropuertoPublico(String nombre, String ciudad, String pais, double dineroNacion) {
        super(nombre, ciudad, pais);
        this.dineroNacion = dineroNacion;
    }

    public void mostrarCompanies(){

    };
}
