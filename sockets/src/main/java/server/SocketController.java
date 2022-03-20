package server;

/**
 * Wymagania stawiane wobec rest controllera
 */
public interface SocketController {

    String prepareResponse();

    boolean accepts(String uri);

}
