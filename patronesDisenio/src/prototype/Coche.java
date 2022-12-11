package prototype;

public class Coche implements  Cloneable{

    public String marca;
    public int puertas;

    public Coche clonar() throws CloneNotSupportedException {

        return (Coche) this.clone();
    }

    public String toString(){
        return "Marcha: " + this.marca + " puertas: " + this.puertas;
    }
}
