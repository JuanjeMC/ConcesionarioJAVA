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
public class CocheComparaPrecio implements Comparator<Coche> {

    @Override
    public int compare(Coche c1, Coche c2) {
        return Float.compare(c2.getPrecio(), c1.getPrecio());
    }
}
