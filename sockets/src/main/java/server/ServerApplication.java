package server;

import common.CONSTANTS;

public class ServerApplication {
    public static void main(String[] args) {
        new Thread(new IncomingSocketConnectionHandler(CONSTANTS.PORT)).start();
    }
}
