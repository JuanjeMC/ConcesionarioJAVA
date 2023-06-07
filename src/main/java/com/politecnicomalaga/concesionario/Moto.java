/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.concesionario;

/**
 *
 * @author juanjemc
 */
public class Moto extends Vehiculo{
    
    private int cilindrada;

    public Moto(String marca, String modelo, String matricula, String tipo, float kilometraje, float precio, boolean disponible, int cilindrada) {
        super(marca, modelo, matricula, tipo, kilometraje, precio, disponible);
        this.cilindrada = cilindrada;
    }
    

    @Override
    public float facturaAlquiler(int kms) {
        float resultado = this.precio * kms;
        
        
        if (this.cilindrada >= 500) {

            resultado = (float) (resultado + (resultado * 0.20));
        }
        
        return resultado;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        if (cilindrada >= 0){ //No se qué cilindrada es la mínima.
        this.cilindrada = cilindrada;
        }
    }   
    
    @Override
    public String toString(){ //String marca, String modelo, String kilometraje, String matricula, float precio, boolean disponible, String tipo
        return "VEHICULO:" + this.marca + ";" + this.modelo + ";" + this.kilometraje + ";" + this.matricula + ";" + this.precio + ";" + this.disponible + ";" + this.tipo + ";" + this.cilindrada + "\n";
        
    }
    
    
    
}
