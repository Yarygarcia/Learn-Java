public class VehiculoTurismo extends  Vehiculo{
    private int numeroPuertas;
    public VehiculoTurismo(String marca, String matricula, String modelo, int numeroPuertas){
        super(marca, matricula, modelo);
        this.numeroPuertas = numeroPuertas;
    }
    public int getNumeroPuertas(){
        return numeroPuertas;
    }
    @Override
    public  String mostrarDatos(){
        return "Marca: " + getMarca() + "\nMatricula: " + getMatricula() + "\nModelo: " + getModelo() + "\nNumero de puertas: " + numeroPuertas;
    }
}
