package client;

import common.CONSTANTS;
import common.Message;

import java.io.*;
import java.net.*;
import java.util.Random;

public class Client {

    String createRequest(int n){
        try {
            InetAddress address = InetAddress.getLocalHost();
            try (Socket socket = new Socket(address, CONSTANTS.PORT)) {
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {

                    String response = (String)objectInputStream.readObject();
                    if (!response.equals(CONSTANTS.READY)) {
                        return CONSTANTS.ERROR;
                    }

                    objectOutputStream.writeObject(n);

                    response = (String)objectInputStream.readObject();
                    if (!response.equals(CONSTANTS.READY_FOR_MESSAGES)) {
                        return CONSTANTS.ERROR;
                    }

                    Random rand = new Random();
                    int[] tab = new int[10];
                    for(int i=0;i<10;i++){
                        tab[i] = rand.nextInt(n);
                    }
                    objectOutputStream.writeObject(tab);

                    for(int i=0;i<n;i++){
                        objectOutputStream.writeObject(new Message(i+1,"Wiadomość "+(i+1)));
                    }

                    response = (String)objectInputStream.readObject();
                    if (!response.equals(CONSTANTS.FINISHED)) {
                        return CONSTANTS.ERROR;
                    }
                    return response;

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return CONSTANTS.ERROR;
    }
}
