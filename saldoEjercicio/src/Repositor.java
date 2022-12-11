public class Repositor implements Empleado{
    private String tipoEmpelado = "Repositor";
    @Override
    public double saldo() {
        double saldoMensula = 15890;
        int bono = 10;
        double saldoTotal = (bono * saldoMensula)/100 + saldoMensula;
        return saldoTotal;
    }

    @Override
    public void funcion() {
        System.out.println("Poner la mercancia en las estanterias");
    }
    public String getTipoEmpelado(){
        return tipoEmpelado;
    }
    public String toString(){
        return getTipoEmpelado();
    }
}
