public class Proceso3 extends Thread{
    
    private String letra;
    
    public Proceso3(String letra){
        this.letra = letra;
    }

    public void run(){
        try{
            for(int i =0; i <5; i++ ){
                System.out.println(letra);
                Thread.sleep(1000);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
