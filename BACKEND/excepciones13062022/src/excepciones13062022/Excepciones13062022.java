/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package excepciones13062022;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaby
 */
public class Excepciones13062022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Piscina p = new Piscina(500);
        p.llenar(100);
        System.out.println("Nivel actual" + p.getNivel());

    }

}
