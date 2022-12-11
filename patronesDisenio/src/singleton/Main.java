package singleton;

public class Main {

    public static void main (String [] args){
        Singleton sing = Singleton.getSing();
        Singleton sing1 = Singleton.getSing();
        Singleton sing2 = Singleton.getSing();
        System.out.println(sing2.getValor(5));
        System.out.println(sing1.getValor(9));
        System.out.println(sing + "  " + sing1);
    }
}
