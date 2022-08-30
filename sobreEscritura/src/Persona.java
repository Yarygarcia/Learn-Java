public class Persona extends Animal {
    public Persona (String nombre, int patas){
        super(nombre, patas);
    }
    @Override
    public void comer(){
        System.out.println("SOy un " + getNombre()+ " Y estoy comiendo en una mesa con platos y cibiertos");
    }

}
