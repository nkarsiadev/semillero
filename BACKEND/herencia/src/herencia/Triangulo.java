/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;

/**
 *
 * @author Gaby
 */
public class Triangulo extends Figura2D {

    double base, altura;

    public Triangulo(int x, int y, double base, double altura,String name) {
        super(x, y,name);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {

        return (base * altura) / 2;
    }

}
