/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfacemovimiento;

/**
 *
 * @author Gaby
 */
public interface InterfaceMovimiento {
    int x=0,y=0;
    //debe ser metodo abstracto
    public void caminar() throws Exception;
    public void correr()  throws Exception;
    public void parar() throws Exception;

}
