import java.util.ArrayList;

public class Vuelo {
    private int  idVuelo;
    private String ciudadOrigen;
    private String ciudadDestino;
    private double precioVuelo;
    private Pasajero listaPasajeros[];
    private int maxPasajeros;
    private int cantidadPasajeros;

    public Vuelo(int idVuelo, String ciudadOrigen, String ciudadDestino, double precioVuelo, int maxPasajeros){
        this.idVuelo = idVuelo;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precioVuelo = precioVuelo;
        this.maxPasajeros = maxPasajeros;
        this.cantidadPasajeros = 0;
        this.listaPasajeros = new Pasajero[maxPasajeros];
    }
    public  void ingresarPasajeros(Pasajero pasajero){
        listaPasajeros[maxPasajeros] = pasajero;
        maxPasajeros++;
    }
    public int getIdVuelo() {
        return idVuelo;
    }
    public String getCiudadOrigen() {
        return ciudadOrigen;
    }
    public String getCiudadDestino() {
        return ciudadDestino;
    }
    public double getPrecioVuelo() {
        return precioVuelo;
    }

    public int getMaxPasajeros() {
        return maxPasajeros;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }
    public void obtenerPasajero(Pasajero pasajero[], String pasaporte){
        for(int i =0; i <pasajero.length; i++){
            if(pasajero[i].getIdPasaporte() == pasaporte){
                System.out.println(pasajero[i]);
            }
        }
    }
}
