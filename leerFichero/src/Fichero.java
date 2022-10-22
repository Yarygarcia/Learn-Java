import java.io.*;

public class Vectores {
    public static void main(String[] args)  {
        try{
            InputStream fichero = new FileInputStream("C:/Users/Administrador/Documents/cartaMotivación - copia.txt");
            BufferedInputStream ficheroBuffer = new BufferedInputStream(fichero);
            try{
                int datos = ficheroBuffer.read();
                while(datos !=-1){
                    System.out.print((char)datos);
                    datos= ficheroBuffer.read();
                }

            }catch (IOException e){
                System.out.println(e.getClass());
            }
        }catch (FileNotFoundException e){
            System.out.println("No encontrado");
        }

    }
}
