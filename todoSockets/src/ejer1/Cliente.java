package ejer1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Cliente {

    //primero hay que poner en marcha el servidor y luego el cliente
    public static void main(String[] args) {

        try {
            //hay que crear un socket con la ip(en este caso localhost) y el puerto
            Socket cliente = new Socket("localhost", 6500);

            //leer el flujo de entrada que lo ha enviado el servidor
            DataInputStream leer = new DataInputStream(cliente.getInputStream());
            System.out.println(leer.readUTF());


            //Cerrar las conexiones
            leer.close();
        } catch (IOException e) {
            System.out.println("\n*** Connection refused ***");
        }


    }

}
