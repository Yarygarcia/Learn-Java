import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Poligono> misPoligonos = new ArrayList<>();
    public static void main(String[] args){
        ingresarPoligonos();
        mostrarPoligonos();
    }
    public static void ingresarPoligonos() {
        int opcion;
        char siNo;
        do {
            do {
                System.out.println("Ingresa un valor para el poligono que deseas ingresar");
                System.out.println("1. Triangulo \n2. Rectangulo");
                System.out.println("   Opcion: ");
                opcion = entrada.nextInt();
            }
            while (opcion <1 || opcion >2);
                switch (opcion) {
                    case 1:
                        llenarTriangulo();
                        break;
                    case 2:
                        llenarRectangulo();
                        break;
                }
                System.out.print("Deseas ingresar otro poligono? (s/n)");
                siNo = entrada.next().charAt(0);
            }
            while (siNo == 's' || siNo == 'S');
    }
    public static void llenarTriangulo(){
        int lado1, lado2, lado3;
        System.out.println("--------------Triangulo------------");
        System.out.println("Ingresa el lado 1: ");
        lado1 = entrada.nextInt();
        System.out.println("Ingresa el lado 2: ");
        lado2 = entrada.nextInt();
        System.out.println("Ingresa el lado 3: ");
        lado3 = entrada.nextInt();
        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
        misPoligonos.add(triangulo);

    }
    public static  void llenarRectangulo(){
        int lado1, lado2;
        System.out.println("--------Rectangulo -------------");
        System.out.println("Ingresa el lado 1: ");
        lado1 = entrada.nextInt();
        System.out.println("Ingresa el lado 2: ");
        lado2 = entrada.nextInt();
        Rectangulo rectangulo = new Rectangulo(lado1,lado2);
        misPoligonos.add(rectangulo);
    }
    public static void mostrarPoligonos(){
        for(int i =0; i<misPoligonos.size(); i++){
            System.out.println(misPoligonos.get(i).toString());
            System.out.println("Area: " + misPoligonos.get(i).area());
        }
    }

}
