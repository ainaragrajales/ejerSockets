package ejemploUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Cliente {

    public static void main(String[] args) throws IOException {

        //En el datagramSocket del cliente no se le pasa nada
        DatagramSocket cliente = new DatagramSocket();

        //No se puede mandar el mensaje en String, se puede pasarlo como array mediante mensaje.getBytes()
        String mensaje = "Hola";

        //DatagramPacket para enviar al servidor, cuando se pone el host hay que usar InetAdress y se puede de las dos maneras siguientes
        //DatagramPacket paquete = new DatagramPacket(mensaje.getBytes(), (mensaje.getBytes()).length, InetAddress.getByName("localhost"), 7000);
        DatagramPacket paquete = new DatagramPacket(mensaje.getBytes(), (mensaje.getBytes()).length, InetAddress.getLocalHost(), 7000);

        cliente.send(paquete);

    }

}
