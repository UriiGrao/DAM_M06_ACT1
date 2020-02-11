package App;

import Models.Incidencias;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author uriishii
 */
public class Buscador {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context =  JAXBContext.newInstance(Incidencias.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Incidencias incidencias = (Incidencias) unmarshaller.unmarshal(new File("Documents/incidencias.xml"));
        
        System.out.println(incidencias.getIncidencias());
    }
}
