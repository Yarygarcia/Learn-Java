public class Main {
    public static void main(String[] args) {
        Empleado empleado = FuncionEmpleado.llamarEmpleado("Gerente");
//        Empleado empleado1 = FuncionEmpleado.llamarEmpleado("Repositor");
//        Empleado empleado2 = FuncionEmpleado.llamarEmpleado("Supervisor");
//        Empleado empleado3 = FuncionEmpleado.llamarEmpleado("Gerente");
        //System.out.println(empleado.toString());
        empleado.funcion();
        System.out.println(empleado.saldo());

    }
}
