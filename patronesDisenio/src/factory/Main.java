package factory;

public class Main {

    public static void main(String [] args){
        Dispositivos d1 = Fabrica.construir("Celular");
        Dispositivos d2 = Fabrica.construir("Computad");
        d1.apagar();
        d2.encender();
    }
}
