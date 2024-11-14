import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LecturaFicheros {

    public List<Reserva> readReservaFile(String path){
        List<Reserva> reservasList = new ArrayList<>();
        Reserva reserva;
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

    public void writeFileReserva(String path){
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

    private void writeObject(String path, List<Reserva> reservas) throws IOException {
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(path));
        for(int i = 0; i < reservas.size(); i++){
            ous.writeObject(reservas.get(i));
        }
        ous.close();
    }

    private void addReservas(File file, List<Reserva> reservasList) throws IOException, ClassNotFoundException {
        Reserva reserva;
        if(file.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            while((reserva = (Reserva) ois.readObject()) != null){
                reservasList.add(reserva);
            }
            ois.close();
        }
    }

    private List<Reserva> createObjectsReserva(){
        Reserva reserva1 = new Reserva(1, "361a", 1, 2);
        Reserva reserva2 = new Reserva(2, "361b", 3, 4);
        Reserva reserva3 = new Reserva(3, "361a", 5, 6);

        List<Reserva> reservas = new ArrayList<>();
        reservas.add(reserva1);
        reservas.add(reserva2);
        reservas.add(reserva3);

        return reservas;
    }
}
