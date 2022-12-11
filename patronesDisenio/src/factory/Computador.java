package factory;

public class Computador implements Dispositivos{

    public  Computador(){

    }
    @Override
    public void encender(){
        System.out.println("El Computador se encendio");
    }

    @Override
    public void apagar(){
        System.out.println("El Computador de apagó");
    }

}
