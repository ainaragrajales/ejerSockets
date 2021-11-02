package ejer4Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Cliente {

    public static void main(String[] args) {

        try {

            //hay que lanzar varios clientes, para ello en la configuración run/debug(donde el play arriba a la derecha)
            // hay que añadir lo de run multiple instances en la opcion modify options que está en azul
            MulticastSocket cliente = new MulticastSocket(5557);

            //con el jdk anterior al 17 funciona, sino hay que hacerlo de otra manera ya que sale que está deprecated
            //hay que unirse al grupo multicast del servidor
            cliente.joinGroup(InetAddress.getByName("230.0.0.1"));

            byte[] dato = new byte[1024];
            DatagramPacket recibido;
            String mensaje = "";

            while (!mensaje.trim().equalsIgnoreCase("*")) {

                recibido = new DatagramPacket(dato, dato.length);
                cliente.receive(recibido);
                mensaje = new String(recibido.getData()).trim();
                System.out.println("Mensaje recibido: " + mensaje);

            }
            //al terminar hay que salir del grupo multicast del servidor
            cliente.leaveGroup(InetAddress.getByName("230.0.0.1"));
            cliente.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
