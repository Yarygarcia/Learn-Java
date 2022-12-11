package builder;

public class Gato implements  Animal{
    private String color;

    public Gato(){

    }

    @Override
    public void correr() {
        System.out.println("El Gato corre");
    }

    @Override
    public void saltar() {
        System.out.println("El Gato salta");
    }

    @Override
    public void dormir() {
        System.out.println("El Gato duerme");
    }
    public Gato ronronear(){
        return this;
    }
    public Gato mauyar(){
        return this;
    }

    public Animal setColor(String color){
        this.color = color;
        return this;
    }
    public String getColor(){
        return this.color;
    }
    public Gato buil(){
        return this;
    }

}
