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
public class Categoria {
    private int id;
    private String nombre;
    private String nombrePadre;

    public Categoria() {
    }

    public Categoria(int id, String nombre, String nombrePadre) {
        this.id = id;
        this.nombre = nombre;
        this.nombrePadre = nombrePadre;
    }

    public Categoria(String nombre, String nombrePadre) {
        this.nombre = nombre;
        this.nombrePadre = nombrePadre;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }
    
    
    
}
