public class Main {
    public static void main(String[] args) {
        Proceso proceso1 = new Proceso("G");
        Proceso2 proceso2 = new Proceso2("E");
        Proceso3 proceso3 = new Proceso3("K");

        proceso1.start();
        try{
            proceso1.sleep(10);
        }catch (Exception e){
            System.out.println(e);
        }
        proceso2.start();
        try{
            proceso2.sleep(10);
        }catch (Exception e){
            System.out.println(e);
        }
        proceso3.start();
        try{
            proceso3.sleep(10);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}