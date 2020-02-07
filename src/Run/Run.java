/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author uriishii
 */
public class Run {

    public static void main(String[] args) {
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

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
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
