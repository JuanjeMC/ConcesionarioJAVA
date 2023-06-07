/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.concesionario;

/**
 *
 * @author juanjemc
 */
public class Camioneta extends Vehiculo {

    private float pesoMaximo;

    public Camioneta(String marca, String modelo, String matricula, String tipo, float kilometraje, float precio, boolean disponible, float pesoMaximo) {
        super(marca, modelo, matricula, tipo, kilometraje, precio, disponible);
        if (pesoMaximo >= 3500 && pesoMaximo <= 7500) {
            this.pesoMaximo = pesoMaximo;
        }
    }

    @Override
    public float facturaAlquiler(int kms) {
        float resultado = this.precio * kms;

        if (this.pesoMaximo >= 5000) {

            resultado = (float) (resultado + (resultado * 0.30));
        }

        return resultado;
    }

    public float getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(float pesoMaximo) {
        if (pesoMaximo >=0 ){ //No se que valor límite poner además de éste...
        this.pesoMaximo = pesoMaximo;
        }
    }
    
    @Override
    public String toString(){ //String marca, String modelo, String kilometraje, String matricula, float precio, boolean disponible, String tipo
        return "VEHICULO:" + this.marca + ";" + this.modelo + ";" + this.kilometraje + ";" + this.matricula + ";" + this.precio + ";" + this.disponible + ";" + this.tipo + ";" + this.pesoMaximo + "\n";
        
    }
    
}


