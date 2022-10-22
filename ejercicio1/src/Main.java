import java.util.Scanner;

public class Main {
    static Scanner  entrada = new Scanner(System.in);
    public static int resultado;
    public static int resultadoFigura;

    public static  void main(String[] args){
        mostrarMenuPrincipal();
    }
    public static void mostrarMenuPrincipal(){
        do {
            switch (resultado){
                case 1: mostrarArea();
                    break;
                case 2: mostrarPerimetro();
                    break;
                case 3: break;
            }
            do {
                System.out.println("------------- Menú Principal -------------");
                System.out.println( "1. Calcular área");
                System.out.println( "2. Calcular perimetro");
                System.out.println( "3. Salir");
                resultado = entrada.nextInt();

            }while (resultado < 0 && resultado > 3);

        }while (resultado !=3);
    }
    public static  void mostrarArea(){
        do {
            do {
                System.out.println("------------- Menú Áreas -------------");
                System.out.println("1. Cuadrado");
                System.out.println("2. Rectangulo");
                System.out.println("3. Triangulo");
                System.out.println("4. Circulo");
                System.out.println("5. Volver");
                resultadoFigura = entrada.nextInt();

            }while (resultadoFigura < 0 && resultadoFigura >5);
                switch (resultadoFigura){
                    case 1:
                        System.out.print("Ingresa un lado: ");
                        double lado1Cuadrado = entrada.nextDouble();
                        Cuadrado cuadrado = new Cuadrado(lado1Cuadrado);
                        cuadrado.mostrarArea();
                        break;
                    case 2:
                        System.out.print("Ingresa un lado: ");
                        double lado1Rectangulo = entrada.nextDouble();
                        System.out.print("Ingresar un segundo lado: ");
                        double lado2Rectangulo = entrada.nextDouble();
                        Rectangulo rectangulo = new Rectangulo(lado1Rectangulo, lado2Rectangulo);
                        rectangulo.mostrarArea();
                        break;
                    case 3:
                        System.out.print("Ingresar un lado: ");
                        double lado1Triangulo = entrada.nextDouble();
                        System.out.print("Ingresa un lado: ");
                        double lado2Triangulo = entrada.nextDouble();
                        System.out.print("Ingresar un lado: ");
                        double lado3Triangulo = entrada.nextDouble();
                        Triangulo triangulo = new Triangulo(lado1Triangulo, lado2Triangulo, lado3Triangulo);
                        triangulo.mostrarArea();
                        break;
                    case 4:
                        System.out.print("Ingresa el diametro");
                        double diametro = entrada.nextDouble();
                        Circulo circulo = new Circulo(diametro);
                        circulo.mostrarArea();
                        break;
                    case 5: break;
                }

        }while (resultadoFigura !=5);

    }
    public static  void mostrarPerimetro(){
        do {
            do {
                System.out.println("------------- Menú Perimetro -------------");
                System.out.println("1. Cuadrado");
                System.out.println("2. Rectangulo");
                System.out.println("3. Triangulo");
                System.out.println("4. Circulo");
                System.out.println("5. Volver");
                resultadoFigura = entrada.nextInt();
            }while (resultadoFigura <0 && resultadoFigura >5);
            switch (resultadoFigura){
                case 1:
                    System.out.print("Ingresar un lado: ");
                    double lado1 = entrada.nextDouble();
                    Cuadrado cuadrado = new Cuadrado(lado1);
                    cuadrado.mostrarPerimetro();
                    break;
                case 2:
                    System.out.print("Ingresar un lado: ");
                    double lado1Rectangulo = entrada.nextDouble();
                    System.out.print("Ingresar un lado: ");
                    double lado2Rectangulo = entrada.nextDouble();
                    Rectangulo rectangulo = new Rectangulo(lado1Rectangulo, lado2Rectangulo);
                    rectangulo.mostrarPerimetro();
                    break;
                case 3:
                    System.out.print("Ingresa un lado: ");
                    double lado1Triangulo = entrada.nextDouble();
                    System.out.print("Ingresar un lado: ");
                    double lado2Triangulo = entrada.nextDouble();
                    System.out.print("Ingresar un lado: ");
                    double lado3Triangulo = entrada.nextDouble();
                    Triangulo triangulo = new Triangulo(lado1Triangulo, lado2Triangulo, lado3Triangulo);
                    triangulo.mostrarPerimetro();
                    break;
                case 4:
                    System.out.print("Ingresa el diametro: ");
                    double diametro = entrada.nextDouble();
                    Circulo circulo = new Circulo(diametro);
                    circulo.mostrarPerimetro();
                    break;
                case 5: break;
            }

        }while (resultadoFigura !=5);
    }
}
