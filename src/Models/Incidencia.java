package Models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Clase de las incidencias
 *
 * @author uriishii
 */
@XmlRootElement(name = "incidencia")
@XmlType(propOrder = {"origen", "destino", "detalle", "tipo"})
public class Incidencia {

    String fechahora;
    String origen;
    String destino;
    String detalle;
    String tipo;

    public Incidencia() {
    }

    public Incidencia(String fechahora, String origen, String destino, String detalle, String tipo) {
        this.fechahora = fechahora;
        this.origen = origen;
        this.destino = destino;
        this.detalle = detalle;
        this.tipo = tipo;
    }

    @XmlAttribute(name = "fechahora")
    public String getFecha() {
        return fechahora;
    }

    public void setFecha(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "fecha=" + fechahora + ", origen=" + origen + ", destino=" + destino + ", detalle=" + detalle + ", tipo=" + tipo;
    }

}
