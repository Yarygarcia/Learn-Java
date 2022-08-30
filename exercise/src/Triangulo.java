public class Triangulo {
    private int lado1;
    private int lado2;
    private  int lado3;
    public Triangulo(int lado1, int lado3){
        this.lado1 = this.lado2 = lado1;
        this.lado3 = lado3;
    }

    public double area(){
        double base=0;
        double altura=0;
        if(lado1 > base){
            base = lado3/2;
            altura= Math.sqrt(Math.pow(lado1,2)- Math.pow(base,2));

        }
        return (base*altura)/2;
    }
    public double perimetro(){
        int a = Math.PI + Math.PI
        return (lado1*2) + lado3;
    }
}
