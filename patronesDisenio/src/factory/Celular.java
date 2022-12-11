package factory;

public class Celular implements  Dispositivos{
    public  Celular(){
    }
    @Override
    public void encender(){
        System.out.println("El celular se encendio");
    }

    @Override
    public void apagar(){
        System.out.println("El celular se apagó");
    }

}
