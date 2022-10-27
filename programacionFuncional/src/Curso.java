public class Curso {

    private String nombreCurso;
    private double nota;

    public Curso(String nombreCurso, double nota){
        this.nombreCurso = nombreCurso;
        this.nota = nota;
    }

    public Curso() {
    }

    public Curso(Alumno n) {
    }

    public String getNombreCurso(){
        return nombreCurso;
    }
    public  double getNota(){
        return nota;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombreCurso='" + nombreCurso + '\'' +
                ", nota=" + nota +
                '}';
    }
}
