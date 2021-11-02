package ejer2conHilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket servidor = new ServerSocket(6500);
        Socket cliente;

        while (true) {

            cliente = servidor.accept();
            Hilo hilo = new Hilo(cliente);
            hilo.start();

        }

    }

}
