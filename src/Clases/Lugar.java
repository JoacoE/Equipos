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
public class Lugar {
    
    private int id;
    private String local;
    private String seccion;

    public Lugar() {
    }

    public Lugar(int id, String local, String seccion) {
        this.id = id;
        this.local = local;
        this.seccion = seccion;
    }

    public Lugar(String local, String seccion) {
        this.local = local;
        this.seccion = seccion;
    }

    public int getId() {
        return id;
    }

    public String getLocal() {
        return local;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    
    
}
