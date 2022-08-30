public class Vaca extends  Animal{
    public Vaca(String nombre, int patas){
        super(nombre, patas);
    }
    @Override
    public void comer(){
        System.out.println("SOy un " + getNombre() + "Y estoy comiendo en la yerba");
    }
}
