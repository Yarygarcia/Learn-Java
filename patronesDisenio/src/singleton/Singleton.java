package singleton;

public class Singleton {
    private static Singleton sing;
    private static int valor;

    private Singleton(){}

    public static Singleton getSing(){
        if(sing == null){
            sing = new Singleton();
            System.out.println("Prendido");
        }
        else{
            sing = new Singleton();
            System.out.println("Ya ha sido prendido");

        }
        return sing;
    }

    public int getValor(int n){
        return valor =  n;
    }
}
