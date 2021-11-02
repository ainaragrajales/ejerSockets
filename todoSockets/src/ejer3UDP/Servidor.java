package ejer3UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

public class Servidor {

    public static void main(String[] args) {

        try {

            //En el datagramSocket  del servidor se le pasa el puerto
            DatagramSocket servidor = new DatagramSocket(7000);
            System.out.println("Servidor conectado");
            byte[] msg = new byte[1024];
            byte[] msgEnviado = new byte[1024];
            DatagramPacket paquete;


           while (true){

               //DatagramPacket, se le pasa un array de bytes en el que se recoge el mensaje y la longitud máxima. El maximo posible es 65535
               DatagramPacket recibir = new DatagramPacket(msg, 1024);
               servidor.receive(recibir);
               String mensaje = new String(recibir.getData());
               System.out.println("Ha llegado una petición \n " + mensaje);
               System.out.println("Procedencia de: " +recibir.getAddress());
               System.out.println("En el puerto: " + recibir.getPort());
               System.out.println("Sirviendo la petición");

               if (mensaje.trim().equalsIgnoreCase("hora")){
                   String message = "HORA DEL SERVIDOR: " + new Date();
                   msgEnviado = message.getBytes();
                   paquete = new DatagramPacket(msgEnviado, msgEnviado.length, recibir.getAddress(), recibir.getPort());

                   servidor.send(paquete);

               } else {
                   String texto = "Mensaje vacío";
                   msgEnviado = texto.getBytes();
                   paquete = new DatagramPacket(msgEnviado, msgEnviado.length, recibir.getAddress(), recibir.getPort());

                   servidor.send(paquete);
               }

           }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
