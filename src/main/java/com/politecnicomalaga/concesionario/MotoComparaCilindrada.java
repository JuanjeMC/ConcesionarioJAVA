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
public class MotoComparaCilindrada implements Comparator<Moto> {

    @Override
    public int compare(Moto m1, Moto m2) {
        return Integer.compare(m2.getCilindrada(), m1.getCilindrada());
    }
}
