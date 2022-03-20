import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ThreadManager {
    static final String SOURCE_PATH = "test-1-watki.txt";
    static final String DESTINATION_PATH = "wynik.txt";

    Thread[] threads;

    File source = new File(SOURCE_PATH);

    TaskResource taskResource = new TaskResource();
    SavingResource savingResource = new SavingResource(DESTINATION_PATH);


    public ThreadManager(int number) {
        this.threads = new Thread[number];
    }

    void startNewThreads() {

        for(int i=0;i<threads.length;i++)
            threads[i] = new Thread(new CalculationThread(taskResource, savingResource));

        Arrays.stream(threads).forEach(t -> t.start());

        readStartingInputFromFiles();

        takeUserInput();

        stopThreads();
    }

    void readStartingInputFromFiles() {
        try(Scanner scanner = new Scanner(source)) {
            while(scanner.hasNextLong()) {
                Long longNumber = scanner.nextLong();
                taskResource.put(longNumber);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie odczytano pliku");
            return;
        }
    }

    void takeUserInput(){
        try (Scanner input = new Scanner(System.in)) {
            while(true){
                System.out.print("Dodaj liczbę na tablicę ogłoszeń: ");
                String line = input.nextLine();
                System.out.println();

                if (line.equals("exit"))
                    break;
                else
                    taskResource.put(Long.parseLong(line));
            }
        }
    }

    void stopThreads() {
        for(int i=0;i<threads.length;i++)
            threads[i].interrupt();
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
