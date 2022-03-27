package views;

import repositories.TowerRepository;
import services.TowerService;

import java.util.Scanner;


public class TowersView extends View{

    private final TowerService towerService;

    public TowersView(TowerService towerService) {
        this.towerService = towerService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj wysokość: ");
        int height = scanner.nextInt();
        SIGN sign = getSign(scanner);
        System.out.println(towerService.findAllByHeight(height, sign));
    }
}
