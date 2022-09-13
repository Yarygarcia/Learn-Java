import org.w3c.dom.ls.LSOutput;

public class Doctor extends  Persona{
    private String titulacion;
    private  int experiencia;
    public Doctor(String nombre, String apellido, int edad, String titulacion, int experiencia) {
        super(nombre, apellido, edad);
        this.titulacion = titulacion;
        this.experiencia = experiencia;
    }
    public String getTitulacion(){
        return titulacion;
    }
    public  int getExperiencia(){
        return  experiencia;
    }
    @Override
    public  String toString(){
        return "Doctor" + super.toString() + "\nTitulación= " + titulacion + " experiencia= " + experiencia;
    }
    @Override
    public  void entrenamiento(){
        System.out.println("Supervisa el bienestar de los futbolistas");
    }
    @Override
    public  void partidoDeFutbol(){
        System.out.println("Supervisa el bienestar de los futbolistas");
    }

    public void curaLesion(){
        System.out.println("Cura la lesiones de los futbolistas");
    }
}
