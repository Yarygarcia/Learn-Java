public class Futbolista extends Persona{
    private int dorsal;
    private String posicion;
    public Futbolista(String nombre, String apellido, int edad, int dorsal, String posicion) {
        super(nombre, apellido, edad);
        this.dorsal= dorsal;
        this.posicion = posicion;
    }
    public String getPosicion(){
        return posicion;
    }
    public  int getDorsal(){
        return dorsal;
    }

    @Override
    public String toString() {
        return "Futbolista: " + super.toString() + "\n Dorsal= " + dorsal + ", posicion='" + posicion;
    }
    @Override
    public void entrenamiento(){
        System.out.println("Entrena en la cancha con las indicaciones del entrenador");
    }
    public  void partidoDeFutbol(){
        System.out.println("Juega en la cancha y hacen todo por ganar");
    }
    public void entrevista(){
        System.out.println("Da entrevista y responde las preguntas de los periodistas");
    }
}
