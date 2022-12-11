public class Cajero implements Empleado{
    private  String tipoEmpleado = "Cajero";
    @Override
    public double saldo() {
        double saldoTotal = 25630.89;
        return saldoTotal;
    }

    @Override
    public void funcion() {
        System.out.println("Encargado de la caja");
    }

    public String getTipoEmpleado(){
        return this.tipoEmpleado;
    }

    public String toString(){
        return getTipoEmpleado();
    }
}
