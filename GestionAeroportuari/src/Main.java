import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    //             -------------------Empresas patrocinadoras ------------
    static String empresasPatrocinadoras[] = {"Ecopetrol", "Claro", "Mercado Libre", "Santo Domingo"};
    static String empresasPatrocinadoras2[] = {"Isagen", "Aardila Lule", "Emp"};


    //------------Aeropuertos-------------
    final static int numAeropuerto = 4;
    static Aeropuerto aeropuerto[] = new Aeropuerto[numAeropuerto];
    static Aeropuerto aeropuertoPublico1 = new AeropuertoPublico("Jose Maria Cordoba", "Rionegro - Antioquia", "Colombia", 100050200);
    static Aeropuerto aeropuertoPublico2 = new AeropuertoPublico("El Dorado", "CD Bogota", "Colombia", 210800000);
    static Aeropuerto aeropuertoPrivado1 = new AeropuertoPrivado("Olaya Herrera", "Medellín - Antioquia", "Colombia");

    static Aeropuerto aeropuertoPrivado2 = new AeropuertoPrivado("Rafael Nuñez", "Cartagena - Bolivar", "Colombia");

    //---------Compañias / Aerolineas ------------
    static Company company1 = new Company("Avianca");
    static Company company2 = new Company("Viva Colombia");
    static Company company3 = new Company("Latam");
    static Company company4 = new Company("American Airlines");

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion;
        char salir;
        do {
            do {
                System.out.println("      -----Menú ----");
                System.out.println("1.Ver Aeropuertos \n2.Aeropuerto privado o Aeropuerto publico\n3.Ver las aerolineas de un aeropuerto\4. Vuelos de una arolinea y aeroppuerto determinado");
                opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        insertarAeropuertos(aeropuerto);
                        break;
                    case 2:
                        publicoPrivado("El Dorado");
                        break;
                    case 3:
                        aerolineas("Olaya Herrera");
                        break;
                    case 4:
                        aerolineasVuelos("El Dorado", "Avianca");
                        break;
                    case 5:
                        break;
                }
                System.out.println("Dedeas digitar otra opción (S/N)");
                salir = entrada.next().charAt(0);
            }

            while (opcion < 1 && opcion > 6);
        }
        while (salir == 's' || salir == 'S');

    }

    public static void insertarAeropuertos(Aeropuerto aeropuerto[]) {
        aeropuerto[0] = aeropuertoPublico1;
        aeropuertoPublico1.insertarCompany(company1);
        aeropuertoPublico1.insertarCompany(company2);
        aeropuertoPublico1.insertarCompany(company4);
        aeropuerto[1] = aeropuertoPublico2;
        aeropuertoPublico2.insertarCompany(company2);
        aeropuertoPublico2.insertarCompany(company3);
        aeropuertoPublico2.insertarCompany(company4);
        aeropuerto[2] = aeropuertoPrivado1;
        ((AeropuertoPrivado) aeropuertoPrivado1).insertarEmpresas(empresasPatrocinadoras);
        aeropuertoPrivado1.insertarCompany(company1);
        aeropuertoPrivado1.insertarCompany(company2);
        aeropuertoPrivado1.insertarCompany(company3);
        aeropuertoPrivado1.insertarCompany(company4);
        aeropuerto[3] = aeropuertoPrivado2;
        ((AeropuertoPrivado) aeropuertoPrivado2).insertarEmpresas(empresasPatrocinadoras2);
        aeropuertoPrivado2.insertarCompany(company1);
        aeropuertoPrivado2.insertarCompany(company2);
        aeropuertoPrivado2.insertarCompany(company4);
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

    public static void publicoPrivado(String nombreAeropuerto) {
        for (int i = 0; i < aeropuerto.length; i++) {
            if (aeropuerto[i].getNombre().equals(nombreAeropuerto)) {
                if (aeropuerto[i].getClass().toString().equals("class AeropuertoPublico")) {
                    System.out.println("Subvencion: " + ((AeropuertoPublico) aeropuerto[i]).getDineroNacion());
                } else {
                    System.out.println("Empresas patrocinadoras: " + i++ + ". " + ((AeropuertoPrivado) aeropuerto[i]).getEmpresas());
                }
            } else {
                System.out.println("Aeropuerto no encontrado");
            }
        }
    }

    public static void aerolineas(String nombreAeropuerto) {
        for (int i = 0; i < aeropuerto.length; i++) {
            if (aeropuerto[i].getNombre().equals(nombreAeropuerto)) {
                System.out.println(aeropuerto[i].getListCompanies());
            } else {
                System.out.println("Aeropuerto no encontrado");
            }
        }
    }

    public static void aerolineasVuelos(String nombreAeropuerto, String NombreAerolinea) {
        for (int i = 0; i < aeropuerto.length; i++) {
            for (int e = 0; e < aeropuerto[i].getNumCompany(); i++){
                //if (aeropuerto[i].getNombre().equals(nombreAeropuerto) && )  {

                //}

            }

        }
    }
}
