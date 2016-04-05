/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Enumerados.Estado;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Joaquin
 */
public class Dispositivo {

    
    
    private int idDisp;
    private int idSw;
    private Categoria cat;
    private String marca;
    private String modelo;
    private String procesador;
    private String memoria;
    private String HDD;
    private Usuario usuario;
    private Lugar lugar;
    private Date fecha_compra;
    private String proveedor;
    private String estado;
    private int garantia;
    private int factura;
    private String ip;
    private String nota;
    private File archivo;
    
    public Dispositivo() {
    }

    public Dispositivo(int idDisp, int idSw, Categoria cat, String marca, String modelo, String procesador, String memoria, String HDD, Usuario usuario, Lugar lugar, Date fecha_compra, String proveedor, String estado, int garantia, int factura, String ip, String nota, File archivo) {
        this.idDisp = idDisp;
        this.idSw = idSw;
        this.cat = cat;
        this.marca = marca;
        this.modelo = modelo;
        this.procesador = procesador;
        this.memoria = memoria;
        this.HDD = HDD;
        this.usuario = usuario;
        this.lugar = lugar;
        this.fecha_compra = fecha_compra;
        this.proveedor = proveedor;
        this.estado = estado;
        this.garantia = garantia;
        this.factura = factura;
        this.ip = ip;
        this.nota = nota;
        this.archivo = archivo;
    }

    public String getProcesador() {
        return procesador;
    }

    public String getMemoria() {
        return memoria;
    }

    public String getHDD() {
        return HDD;
    }

    public int getIdDisp() {
        return idDisp;
    }

    public int getIdSw() {
        return idSw;
    }

    public Categoria getTipo() {
        return cat;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getEstado() {
        return estado;
    }

    public int getGarantia() {
        return garantia;
    }

    public int getFactura() {
        return factura;
    }

    public String getIp() {
        return ip;
    }

    public String getNota() {
        return nota;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setIdDisp(int idDisp) {
        this.idDisp = idDisp;
    }

    public void setIdSw(int idSw) {
        this.idSw = idSw;
    }

    public void setTipo(Categoria cat) {
        this.cat = cat;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public void setHDD(String HDD) {
        this.HDD = HDD;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    
    
}
