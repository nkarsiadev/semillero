package genericos;


import genericos.Empleado;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sscon
 */
public class EjecutarLlenadoObjetos {
    public static void main (String[] args){
        
        double a,b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingres los numeros: ");
        a=sc.nextDouble();
        b=sc.nextDouble();
        
        ArrayListG<Double, Double> suma = new ArrayListG<>(a,b);
        
        double sum = suma.getNumUno() + suma.getNumDos();
        double rest = suma.getNumUno() - suma.getNumDos();
        double mult = suma.getNumUno() * suma.getNumDos();
        double div = suma.getNumUno() / suma.getNumDos();
        
        System.out.println("La suma de los dos numeros es: "+sum);
        System.out.println("La resta de los dos numeros es: "+rest);
        System.out.println("La multiplicacion de los dos numeros es: "+mult);
        System.out.println("La division de los dos numeros es: "+div);
                
        /*
        suma.setNumUno(a);
        suma.setNumDos(b);
        System.out.println("Valor de cadena"+suma.getStringNumbres());
        /*
        
        int sum = suma.getNumUno() + suma.getNumDos();
        int rest = suma.getNumUno() - suma.getNumDos();
        int mult = suma.getNumUno() * suma.getNumDos();
        int div = suma.getNumUno() / suma.getNumDos();*/
        
        /*System.out.println("La suma de los dos numeros es: "+sum);
        System.out.println("La resta de los dos numeros es: "+sum);
        System.out.println("La multiplicacion de los dos numeros es: "+sum);
        System.out.println("La division de los dos numeros es: "+sum);*/
        
        //System.out.println(suma.getNumUno());
        //System.out.println(suma.getNumDos());
        
        
        /*ArrayList<Integer> array = new ArrayList<Integer>();
        array.leerValores();
        System.out.println(array.calcularSuma(array));*/
        
        
        
        
        
        
        
        
        /*ArrayList<Integer> coleccion = new ArrayList<Integer>(4);
        
        coleccion.agregarElemento(1);
        coleccion.agregarElemento(7);
        coleccion.agregarElemento(3);
        coleccion.agregarElemento(4);
        
        
        
        int valor = coleccion.obtenerElemento(1)+coleccion.obtenerElemento(2);
        System.out.println(valor);
        
        int valor2 = coleccion.obtenerElemento(1)+coleccion.obtenerElemento(2);
        System.out.println(valor);
        
        int valor3 = coleccion.obtenerElemento(1)+coleccion.obtenerElemento(2);
        System.out.println(valor);
        
        int valor4 = coleccion.obtenerElemento(1)+coleccion.obtenerElemento(2);
        System.out.println(valor);*/
        
    }
}
