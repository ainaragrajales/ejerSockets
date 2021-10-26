package ejemplo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    //primero hay que poner en marcha el servidor y luego el cliente

    //va a ser una clase ejecutable, necesita un Main
    public static void main(String[] args) throws IOException {


        //hay que crear un socket con la ip(en este caso localhost) y el puerto
        Socket cliente = new Socket("localhost", 6500);

        //generar un flujo de datos partiendo del socket cliente, es el de salida de datos
        DataOutputStream datos = new DataOutputStream(cliente.getOutputStream());
        //mensaje que se le envía al servidor
        datos.writeUTF("Hola");

        //leer el flujo de entrada que lo ha enviado el servidor
        DataInputStream leer = new DataInputStream(cliente.getInputStream());
        System.out.println(leer.readUTF());

        //cerrar las conexiones
        datos.close();
        leer.close();




    }
}
