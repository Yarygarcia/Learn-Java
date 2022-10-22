public class Rectangulo implements IFigura{
    private double lado1;
    private double lado2;

    public Rectangulo(double lado1, double lado2){
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    public double getLado1(){
        return lado1;
    }
    public  double getLado2(){
        return  lado2;
    }

    @Override
    public void mostrarArea(){
        double formulaArea = lado1* lado2;
        System.out.println( "Área Rectangulo: " + formulaArea );
    }
    @Override
    public void mostrarPerimetro(){
        double formulaPerimetro = lado1*2 + lado2*2;
        System.out.println( "Perimetro Rectangulo: " + formulaPerimetro);
    }
}
