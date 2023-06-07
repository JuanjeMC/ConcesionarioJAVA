/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.concesionario;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author juanjemc
 */
public class Flota {

    private String nombre, dni, email;
    private Map<String, Vehiculo> misVehiculos;


    public Flota(String nombre, String dni, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.misVehiculos = new HashMap<>();

    }

    //Devuelve motos que no estén alquiladas, solo disponibles, orden cilindrada.
    public Moto[] motosDisponibles() {
        MotoComparaCilindrada comparadorCilindrada = new MotoComparaCilindrada();
        ArrayList<Vehiculo> motos = new ArrayList<>(misVehiculos.values());
        ArrayList<Moto> motosDisponibles = new ArrayList<>();

        for (int i = 0; i < motos.size(); i++) {
            if (motos.get(i).getTipo().equals("Moto") && motos.get(i).isDisponible() == true) {
                motosDisponibles.add((Moto) motos.get(i));
            }
        }

        motosDisponibles.sort(comparadorCilindrada);

        Moto[] listaMotos = new Moto[motosDisponibles.size()];

        for (int i = 0; i < motosDisponibles.size(); i++) {

            listaMotos[i] = motosDisponibles.get(i);
        }

        return listaMotos;

    }

    //Precio
    public Coche[] cochesDisponibles() {

        CocheComparaPrecio comparadorPrecio = new CocheComparaPrecio();
        ArrayList<Vehiculo> coches = new ArrayList<>(misVehiculos.values());
        ArrayList<Coche> cochesDisponibles = new ArrayList<>();

        for (int i = 0; i < coches.size(); i++) {
            if (coches.get(i).getTipo().equals("Coche") && coches.get(i).isDisponible() == true) {
                cochesDisponibles.add((Coche) coches.get(i));
            }
        }

        cochesDisponibles.sort(comparadorPrecio);

        Coche[] listaCoches = new Coche[cochesDisponibles.size()];

        for (int i = 0; i < cochesDisponibles.size(); i++) {

            listaCoches[i] = cochesDisponibles.get(i);
        }

        return listaCoches;

    }

    //Peso
    public Camioneta[] camionetasDisponibles() {

        CamComparaPeso comparadorPeso = new CamComparaPeso();
        ArrayList<Vehiculo> camionetas = new ArrayList<>(misVehiculos.values());
        ArrayList<Camioneta> camionetasDisponibles = new ArrayList<>();

        for (int i = 0; i < camionetas.size(); i++) {
            if (camionetas.get(i).getTipo().equals("Camioneta") && camionetas.get(i).isDisponible() == true) {
                camionetasDisponibles.add((Camioneta) camionetas.get(i));
            }
        }

        camionetasDisponibles.sort(comparadorPeso);

        Camioneta[] listaCamionetas = new Camioneta[camionetasDisponibles.size()];

        for (int i = 0; i < camionetasDisponibles.size(); i++) {

            listaCamionetas[i] = camionetasDisponibles.get(i);
        }

        return listaCamionetas;

    }

    //Camas
    public Autocaravana[] autocaravanasDisponibles() {

        AutComparaCamas comparadorCamas = new AutComparaCamas();
        ArrayList<Vehiculo> autocaravanas = new ArrayList<>(misVehiculos.values());
        ArrayList<Autocaravana> autocaravanasDisponibles = new ArrayList<>();

        for (int i = 0; i < autocaravanas.size(); i++) {
            if (autocaravanas.get(i).getTipo().equals("Autocaravana") && autocaravanas.get(i).isDisponible() == true) {
                autocaravanasDisponibles.add((Autocaravana) autocaravanas.get(i));
            }
        }

        autocaravanasDisponibles.sort(comparadorCamas);

        Autocaravana[] listaAutocaravanas = new Autocaravana[autocaravanasDisponibles.size()];

        for (int i = 0; i < autocaravanasDisponibles.size(); i++) {

            listaAutocaravanas[i] = autocaravanasDisponibles.get(i);
        }

        return listaAutocaravanas;

    }

