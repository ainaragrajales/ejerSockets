package ejer2conHilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Hilo extends Thread{

    Socket cliente;

    public Hilo(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {

        try {
            String cadena = "";
            PrintWriter fsalida = new PrintWriter(cliente.getOutputStream());

            BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            System.out.println("Servidor conectado");
            while ((cadena=fentrada.readLine())!=null){

                fsalida.println(cadena.toUpperCase());
                System.out.println("Recibiendo: \t " + cadena);
            }

            fentrada.close();
            fsalida.close();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
