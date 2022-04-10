package views;

import entities.Beer;
import entities.Brewery;
import services.BeerService;
import services.BreweryService;

import java.util.Scanner;

public class BeerView extends View{
    private final BeerService beerService;
    private final BreweryService breweryService;

    public BeerView(BeerService beerService, BreweryService breweryService) {
        this.beerService = beerService;
        this.breweryService = breweryService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("a)Pobierz piwa z danego browaru");
        System.out.println("b)Pobierz wszystkie piwa z ceną");
        System.out.println("c)Dodaj piwo");
        System.out.println("d)Usuń piwo");
        System.out.println("e)Pobierz wszystkie piwa");
        String option = scanner.nextLine();

        if (option.equalsIgnoreCase("a")) {
            System.out.println("Podaj nazwę browaru: ");
            String towerName = scanner.nextLine();
            System.out.println("Podaj cenę piwa: ");
            int lvl = scanner.nextInt();
            SIGN sign = getSign(scanner);
            Brewery tower = breweryService.findById(towerName);
            System.out.println(beerService.findAllByTowerAndLvl(tower,lvl, sign));
        } else if (option.equalsIgnoreCase("b")) {
            SIGN sign = getSign(scanner);
            System.out.println("Podaj cenę: ");
            int lvl = scanner.nextInt();
            System.out.println(beerService.findAllByLvl(lvl, sign));
        } else if (option.equalsIgnoreCase("c")) {
            System.out.println("Podaj nazwę: ");
            String name = scanner.nextLine();

            System.out.println("Podaj nazwę browaru: ");
            String towerN = scanner.nextLine();
            System.out.println("Podaj cenę: ");
            int level = scanner.nextInt();
            System.out.println("Dodawanie");
            Brewery tower = breweryService.findById(towerN);
            beerService.create(name,level, tower);
        } else if (option.equalsIgnoreCase("d")) {
            System.out.println("Podaj nazwę piwa do usunięcia: ");
            String name = scanner.nextLine();
            Beer mage = beerService.findById(name);
            beerService.delete(mage);
        } else if(option.equalsIgnoreCase("e")) {
            System.out.println(beerService.findAll());
        }

    }
}
