public class Animal {
    private String nombre;
    private int patas;
    public Animal(String nombre, int patas){
        this.nombre = nombre;
        this.patas = patas;
    }
    public String getNombre(){
        return nombre;
    }
    public int getPatas(){
        return patas;
    }
    public void comer(){
        System.out.println("Soy un " + nombre + " y estoy comiendo");
    }
}
