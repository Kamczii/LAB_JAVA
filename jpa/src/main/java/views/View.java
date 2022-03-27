package views;

import java.util.Scanner;

public abstract class View {

    abstract void display();

    protected SIGN getSign(Scanner scanner) {
        System.out.println("Podaj znak (<,>,=): ");
        SIGN sign;
        switch (scanner.next()) {
            case "<":
                sign = SIGN.LT;
                break;
            case ">":
                sign = SIGN.GT;
                break;
            case "=":
                sign = SIGN.EQ;
                break;
            default:
                System.out.println("Niepoprawny znak, wychodzę!");
                return null;
        }
        return sign;
    }
}
