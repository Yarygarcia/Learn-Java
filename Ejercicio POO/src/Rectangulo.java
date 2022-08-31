public class Rectangulo extends Poligono {
    private int lado1;
    private int lado2;
    public Rectangulo(int lado1, int lado2){
        super(2);
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    public int getLado1(){
        return lado1;
    }
    public int getLado2(){
        return lado2;
    }
    @Override
    public String toString(){
        return "Rectangulo: " + super.toString() + "\nLado 1: " + lado1 + " lado 2: " + lado2;
    }

    @Override
    public String area(){
        return "El area  es:" + (lado1*lado2);
    }
}
