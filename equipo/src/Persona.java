public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected int edad;

    public Persona(String nombre, String apellido, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre(){
        return nombre;
    }
    public  String getApellido(){
        return apellido;
    }

    public int getEdad() {
        return edad;
    }
    @Override
    public String toString(){
        return  " Nombre: " + nombre +  " "+ apellido + " edad: " + edad;
    }
    public void viaje(){
        System.out.println("Viaja los futbolistas, el entrenador y el doctor");
    }
    public abstract void entrenamiento();
    public abstract void partidoDeFutbol();
}
