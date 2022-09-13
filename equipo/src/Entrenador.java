public class Entrenador extends Persona{
    private String estrategia;
    public Entrenador(String nombre, String apellido, int edad, String estrategia){
        super(nombre, apellido, edad);
        this.estrategia= estrategia;
    }
    public String getEstrategia(){
        return  estrategia;
    }
    @Override
    public  String toString(){
        return "Entrenador: " + super.toString() + "\nEstrategia= " + estrategia;
    }
    @Override
    public void entrenamiento(){
        System.out.println("Entrena a los futbolistas");
    }
    @Override
    public  void partidoDeFutbol(){
        System.out.println("Está pendiente del rendimiento de los futbolistas y les da indicaciones a lo largo del partido");
    }
    public  void planificarEntrenamiento(){
        System.out.println("Planifica el entrenamiento");
    }

}
