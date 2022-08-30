public class Main {
    public static void main( String[] args){
        int num=10;
        int num1 =0, num2 =1, num3;
        for(int i =0; i < num; i++){
            num3=num1;
            num1 = num2;
            num2 = num1 + num3;
            System.out.println(num1);
        }

    }
}
