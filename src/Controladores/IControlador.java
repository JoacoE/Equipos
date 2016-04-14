/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Categoria;
import Clases.Dispositivo;
import Clases.Lugar;
import Clases.Software;
import Clases.Usuario;
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
    public abstract void addSw(int id, String tipo, String descripcion, String key, int licencias);
    
    public abstract ArrayList ListarCat();
    public abstract boolean existeCat(String nom, String padre);
    public abstract int addCategoria(Categoria cat);
    public abstract ArrayList listarUsuarios();
    public abstract ArrayList listarLugares();
    public abstract void addDispositivo(Dispositivo disp);
    public abstract int retornoIdCategoria(Categoria cat);
    public abstract void setNcat(Categoria Ncat);
    public abstract Categoria getNcat();
    public abstract String validarSW(int id, int licencias, int id_dispo);
    public abstract Software retKey(int id);
    public abstract Categoria findCategoria(int id);
    public abstract ArrayList ListarEquipos();
    public abstract Dispositivo findDispositivo(int id);
    public abstract Lugar findLugar(int id);
    public abstract void actualizarEquipo(Dispositivo disp);
    public abstract Usuario findUsuario(int id);
}