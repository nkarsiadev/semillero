/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ferreteriafactura;

import java.util.Scanner;

/**
 *
 * @author Gabriela Valladares
 */
public class mainFactura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // TODO code application logic here
        String npieza = "";
        String descripcion = "";
        int cantidad = 0;
        double precio = 0;
        Factura factura = new Factura(npieza, descripcion, cantidad, precio);

        // Número de pieza
        System.out.print("\nEscriba el número de pieza: ");
        npieza = entrada.nextLine();
        factura.setnPieza(npieza);

        //Descripción de la pieza
        System.out.print("\nEscriba la descripción de la pieza: ");
        descripcion = entrada.nextLine();
        factura.setDescPieza(descripcion);

        // Cantidad del artículo
        System.out.print("\nEscriba la cantidad del artículo: ");
        cantidad = entrada.nextInt();
        factura.setCant(cantidad);

        // Valor del artículo
        System.out.print("\nEscriba el valor del artículo: ");
        precio = entrada.nextDouble();
        factura.setPrecio(precio);

        // Mostrar el monto de la factura
        factura.recibo();
        System.out.print("Valor a pagar: " + factura.obtenerMontoPago());

        System.out.println();
        System.out.println();
    }

}
