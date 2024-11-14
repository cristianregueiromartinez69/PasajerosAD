import java.util.List;

public class Main {
    public static void main(String[] args) {

        LecturaFicheros lef = new LecturaFicheros();

        String path = "/home/accesodatos/Escritorio/compartidaAD/ejemploExamenAD/reservas";

        lef.writeFileReserva(path);
        List<Reserva> reservaList = lef.readReservaFile(path);

        for(Reserva reserva : reservaList) {
            System.out.println(reserva);
        }
    }
}