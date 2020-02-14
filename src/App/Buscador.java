package App;

import javax.xml.xpath.*;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;
import java.io.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import static utils.Colors.printBlue;
import static utils.Colors.printRed;

/**
 *
 * @author uriishii
 */
public class Buscador {

    public static XPath xpath;
    public static XPathExpression exp;
    public static Document XMLDoc;

    public static void main(String[] args) {

        openFileXML();
        String result = executeXpath("//incidencia[./destino = 'jramirez' ]");
        printBlue(result);
    }

    public static int openFileXML() {
        try {
            xpath = XPathFactory.newInstance().newXPath();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            XMLDoc = factory.newDocumentBuilder().parse(
                    new InputSource(new FileInputStream("Documents/incidencias.xml")));
            return 0;
        } catch (Exception ex) {
            printRed("Error: " + ex.toString());
            return -1;
        }
    }

    public static String executeXpath(String consulta) {
        String salida = "";
        try {
            exp = xpath.compile(consulta);
            NodeList nodeList = (NodeList) exp.evaluate(XMLDoc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                salida = salida + "\n" + nodeList.item(i).getTextContent();
            }
            return salida;
        } catch (Exception ex) {
            return "Error mostrar Datos: " + ex.toString();
        }
    }
}
