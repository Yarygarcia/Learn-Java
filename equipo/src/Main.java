import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Persona> equipo = new ArrayList<Persona>();
     static int integrante;
     static  char nuevoIntegrante;
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[]args){
        ingresarIntegrantes();
        infoIntegrantes();
    }
    public static void ingresarIntegrantes() {
        do {
            do {
                System.out.println("Ingresar integrante");
                System.out.println("1.Futbolista\n2.Entrenador\n3.Doctor");
                integrante = entrada.nextInt();
                System.out.println("");
                switch (integrante){
                    case 1: ingresarFutbolista();
                        break;
                    case 2: ingresarEntrenador();
                        break;
                    case 3: ingresarDoctor();
                        break;
                }
                System.out.println("Deseas ingresar otro integrante (s/n): ");
                nuevoIntegrante = entrada.next().charAt(0);
            }while (nuevoIntegrante == 's' || nuevoIntegrante== 'S');
        } while (integrante<1 && integrante >3 );
    }

    public static void ingresarFutbolista(){
        if (numFutbolistas <12){
            String nombre, apellido, posicion;
            int edad, dorsal;
            System.out.println("-------Futbolista-------");
            entrada.nextLine();
            System.out.println("Nombre: ");
            nombre = entrada.nextLine();
            System.out.println("Apellido: ");
            apellido = entrada.nextLine();
            System.out.println("Edad: ");
            edad = entrada.nextInt();
            System.out.println("Dorsal: ");
            dorsal = entrada.nextInt();
            while (dorsal >11 || dorsal <0){
                System.out.println("   ¡Dorsal no valido, escribe un número entre el 1 al 11!  ");
                System.out.println("Dorsal: ");
                dorsal = entrada.nextInt();
            }
            System.out.println("Posicion: ");
            posicion = entrada.nextLine();
            Futbolista futbolista = new Futbolista(nombre, apellido, edad, dorsal, posicion);
            equipo.add(futbolista);
        }
        else{
            System.out.println("El equipo de futbolistas está completo");
        }
    }
    public static  void ingresarEntrenador(){
        if(numEntrenador ==0){
            String nombre, apellido, estrategia;
            int edad;
            entrada.nextLine();
            System.out.println("-------Entrenador-------");
            System.out.println("Nombre: ");
            nombre = entrada.nextLine();
            System.out.println("Apellido: ");
            apellido = entrada.nextLine();
            System.out.println("Edad: ");
            edad = entrada.nextInt();
            System.out.println("Estrategia: ");
            estrategia = entrada.nextLine();
            Entrenador entrenador = new Entrenador(nombre, apellido, edad, estrategia);
            equipo.add(entrenador);
        }
        else{
            System.out.println("Ya hay un entrenador, No se aceptan más");
        }
    }
    public static void ingresarDoctor(){
        if(numDoctor == 0){
            String nombre, apellido, titulacion;
            int edad, experiencia;
            System.out.println("-------Doctor-------");
            System.out.println("Nombre: ");
            nombre = entrada.nextLine();
            System.out.println("Apellido: ");
            apellido = entrada.nextLine();
            System.out.println("Edad: ");
            edad = entrada.nextInt();
            System.out.println("Titulación: ");
            titulacion = entrada.nextLine();
            System.out.println("Experiencia: ");
            experiencia = entrada.nextInt();
            Doctor doctor = new Doctor(nombre, apellido, edad, titulacion, experiencia);
            equipo.add(doctor);
        }
        else{
            System.out.println("Ya hay un Doctor, no se reciben más doctores");
        }
    }
    static int numFutbolistas =0, numEntrenador, numDoctor;
    public  static void infoIntegrantes(){
        for(Persona person : equipo){
            if(person.getClass().equals("class  Futbolista")){
                numFutbolistas++;
            }
            else if(person.getClass().equals("class Entrenador")){
                numEntrenador++;
            }
            else if( person.getClass().equals("class Doctor")){
                numDoctor++;
            }
            person.toString();
            person.entrenamiento();
            person.partidoDeFutbol();
            person.viaje();
        }
    }
}
