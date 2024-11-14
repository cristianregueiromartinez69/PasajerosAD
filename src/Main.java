import java.util.List;

public class Main {
    public static void main(String[] args) {

        LecturaFicheros lef = new LecturaFicheros();
        Crud crud = new Crud();
        Metodos metodos = new Metodos();
        String path = "reservas";

        lef.writeFileReserva(path);
        List<Reserva> reservaList = lef.readReservaFile(path);
        crud.auxUpdateReservas(reservaList);

        List<Integer> sumaViajes = metodos.sumaViajesList(reservaList, crud);

        List<String> getNombres = metodos.getNombresViajes(reservaList, crud);

        metodos.insertarValores(reservaList, sumaViajes, getNombres, crud);
    }
}