public class FuncionEmpleado {

    public static   Empleado llamarEmpleado(String tipoEmpleado){
        switch (tipoEmpleado){
            case "Cajero":
                return new Cajero();
            case "Repositor":
                return new Repositor();
            case "Supervisor":
                return new Supervisor();
            default:
                System.out.println("No existe dicho empleado");
                return null;
        }
    }

}
