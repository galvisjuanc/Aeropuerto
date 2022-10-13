import java.util.Scanner;

/** Diseñar y codificar una aplicación informática para una compañía de gestión aeroportuaria, satisfaciendo los siguientes requisitos:

 * Para cada aeropuerto, es necesario saber:
 ** Todas las compañías de vuelos que operan en él.
 ** Nombre del aeropuerto, la ciudad donde se ubica y el país al que pertenece.

 * Cada compañía se caracteriza por el nombre y la lista de vuelos que ofrece.

 * Los vuelos están definidos por su identificador, la ciudad de origen, la ciudad de destino, el precio del viaje, la lista de pasajeros,
 el número máximo de pasajeros permitidos en el vuelo y el número real de pasajeros que ha reservado asiento en el avión.

 * Los aeropuertos pueden ser privados o públicos.
 ** Los aeropuertos privados tienen una serie de empresas que los patrocinan y es necesario saber el nombre de cada una de esas empresas.
 ** Para los aeropuertos públicos, se requiere saber la cantidad de dinero correspondiente a la subvención gubernamental.

 * Se necesita gestionar también la información de los pasajeros.
 ** Para cada pasajero, se necesita saber nombre, número de pasaporte y nacionalidad.

 La aplicación tendrá un menú con las siguientes opciones:

 1. Consultar los aeropuertos gestionados, indicando separadamente los aeropuertos públicos y los privados. Para cada uno de ellos, deberá
 mostrar su nombre, la ciudad de ubicación y el país al que pertenece.
 2. Visualizar las empresas que patrocinan un determinado aeropuerto en caso que sea privado, o la cuantía de la subvención en caso de que
 se trate de un aeropuerto público.
 3. Para un determinado aeropuerto, se debe poder mostrar la lista de compañías que vuelan desde ese aeropuerto.
 4. Para una determinada compañía que opera en un aeropuerto concreto, listar todos los posibles vuelos que dicha compañía ofrece, mostrando
 su identificador, la ciudad origen y destino y el precio del vuelo.
 5. Mostrar todos los posibles vuelos (identificador) que parten de una ciudad origen a otra ciudad destino (indicadas por el usuario) y
 mostrar su precio.
 * */

public class Principal {
    static Scanner entrada = new Scanner(System.in);
    final static int num = 4;           // # aeropuertos
    static Aeropuerto aeropuertos [] = new Aeropuerto[num];

    public static void main(String[] args) {
        //insertar datos de aeropuertos
        insertarDatosAeropuertos(aeropuertos);
        menu();
    }

