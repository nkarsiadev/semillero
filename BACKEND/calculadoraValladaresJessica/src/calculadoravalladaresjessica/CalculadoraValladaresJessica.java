/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadoravalladaresjessica;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaby
 */
public class CalculadoraValladaresJessica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        double c;
        String op, seguir = "s";
        classCalculadora calc = new classCalculadora(0, 0, 0);
        JOptionPane.showMessageDialog(null, "Bienvenido a la calculadora");
        do {
            a = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el primer valor"));
            calc.setCant1(a);

            op = JOptionPane.showInputDialog(null, "Ingrese el operador=>  + - / *", "Que operación desea realizar?",
                    JOptionPane.QUESTION_MESSAGE);
            b = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el segundo valor"));
            calc.setCant2(b);

            switch (op) {
                case "+":
                    calc.suma(a, b);
                    JOptionPane.showMessageDialog(null, a + "+" + b + "= " + calc.getResultado(), "Resultado",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "-":
                    calc.resta(a, b);
                    JOptionPane.showMessageDialog(null, a + "-" + b + "= " + calc.getResultado(), "Resultado",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "*":
                    calc.multiplicacion(a, b);
                    JOptionPane.showMessageDialog(null, a + "*" + b + "= " + calc.getResultado(), "Resultado",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "/":

                    calc.division(a, b);
                    JOptionPane.showMessageDialog(null, a + "/" + b + "= " + calc.getResultado(), "Resultado",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

            }
            seguir = JOptionPane.showInputDialog(null, "Desea realizar un nuevo calculo?",
                    JOptionPane.QUESTION_MESSAGE);
        } while (seguir.equals("s") || seguir.equals("S"));
    }

}
