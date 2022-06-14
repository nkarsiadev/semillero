/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;

/**
 *
 * @author Gaby
 */
public abstract class Figura2D {

    int x;
    int y;
    String name;

    public Figura2D(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public abstract double area();
}
