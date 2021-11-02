package ejer1conHilos;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class HiloServidor extends Thread{
    //Ejemplo con hilos
    Socket cliente;
    private int contador;

    public HiloServidor(Socket cliente, int contador) {
        this.cliente = cliente;
        this.contador = contador;
    }

    @Override
    public void run() {

        System.out.println("le llega al hilo el valor " + contador);
        OutputStream aux = null;
        try {
            aux = cliente.getOutputStream();
            DataOutputStream datos = new DataOutputStream(aux);
            datos.writeUTF(" --> Hola cliente " + contador);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
