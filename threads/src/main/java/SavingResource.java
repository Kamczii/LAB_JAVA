import java.io.*;

public class SavingResource {
    String destination;

    public SavingResource(String destination) {
        this.destination = destination;
        try {
            new FileWriter(destination).close();
        } catch (IOException e) {
            System.out.println("Błąd pliku!");
        }
    }

    public synchronized void save(String value){
        try(FileWriter writer = new FileWriter(destination, true)){
            writer.write(value);
        } catch (IOException e) {
            System.out.println("Błąd pliku!");
        }
    }
}
