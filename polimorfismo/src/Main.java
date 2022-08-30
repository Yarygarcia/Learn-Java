public class Main {
    public static void main(String [] args){
        Vehiculo misVehiculos[] = new Vehiculo[3];
        misVehiculos[0] = new Vehiculo("Ferrari", "AB32", "GGQ");
        misVehiculos[1] = new VehiculoFurgon("Audi", "AdF", "12GD", 500);
        misVehiculos[2] = new VehiculoDeporte("Mazda", "AGQ2", "4RE", 200);

        for(int i =0; i< misVehiculos.length; i++){
            System.out.println(misVehiculos[i].mostrarDatos());
        }
    }
}
