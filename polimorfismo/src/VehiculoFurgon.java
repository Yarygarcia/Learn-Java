public class VehiculoFurgon extends Vehiculo {
    private int carga;
    public VehiculoFurgon(String marca, String matricula, String modelo, int carga){
        super(marca, matricula, modelo);
        this.carga = carga;
    }
    public int getCarga(){
        return carga;
    }
    @Override
    public String mostrarDatos(){
        return "Marca: " + getMarca() + "\nMatricula: " + getMatricula() + "\nModelo: " + getModelo() + "\nCarga: " + carga;
    }
}
