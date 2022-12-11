package prototype;

public class Main {
    public static void main(String [] args) throws CloneNotSupportedException {
        Coche carro1 = new Coche();
        carro1.puertas= 4;
        carro1.marca = "Susuki";

        Coche carro2 = new Coche();

        carro2.marca= "Toyota";
        carro2.puertas = 4;

        Coche carro3 = carro1.clonar();


        System.out.println(carro1.toString());
        System.out.println(carro2.toString());
        System.out.println(carro3.toString());

    }
}
