import java.util.Scanner;

public class Main {
    public  static int mayorArea(Triangulo triangulos[]){
        int indice = 0;
        double areaMayor = triangulos[indice].area();
        for(int z =0; z< triangulos.length; z++){
            if(triangulos[z].area() > areaMayor){
                indice= z;
                areaMayor = triangulos[indice].area();
            }
        }
        return  indice;
    }
    public static  void main (String[]args){
        Scanner entrada = new Scanner(System.in);

        int lado1 =0;
        int lado2 = lado1;
        int lado3;
        System.out.print("Ingrese el número de triangulos: ");
        int dimension = entrada.nextInt();
        Triangulo triengulos[] = new Triangulo[dimension];
        for(int i =0; i< triengulos.length; i++){
            System.out.print("Triangulo " + (i+1));
            System.out.print("Ingrese el primer lado: ");
            lado1 = entrada.nextInt();
            System.out.print("Ingrese el último lado: ");
            lado3 = entrada.nextInt();
            triengulos[i] = new Triangulo(lado1,lado3);
        }
        int indiceTrinagulo = mayorArea(triengulos);
        System.out.println(triengulos[indiceTrinagulo].area());
    }
}
