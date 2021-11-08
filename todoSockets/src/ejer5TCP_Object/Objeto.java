package ejer5TCP_Object;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Objeto implements Serializable {

    public int num1;
    public int num2;
    public int multiplicacion;


    public Objeto() {
    }

    public Objeto(int num1, int num2, int multiplicacion) {
        this.num1 = num1;
        this.num2 = num2;
        this.multiplicacion = multiplicacion;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getMultiplicacion() {
        return multiplicacion;
    }

    public void setMultiplicacion(int multiplicacion) {
        this.multiplicacion = multiplicacion;
    }
}
