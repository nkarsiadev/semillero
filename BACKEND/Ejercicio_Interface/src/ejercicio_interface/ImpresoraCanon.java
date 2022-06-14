package ejercicio_interface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sscon
 */
public class ImpresoraCanon implements IImpresora {
    
    public int Velocidad=0;
    public int NumeroPaginas=0;
    
    //conatructor
    public ImpresoraCanon() {
    }
    //constructor para la sobrecarga
    public ImpresoraCanon(int velocidad) {
        this.Velocidad=velocidad;
    }
    
    public ImpresoraCanon(int velocidad, int numeropag) {
        this.Velocidad = velocidad;
        this.NumeroPaginas = numeropag;
    }
    
    //sobrecarga de metodos
    public void Velocidad(double tiempo) {
        //double tiempo;
        if ( Velocidad >= NumeroPaginas){
            tiempo = NumeroPaginas + Velocidad;
            System.out.println("Terminara de imprimir en: " + tiempo );
        }else{
            tiempo = NumeroPaginas * Velocidad;
            System.out.println("Terminara de imprimir en: " + tiempo );
        } 
    }
    
    @Override
    public void Velocidad() {
        double tiempo;
        if ( Velocidad >= NumeroPaginas){
            tiempo = NumeroPaginas + Velocidad;
            System.out.println("Terminara de imprimir en: " + tiempo );
        }else{
            tiempo = NumeroPaginas * Velocidad;
            System.out.println("Terminara de imprimir en: " + tiempo );
        } 
    }
    
    

}
