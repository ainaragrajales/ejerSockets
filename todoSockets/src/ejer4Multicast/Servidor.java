package ejer4Multicast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Servidor {

    public static void main(String[] args) {

        try {

            MulticastSocket servidor = new MulticastSocket();


            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String cadena = "";
            DatagramPacket dgp;

            while (!cadena.trim().equals("*")) {

                System.out.println("Datos a enviar al grupo: ");
                cadena = in.readLine();

                dgp = new DatagramPacket(cadena.getBytes(), (cadena.getBytes()).length, InetAddress.getByName("230.0.0.1"), 5557);

                servidor.send(dgp);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
