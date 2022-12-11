public class Supervisor implements Empleado{
    private String tipoEmpleado = "Supervisor";
    @Override
    public double saldo() {
        double sueldoMensual = 35560.20;
        int jubilacion = 11;
        double sueldoTotal = sueldoMensual - (sueldoMensual*jubilacion)/100;
        return sueldoTotal;
    }

    @Override
    public void funcion() {
        System.out.println("Suoervisa los empleados que tiene a acargo");
    }
    public String getTipoEmpleado(){
        return tipoEmpleado;
    }
    public String toString(){
        return getTipoEmpleado();
    }
}
