package listas;

import java.io.Serializable;

public class Boleto implements Serializable {
    private int numeroBoleto;
    private char[] nombreBoleto;
    private Boleto siguiente;


    public int getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(int numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }


    public char[] getNombreBoleto() {
        return nombreBoleto;
    }

    public void setNombreBoleto(char[] nombreBoleto) {
        this.nombreBoleto = nombreBoleto;
    }


    public Boleto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Boleto siguiente) {
        this.siguiente = siguiente;
    }
}
