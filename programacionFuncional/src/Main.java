import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    
    //Imprimir una List con programaciòn tradicional y con programaciòn funcional(Lambda)
    public static void main(String[]args){

        System.out.println("Tradicional");
        for(Integer numeros : Arrays.asList(1,2,3,4)){
            System.out.println(numeros);
        }

        System.out.println("Funcional");

        Arrays.asList(1,2,3,4).forEach(n -> System.out.println(n));


    }

}
