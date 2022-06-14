/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package genericos;

/**
 *
 * @author Gaby
 */
public class EjecutaLlenadoObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> colection = new ArrayList<String>(4);
        
        
        colection.agregarElemento("Maria");
        colection.agregarElemento("Julio");
        colection.agregarElemento("Daniel");
        colection.agregarElemento("Byron");
        String valor=colection.obtenerElemento(2);
        System.out.println(valor);
        
    }
    
}
