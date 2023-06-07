/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.concesionario;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author juanjemc
 */
public class ControladorVehiculos {

    public static void grabarAFichero(String filename, Flota miFlota) {

        //Grabación en texto
        FileWriter fo = null;
        PrintWriter pw = null;

        try {

            fo = new FileWriter(filename);
            pw = new PrintWriter(fo);

            for (Vehiculo vehiculo : miFlota.getMisVehiculos().values()) {
                try {
                    pw.print(vehiculo);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            pw.flush();

            fo.close();
            fo = null;

        } catch (IOException e) {

            System.out.println(e.getMessage());

        } finally {
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }

            }
        }

    }

    public static int leerDeFichero(String filename, Flota miFlota) {
        int lineasCorrectas = 0;
        // lectura en texto
        String resultado = "";
        FileReader fi = null;
        Scanner sc = null;

        try {
            int i = 0;
            fi = new FileReader(filename);
            sc = new Scanner(fi);

            while (sc.hasNextLine()) {

                try {
                    String lineas = sc.nextLine();
                    String[] campos = lineas.split(":");
                    String[] atributos = campos[1].split(";");

                    //String marca, String modelo, String matricula, String tipo, float kilometraje, float precio, boolean disponible, int pasajeros
                    String[] attOrd = {atributos[0], atributos[1], atributos[3], atributos[6], atributos[2], atributos[4], atributos[5], atributos[7]};

                    //String marca, String modelo, String kilometraje, String matricula, float precio, boolean disponible, String tipo, int pasajeros
                    miFlota.putVehiculo(miFlota.crearVehiculo(attOrd, atributos[6]));

                    lineasCorrectas++;
                    i++;

                } catch (Exception e) {

                    System.out.println("Error en la lectura de la línea: " + (i + 1));
                    i++;

                }

            }

            fi.close();
            fi = null;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fi != null) {
                try {
                    fi.close();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }
        return lineasCorrectas;

    }

    //*************************************toJSON************************************************
    public static void toJSON(String filename, Flota miFlota) {
        FileWriter fo = null;
        PrintWriter pw = null;

        try {

            fo = new FileWriter(filename);
            pw = new PrintWriter(fo);

            pw.print(miFlota.toJSON()); //El método para sacar los vehículos a json por separado está en Flota.

            pw.flush();

            fo.close();
            fo = null;

        } catch (IOException e) {

            System.out.println(e.getMessage());

        } finally {
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }

            }
        }
    }

    public static int fromJSON(String filename, Flota miFlota) {

        Gson gson = new Gson();

        int lineasCorrectas = 0;
        // lectura en texto

        FileReader fi = null;
        Scanner sc = null;
        String jsonTr = "";

        try {
            int i = 0;
            fi = new FileReader(filename);
            sc = new Scanner(fi);

            while (sc.hasNext()) {
                jsonTr += sc.next();
            }

            String[] objetos = jsonTr.split("@@@");

            for (i = 0; i < objetos.length; i++) {
                try {
                    if (objetos[i].contains("Moto")) {

                        Moto moto = gson.fromJson(objetos[i], Moto.class);

                        miFlota.putVehiculo(moto);

                        lineasCorrectas++;

                    } else if (objetos[i].contains("Coche")) {

                        Coche coche = gson.fromJson(objetos[i], Coche.class);

                        miFlota.putVehiculo(coche);

                        lineasCorrectas++;

                    } else if (objetos[i].contains("Autocaravana")) {

                        Autocaravana autocaravana = gson.fromJson(objetos[i], Autocaravana.class);

                        miFlota.putVehiculo(autocaravana);

                        lineasCorrectas++;

                    } else if (objetos[i].contains("Camioneta")) {

                        Camioneta camioneta = gson.fromJson(objetos[i], Camioneta.class);

                        miFlota.putVehiculo(camioneta);

                        lineasCorrectas++;

                    }

                } catch (Exception e) {

                    System.out.println("Error en la lectura de la línea: " + (i + 1));
                    i++;

                }

            }

            fi.close();
            fi = null;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fi != null) {
                try {
                    fi.close();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }
        return lineasCorrectas;

    }

    //*****************************FICHEROS POR SEPARADO********************************************
    public static void grabarSeparado(ArrayList vehiculos) {
        //ArrayList vehículos viene de "extraerVehiculos" de la clase Flota.
        
        FileWriter fo = null;
        PrintWriter pw = null;

        try {
            for (int i = 0; i < vehiculos.size(); i++) {
                fo = new FileWriter("vehiculo" + (i + 1) + ".txt");
                pw = new PrintWriter(fo);
                try {
                    pw.print(vehiculos.get(i).toString());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                pw.flush();

                fo.close();
                fo = null;
            }

        } catch (IOException e) {

            System.out.println(e.getMessage());

        } finally {
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }

            }
        }

    }

    //******************************CONTENIDO CIFRADO CESAR*****************************************
    public static String codificarFichero(String contenido, int desplazamiento) {

        String contenidoCodificado = "";
        for (int i = 0; i < contenido.length(); i++) {
            char caracter = contenido.charAt(i);

            if (caracter == '\n') {
                contenidoCodificado += caracter;
            } else {
                int codigoASCII = (int) caracter;
                codigoASCII += desplazamiento;
                char caracterCodificado = (char) codigoASCII;
                contenidoCodificado += caracterCodificado;
            }
        }
        return contenidoCodificado;
    }

    public static void grabarCodificado(String filename, Flota miFlota, int desplazamiento) {

        //Grabación en texto
        FileWriter fo = null;
        PrintWriter pw = null;

        try {

            fo = new FileWriter(filename);
            pw = new PrintWriter(fo);
            String contenido = "";

            for (Vehiculo vehiculo : miFlota.getMisVehiculos().values()) {

                contenido += vehiculo;
            }

            pw.print(codificarFichero(contenido, desplazamiento));
            pw.flush();

            fo.close();
            fo = null;

        } catch (IOException e) {

            System.out.println(e.getMessage());

        } finally {
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }

            }

        }

    }

    public static String decodificarFichero(String contenido, int desplazamiento) {
        String contenidoDecodificado = "";
        for (int i = 0; i < contenido.length(); i++) {
            char caracter = contenido.charAt(i);
            if (caracter == '\n') {
                contenidoDecodificado += caracter;
            } else {
                int codigoASCII = (int) caracter;
                codigoASCII -= desplazamiento;
                char caracterDecodificado = (char) codigoASCII;
                contenidoDecodificado += caracterDecodificado;
            }
        }
        return contenidoDecodificado;
    }

    public static int leerCodificado(String filename, Flota miFlota, int desplazamiento) {
        int lineasCorrectas = 0;
        // lectura en texto
        String resultado = "";
        String resultadoDecodificado = "";
        FileReader fi = null;
        Scanner sc = null;

        try {

            fi = new FileReader(filename);
            sc = new Scanner(fi);

            while (sc.hasNext()) {

                resultado += sc.nextLine() + "\n";

            }
            fi.close();
            fi = null;

            resultadoDecodificado = ControladorVehiculos.decodificarFichero(resultado, desplazamiento);
            String[] lineas = resultadoDecodificado.split("\n");

            for (int i = 0; i < lineas.length; i++) {

                String[] campos = lineas[i].split(":");
                String[] atributos = campos[1].split(";");

                //String marca, String modelo, String matricula, String tipo, float kilometraje, float precio, boolean disponible, int pasajeros
                String[] attOrd = {atributos[0], atributos[1], atributos[3], atributos[6], atributos[2], atributos[4], atributos[5], atributos[7]};

                //String marca, String modelo, String kilometraje, String matricula, float precio, boolean disponible, String tipo, int pasajeros
                miFlota.putVehiculo(miFlota.crearVehiculo(attOrd, atributos[6]));

                lineasCorrectas++;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fi != null) {
                try {
                    fi.close();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }
        return lineasCorrectas;

    }

}
