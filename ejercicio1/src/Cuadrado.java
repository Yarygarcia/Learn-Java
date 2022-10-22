public class Cuadrado implements  IFigura{
    private double lado1;

    public Cuadrado(double lado1){
        this.lado1 = lado1;
    }

    public double getLado1() {
        return lado1;
    }
    @Override
    public  void mostrarArea(){
        double formulaArea = lado1*lado1;
        System.out.println("Area Cuadrado: " + formulaArea);
    }
    @Override
    public void mostrarPerimetro() {
        double formulaPerimetro = lado1*4;
        System.out.println("Perimetro cuadrado: " + formulaPerimetro );
    }
}
