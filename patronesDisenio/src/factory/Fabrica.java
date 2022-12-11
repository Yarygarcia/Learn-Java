package factory;

public  class Fabrica {
    public static Dispositivos construir(String tipo){
        switch (tipo){
            case "Celular":
                return new Celular();
            case "Computador":
                return  new Computador();
            default:
                System.out.println("No existe dicho dispositivo");
                return null;
        }
    }
}
