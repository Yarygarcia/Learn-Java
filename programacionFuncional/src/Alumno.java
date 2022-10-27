import java.util.stream.Stream;

public class Alumno {
    private int id;
    private int cedula;
    private String nombres;
    private String apellidos;
    private int edad;
    private Curso infoCurso;

    public Alumno(){

    }
    public Alumno(int id, int cedula, String nombres, String apellidos, int edad, Curso infoCurso){
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.infoCurso = infoCurso;
    }


    public int getId(){
        return id;
    }
    public int getCedula(){
        return  cedula;
    }
    public String getNombres(){
        return  nombres;
    }
    public String getApellidos(){
        return apellidos;
    }
    public int getEdad(){
        return  edad;
    }

    public Curso getInfoCurso(){
        return  infoCurso;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", cedula=" + cedula +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", infoCurso=" + infoCurso +
                '}';
    }
}