    public Vehiculo crearVehiculo(String[] datosAtributos, String tipo) {

        String marca, modelo, matricula, tipoV;
        float kilometraje, precio, pesoMaximo;
        boolean disponible;
        int cilindrada, pasajeros, camasDisponibles;

        //String marca, String modelo, String matricula, String tipo, float kilometraje, float precio, boolean disponible, int cilindrada)
        if (tipo.equals("Moto")) {

            marca = datosAtributos[0];
            modelo = datosAtributos[1];
            matricula = datosAtributos[2];
            tipoV = datosAtributos[3];
            kilometraje = Float.parseFloat(datosAtributos[4]);
            precio = Float.parseFloat(datosAtributos[5]);
            disponible = Boolean.parseBoolean(datosAtributos[6]);
            cilindrada = Integer.parseInt(datosAtributos[7]);

            Moto nuevoVehiculo = new Moto(marca, modelo, matricula, tipoV, kilometraje, precio, disponible, cilindrada);

            return nuevoVehiculo;

        } else if (tipo.equals("Coche")) {
            marca = datosAtributos[0];
            modelo = datosAtributos[1];
            matricula = datosAtributos[2];
            tipoV = datosAtributos[3];
            kilometraje = parseFloat(datosAtributos[4]);
            precio = parseFloat(datosAtributos[5]);
            disponible = parseBoolean(datosAtributos[6]);
            pasajeros = parseInt(datosAtributos[7]);

            Coche nuevoVehiculo = new Coche(marca, modelo, matricula, tipoV, kilometraje, precio, disponible, pasajeros);

            return nuevoVehiculo;

        } else if (tipo.equals("Camioneta")) {

            marca = datosAtributos[0];
            modelo = datosAtributos[1];
            matricula = datosAtributos[2];
            tipoV = datosAtributos[3];
            kilometraje = parseFloat(datosAtributos[4]);
            precio = parseFloat(datosAtributos[5]);
            disponible = parseBoolean(datosAtributos[6]);
            pesoMaximo = parseFloat(datosAtributos[7]);

            Camioneta nuevoVehiculo = new Camioneta(marca, modelo, matricula, tipoV, kilometraje, precio, disponible, pesoMaximo);

            return nuevoVehiculo;

        } else if (tipo.equals("Autocaravana")) {

            marca = datosAtributos[0];
            modelo = datosAtributos[1];
            matricula = datosAtributos[2];
            tipoV = datosAtributos[3];
            kilometraje = parseFloat(datosAtributos[4]);
            precio = parseFloat(datosAtributos[5]);
            disponible = parseBoolean(datosAtributos[6]);
            camasDisponibles = parseInt(datosAtributos[7]);

            Autocaravana nuevoVehiculo = new Autocaravana(marca, modelo, matricula, tipoV, kilometraje, precio, disponible, camasDisponibles);

            return nuevoVehiculo;

        }

        return null;
    }

    public void putVehiculo(Vehiculo v) {
        

        misVehiculos.put(v.getMatricula(), v);
        
        

    }

    public float facturarVehiculo(String matricula, int kms) {
        float precio = 0;

        if (misVehiculos.containsKey(matricula) && misVehiculos.get(matricula).isDisponible() == false) {

            misVehiculos.get(matricula).setKilometraje(kms);
            misVehiculos.get(matricula).setDisponible(true);
            precio = misVehiculos.get(matricula).facturaAlquiler(kms);

        }

        return precio;

    }

    public boolean alquilarVehiculo(String matricula) {

        if (misVehiculos.containsKey(matricula) && misVehiculos.get(matricula).isDisponible() == true) {
            misVehiculos.get(matricula).setDisponible(false);

            return true;
        }
        return false;
    }

    @Override
    public String toString() { //String marca, String modelo, String matricula, String tipo, float kilometraje, float precio, boolean disponible
        return this.nombre + ";" + this.dni + ";" + this.email + "\n";

    }

    public Map<String, Vehiculo> getMisVehiculos() {
        return misVehiculos;
    }

    public String toJSON() {
        Gson gson = new Gson();
        ArrayList<Vehiculo> vehiculos = new ArrayList<>(misVehiculos.values());
        
        String gsonGenerado = "";

        for (int i = 0; i < vehiculos.size(); i++) {
            
            Vehiculo vehiculo = vehiculos.get(i);
            if (vehiculo instanceof Moto) {
                gsonGenerado += gson.toJson((Moto) vehiculo);
            } else if (vehiculo instanceof Coche) {
                gsonGenerado += gson.toJson((Coche) vehiculo);
            } else if (vehiculo instanceof Camioneta) {
                gsonGenerado += gson.toJson((Camioneta) vehiculo);
            } else if (vehiculo instanceof Autocaravana) {
                gsonGenerado += gson.toJson((Autocaravana) vehiculo);
            }

            if (i < vehiculos.size() - 1) {
                gsonGenerado += "@@@";
            }
        }
        return gsonGenerado;
    }
    
    public ArrayList extraerVehiculos(){
        
        return new ArrayList<>(misVehiculos.values());
        
    }


}
