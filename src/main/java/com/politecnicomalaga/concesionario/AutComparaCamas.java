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
public class AutComparaCamas implements Comparator<Autocaravana> {

    @Override
    public int compare(Autocaravana c1, Autocaravana c2) {
        return Float.compare(c2.getCamasDisponibles(), c1.getCamasDisponibles());
    }
}
