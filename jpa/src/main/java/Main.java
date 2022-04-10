import repositories.BeerRepository;
import repositories.BreweryRepository;
import services.InitService;
import services.BeerService;
import services.BreweryService;
import views.BeerView;
import views.BreweryView;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mags");

        BeerService magsService = new BeerService(new BeerRepository(entityManagerFactory));
        BreweryService breweryService = new BreweryService(new BreweryRepository(entityManagerFactory));
        InitService initService = new InitService(magsService, breweryService);
        initService.init();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("Piwko czy browar: ");
            switch (scanner.nextLine()) {
                case "browar":
                    new BreweryView(breweryService).display();
                    break;
                case "piwko":
                    new BeerView(magsService, breweryService).display();
                    break;
            }
        }

        entityManagerFactory.close();
    }
}
