/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.politecnicomalaga.concesionario;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author juanjemc
 */
public class Concesionario {

    public static void main(String[] args) {

        Flota miFlota = new Flota("Amazon", "337788", "Amazon@yo.es");
        ControladorVehiculos miControl = new ControladorVehiculos();
        
        
        //*****************CARGAR VEHÍCULOS DESDE FICHERO*************************************
        
        //System.out.println(miControl.leerDeFichero("Prueba.csv", miFlota));   
        //System.out.println(miControl.leerCodificado("Codificado.csv", miFlota, 4));
        
        /*miControl.fromJSON("PruebaJSON.json", miFlota);
         
        
        System.out.println("Todos los vehículos: ");
        for (Vehiculo vehiculo : miFlota.getMisVehiculos().values()) {
                System.out.println(vehiculo.toString());
        }
        
        System.out.println("Coches Disponibles");
        System.out.println(Arrays.toString(miFlota.cochesDisponibles()));
        
        System.out.println("Motos Disponibles");
        System.out.println(Arrays.toString(miFlota.motosDisponibles()));
        
        System.out.println("Camionetas Disponibles");
        System.out.println(Arrays.toString(miFlota.camionetasDisponibles()));
        
        System.out.println("Autocaravanas Disponibles");
        System.out.println(Arrays.toString(miFlota.autocaravanasDisponibles()));*/

        
        
        //******************AÑADIR VEHÍCULOS + GRABAR A FICHERO******************************

        String[] datosMoto = {"Honda", "CBR", "123ABC", "Moto", "10000", "5000", "true", "500"};
        String[] datosCoche = {"Toyota", "Corolla", "456DEF", "Coche", "20000", "15000", "true", "5"};
        String[] datosCamioneta = {"Ford", "Ranger", "789GHI", "Camioneta", "30000", "20000", "true", "1000"};
        String[] datosAutocaravana = {"Mercedes", "Sprinter", "ABC123", "Autocaravana", "40000", "30000", "true", "3"};
        
        String[] datosMoto2 = {"Piaggio", "Liberty", "123ABCD", "Moto", "10000", "5000", "false", "500"};
        String[] datosCoche2 = {"Ferrari", "Maranello", "456DEFG", "Coche", "20000", "15000", "false", "5"};
        String[] datosCamioneta2 = {"Lamborghini", "Urus", "789GHIJ", "Camioneta", "30000", "20000", "false", "1000"};
        String[] datosAutocaravana2 = {"Ford", "Sprinter", "ABC1234", "Autocaravana", "40000", "30000", "false", "3"};
        
        String[] datosMoto3 = {"Suzuki", "Hayabusa", "123ABCDE", "Moto", "10000", "5000", "true", "1300"};
        String[] datosMoto4 = {"Piaggio", "Liberty 2023", "123ABCDEF", "Moto", "10000", "5000", "true", "125"};
        
        Vehiculo moto = miFlota.crearVehiculo(datosMoto, "Moto");
        Vehiculo moto2 = miFlota.crearVehiculo(datosMoto2, "Moto");
        Vehiculo moto3 = miFlota.crearVehiculo(datosMoto3, "Moto");
        Vehiculo moto4 = miFlota.crearVehiculo(datosMoto4,"Moto");
        
        Vehiculo coche = miFlota.crearVehiculo(datosCoche, "Coche");
        Vehiculo coche2 = miFlota.crearVehiculo(datosCoche2, "Coche");
        
        Vehiculo camioneta = miFlota.crearVehiculo(datosCamioneta, "Camioneta");
        Vehiculo camioneta2 = miFlota.crearVehiculo(datosCamioneta2, "Camioneta");
        
        Vehiculo autocaravana = miFlota.crearVehiculo(datosAutocaravana, "Autocaravana");
        Vehiculo autocaravana2 = miFlota.crearVehiculo(datosAutocaravana2, "Autocaravana");
        
        
        //Hago por separado el put y el crear para comprobar que ambos métodos funcionan de forma independiente.
        
        miFlota.putVehiculo(autocaravana);
        miFlota.putVehiculo(autocaravana2);
        miFlota.putVehiculo(moto);
        miFlota.putVehiculo(moto2);
        miFlota.putVehiculo(moto3);
        miFlota.putVehiculo(moto4);
        miFlota.putVehiculo(coche);
        miFlota.putVehiculo(coche2);
        miFlota.putVehiculo(camioneta);
        miFlota.putVehiculo(camioneta2);
        
        
        System.out.println("Autocaravanas Disponibles");
        System.out.println(Arrays.toString(miFlota.autocaravanasDisponibles()));
        
        System.out.println("Coches Disponibles");
        System.out.println(Arrays.toString(miFlota.cochesDisponibles()));
        
        System.out.println("Motos Disponibles");
        System.out.println(Arrays.toString(miFlota.motosDisponibles()));
        
        System.out.println("Camionetas Disponibles");
        System.out.println(Arrays.toString(miFlota.camionetasDisponibles()));
        
        miControl.grabarAFichero("Prueba.csv", miFlota);
        miControl.toJSON("PruebaJSON.json", miFlota);
        miControl.grabarCodificado("Codificado.csv", miFlota, 4);
        miControl.grabarSeparado(miFlota.extraerVehiculos());

    }
}
