/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegv;

/**
 *
 * @author Gaby
 */
public class Yamaha implements NewInterface {

    public int CaballosFuerza = 0;
    public int Compresion = 0;

    public Yamaha() {
    }
    //constructor para la sobrecarga

    public Yamaha(int compresion) {
        this.Compresion = compresion;
    }

    public Yamaha(int cf, int compresion) {

        this.CaballosFuerza = cf;
        this.Compresion = compresion;
    }


    public void Velocidad(double velocidad) {

        if (Compresion > 10) {
            velocidad = Compresion * CaballosFuerza;
            System.out.println("La velocidad punta es: " + velocidad);
        } else {
            System.out.println("La velocidad no pasa de los 100 km");
        }
    }

    @Override
    public void Velocidad() {
        double velocidad;
        if (Compresion > 10) {
            velocidad = Compresion * CaballosFuerza;
            System.out.println("La velocidad punta es: " + velocidad);
        } else {
            System.out.println("La velocidad no pasa de los 100 km");
        }
    }
}
