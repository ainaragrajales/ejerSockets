package ejer5TCP_Object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {

        try {

            Socket cliente = new Socket("localhost", 5000);

            Objeto object = new Objeto();

            ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());

            ObjectInputStream inputObjeto = new ObjectInputStream(cliente.getInputStream());

            object = (Objeto) inputObjeto.readObject();
            object.setMultiplicacion(object.getNum1()* object.getNum2());

            outObjeto.writeObject(object);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
