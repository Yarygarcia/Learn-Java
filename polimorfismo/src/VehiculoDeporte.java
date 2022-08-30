public class VehiculoDeporte extends Vehiculo {
    private int cilindrada;

    public VehiculoDeporte(String marca, String matricula, String modelo, int cilindrada) {
        super(marca, matricula, modelo);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public String mostrarDatos() {
        return "Marca: " + getMarca() + "\nMatricula: " + getMatricula() + "\nModelo: " + getModelo() + "\nCilindrada: " + cilindrada;
    }
}