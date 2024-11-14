import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Crud {

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    public void updateReservasPasajeros(String dni){
        String consulta = "update pasaxeiros set nreservas = nreservas + 1  where dni = ?";

        try{
            conn = EstablecerConexion.conectar();
            pst = conn.prepareStatement(consulta);

            pst.setString(1, dni);

            if(pst.executeUpdate() > 0){
                System.out.println("Actualizacion hecha con exito");
            }
        } catch (SQLException e) {
            System.out.println("Ups, no se pudo actualizar la tabla");
        }
    }

    public void auxUpdateReservas(List<Reserva> reservasList){
        for(Reserva reserva : reservasList){
            updateReservasPasajeros(reserva.getDni());
        }
    }
}
