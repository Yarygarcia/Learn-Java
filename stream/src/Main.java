import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[]args){
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
        cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
        cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
        cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
        cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300 ));

        System.out.println("Libros que superan el promedio de duracion");

        double promedio = cursos.stream().mapToDouble(e -> e.getDuracion()).average().orElse(0);

        cursos.stream().filter( e-> e.getDuracion() > promedio).forEach(System.out::println);

        System.out.println("Duración de los cursos que tienen menos de 500 alumnos");

        cursos.stream().filter(e -> e.getAlumnos() < 500).forEach(e -> System.out.println(e.getDuracion()));

        System.out.println("Curso con mayor duración");

        double mayorDuracion = cursos.stream().mapToDouble(e -> e.getDuracion()).max().getAsDouble();
        System.out.println(mayorDuracion);

        System.out.println("Lista String con todos los nombres de los cursos");

        List<String> a = cursos.stream().map(e -> e.getTitulo()).toList();
        System.out.println(a);

        System.out.println("Sacar el cubo de los elementos de la lista");

        List<Integer> num = List.of(1,2,3,4,5);

        num.stream().map(e -> Math.pow(e,3)).forEach(System.out::println);

        Function<Integer, Integer> aMayuscula = x ->  x+6;
        System.out.println(aMayuscula.apply(5));

        System.out.println(sumaRecursividad(5));
        System.out.println(sumaFuncional(4));

    }
    public static int sumaRecursividad(int num){
        if (num ==1){
            return 1;
        }
        return num + sumaRecursividad(num -1);
    }

    public static int sumaFuncional(int num){
        return IntStream.rangeClosed(1,num).reduce( 1 , (num1, num2) ->num1 * num2);
    }

}
