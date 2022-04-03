package views;

import entities.Brewery;
import services.BreweryService;

import java.util.Scanner;


public class BreweryView extends View{

    private final BreweryService breweryService;

    public BreweryView(BreweryService breweryService) {
        this.breweryService = breweryService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wyświetl: ");
        System.out.println("a) wszystkie browary o wartości");
        System.out.println("b) konkretny browar");
        String option = scanner.nextLine();

        if(option.equalsIgnoreCase("a")) {
            System.out.println("Podaj wartość: ");
            int height = scanner.nextInt();
            SIGN sign = getSign(scanner);
            System.out.println(breweryService.findAllByValue(height, sign));
        } else if (option.equalsIgnoreCase("b")) {
            System.out.println("Podaj nazwę browaru: ");
            String name = scanner.nextLine();
            Brewery brewery = breweryService.findById(name);
            System.out.println(brewery);
        }

    }
}
