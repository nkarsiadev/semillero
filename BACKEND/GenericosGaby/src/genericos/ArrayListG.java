package genericos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sscon
 */
public class ArrayListG<S extends Number,T extends Number> {
    private S numUno;
    private T numDos;

    public ArrayListG(S numUno, T numDos) {
        this.numUno = numUno;
        this.numDos = numDos;
    }

    public S getNumUno() {
        
        return numUno;
    }

    public void setNumUno(S numUno) {
        this.numUno = numUno;
    }

    public T getNumDos() {
        return numDos;
    }

    public void setNumDos(T numDos) {
        this.numDos = numDos;
    }
    
    public <G> String getStringNumbres(){
        return this.numUno + "UNO" + this.numDos + "DOS";
    }
    
}
