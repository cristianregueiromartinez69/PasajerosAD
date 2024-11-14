import java.util.List;

public class Main {
    public static void main(String[] args) {

        LecturaFicheros lef = new LecturaFicheros();
        Crud crud = new Crud();
        String path = "reservas";

        lef.writeFileReserva(path);
        List<Reserva> reservaList = lef.readReservaFile(path);
        crud.auxUpdateReservas(reservaList);

    }
}