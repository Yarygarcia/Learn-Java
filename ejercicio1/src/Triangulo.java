public class Triangulo implements  IFigura{

    private double lado1;
    private double lado2;
    private  double lado3;

    public Triangulo(double lado1, double lado2, double lado3){
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double getLado1(){
        return  lado1;
    }
    public  double getLado2(){
        return  lado2;
    }
    public double getLado3(){
        return  lado3;
    }

    @Override
    public void  mostrarArea(){
        double formulaArea = Math.sqrt(5*(5-lado1) * (5-lado2) * (5 - lado3));
        System.out.println( "Area Triangulo: " + formulaArea );
    }
    @Override
    public  void mostrarPerimetro(){
        double formulaPerimetro = lado1 + lado2 + lado3;
        System.out.println( "Perimetro Triangulo: " + formulaPerimetro );
    }

}
