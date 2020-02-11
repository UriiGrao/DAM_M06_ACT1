package Models;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author uriishii
 */
@XmlRootElement(name = "incidencias")
public class Incidencias {

    private ArrayList<Incidencia> incidencias = new ArrayList<>();

    @XmlElement(name = "incidencia")
    public ArrayList<Incidencia> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(ArrayList<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }

    public Incidencias() {
    }
}
