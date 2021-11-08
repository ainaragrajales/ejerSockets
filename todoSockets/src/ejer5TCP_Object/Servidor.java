package ejer5TCP_Object;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {

        try {
            ServerSocket servidor = new ServerSocket(5000);


            System.out.println("Esperando al cliente.......");
            Socket socket = servidor.accept();

            //Flujo de salida para objetos
            ObjectOutputStream outObjeto = new ObjectOutputStream(socket.getOutputStream());

            //Recoger los datos por pantalla
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduce el primer numero:");
            int n1 = Integer.parseInt(in.readLine());
            System.out.println("Segundo numero:");
            int n2 = Integer.parseInt(in.readLine());

            //Crear el objeto con los parámetros
            Objeto nuevoObjeto = new Objeto(n1, n2, 0);
            //Enviar el objeto
            outObjeto.writeObject(nuevoObjeto);
            System.out.println("Enviando: " + nuevoObjeto.getNum1() + " ; " + nuevoObjeto.getNum2());

            //Flujo de entrada para objetos
            ObjectInputStream inputObjeto = new ObjectInputStream(socket.getInputStream());
            //Recibido el objeto modificado
            nuevoObjeto = (Objeto) inputObjeto.readObject();
            //Se muestra el resultado
            System.out.println("Recibiendo resultado: " + nuevoObjeto.getMultiplicacion());

            outObjeto.close();
            inputObjeto.close();
            socket.close();
            servidor.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
