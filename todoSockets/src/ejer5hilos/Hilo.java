package ejer5hilos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class Hilo extends Thread{

    Socket cliente;

    public Hilo(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {

        try {

            Random r = new Random();
            int n1 = r.nextInt();
            System.out.println("Primer digito: " + n1);
            int n2 = r.nextInt();
            System.out.println("Segundo digito " + n2);

            Objeto nuevoObjeto = new Objeto(n1, n2, 0);
            //Flujo de salida para objetos
            ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
            outObjeto.writeObject(nuevoObjeto);
            System.out.println("Enviando: " + nuevoObjeto.getNum1() + " ; " + nuevoObjeto.getNum2());
            //Flujo de entrada para objetos
            ObjectInputStream inputObjeto = new ObjectInputStream(cliente.getInputStream());
            //Recibido el objeto modificado
            nuevoObjeto = (Objeto) inputObjeto.readObject();
            //Se muestra el resultado
            System.out.println("Recibiendo resultado: " + nuevoObjeto.getMultiplicacion());

            outObjeto.close();
            inputObjeto.close();
            cliente.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
