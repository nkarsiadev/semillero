/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacemovimiento;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaby
 */
public class Persona implements InterfaceMovimiento {

    private String nombre;
    private int x = 0, y = 0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void caminar() throws Exception{

        x++;
        y++;

        if (x >= 100 || y >= 100) {
            parar();
        }
        System.out.println(x);
    }

    @Override
    public void correr() throws Exception{
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        x += 2;
        y += 2;
        
        if (x >= 100 || y >= 100) {
            parar();
        }

    }

    @Override
    public void parar() throws Exception{

        System.out.println("Se detuvo");
        throw new Exception("Exception init");
      

    }

}
