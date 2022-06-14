/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;

/**
 *
 * @author Gaby
 */
public class Circulo extends Figura2D {
double radio;

    public Circulo( int x, int y,double radio,String name) {
        super(x, y,name);
        this.radio = radio;
    }

    public double area() {
        return Math.PI*radio*radio;
    }
    
}
