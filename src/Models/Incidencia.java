/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 * Clase de las incidencias
 *
 * @author uriishii
 */
public class Incidencia {

    String fecha;
    String origen;
    String destino;
    String detalle;
    String tipo;

    public Incidencia(String fecha, String origen, String destino, String detalle, String tipo) {
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.detalle = detalle;
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        return "fecha=" + fecha + ", origen=" + origen + ", destino=" + destino + ", detalle=" + detalle + ", tipo=" + tipo;
    }

}
