/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package herencia;

/**
 *
 * @author Gaby
 */
public class Herencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Figura2D f;
        f = new Circulo(0, 0, 5.5, "Circulo");
        System.out.println("Area del círculo " + f.area());
        f = new Triangulo(0, 0, 5.5, 2.0, "Triangulo");
        System.out.println("Area del triangulo " + f.area());
    }

}
