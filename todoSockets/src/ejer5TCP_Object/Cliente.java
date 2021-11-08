package ejer5TCP_Object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {

        try {

            //Cliente que se conecta al servidor
            Socket cliente = new Socket("localhost", 5000);

            Objeto object = new Objeto();

            //Flujo de salida para objetos, primero se declara este, da igual si no se usa luego el primero
            ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
            //Flujo de entrada para objetos
            ObjectInputStream inputObjeto = new ObjectInputStream(cliente.getInputStream());

            //Recoger el objeto
            object = (Objeto) inputObjeto.readObject();
            System.out.println("Recibo: "+ object.getNum1() + " y " + object.getNum2());

            //Rellenar el resultado
            object.setMultiplicacion(object.getNum1()* object.getNum2());
            //enviar el objeto con el resultado
            outObjeto.writeObject(object);

            outObjeto.close();
            inputObjeto.close();
            cliente.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
