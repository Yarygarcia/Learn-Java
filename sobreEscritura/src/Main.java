public class Main {
    public static void main (String[]args){
        Animal a = new Animal("Animal", 6);
        Persona p = new Persona("Persona", 2);
        Vaca v = new Vaca("Vaca", 4);
        Perro pe = new Perro("Perro", 4);
        a.comer();
        p.comer();
        v.comer();
        pe.comer();
    }
}
