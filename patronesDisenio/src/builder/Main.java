package builder;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Gato().setColor("cafe");
        animal1.correr();
    }
}
