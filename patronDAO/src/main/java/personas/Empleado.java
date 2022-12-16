package personas;

public class Empleado {

    private  String nombre;
    private String cargo;
    private int id;
    public Empleado(String nombre, String cargo){
        this.nombre = nombre;
        this.cargo = cargo;
    }
    public Empleado (int id){
        this.id = id;
    }

    public Empleado(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public  String getCargo(){return  cargo;}
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}