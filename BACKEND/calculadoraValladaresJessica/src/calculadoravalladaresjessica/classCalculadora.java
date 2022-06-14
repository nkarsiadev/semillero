/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadoravalladaresjessica;

import javax.swing.JOptionPane;

/**
 *
 * @author Gaby
 */
public class classCalculadora {

    private int cant1, cant2;
    private double resultado;

    public classCalculadora(int cant1, int cant2, double resultado) {
        this.cant1 = cant1;
        this.cant2 = cant2;
        this.resultado = resultado;
    }

    public int getCant1() {
        return cant1;
    }

    public void setCant1(int cant1) {
        this.cant1 = cant1;
    }

    public int getCant2() {
        return cant2;
    }

    public void setCant2(int cant2) {
        this.cant2 = cant2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    public int suma(int cant1,int cant2){
        resultado = cant1+cant2;
        return (int) resultado;
    }
    public int resta(int cant1,int cant2){
        resultado = cant1-cant2;
        return (int) resultado;
    }
    public int multiplicacion(int cant1,int cant2){
       resultado = cant1*cant2;
        return (int) resultado;
    }
    public double division(int cant1,int cant2){
        if(cant2==0){
             resultado = 0;
             JOptionPane.showMessageDialog(null,"No es posible division para 0, el valor por defecto será 0.","ERROR",JOptionPane.ERROR_MESSAGE);
          
        }else{
            resultado=cant1/cant2;
        }
        return resultado;
    }
}
