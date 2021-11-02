package ejer5TCP_Object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;

public class Servidor {

    public static void main(String[] args) {

        try {
            ServerSocket servidor = new ServerSocket(5000);

            Objeto nuevoObjeto = new Objeto();
            System.out.println("Esperando al cliente.......");
            servidor.accept();

            ObjectOutputStream outObjeto = new ObjectOutputStream(servidor);
            nuevoObjeto.setNum1(5);
            nuevoObjeto.setNum2(7);
            outObjeto.writeObject(nuevoObjeto);
            System.out.println("Enviando: " + nuevoObjeto.getNum1() + " ; " + nuevoObjeto.getNum2());

            ObjectInputStream inputObjeto = new ObjectInputStream(servidor);
            nuevoObjeto = (Objeto) inputObjeto.readObject();
            System.out.println("Recibiendo resultado: " + nuevoObjeto.getMultiplicacion());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
