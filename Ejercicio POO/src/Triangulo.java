public class Triangulo extends  Poligono{
    int lado1;
    int lado2;
    int lado3;
    public Triangulo(int lado1, int lado2, int lado3){
        super(3);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }
    public int getLado1(){
        return lado1;
    }
    public int getLado2(){
        return lado2;
    }
    public  int getLado3() {
        return lado3;
    }
    @Override
    public String toString() {
        return "Triangulo: " + super.toString() + "\nLado 1: " +lado1 + " lado 2: " + lado2 + " lado 3: " + lado3;
    }
    @Override
    public String area(){
        double p = (lado1 + lado2 + lado3)/2;
        return "Area: " + (Math.sqrt(p*(p-lado1)* (p-lado2) * (p-lado3)));
    }
}
