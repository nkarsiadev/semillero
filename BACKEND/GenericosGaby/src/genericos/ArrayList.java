/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genericos;

/**
 *
 * @author Gaby
 */
public class ArrayList<T> {

    private T[] conjunto;
    private int i;

    public ArrayList(int tam) {
        conjunto = (T[])new Object[tam];
        i = 0;
    }

    public void agregarElemento(T object) {
        conjunto[i] = object;
        i++;
    }

    public T obtenerElemento(int i) {
        return conjunto[i];
    }
}
