import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner entrada = new Scanner(System.in);
        int num1;
        int num2;
        int mcm =0;
        int num3=0;
        System.out.print("ingrese un nùmero: ");
        num1 = entrada.nextInt();
        System.out.print("Ingrese un segundo nùmero: ");
        num2 = entrada.nextInt();
        if(num1 > num2){
            num3 = num1;
        }
        else{
            num3 = num2;
        }
        Mcm obj = new Mcm(num1, num2);
        while(true){
            if(num3 %num1 ==0 && num3 % num2 ==0 ){
                mcm = num3;
                System.out.print(obj.McmNum(mcm));
                break;
            }
            num3++;
        }

    }
}
