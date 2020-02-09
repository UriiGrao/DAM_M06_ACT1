/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import Models.Incidencia;
import static Run.Run.incidencias;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author uriishii
 */
public class Traspaso {
    public static void guardarDeFichero() {
        File f = null;
        FileReader fr = null;
        BufferedReader br = null;

        File ruta = new File("Documents");
        String fichero = "incidencias.txt";

        try {
            f = new File(ruta, fichero);
            if (!f.exists()) {
                System.out.println("No existe el fichero: " + fichero + " en la ruta: " + ruta.getPath());
                System.exit(0);
            }

            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String fecha = "";
            String origen = "";
            String destino = "";
            String tipo = "";
            String detalle = "";

            String line;
            while ((line = br.readLine()) != null) {
                String[] frase = line.split(" ");
                if (frase[0].contains("%")) {
                    fecha = frase[1] + " " + frase[2];
                    origen = frase[3];
                    destino = frase[4];
                } else {
                    if (line.contains(" ")) {
                        detalle = line;
                    } else {
                        tipo = line;
                        incidencias.add(new Incidencia(fecha, origen, destino, detalle, tipo));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
