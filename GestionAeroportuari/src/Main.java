import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    //   -------------------Empresas patrocinadoras ------------
    static String empresasPatrocinadoras[] = {"Ecopetrol", "Claro", "Mercado Libre", "Santo Domingo"};
    static String empresasPatrocinadoras2[] = {"Isagen", "Aardila Lule", "Emp"};

    //--------Vuelos------
    static Vuelo vuelo1 = new Vuelo(003, "Rionegro", "Atlanta", 120000, 67);
    static Vuelo vuelo3 = new Vuelo(021, "Rionegro", "Bogota", 120000, 72);
    static Vuelo vuelo4 = new Vuelo(002, "Rionegro", "Sidny", 1700000, 70);
    static Vuelo vuelo5 = new Vuelo(031, "Rionegro", "Tokio", 2350000, 68);

    static Vuelo vuelo2 = new Vuelo(103, "Bogotá", "Madrid", 400000, 70);
    static Vuelo vuelo6 = new Vuelo(130,"Bogotá", "Seúl", 3000000, 70);
    static Vuelo vuelo7 =  new Vuelo(107, "Bogotá", "Miami", 1000000, 78);
    static Vuelo vuelo8 = new Vuelo(121, "Bogotá", "Londres", 1800000, 66);
    static Vuelo vuelo9 = new Vuelo(109, "Bogotá", "Medellín", 80000, 80 );
    static Vuelo vuelo10 = new Vuelo(160, "Bogotá", "Paris", 2200000, 60);

    static Vuelo vuelo11 = new Vuelo(202, "Medellín", "Cali", 95000, 70);
    static Vuelo vuelo12 = new Vuelo(270, "Medellín", "Cartagena", 120000, 55);
    static Vuelo vuelo13 = new Vuelo(284, "Medellín", "Barranquilla", 120000, 60);
    static Vuelo vuelo14 = new Vuelo(251, "Medellín", "Choco", 70000, 60);

    static Vuelo vuelo15 = new Vuelo(301, "Cartagena", "SanAndres", 170000, 68);
    static Vuelo vuelo16 = new Vuelo(361, "Cartagena", "Rionegro", 80000, 70);
    static Vuelo vuelo17 = new Vuelo(3001, "Cartagena", "Bogotá", 110000, 76);
    static Vuelo vuelo18 = new Vuelo(360, "Cartagena", "Boston", 1900000, 70);

    static Vuelo vuelos[] ={vuelo1,vuelo2,vuelo3,vuelo4,vuelo5,vuelo6,vuelo7,vuelo8,vuelo9,vuelo10,vuelo11,vuelo12,vuelo13,vuelo14,vuelo15,vuelo16,vuelo17,vuelo18};
    //------------Aeropuertos-------------
    final static int numAeropuerto = 4;
    static Aeropuerto aeropuerto[] = new Aeropuerto[numAeropuerto];
    static Aeropuerto aeropuertoPublico2 = new AeropuertoPublico("El Dorado", "CD Bogota", "Colombia", 210800000);
    static Aeropuerto aeropuertoPrivado1 = new AeropuertoPrivado("Olaya Herrera", "Medellín - Antioquia", "Colombia");

    static Aeropuerto aeropuertoPrivado2 = new AeropuertoPrivado("Rafael Nuñez", "Cartagena - Bolivar", "Colombia");

    //---------Compañias / Aerolineas ------------
    static Company company1 = new Company("Avianca");
    static Company company2 = new Company("Viva Colombia");
    static Company company3 = new Company("Latam");
    static Company company4 = new Company("American Airlines");

    static Company companies[] = {company1,company2,company3,company4};

    public static void main(String[] args) {
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
                        insertarAeropuertos(aeropuerto);
                        break;
                    case 2:
                        //publicoPrivado("El Dorado");
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
        aeropuerto[0] = new AeropuertoPublico("Jose Maria Cordoba", "Rionegro - Antioquia", "Colombia", 100050200));
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


        aeropuerto[1].insertarCompany(company2);
        aeropuerto[1].insertarCompany(company3);
        aeropuerto[1].insertarCompany(company4);
        //company2.insertarVuelo(vuelo2);
        company2.insertarVuelo(vuelo6);
        //company2.insertarVuelo(vuelo7);
        //company2.insertarVuelo(vuelo8);

       // aeropuerto[1].traerComapy(company2.toString()).insertarVuelo(vuelo2);
        //aeropuerto[1].traerComapy(company2.toString()).insertarVuelo(vuelo6);
        //aeropuerto[1].traerComapy(company2.toString()).insertarVuelo(vuelo7);
        //aeropuerto[1].traerComapy(company2.toString()).insertarVuelo(vuelo8);
        //company3.insertarVuelo(vuelo9);
        company3.insertarVuelo(vuelo2);
        //company3.insertarVuelo(vuelo7);
        //company3.insertarVuelo(vuelo10);
        //company4.insertarVuelo(vuelo9);
       // company4.insertarVuelo(vuelo8);
        //company4.insertarVuelo(vuelo10);
        //aeropuerto[1].traerComapy(company3.toString()).insertarVuelo(vuelo9);
        //aeropuerto[1].traerComapy(company3.toString()).insertarVuelo(vuelo2);
        //aeropuerto[1].traerComapy(company3.toString()).insertarVuelo(vuelo7);
        //aeropuerto[1].traerComapy(company3.toString()).insertarVuelo(vuelo10);
        //aeropuerto[1].traerComapy(company4.toString()).insertarVuelo(vuelo9);
        //aeropuerto[1].traerComapy(company4.toString()).insertarVuelo(vuelo8);
        //aeropuerto[1].traerComapy(company4.toString()).insertarVuelo(vuelo10);
        //---- Aeropuerto 2---
        aeropuerto[2] = aeropuertoPrivado1;
        ((AeropuertoPrivado) aeropuertoPrivado1).insertarEmpresas(empresasPatrocinadoras);
        aeropuerto[2].insertarCompany(company1);
        aeropuerto[2].insertarCompany(company2);
        //aeropuerto[2].insertarCompany(company3);
        aeropuerto[2].insertarCompany(company4);
        //company1.insertarVuelo(vuelo11);
        //company1.insertarVuelo(vuelo12);
        company1.insertarVuelo(vuelo13);
        //company1.insertarVuelo(vuelo14);
        //company2.insertarVuelo(vuelo13);
        //company2.insertarVuelo(vuelo12);
        //company3.insertarVuelo(vuelo14);
        //company3.insertarVuelo(vuelo11);
        company3.insertarVuelo(vuelo12);
        //company4.insertarVuelo(vuelo11);
        //company4.insertarVuelo(vuelo13);
        //company4.insertarVuelo(vuelo14);
        //---- Aeropuerto 3---
        aeropuerto[3] = aeropuertoPrivado2;
        ((AeropuertoPrivado) aeropuertoPrivado2).insertarEmpresas(empresasPatrocinadoras2);
        aeropuerto[3].insertarCompany(company1);
        aeropuerto[3].insertarCompany(company2);
        aeropuerto[3].insertarCompany(company4);
        //company1.insertarVuelo(vuelo15);
        //company1.insertarVuelo(vuelo16);
        company1.insertarVuelo(vuelo18);
        //company2.insertarVuelo(vuelo15);
        company2.insertarVuelo(vuelo16);
        //company2.insertarVuelo(vuelo17);
        //company4.insertarVuelo(vuelo15);
        company4.insertarVuelo(vuelo16);
        //company4.insertarVuelo(vuelo17);
        //company4.insertarVuelo(vuelo18);
        for (int i = 0; i < aeropuerto.length; i++) {
            if (aeropuerto[i].getClass().toString().equals("class AeropuertoPublico")) {
                System.out.println("       ----Aeropuerto publicos-----");
                System.out.println("Nombre: " + aeropuerto[i].getNombre() + " Ciudad/Departamento: " + aeropuerto[i].getCiudad() + " Pais: " + aeropuerto[i].getPais());
                System.out.println();
            } else {
                System.out.println("       ----Aeropuertos privados-----");
                System.out.println("Nombre: " + aeropuerto[i].getNombre() + " Ciudad/Departamento: " + aeropuerto[i].getCiudad() + " Pais: " + aeropuerto[i].getPais());
                System.out.println();
            }
        }
    }

    /*public static void publicoPrivado(String nombreAeropuerto) {
        for (int i = 0; i < aeropuerto.length; i++) {
            if (aeropuerto[i].getNombre() == nombreAeropuerto) {
                if (aeropuerto[i].getClass().toString().equals("class AeropuertoPublico")) {
                    System.out.println("Subvencion: " + ((AeropuertoPublico) aeropuerto[i]).getDineroNacion());
                } else {
                    System.out.println("Empresas patrocinadoras: " + i++ + ". " + ((AeropuertoPrivado) aeropuerto[i]).getEmpresas());
                }
            } else {
                System.out.println("Aeropuerto no encontrado");
            }
        }
    }*/

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
