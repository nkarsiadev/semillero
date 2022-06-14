package ejercicio_interface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author sscon
 */
public class ImpresoraHP implements IImpresora{
    public int Velocidad=0;
    public int NumeroPaginas=0;

    public ImpresoraHP(int vel, int numpag) {
        this.Velocidad = vel;
        this.NumeroPaginas = numpag;
    }
    
    public ImpresoraHP() {
        
    }
    public ImpresoraHP(int numpag) {
        this.NumeroPaginas=numpag;
        
    }
    //Sobrecarga de metodos
    public void Velocidad(int numpag) {
        System.out.println("Se esta imprimiento " + numpag + " paginas");
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
