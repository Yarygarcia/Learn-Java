import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    //   -------------------Empresas patrocinadoras ------------
    static String empresasPatrocinadoras[] = {"Ecopetrol", "Claro", "Mercado Libre", "Santo Domingo"};
    static String empresasPatrocinadoras2[] = {"Isagen", "Aardila Lule", "Emp"};


    //------------Aeropuertos-------------
    final static int numAeropuerto = 4;
    static Aeropuerto aeropuerto[] = new Aeropuerto[numAeropuerto];


    //---------Compañias / Aerolineas ------------
    static Company company1 = new Company("Avianca");
    static Company company2 = new Company("Viva Colombia");
    static Company company3 = new Company("Latam");
    static Company company4 = new Company("American Airlines");

    static Company companies[] = {company1,company2,company3,company4};

    public static void main(String[] args) {
        insertarAeropuertos(aeropuerto);
        menu();
    }

    public static void menu() {
        int opcion;
        char salir;
        do {
            do {
                System.out.println("      -----Menú ----");
                System.out.println("1.Ver Aeropuertos \n2.Aeropuerto privado o Aeropuerto publico\n3.Ver las aerolineas de un aeropuerto\4. Vuelos de una arolinea y aeroppuerto determinado\n5. Vuelos segun ciudad de origen y de destino\n6. Salir");
                opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        consultarAeropuertos(aeropuerto);
                        break;
                    case 2:
                        publicoPrivado("Olaya Herrera");
                        break;
                    case 3:
                        //aerolineas("Olaya Herrera");
                        break;
                    case 4:
                        //aerolineasVuelos("El Dorado", "Avianca");
                        break;
                    case 5:
                        //verVuelos("Rionegro", "Atlanta");
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                        break;
                }
                System.out.println("Desea digitar otra opción (S/N)");
                salir = entrada.next().charAt(0);
            }

            while (salir == 's' || salir == 'S');
        }
        while (opcion < 1 && opcion  > 6 );

    }
    public static void insertarAeropuertos(Aeropuerto aeropuerto[]) {
        //---- Aeropuerto 0---
        aeropuerto[0] = new AeropuertoPublico("Jose Maria Cordoba", "Rionegro - Antioquia", "Colombia", 100050200);
        aeropuerto[0].insertarCompany(new Company("Avianca"));
        aeropuerto[0].insertarCompany(new Company("Latam"));
        aeropuerto[0].insertarCompany(new Company("American Airlines"));
        aeropuerto[0].traerComapy("Avianca").insertarVuelo(new Vuelo(003, "Rionegro", "Atlanta", 120000, 67));
        aeropuerto[0].traerComapy("Avianca").insertarVuelo(new Vuelo(002, "Rionegro", "Sidny", 1700000, 70));
        aeropuerto[0].traerComapy("Latam").insertarVuelo(new Vuelo(021, "Rionegro", "Bogota", 120000, 72));
        aeropuerto[0].traerComapy("Latam").insertarVuelo(new Vuelo(023, "Rionegro", "Atlanta", 120000, 67));
        aeropuerto[0].traerComapy("American Airlines").insertarVuelo(new Vuelo(031, "Rionegro", "Tokio", 2350000, 68));
        aeropuerto[0].traerComapy("American Airlines").insertarVuelo(new Vuelo(013, "Rionegro", "Atlanta", 120000, 67));
        aeropuerto[0].traerComapy("American Airlines").insertarVuelo(new Vuelo(020, "Rionegro", "Bogota", 120000, 72));


        //---- Aeropuerto 1---
        aeropuerto[1] = new AeropuertoPublico("El Dorado", "CD Bogota", "Colombia", 210800000);
        aeropuerto[1].insertarCompany(new Company("Viva Colombia"));
        aeropuerto[1].insertarCompany(new Company("Latam"));
        aeropuerto[1].insertarCompany(new Company("American Airlines"));
        aeropuerto[1].traerComapy("Viva Colombia").insertarVuelo(new Vuelo(103, "Bogotá", "Madrid", 400000, 70));
        aeropuerto[1].traerComapy("Viva Colombia").insertarVuelo(new Vuelo(130,"Bogotá", "Seúl", 3000000, 70));
        aeropuerto[1].traerComapy("Viva Colombia").insertarVuelo(new Vuelo(107, "Bogotá", "Miami", 1000000, 78));
        aeropuerto[1].traerComapy("Viva Colombia").insertarVuelo(new Vuelo(121, "Bogotá", "Londres", 1800000, 66));
        aeropuerto[1].traerComapy("Latam").insertarVuelo(new Vuelo(109, "Bogotá", "Medellín", 80000, 80));
        aeropuerto[1].traerComapy("Latam").insertarVuelo(new Vuelo(133, "Bogotá", "Madrid", 400000, 70));
        aeropuerto[1].traerComapy("Latam").insertarVuelo(new Vuelo(117, "Bogotá", "Miami", 1000000, 78));
        aeropuerto[1].traerComapy("Latam").insertarVuelo(new Vuelo(160, "Bogotá", "Paris", 2200000, 60));
        aeropuerto[1].traerComapy("Latam").insertarVuelo(new Vuelo(119, "Bogotá", "Medellín", 80000, 80));
        aeropuerto[1].traerComapy("American Airlines").insertarVuelo(new Vuelo(124, "Bogotá", "Londres", 1800000, 66));
        aeropuerto[1].traerComapy("American Airlines").insertarVuelo(new Vuelo(161, "Bogotá", "Paris", 2200000, 60));

        //---- Aeropuerto 2---
        aeropuerto[2] = new AeropuertoPrivado("Olaya Herrera", "Medellín - Antioquia", "Colombia");
        ((AeropuertoPrivado) aeropuerto[2]).insertarEmpresas(empresasPatrocinadoras);
        aeropuerto[2].insertarCompany(new Company("Avianca"));
        aeropuerto[2].insertarCompany(new Company("Viva Colombia"));
        aeropuerto[2].insertarCompany(new Company("Latam"));
        aeropuerto[2].insertarCompany(new Company("American Airlines"));
        aeropuerto[2].traerComapy("Avianca").insertarVuelo(new Vuelo(202, "Medellín", "Cali", 95000, 70));
        aeropuerto[2].traerComapy("Avianca").insertarVuelo(new Vuelo(270, "Medellín", "Cartagena", 120000, 55));
        aeropuerto[2].traerComapy("Avianca").insertarVuelo(new Vuelo(284, "Medellín", "Barranquilla", 120000, 60));
        aeropuerto[2].traerComapy("Avianca").insertarVuelo(new Vuelo(251, "Medellín", "Choco", 70000, 60));
        aeropuerto[2].traerComapy("Viva Colombia").insertarVuelo(new Vuelo(281, "Medellín", "Barranquilla", 120000, 60));
        aeropuerto[2].traerComapy("Viva Colombia").insertarVuelo(new Vuelo(274, "Medellín", "Cartagena", 120000, 55));
        aeropuerto[2].traerComapy("Latam").insertarVuelo(new Vuelo(250, "Medellín", "Choco", 70000, 60));
        aeropuerto[2].traerComapy("Latam").insertarVuelo(new Vuelo(222, "Medellín", "Cali", 95000, 70));
        aeropuerto[2].traerComapy("Latam").insertarVuelo(new Vuelo(271, "Medellín", "Cartagena", 120000, 55));
        aeropuerto[2].traerComapy("American Airlines").insertarVuelo(new Vuelo(212, "Medellín", "Cali", 95000, 70));
        aeropuerto[2].traerComapy("American Airlines").insertarVuelo(new Vuelo(280, "Medellín", "Barranquilla", 120000, 60));
        aeropuerto[2].traerComapy("American Airlines").insertarVuelo(new Vuelo(251, "Medellín", "Choco", 70000, 60));

        //---- Aeropuerto 3---
        aeropuerto[3] = new AeropuertoPrivado("Rafael Nuñez", "Cartagena - Bolivar", "Colombia");
        ((AeropuertoPrivado) aeropuerto[3]).insertarEmpresas(empresasPatrocinadoras2);
        aeropuerto[3].insertarCompany(new Company("Avianca"));
        aeropuerto[3].insertarCompany(new Company("Viva Colombia"));
        aeropuerto[3].insertarCompany(new Company("American Airlines"));
        aeropuerto[3].traerComapy("Avianca").insertarVuelo(new Vuelo(301, "Cartagena", "SanAndres", 170000, 68));
        aeropuerto[3].traerComapy("Avianca").insertarVuelo(new Vuelo(361, "Cartagena", "Rionegro", 80000, 70));
        aeropuerto[3].traerComapy("Avianca").insertarVuelo(new Vuelo(360, "Cartagena", "Boston", 1900000, 70));
        aeropuerto[3].traerComapy("Viva Colombia").insertarVuelo(new Vuelo(311, "Cartagena", "SanAndres", 170000, 68));
        aeropuerto[3].traerComapy("Viva Colombia").insertarVuelo(new Vuelo(363, "Cartagena", "Rionegro", 80000, 70));
        aeropuerto[3].traerComapy("Viva Colombia").insertarVuelo(new Vuelo(3001, "Cartagena", "Bogotá", 110000, 76));
        aeropuerto[3].traerComapy("American Airlines").insertarVuelo(new Vuelo(301, "Cartagena", "SanAndres", 170000, 68));
        aeropuerto[3].traerComapy("American Airlines").insertarVuelo(new Vuelo(369, "Cartagena", "Rionegro", 80000, 70));
        aeropuerto[3].traerComapy("American Airlines").insertarVuelo(new Vuelo(3004, "Cartagena", "Bogotá", 110000, 76));
        aeropuerto[3].traerComapy("American Airlines").insertarVuelo(new Vuelo(365, "Cartagena", "Boston", 1900000, 70));

    }

    public static void consultarAeropuertos(Aeropuerto aeropuertos[]){
        for (int i = 0; i < aeropuertos.length; i++) {
            //aeropuertos[i].getClass().toString().equals("class AeropuertoPublico")
            if (aeropuertos[i] instanceof AeropuertoPublico) {
                System.out.println("       ----Aeropuerto publicos-----");
                System.out.println("Nombre: " + aeropuertos[i].getNombre() + " Ciudad/Departamento: " + aeropuertos[i].getCiudad() + " Pais: " + aeropuertos[i].getPais());
                System.out.println();
            } else {
                System.out.println("       ----Aeropuertos privados-----");
                System.out.println("Nombre: " + aeropuertos[i].getNombre() + " Ciudad/Departamento: " + aeropuertos[i].getCiudad() + " Pais: " + aeropuertos[i].getPais());
                System.out.println();
            }
        }
    }

    public static void publicoPrivado(String nombreAeropuerto) {
        for (int i = 0; i < aeropuerto.length; i++) {
            if (aeropuerto[i].getNombre() == nombreAeropuerto) {
                if (aeropuerto[i].getClass().toString().equals("class AeropuertoPublico")) {
                    System.out.println("Subvencion: " + ((AeropuertoPublico) aeropuerto[i]).getDineroNacion());
                } else {
                    System.out.println("Empresas patrocinadoras: " + i++ + ". " + ((AeropuertoPrivado) aeropuerto[i]).getEmpresas());
                }
            }
            /*else {
                System.out.println("Aeropuerto no encontrado");
            }*/
        }
    }

    /*public static void aerolineas(String nombreAeropuerto) {
        for (int i = 0; i < aeropuerto.length; i++) {
            if (aeropuerto[i].getNombre().equals(nombreAeropuerto)) {
                System.out.println(aeropuerto[i].getListCompanies());
            } else {
                System.out.println("Aeropuerto no encontrado");
            }
        }
    }*/

    /*public static void aerolineasVuelos(String nombreAeropuerto, String NombreAerolinea) {
        for (int i = 0; i < aeropuerto.length; i++) {
            for (int e = 0; e < aeropuerto[i].getNumCompany(); i++){
                if (aeropuerto[i].getNombre().equals(nombreAeropuerto) && aeropuerto[i].traerComapy(NombreAerolinea).equals(NombreAerolinea)){
                    aeropuerto[i].traerComapy(NombreAerolinea).listarVuelos();
                }
                else{
                    System.out.println("No exsite aerolinea y/o aeropuerto");
                }
            }
        }
    }*/

    /*public static void verVuelos(String ciudadOrigen, String ciudadDestino){
        for(int i =0; i < vuelos.length; i++){
            if(vuelos[i].getCiudadOrigen() == ciudadOrigen && vuelos[i].getCiudadDestino() == ciudadDestino){
                aeropuerto[i].traerComapy(companies[i].toString()).obtenerVuelo(ciudadOrigen, ciudadDestino);
            }
            else{
                System.out.println("No existe vuelos con los parametros\nCiudad Origen" + ciudadDestino + " Ciudad destino: " + ciudadDestino);
            }
        }
    }*/
}
