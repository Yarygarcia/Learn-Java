public class Main {

    public static void main(String[]args){

        CocheCRUDImpl coche = new CocheCRUDImpl();
        coche.save(coche);
        coche.findAll();
        coche.delete(coche);
    }
}
