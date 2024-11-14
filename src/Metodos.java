import java.util.ArrayList;
import java.util.List;

public class Metodos {

    public List<Integer> sumaViajesList(List<Reserva> reservaList, Crud crud){
        List<Integer> sumaViajes = new ArrayList<>();
        int ida = 0;
        int vuelta = 0;
        for(int i = 0; i < reservaList.size(); i++){
            ida = crud.getPreciosIdaOrigen(reservaList.get(i).getIdvooida());
            vuelta = crud.getPreciosIdaOrigen(reservaList.get(i).getIdvoovolta());
            sumaViajes.add(ida + vuelta);
        }
        return sumaViajes;
    }

    public List<String> getNombresViajes(List<Reserva> reservaList, Crud crud){
        List<String> listaNombresViajes = new ArrayList<>();
        for(int i = 0; i < reservaList.size(); i++){
            listaNombresViajes.add(crud.getNombreFromDB(reservaList.get(i).getDni()));
        }
        return listaNombresViajes;
    }

    public void insertarValores(List<Reserva> reservaList, List<Integer> sumasViajes, List<String> nombresList, Crud crud){
        for(int i = 0; i < reservaList.size(); i++){
            crud.insertValuesInReservasFeitas(reservaList.get(i).getCodr(),
                    reservaList.get(i).getDni(), nombresList.get(i), sumasViajes.get(i));
        }
    }

}
