/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import Models.Incidencia;
import java.util.ArrayList;
import static Run.Controller.*;

/**
 *
 * @author uriishii
 */
public class Run {

    public static ArrayList<Incidencia> incidencias = new ArrayList<>();

    public static void main(String[] args) {
        guardarDeFichero();
        incidencias.forEach((incidencia) -> {
            System.out.println(incidencia.toString());
        });
        
        
    }
}
