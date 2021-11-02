package ejer1conHilos;

import ejer1conHilos.HiloServidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    static int cont = 0;

    public static void main(String[] args) throws IOException {

        ServerSocket servidor = new ServerSocket( 6500);
        Socket cliente;

        while (true) {
            cliente = servidor.accept();
            HiloServidor hServer = new HiloServidor(cliente, cont);
            hServer.start();
            cont++;
        }


    }

}
