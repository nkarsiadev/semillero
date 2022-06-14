/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_interface;

/**
 *
 * @author sscon
 */
public class ImpresoraEpson implements IImpresora{
    
    public int Velocidad=0;
    public int NumeroPaginas=0;

    public ImpresoraEpson() {
    }
    
    public ImpresoraEpson(int numpg) {
        this.NumeroPaginas=numpg;
    }
    
    public ImpresoraEpson(int vel, int np) {
        this.Velocidad = vel;
        this.Velocidad = np;
    }
    
     //Sobrecarga de metodos
    public void Velocidad(int np) {
        System.out.println("Se esta imprimiento " + np + " paginas");
    }

    @Override
    public void Velocidad() {
        float tiempo;
        if ( Velocidad <= NumeroPaginas){
            tiempo = Velocidad + NumeroPaginas ;
            System.out.println("Terminara de imprimir en: " + tiempo );
        }else{
            tiempo = NumeroPaginas * Velocidad;
            System.out.println("Terminara de imprimir en: " + tiempo );
        } 
    }
    
}
