import java.util.List;

/**
 * Clase main donde ejecutamos el programa
 * @author cristian
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        //objeto para leer el fichero
        LecturaFicheros lef = new LecturaFicheros();

        //objeto con operaciones crud a la base de datos
        Crud crud = new Crud();

        //objeto con los metodos del programa
        Metodos metodos = new Metodos();

        //path del fichero
        String path = "reservas";

        //escribimos en el fichero
        lef.writeFileReserva(path);

        //hacemos una lista igual al metodo que devuelve una lista despues de leerla
        List<Reserva> reservaList = lef.readReservaFile(path);

        //actualizamos valores
        crud.auxUpdateReservas(reservaList);

        //hacemos una lista igual al metodo que devuelve una lista de sumas de viajes
        List<Integer> sumaViajes = metodos.sumaViajesList(reservaList, crud);

        //hacemos una lista igual a un metodo que devuelve una lista de nombres de viajes
        List<String> getNombres = metodos.getNombresViajes(reservaList, crud);

        //insertamos valores en la base de datos
        metodos.insertarValores(reservaList, sumaViajes, getNombres, crud);
    }
}