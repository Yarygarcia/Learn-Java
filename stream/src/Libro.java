public class Libro {
    private String nombre;
    private double precio;
    private String autor;

    public Libro(String nombre, double precio, String autor){
        this.nombre = nombre;
        this.precio = precio;
        this.autor = autor;
    }

    public String getNombre(){
        return  nombre;
    }
    public  double getPrecio(){
        return precio;
    }
    public String  getAutor(){
        return autor;
    }
    @Override
    public String toString(){
        return "Libro: " + this.nombre + " autor:  " + this.autor + " precio: " + this.precio;
    }
}
