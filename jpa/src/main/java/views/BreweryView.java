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
        System.out.println("c) usuń browar");
        System.out.println("d) wszystkie browary");
        System.out.println("e) dodaj browar");

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
        } else if (option.equalsIgnoreCase("c")) {
            System.out.println("Nazwa browaru do usunięcia: ");
            String name = scanner.nextLine();
            Brewery brewery = breweryService.findById(name);
            breweryService.delete(brewery);
        } else if(option.equalsIgnoreCase("d")) {
            System.out.println(breweryService.findAll());
        } else if(option.equalsIgnoreCase("e")) {
            System.out.println("Podaj nazwę browaru: ");
            String breweryName = scanner.nextLine();
            System.out.println("Podaj wartość: ");
            int value = scanner.nextInt();
            System.out.println("Dodawanie");
            breweryService.create(breweryName,value);
        }

    }
}
