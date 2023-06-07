/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.concesionario;

/**
 *
 * @author juanjemc
 */
public abstract class Vehiculo {
    
    protected String marca, modelo, matricula, tipo; //moto, coche, camioneta y autocaravana.
    protected float kilometraje, precio;
    protected boolean disponible;

    public Vehiculo(String marca, String modelo, String matricula, String tipo, float kilometraje, float precio, boolean disponible) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.tipo = tipo;
        
        if (this.kilometraje < 0){
        this.kilometraje = 0;
        }else{
            this.kilometraje = kilometraje;
        }
        
        this.precio = precio;
        this.disponible = disponible;
    }
    
    public abstract float facturaAlquiler(int kms);

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public float getKilometraje() {
        return kilometraje;
    }

    public float getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setMarca(String marca) {
        if(!marca.isEmpty()){
        this.marca = marca;
        }
    }

    public void setModelo(String modelo) {
        if(!modelo.isEmpty()){
        this.modelo = modelo;
        }
    }

    public void setMatricula(String matricula) {
        if(!matricula.isEmpty()){
        this.matricula = matricula;
        }
    }

    public void setTipo(String tipo) {
        if(!tipo.isEmpty()){
        this.tipo = tipo;
        }
    }

    public void setKilometraje(float kilometraje) {
        if (kilometraje >=0){
        this.kilometraje += kilometraje;
        } 
    }

    public void setPrecio(float precio) {
        if (precio >= 0){
        this.precio = precio;
        }
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    @Override
    public String toString(){ //String marca, String modelo, String kilometraje, String matricula, float precio, boolean disponible, String tipo
        return "VEHICULO:" + this.marca + ";" + this.modelo + ";" + this.kilometraje + ";" + this.matricula + ";" + this.precio + ";" + this.disponible + ";" + this.tipo + "\n";
        
    }
    
    
}
