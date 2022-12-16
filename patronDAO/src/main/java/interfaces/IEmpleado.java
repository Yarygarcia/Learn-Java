package interfaces;

import personas.Empleado;

public interface IEmpleado {

    public void regitrar(Empleado empleado);

    public void listar(Empleado empleado);
    public  void Verificar();

    public void modificar( Empleado empleado, int id);

    public  void buscar(Empleado empleado);

    public  void  eliminar(Empleado empleado, int id);
}
