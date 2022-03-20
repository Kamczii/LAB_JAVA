package client;

import java.util.Scanner;

public class ClientApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        boolean loop = true;
        while (loop) {
            System.out.print("Podaj liczbę wiadomości do wysłania: ");
            String line = scanner.nextLine();
            if(line.equals("exit")) {
                loop = false;
                System.out.println("KONIEC");
            } else {
                System.out.println(client.createRequest(Integer.parseInt(line)));
            }
        }
    }
}
