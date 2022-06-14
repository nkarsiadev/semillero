package ejercicio_interface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sscon
 */
public interface IImpresora {
    int NumeroPaginas = 0;
    int Velocidad = 0;
    
    //metodo default
    default void Imprimir(String texto){
        System.out.println("La impresora " + texto + " esta imprimiendo...");
    }
    //metodo por implementar
    public void Velocidad();
    
}
