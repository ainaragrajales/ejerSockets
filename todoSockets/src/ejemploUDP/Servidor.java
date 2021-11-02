package ejemploUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {

    public static void main(String[] args) throws IOException {

        //En el datagramSocket  del servidor se le pasa el puerto
        DatagramSocket servidor = new DatagramSocket(7000);

        byte[] msg = new byte[1024];

        //DatagramPacket, se le pasa un array de bytes en el que se recoge el mensaje y la longitud máxima.
        DatagramPacket recibir = new DatagramPacket(msg, 1024);
        servidor.receive(recibir);

    }

}
