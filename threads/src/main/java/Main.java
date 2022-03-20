import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //sekcja krytyczna - fragment kodu, w którym korzysta się z zasobu nie obsługującego dostępu
    //przez wiele wątków na raz
    //runnable - porcja pracy do wykonania
    //thread - zarządzanie wątkiem
    //main - glowny watek
    //jedna sekcja krytyczna obejmuje wszystkie metody synchronized
    //isInterrupted zeruje flagę
    public static void main(String[] args) {

        int numberOfThreads = Integer.parseInt(args[0]);

        ThreadManager manager = new ThreadManager(numberOfThreads);
        manager.startNewThreads();

    }
}
