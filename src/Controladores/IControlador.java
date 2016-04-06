/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Categoria;
import Clases.Dispositivo;
import Clases.Software;
import java.util.ArrayList;


/**
 *
 * @author Joaquin
 */
public interface IControlador {
    
    public abstract boolean addUsuario(String nombre, String apellido);
//    public abstract ArrayList listarTecnicos();
//    public abstract ArrayList listarTareas();
//    public abstract void registrar(String nombre, String tarea, int horas);
    public abstract boolean addLugar(String local, String seccion);
    public abstract void addSw(int id, String tipo, String descripcion, String key, int idDisp, int licencias);
    public abstract ArrayList listarEquipos();
    public abstract ArrayList ListarCat();
    public abstract boolean existeCat(String nom, String padre);
    public abstract int addCategoria(Categoria cat);
    public abstract ArrayList listarUsuarios();
    public abstract ArrayList listarLugares();
    public abstract void addDispositivo(Dispositivo disp);
    public abstract int retornoIdCategoria(Categoria cat);
    public abstract void setNcat(Categoria Ncat);
    public abstract Categoria getNcat();

}
