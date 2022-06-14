/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegv;

/**
 *
 * @author Gaby
 */
public class Kawasaki implements NewInterface {

   
    public int CaballosFuerza = 0;
    public int Compresion=0;


    public Kawasaki() {
    }
    //constructor para la sobrecarga

    public Kawasaki(int compresion) {
        this.Compresion = compresion;
    }

    public Kawasaki (int cf,int compresion) {
  
        this.CaballosFuerza = cf;
        this.Compresion=compresion;
    }

    //sobrecarga de metodos
    public void Velocidad(double velocidad) {
        
        if (Compresion >10) {
            velocidad=Compresion*CaballosFuerza;
            System.out.println("La velocidad punta es: " + velocidad);
        } else {
            System.out.println("La velocidad no pasa de los 100 km" );
        }
    }

    @Override
    public void Velocidad() {
     double velocidad;
       if (Compresion >10) {
            velocidad=Compresion*CaballosFuerza;
            System.out.println("La velocidad punta es: " + velocidad);
        } else {
            System.out.println("La velocidad no pasa de los 100 km" );
        }
    }
}
