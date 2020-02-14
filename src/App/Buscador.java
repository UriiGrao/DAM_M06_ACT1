package App;

import javax.xml.xpath.*;
import java.io.FileWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;
import java.io.*;
import static utils.Colors.printBlue;
import static utils.Colors.printRed;

/**
 *
 * @author uriishii
 */
public class Buscador {
	public static void main(String[] args) {
		XPath xpath;
		XPathExpression exp;
		Document XMLDoc;

		openFileXML();
		String result = executeXpath("///destino[.='jramirez']");

		printBLUE(result);
	}

	public int openFileXML() {
		try {
			xpath = XPathFactory.newInstance().newXPath();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			XMLDoc = factory.newDocumentBuilder().parse(
				new InputSource(new FileInputStream("Documents/incidencias.xml")));
			return 0;
		}
		catch(Exception ex) {
			printRED("Error: " + ex.toString());
			return -1;
		}
	}

	public String executeXpath(String consulta){
		String salida = "";
		try {
			exp = xpath.compite(consulta);
			NodeList nodeList = (NodeList) exp.evaluate(XMLDoc, XPathConstants.NODESET);
			for(int i = 0; i < nodeList.getLength(); i++) {
				salida = salida + "\n" + nodeList.item(i).getChildNodes().item(0).getNodeValue();
			}
			return salida;
		} catch(Exception ex) {
			return "Error mostrar Datos: " + ex.toString();
		}
	}
}
