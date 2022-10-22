import java.io.*;

public class Archivo {

    /*public static void main(String[] args)  {
            File archivo = new File("C:\\Users\\Administrador\\IdeaProjects\\fichero\\prueba.txt");
        try{
            FileWriter escribir = new FileWriter(archivo);
            escribir.write("Today is Saturday");
            escribir.close();
            System.out.println("Mensaje añadido con exito");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }*/
    public static void main(String[] args){
        File archivo = new File ("C:\\\\Users\\\\Administrador\\\\IdeaProjects\\\\fichero\\\\prueba.txt");
        String contenido;
        try{
            FileReader lector = new FileReader(archivo);
            BufferedReader lectura = new BufferedReader(lector);
            contenido = lectura.readLine();
            while(contenido != null){

                System.out.println(contenido);
                contenido = lectura.readLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
