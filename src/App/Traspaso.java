/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Models.Incidencia;
import Models.Incidencias;
import Utils.MiExcepcion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author uriishii
 */
public class Traspaso {

    public static ArrayList<Incidencia> incidencias = new ArrayList<>();
    public static Incidencias incidenciasXML = new Incidencias();

    public static void main(String[] args) {

        try {
            leerFicheroTXT();
            incidenciasXML.setIncidencias(incidencias);
            guardarEnXML();
            System.out.println("Se ha generado el XML sin problemas!");
        } catch (MiExcepcion ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void leerFicheroTXT() throws MiExcepcion {
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
            throw new MiExcepcion("Error al Leer TXT: " + e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
            }
        }
    }

    private static void guardarEnXML() throws MiExcepcion {
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Incidencias.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(incidenciasXML, new FileWriter("Documents/incidencias.xml"));
        } catch (JAXBException ex) {
            throw new MiExcepcion("Error al escribir el fichero XML: " + ex.getMessage());
        } catch (IOException ex) {
            throw new MiExcepcion("Error al guardar el fichero XML: " + ex.getMessage());

        }
    }
}
