/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


/**
 *
 * @author Joaquin
 */
public class Software {
    
    private int idSw;
    private String tipo;
    private String descripcion;
    private String cdKey;
    private int cantLicencias;
    private int idDisp;

    public Software() {
    }

    public Software(int idSw, String tipo, String descripcion, String cdKey, int idDisp, int licencias) {
        this.idSw = idSw;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.cdKey = cdKey;
        this.idDisp = idDisp;
        this.cantLicencias=licencias;
    }

    public int getCantLicencias() {
        return cantLicencias;
    }

    public void setCantLicencias(int cantLicencias) {
        this.cantLicencias = cantLicencias;
    }

    public void setIdSw(int idSw) {
        this.idSw = idSw;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCdKey(String cdKey) {
        this.cdKey = cdKey;
    }

    public void setIdDisp(int idDisp) {
        this.idDisp = idDisp;
    }

    public int getIdSw() {
        return idSw;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCdKey() {
        return cdKey;
    }

    public int getIdDisp() {
        return idDisp;
    }
    
    
}
