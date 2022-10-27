import java.util.ArrayList;
import java.util.List;

public class Main {
        static List<Alumno> listaAlumnos = new ArrayList<>();
    public static void main(String[] args) {
        listaAlumnos.add(new Alumno(0, 1036402808, "Christian Raul", "Ramirez Escalante", 16,new Curso("Microservicos",2.7)));
        listaAlumnos.add(new Alumno(1, 71111456, "Cesar Oswaldo", "Alzate Agudelo",20, new Curso("Sistemas", 3.7)));
        listaAlumnos.add(new Alumno(2, 43456183, "Gabriel", "santana Martinez", 19, new Curso(".Net",3 )));
        listaAlumnos.add(new Alumno(3, 541735235, "Ana Maria", "Hernandez Lopez", 24, new Curso("Rust", 4.8)));
        listaAlumnos.add(new Alumno(4, 42571523, "Martin", "Perez Casas", 20, new Curso("Kotlin", 4.5)));
        listaAlumnos.add(new Alumno(5,612372, "Elizabeth Maria", "Cardona QUintero", 21, new Curso("Pascal", 5)));
        listaAlumnos.add(new Alumno(6, 16747242, "Laura Maria", "Rojas Perez", 17, new Curso("Java", 4.3)));
        listaAlumnos.add(new Alumno(7, 18273824, "Lorena", "Hoyos Carbajal", 10, new Curso("Python", 5)));
        listarAlimnos();
        nombreLG();
        numAlumnos();
        alumnoMenor();
        alumnoMayor();
        primerAlumno();
        lenguajeTermineT();
        materiaConA();
        longitudCuarentaCaracteres();
        allumnosAprobador();
    }
    public static void listarAlimnos(){
        System.out.println("------------ Listar todos los alumnos -------------");
        listaAlumnos.forEach(alumno -> System.out.println(alumno.toString()));
    }

    public static void nombreLG(){
        System.out.println("------------ Nombre que inicie con al letra G o L");

        listaAlumnos.stream().filter(n -> n.getNombres().charAt(0) == 'L' || n.getNombres().charAt(0) == 'G').forEach(System.out::println);
    }
    public static void numAlumnos(){
        System.out.println(" --------------- Cantidad de alumnos -------------");
        System.out.println(listaAlumnos.size());
    }
    public static  void alumnoMenor(){
        System.out.println("------------- Alumno menor -----------");
        System.out.println(listaAlumnos.stream().min((n1, n2) -> n1.getEdad() - n2.getEdad()));
    }
    public static void alumnoMayor(){
        System.out.println("----------------Alumno mayor------------");
        System.out.println(listaAlumnos.stream().max((n1,n2)-> n1.getEdad() - n2.getEdad()));
    }
    public static void primerAlumno(){
        System.out.println(" ----------- Primer alumno ----------");
        System.out.println(listaAlumnos.stream().findFirst());
    }
    public static void lenguajeTermineT(){
        System.out.println("----------Materia terminada en 'T' -----------");
        listaAlumnos.stream().filter(n -> n.getInfoCurso().getNombreCurso().endsWith("t")).forEach(System.out::println);
    }
    public static void materiaConA(){
        System.out.println("--------------- Materias que contienen la 'A' ---------");
        listaAlumnos.stream().filter(n-> n.getInfoCurso().getNombreCurso().contains("a")).forEach(n -> System.out.println(n));
    }
    public static void longitudCuarentaCaracteres(){
        System.out.println("------Nombre mayores o iguales a 30 caracteres");
        listaAlumnos.stream().filter(n -> n.getNombres().length() + n.getApellidos().length() > 30).forEach(System.out::println);
    }
    public static void allumnosAprobador(){
        listaAlumnos.stream().filter(n -> n.getInfoCurso().getNota() > 3).forEach(System.out::println);
    }
}
