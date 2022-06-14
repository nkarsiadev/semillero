/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones13062022;

/**
 *
 * @author Gaby
 */
public class Piscina {

    private int nivel;
    public final int MAX_NIVEL;

    public Piscina(int max) {
        if (max < 0) {
            max = 0;
        }
        MAX_NIVEL = max;
    }

    public int getNivel() {
        return nivel;
    }

    public void vaciar(int cantidad) throws Exception {

        if (nivel - cantidad < 0) {
            throw new Exception();
        } else {
            nivel = nivel - cantidad;
        }

    }
public void llenar(int cantidad) throws Exception {

        if (nivel + cantidad < MAX_NIVEL) {
            throw new Exception();
        } else {
            nivel = nivel + cantidad;
        }

    }
   
}
