/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfacegv;

/**
 *
 * @author Gaby
 */
public class InterfaceGV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Yamaha r1 = new Yamaha(11,149);
        Yamaha r6 = new Yamaha(12);
        Yamaha mt = new Yamaha(); //llamada al metodo default mediante un objeto canon3
        
        Ducatti corsa = new Ducatti(13,173);
        Ducatti force = new Ducatti();
        Ducatti panigale = new Ducatti(); 
        
        Kawasaki a = new Kawasaki(14,198);
        Kawasaki b = new Kawasaki();
        Kawasaki c = new Kawasaki();
        
        r1.Imprimir(" YAMAHA "); //llamada al metodo default
        r6.Velocidad(); //llamada al metodo sobrecargado
        mt.Velocidad(); //llamada al metodo implementado con interface 
        
        System.out.println("");
        
        corsa.Imprimir(" Ducatti ");
        force.Velocidad(15);
        panigale.Velocidad();
        
        System.out.println("");
        
        a.Imprimir(" KAWASAKI ");
        b.Velocidad(14);
        c.Velocidad();
    }
    
}
