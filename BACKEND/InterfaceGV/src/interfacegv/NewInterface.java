/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacegv;

/**
 *
 * @author Gaby
 */
public interface NewInterface {

    int cf = 0;
    int compresion = 0;
//metodo default
    default void Imprimir(String texto){
        System.out.println("La moto de marca " + texto + " arrancó...");
    }
    public void Velocidad();

}
