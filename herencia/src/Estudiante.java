public class Estudiante extends Persona {
    int id;
    float notaFinal;
    public Estudiante(String nombre, String apellido, int edad, int id, float notaFinal){
        super(nombre, apellido,edad);
        this.id = id;
        this.notaFinal = notaFinal;
    }
    public void mostrarInfo(){
        System.out.println("Estudiante: \n id: " + id + "\nNombre: " + getnombre() + " " + getApellido() + " edad " + getEdad() + "\nNota final: " + notaFinal);

    }

}
