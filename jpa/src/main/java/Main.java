import repositories.MageRepository;
import repositories.TowerRepository;
import services.InitService;
import services.MageService;
import services.TowerService;
import views.MagesView;
import views.SIGN;
import views.TowersView;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mags");

        MageService magsService = new MageService(new MageRepository(entityManagerFactory));
        TowerService towerService = new TowerService(new TowerRepository(entityManagerFactory));
        InitService initService = new InitService(magsService, towerService);
        initService.init();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("Komenda: ");
            switch (scanner.nextLine()) {
                case "towers":
                    new TowersView(towerService).display();
                    break;
                case "mages":
                    new MagesView(magsService, towerService).display();
                    break;
            }
        }

        entityManagerFactory.close();
    }
}
