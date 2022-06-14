/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ferreteriafactura;

/**
 *
 * @author Gabriela Valladares
 */
public class Factura {

    // Variables de instancia
    private String nPieza; // Número de la pieza
    private String descPieza; // Descripción de la pieza
    private int cant; // Cantidad del artículo
    private double precio;

    public Factura(String nPieza, String descPieza, int cant, double precio) {
        this.nPieza = nPieza;
        this.descPieza = descPieza;
        this.cant = cant;
        this.precio = precio;
    }


    public String getnPieza() {
        return nPieza;
    }

    public void setnPieza(String nPieza) {
        this.nPieza = nPieza;
    }

    public String getDescPieza() {
        return descPieza;
    }

    public void setDescPieza(String descPieza) {
        this.descPieza = descPieza;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
        //validamos que la cantidad no sea menor a 0
        cant = (cant < 0) ? 0 : cant;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        //validamos que la cantidad no sea menor a 0 
        precio = (precio < 0.0) ? 0.0 : precio;
    }

    public double obtenerMontoPago() {
        return getCant() * getPrecio(); // calcula el costo total
    }

    public String recibo() {
        return String.format("***********_FERRETERIA_*********************\n"
                + "_____Factura__"
                + "\nNúmero de pieza:" + getnPieza()
                + "\nDescripción" + getDescPieza()
                + "\nPrecio" + getPrecio()
                + "\nCantidad" + getCant());
    }

} //fin de la class principal Factura
