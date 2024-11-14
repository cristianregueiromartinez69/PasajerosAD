import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Clase con las operaciones crud a la base de datos
 * @author cristian
 * @version 1.0
 */
public class Crud {

    /**
     * variables para establecer la conexion
     */
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    /**
     * Metodo para actualizar las reservas de pasajeros
     * @param dni el dni del pasajero
     */
    public void updateReservasPasajeros(String dni){
        /*
          Explicacion:
          1. Preparamos la consulta
          2. establecemos la conexion
          3. metemos el parámetro del dni
          4. se actualiza la tabla
         */
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

    /**
     * Metodo auxiliar para actualizar las reservas de pasajeros
     * @param reservasList la lista de reservas
     */
    public void auxUpdateReservas(List<Reserva> reservasList){
        //con un bucle, recorremos las reservas e introducimos el dni
        for(Reserva reserva : reservasList){
            updateReservasPasajeros(reserva.getDni());
        }
    }
    /**
     * Obtiene el precio de ida de un vuelo a partir de su ID.
     *
     * @param id el identificador del vuelo.
     * @return el precio del vuelo si se encuentra, o 0 si no se pudo obtener o no existe.
     */
    public int getPreciosIdaOrigen(int id){
        String consulta = "select prezo from voos where voo = ?";
        try{
            conn = EstablecerConexion.conectar();
            pst = conn.prepareStatement(consulta);

            pst.setInt(1, id);

            rs = pst.executeQuery();

            while(rs.next()){
                return rs.getInt("prezo");
            }
        } catch (SQLException e) {
            System.out.println("Ups, no se pudo obtener el precio");
        }
        return 0;
    }
    /**
     * Obtiene el nombre de un pasajero de la base de datos a partir de su DNI.
     *
     * @param dni el DNI del pasajero.
     * @return el nombre del pasajero si se encuentra, o null si no se pudo obtener o no existe.
     */
    public String getNombreFromDB(String dni){
        String consulta = "select nome from pasaxeiros where dni = ?";

        try{
            conn = EstablecerConexion.conectar();
            pst = conn.prepareStatement(consulta);

            pst.setString(1, dni);

            rs = pst.executeQuery();

            while(rs.next()){
                return rs.getString("nome");
            }
        } catch (SQLException e) {
            System.out.println("Ups, no se pudo obtener el nombre");
        }
        return null;
    }
    /**
     * Inserta valores en la tabla de reservas realizadas.
     *
     * @param codr el código de la reserva.
     * @param dni el DNI del pasajero.
     * @param nombre el nombre del pasajero.
     * @param sumaViaje el costo total del viaje.
     */
    public void insertValuesInReservasFeitas(int codr, String dni, String nombre, int sumaViaje){
        String consulta = "insert into reservasfeitas values(?,?,?,?)";

        try{
            conn = EstablecerConexion.conectar();
            pst = conn.prepareStatement(consulta);

                pst.setInt(1, codr);
                pst.setString(2, dni);
                pst.setString(3, nombre);
                pst.setInt(4, sumaViaje);

            if(pst.executeUpdate() > 0){
                System.out.println("Inserccion hecha con exito");
            }
        } catch (SQLException e) {
            System.out.println("Ups, hubo un error a la hora de insertar valores");
        }
    }
}
