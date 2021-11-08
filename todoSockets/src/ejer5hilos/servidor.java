package ejer5hilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {

    public static void main(String[] args) {

        try {

            ServerSocket servidor = new ServerSocket(6000);
            System.out.println("Esperando al cliente");

            while (true){
                Socket socket = servidor.accept();
                Hilo hilo = new Hilo(socket);
                hilo.start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
