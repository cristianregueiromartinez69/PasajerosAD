import java.util.ArrayList;
import java.util.List;
/**
 * Clase que contiene métodos para realizar operaciones con listas de objetos de tipo Reserva y
 * realizar operaciones
 * @author cristian
 * @version 1.0
 */
public class Metodos {

    /**
     * Calcula la suma de los precios de ida y vuelta para cada reserva en la lista proporcionada.
     *
     * @param reservaList la lista de objetos Reserva.
     * @param crud el objeto Crud que se usa para obtener los precios de los vuelos.
     * @return una lista de enteros que representa la suma de los precios de ida y vuelta de cada reserva.
     */
    public List<Integer> sumaViajesList(List<Reserva> reservaList, Crud crud){
        List<Integer> sumaViajes = new ArrayList<>();

        for (Reserva reserva : reservaList) {
           int ida = crud.getPreciosIdaOrigen(reserva.getIdvooida());
            int vuelta = crud.getPreciosIdaOrigen(reserva.getIdvoovolta());
            sumaViajes.add(ida + vuelta);
        }
        return sumaViajes;
    }

    /**
     * Obtiene los nombres de los pasajeros correspondientes a cada reserva en la lista proporcionada.
     *
     * @param reservaList la lista de objetos Reserva.
     * @param crud el objeto Crud que se usa para obtener los nombres de los pasajeros desde la base de datos.
     * @return una lista de cadenas que contiene los nombres de los pasajeros.
     */
    public List<String> getNombresViajes(List<Reserva> reservaList, Crud crud){
        List<String> listaNombresViajes = new ArrayList<>();
        for (Reserva reserva : reservaList) {
            listaNombresViajes.add(crud.getNombreFromDB(reserva.getDni()));
        }
        return listaNombresViajes;
    }

    /**
     * Inserta los valores de las reservas en la base de datos utilizando los datos de la lista de reservas,
     * la lista de sumas de precios y la lista de nombres.
     *
     * @param reservaList la lista de objetos Reserva.
     * @param sumasViajes la lista de enteros que representa la suma de los precios de ida y vuelta de cada reserva.
     * @param nombresList la lista de cadenas que contiene los nombres de los pasajeros.
     * @param crud el objeto Crud que se usa para insertar los valores en la base de datos.
     */
    public void insertarValores(List<Reserva> reservaList, List<Integer> sumasViajes, List<String> nombresList, Crud crud){
        for(int i = 0; i < reservaList.size(); i++){
            crud.insertValuesInReservasFeitas(reservaList.get(i).getCodr(),
                    reservaList.get(i).getDni(), nombresList.get(i), sumasViajes.get(i));
        }
    }

}