    public static void insertarDatosAeropuertos(Aeropuerto aero[]){
        aero[0] = new AeropuertoPublico(80000000, "Jorge Chavez", "Lima", "Perú");
        aero[0].insertarCompañia(new Compañia("AeroPerú"));
        aero[0].insertarCompañia(new Compañia("Avianca"));
        aero[0].getCompañia("AeroPerú").insertarVuelo(new Vuelo("IB20", "Lima", "México", 150.90, 150));
        aero[0].getCompañia("AeroPerú").insertarVuelo(new Vuelo("IB21", "Lima", "Buenos Aires", 180.90, 120));
        aero[0].getCompañia("Avianca").insertarVuelo(new Vuelo("FC12", "Ayacucho", "Londres", 500.90, 200));
        aero[0].getCompañia("Avianca").insertarVuelo(new Vuelo("FC13", "Ayacucho", "Santiago de Chile", 200.50, 180));
        aero[0].getCompañia("AeroPerú").getVuelo("IB20").insertarPasajero(new Pasajero("María José Galvis Cuéllar", "P1026149", "Coreana"));
        aero[0].getCompañia("AeroPerú").getVuelo("IB20").insertarPasajero(new Pasajero("María Fernanda Galvis Cuéllar", "P1040148", "Colombiana"));
        aero[0].getCompañia("Avianca").getVuelo("FC12").insertarPasajero(new Pasajero("Huberty Galvis", "P79349", "Colombiana"));
        aero[0].getCompañia("Avianca").getVuelo("FC12").insertarPasajero(new Pasajero("María del Carmen Cuéllar", "P51693", "Argentina"));
        aero[0].getCompañia("AeroPerú").getVuelo("IB21").insertarPasajero(new Pasajero("Douglas Rodriguez Cuéllar", "P10101033", "Sudafricano"));
        aero[0].getCompañia("AeroPerú").getVuelo("IB21").insertarPasajero(new Pasajero("Dicken Barrera Cuéllar", "P666666", "Indonés"));
        aero[0].getCompañia("Avianca").getVuelo("FC13").insertarPasajero(new Pasajero("Wilson Palacios", "P234123", "Brasilero"));
        aero[0].getCompañia("Avianca").getVuelo("FC13").insertarPasajero(new Pasajero("Danna Coral", "P1234493", "Venezolana"));

        aero[1] = new AeropuertoPrivado("Central Ciudad Real","Ciudad Real", "España");
        aero[1].insertarCompañia(new Compañia("AirEuropa"));
        String empresasAP[] =  {"AWS", "Mercadolibre", "HelloWorld"};
        ((AeropuertoPrivado)aero[1]).insertarEmpresas(empresasAP);
        aero[1].getCompañia("AirEuropa").insertarVuelo(new Vuelo("AE025", "Madrid", "Asunción", 450, 200));
        aero[1].getCompañia("AirEuropa").getVuelo("AE025").insertarPasajero(new Pasajero("Johanna Gutierrez", "P6666666", "Francesa"));

        aero[2] = new AeropuertoPublico(20000000, "El Dorado", "Bogotá", "Colombia");
        aero[2].insertarCompañia(new Compañia("VivaColombia"));
        aero[2].insertarCompañia(new Compañia("Satena"));
        aero[2].getCompañia("Satena").insertarVuelo(new Vuelo("AB44", "Bogotá", "San José de Costarica", 300.55, 210));
        aero[2].getCompañia("Satena").insertarVuelo(new Vuelo("AB45", "Bogotá", "Rio de Janeiro", 430.10, 144));
        aero[2].getCompañia("Satena").getVuelo("AB45").insertarPasajero(new Pasajero("Mileidy Martin", "T4312432", "Española"));
        aero[2].getCompañia("Satena").getVuelo("AB45").insertarPasajero(new Pasajero("Catalina Rojas", "T142346", "Alemana"));

        aero[3] = new AeropuertoPublico(50000000, "Mexicolibre", "México", "México");
        aero[3].insertarCompañia(new Compañia("AeroMéxico"));
        aero[3].getCompañia("AeroMéxico").insertarVuelo(new Vuelo("CD55", "Mexico", "Japon", 670, 300));
        aero[3].getCompañia("AeroMéxico").insertarVuelo(new Vuelo("CD56", "Mexico", "Seoul", 990, 350));
        aero[3].getCompañia("AeroMéxico").getVuelo("CD55").insertarPasajero(new Pasajero("Joel Vargas", "T1234", "Bélga"));
        aero[3].getCompañia("AeroMéxico").getVuelo("CD56").insertarPasajero(new Pasajero("Jackie Linares", "T98765", "Chino"));
    }

    public static void menu(){
        int opcion;
        do{
            System.out.println("\t\t.: MENU:.");
            System.out.println("1: Ver Aeropuertos Gestionados(Públicos o Privados)");
            System.out.println("2. Ver empresas(Privado o subvención (Público)");
            System.out.println("3. Listas compañías de un aeropuerto");
            System.out.println("4. Lista de vuelos por compañía");
            System.out.println("5. Listar posibles vuelos de origen a destino");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("");
                    mostrarDatosAeropuertos(aeropuertos);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6: break;
                default:
                    System.out.println("Se equivocó de selección. Intentelo de nuevo");
                    break;
            }
        }
        while (opcion != 6);
    }

    public static void mostrarDatosAeropuertos(Aeropuerto aeropuertos[]){
        for(int i = 0; i < aeropuertos.length; i++){
            if(aeropuertos[i] instanceof AeropuertoPrivado){
                System.out.println("Aeropuerto Privado");
                System.out.println("Nombre: "+aeropuertos[i].getNombre());
                System.out.println("Ciudad: "+aeropuertos[i].getCiudad());
                System.out.println("Pais: "+aeropuertos[i].getPais());
            }
            else{
                System.out.println("Aeropuerto Público");
                System.out.println("Nombre: "+aeropuertos[i].getNombre());
                System.out.println("Ciudad: "+aeropuertos[i].getCiudad());
                System.out.println("Pais: "+aeropuertos[i].getPais());
            }
            System.out.println("");
        }
    }
}
