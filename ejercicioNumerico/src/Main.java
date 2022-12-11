import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String palabra;
        do {
            System.out.print("Ingrese una palabra: ");
            palabra = entrada.nextLine();
        }while (!palabra.equals("salir"));
    }
}
