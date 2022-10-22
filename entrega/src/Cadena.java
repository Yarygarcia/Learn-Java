import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Cadena {

    public static void main(String[]args) {
        devolverCadenaReves();
        System.out.println("---------------------");
        iterarArray();
        System.out.println("---------------------");
        arrayBidimensional();
        System.out.println("---------------------");
        obtenerVector();
        System.out.println("---------------------");
        arrayAlinkList();
        System.out.println("---------------------");
        numerosImpares();
        System.out.println("---------------------");
        dividePorCero(3,0);
    }
    public static void devolverCadenaReves(){
        String cadena1 = "Hola Mundo";
        String cadena2 ="";
        for(int i =cadena1.length()-1; i >= 0; i--){
            cadena2 += cadena1.charAt(i);
        }
        System.out.println(cadena2);
    }

    public static void iterarArray(){
        ArrayList<String> arrayNombres = new ArrayList<>();
        arrayNombres.add("Camila");
        arrayNombres.add("Santiago");
        arrayNombres.add("Laura");
        arrayNombres.add("Ana");

        for(int i =0; i < arrayNombres.size(); i++){
            System.out.print(arrayNombres.get(i) + " ");
        }
        System.out.println();
    }

    public static void arrayBidimensional(){
        int arrayB [][] = {{1,2}, {3,4}};
        for( int i =0; i < arrayB.length; i++){
            for(int j =0; j < arrayB.length; j++){
                System.out.print(" Posicion [" + i + "] [" + j + "]:  "  + arrayB[i][j]);
            }
                System.out.println();
        }
    }

    public  static void obtenerVector(){
        Vector <Integer> vector = new Vector();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);

        vector.remove(1);
        vector.remove(2);

        for (int v: vector){
            System.out.println(v + " ");
        }
    }

    public static void arrayAlinkList(){
        ArrayList<String> dias= new ArrayList<>();
        List<String> diasLinkedList = new LinkedList<>();
        dias.add("lunes");
        dias.add("martes");
        dias.add("miercoles");
        dias.add("jueves");
        diasLinkedList.addAll(dias);
        System.out.println("ArrayList");
        for(String dia :dias){
            System.out.print(dia + " ");
        }
        System.out.println();
        System.out.println("LinkedList");
        for(String dia :diasLinkedList){
            System.out.print(dia + " ");
        }
    }
    public static void numerosImpares(){
        ArrayList<Integer> numeros = new ArrayList<>();
        int cantidad = 10;
        for(int i =1 ; i <= cantidad; i++){
            numeros.add(i);
        }
        for(int i =0; i < numeros.size(); i++){
            if(numeros.get(i)%2 ==0){
                numeros.remove(numeros.get(i));
            }
        }
        for(int num : numeros){
            System.out.print(num + " ");
        }
    }

    public static void dividePorCero(int num1, int num2) throws ArithmeticException{
        try{
            double resultado = num1/num2;
            System.out.println(resultado);
        }catch (ArithmeticException e){
            System.out.println("Esto no puede hacerse");
        }
        finally {
            System.out.println("Demo de código");
        }
    }
    
}
