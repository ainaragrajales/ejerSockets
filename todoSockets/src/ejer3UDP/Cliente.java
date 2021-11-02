package ejer3UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

    public static void main(String[] args) throws IOException {

        //En el datagramSocket del cliente no se le pasa nada
        DatagramSocket cliente = new DatagramSocket();

        byte[] mensaje = new byte[1024];
        InetAddress IPServidor = InetAddress.getLocalHost();
        InetAddress IPServidorAddress = InetAddress.getByName("localhost");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cadena;

        System.out.println("Introduce cadena");
        cadena = in.readLine();
        mensaje = cadena.getBytes();


        //DatagramPacket para enviar al servidor, cuando se pone el host hay que usar InetAddress y se puede de las dos maneras siguientes
        //DatagramPacket paquete = new DatagramPacket(mensaje, mensaje.length, IPServidorAddress, 7000);
        DatagramPacket paquete = new DatagramPacket(mensaje, mensaje.length, IPServidor, 7000);

        //Se envia el paquete
        cliente.send(paquete);

        byte[] msg = new byte[1024];
        DatagramPacket recibir = new DatagramPacket(msg, 1024);
        cliente.receive(recibir);
        String mensajeRecibido = new String(recibir.getData());

        System.out.println("RECIBIDO: " + mensajeRecibido);

    }

}
