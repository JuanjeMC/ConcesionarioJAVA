/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.concesionario;

/**
 *
 * @author juanjemc
 */
public class Autocaravana extends Vehiculo{
    
    private int camasDisponibles;

    public Autocaravana(String marca, String modelo, String matricula, String tipo, float kilometraje, float precio, boolean disponible, int camasDisponibles) {
        super(marca, modelo, matricula, tipo, kilometraje, precio, disponible);
        
        if (camasDisponibles >= 1 && camasDisponibles <= 6){
        this.camasDisponibles = camasDisponibles;
        }
    }

    @Override
    public float facturaAlquiler(int kms) {
        float resultado = this.precio * kms;

        if (this.camasDisponibles >= 5) {

            resultado = (float) (resultado + (resultado * 0.15));
        }

        return resultado;
    }

    public int getCamasDisponibles() {
        return camasDisponibles;
    }

    public void setCamasDisponibles(int camasDisponibles) {
        if (camasDisponibles >= 1 && camasDisponibles <= 6){
        this.camasDisponibles = camasDisponibles;
        }
    }
    
    @Override
    public String toString(){ //String marca, String modelo, String kilometraje, String matricula, float precio, boolean disponible, String tipo
        return "VEHICULO:" + this.marca + ";" + this.modelo + ";" + this.kilometraje + ";" + this.matricula + ";" + this.precio + ";" + this.disponible + ";" + this.tipo + ";" + this.camasDisponibles + "\n";
        
    }
    
    
}
