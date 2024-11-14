import java.io.Serializable;

/**
 * Clase que representa una reserva de un vuelo. Implementa la interfaz Serializable
 * para permitir la serialización de los objetos de tipo Reserva.
 *
 * @author cristian
 * @version 1.0
 */
public class Reserva implements Serializable {

    //variables de clase
    private int codr;
    private String dni;
    private int idvooida;
    private int idvoovolta;

    //constructor por defecto
    public Reserva() {

    }

    /**
     * Constructor con parámetros para inicializar un objeto de tipo Reserva.
     *
     * @param codr el código de la reserva.
     * @param dni el DNI del pasajero.
     * @param idvooida el ID del vuelo de ida.
     * @param idvoovolta el ID del vuelo de vuelta.
     */
    public Reserva(int codr, String dni, int idvooida, int idvoovolta) {
        this.codr = codr;
        this.dni = dni;
        this.idvooida = idvooida;
        this.idvoovolta = idvoovolta;
    }

    //getter y setter
    public int getCodr() {
        return codr;
    }

    public void setCodr(int codr) {
        this.codr = codr;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIdvooida() {
        return idvooida;
    }

    public void setIdvooida(int idvooida) {
        this.idvooida = idvooida;
    }

    public int getIdvoovolta() {
        return idvoovolta;
    }

    public void setIdvoovolta(int idvoovolta) {
        this.idvoovolta = idvoovolta;
    }

    @Override
    public String toString() {
        return "Reserva: " + "\ncodr: " + codr + "\ndni: " + dni + "\nidvooida: " + idvooida + "\nidvoovolta: " + idvoovolta;
    }


}

  
 
 
 

