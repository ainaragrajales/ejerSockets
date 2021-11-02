package ejer2conHilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {

        try {
            //hay que crear un socket con la ip(en este caso localhost) y el puerto
            Socket cliente = new Socket("localhost", 6500);

            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter fsalida = new PrintWriter(cliente.getOutputStream());

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String cadena ,echo= "";

            System.out.println("Introduce cadena");
            cadena = in.readLine();

            while (!cadena.equalsIgnoreCase("fin")){
                //recoger lo que envia el servidor
                fsalida.println(cadena);
                echo = br.readLine();
                System.out.println("--> ECHO " + echo);
                System.out.println("Introduce cadena");
                cadena = in.readLine();


            }
            fsalida.close();
            br.close();
            in.close();
            cliente.close();


        } catch (
                IOException e) {
            System.out.println("\n*** Connection refused ***");
        }

    }
}
