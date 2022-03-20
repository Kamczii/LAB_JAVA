package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * centralny punkt obsługi zapytań oddelegowujący je do osobnych wątków
 */
public class IncomingSocketConnectionHandler implements Runnable{

    int port;
    ServerSocket serverSocket;

    public IncomingSocketConnectionHandler(int port) {
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(port);
            this.serverSocket.setSoTimeout(1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            try {
                Socket socket = serverSocket.accept();
                new Thread(new SocketConnectionHandler(socket)).start();
            } catch (SocketTimeoutException e) {
                System.out.println(e);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
