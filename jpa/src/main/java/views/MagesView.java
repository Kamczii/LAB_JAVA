package views;

import entities.Tower;
import services.MageService;
import services.TowerService;

import java.util.Scanner;

public class MagesView extends View{
    private final MageService mageService;
    private final TowerService towerService;

    public MagesView(MageService mageService, TowerService towerService) {
        this.mageService = mageService;
        this.towerService = towerService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pobierz");
        System.out.println("a) magów z danej wieży");
        System.out.println("b) wszystkich magów");
        String option = scanner.nextLine();

        if (option.equalsIgnoreCase("a")) {
            System.out.println("Podaj nazwę wieży: ");
            String towerName = scanner.nextLine();
            System.out.println("Podaj poziom magów: ");
            int lvl = scanner.nextInt();
            SIGN sign = getSign(scanner);
            Tower tower = towerService.findById(towerName);
            System.out.println(mageService.findAllByTowerAndLvl(tower,lvl, sign));
        } else if (option.equalsIgnoreCase("b")) {
            SIGN sign = getSign(scanner);
            System.out.println("Podaj poziom: ");
            int lvl = scanner.nextInt();
            System.out.println(mageService.findAllByLvl(lvl, sign));
        }

    }
}
