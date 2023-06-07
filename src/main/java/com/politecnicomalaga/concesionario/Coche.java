/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.concesionario;

/**
 *
 * @author juanjemc
 */
public class Coche extends Vehiculo {

    private int pasajeros;

    public Coche(String marca, String modelo, String matricula, String tipo, float kilometraje, float precio, boolean disponible, int pasajeros) {
        super(marca, modelo, matricula, tipo, kilometraje, precio, disponible);

        if (pasajeros >= 2 && pasajeros <= 7) {
            this.pasajeros = pasajeros;
        } else {
            this.pasajeros = 5;
        }
    }

    @Override
    public float facturaAlquiler(int kms) {
        float resultado = this.precio * kms;

        if (this.pasajeros >= 6 && this.pasajeros <= 7) {

            resultado = (float) (resultado + (resultado * 0.10));
        }

        return resultado;
    }

    public void setPasajeros(int pasajeros) {
        if (pasajeros >= 2 && pasajeros <= 7){
        this.pasajeros = pasajeros;
        }
        
    }

    public int getPasajeros() {
        return pasajeros;
    }
    
    @Override
    public String toString(){ //String marca, String modelo, String kilometraje, String matricula, float precio, boolean disponible, String tipo, int pasajeros
        return "VEHICULO:" + this.marca + ";" + this.modelo + ";" + this.kilometraje + ";" + this.matricula + ";" + this.precio + ";" + this.disponible + ";" + this.tipo + ";" + this.pasajeros + "\n";
        
    }

}
