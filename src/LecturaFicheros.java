import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que lee y escribe en ficheros serializados
 * @author cristian
 * @version 1.0
 */
public class LecturaFicheros {

    /**
     * Metodo que devuelve una lista de reservas
     * @param path el path del archivo
     * @return la lista de reservas
     */
    public List<Reserva> readReservaFile(String path){
        /*
            Explicacion:
            1. creamos una lista
            2. creamos un fichero en base a un path
            3. preguntamos si existe
            4. añadimos valores a la lista
            5. capturamos excepciones
         */
        List<Reserva> reservasList = new ArrayList<>();
        File file = new File(path);

        try{
            addReservas(file, reservasList);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el fichero");
        } catch (IOException e) {
            System.out.println("Ups, error al leer el fichero");
        } catch (ClassNotFoundException e) {
            System.out.println("Ups, clase no encontrada");
        }
        return reservasList;
    }

    /**
     * Metodo que escribe en un fichero serializado
     * @param path el path del fichero
     */
    public void writeFileReserva(String path){
        /*
          Explicacion:
          1. creamos un fichero
          2. creamos una lista de reservas
          3. preguntamos si el fichero existe
          4. escribimos los objetos
          5. capturamos excepciones
         */
        File file = new File(path);
        List<Reserva> reservas = createObjectsReserva();
        try{
            if(file.exists()){
                writeObject(path, reservas);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ups, fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Ups, error a la hora de leer el fichero");
        }
    }

    /**
     * Metodo que escribe en un fichero serializado
     * @param path el path del fichero
     * @param reservas la lista de reservas
     * @throws IOException lanzamos una excepcion por si falla la lectura
     */
    private void writeObject(String path, List<Reserva> reservas) throws IOException {
        /*
          Explicacion:
          1. Creamos un objeto ObjectOutputStream para escribir
          2. recorremos una lista de objetos
          3. escribimos los objetos mientras el bucle no para
          4. cerramos el objeto ObjectOutputStream
         */
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(path));
        for (Reserva reserva : reservas) {
            ous.writeObject(reserva);
        }
        ous.close();
    }

    /**
     * Metodo que lee en un fichero serializado
     * @param file el fichero
     * @param reservasList la lista de reservas
     * @throws IOException lanzamos una excepcion por si falla la lectura
     */
    private void addReservas(File file, List<Reserva> reservasList) throws IOException, ClassNotFoundException {
        /*
          Explicacion:
          1. Creamos un objeto ObjectInputStream para leer
          2. mientras el objeto no sea null, leemos
          3. añadimos objetos a la lista
          4. cerramos el objeto ObjectOutputStream
         */
        Reserva reserva;
        if(file.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            while((reserva = (Reserva) ois.readObject()) != null){
                reservasList.add(reserva);
            }
            ois.close();
        }
    }

    /**
     * Metodo que crea objetos y los añade a una lista de objetos
     * @return la lista de objetos
     */
    private List<Reserva> createObjectsReserva(){
        Reserva reserva1 = new Reserva(1, "361a", 1, 2);
        Reserva reserva2 = new Reserva(2, "362b", 3, 4);
        Reserva reserva3 = new Reserva(3, "361a", 5, 6);

        List<Reserva> reservas = new ArrayList<>();
        reservas.add(reserva1);
        reservas.add(reserva2);
        reservas.add(reserva3);

        return reservas;
    }
}
