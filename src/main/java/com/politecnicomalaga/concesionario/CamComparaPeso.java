/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.concesionario;

import java.util.Comparator;

/**
 *
 * @author juanjemc
 */
public class CamComparaPeso implements Comparator<Camioneta> {

    @Override
    public int compare(Camioneta c1, Camioneta c2) {
        return Float.compare(c2.getPesoMaximo(), c1.getPesoMaximo());
    }
}
