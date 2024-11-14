import java.util.ArrayList;
import java.util.List;

public class Metodos {

    public List<Integer> sumaViajesList(List<Reserva> reservaList, Crud crud){
        List<Integer> listaViajes = new ArrayList<>();
        for(int i = 0; i < reservaList.size(); i++){
            listaViajes.add(crud.getPreciosIdaOrigen(reservaList.get(i).getIdvooida()));
            listaViajes.add(crud.getPreciosIdaOrigen(reservaList.get(i).getIdvoovolta()));
        }
        return listaViajes;
    }

    public List<String> getNombresViajes(List<Reserva> reservaList, Crud crud){
        List<String> listaNombresViajes = new ArrayList<>();
        for(int i = 0; i < reservaList.size(); i++){
            listaNombresViajes.add(crud.getNombreFromDB(reservaList.get(i).getDni()));
        }
        return listaNombresViajes;
    }

}
