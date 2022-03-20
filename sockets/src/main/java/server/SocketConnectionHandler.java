package server;

import common.CONSTANTS;
import common.Message;

import java.io.*;
import java.net.Socket;

/**
 * handler dla pojedynczego żądania w danym protokole
 */
public class SocketConnectionHandler implements Runnable {

    Socket socket;

    public SocketConnectionHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {

           objectOutputStream.writeObject(CONSTANTS.READY);

           int n = (Integer) objectInputStream.readObject();

           objectOutputStream.writeObject(CONSTANTS.READY_FOR_MESSAGES);

           for(int i=0;i<n;i++) {
               Message message = (Message) objectInputStream.readObject();
               System.out.println(message);
           }

            objectOutputStream.writeObject(CONSTANTS.FINISHED);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(!socket.isClosed()) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
