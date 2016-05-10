/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Controladores.IControlador;
import Controladores.Controlador;
import Controladores.Persistencia;
import Swing.ListarSoftware;




/**
 *
 * @author Joaquin
 */
public class Fabrica {

private static Fabrica instancia;
private static IControlador IC;
private static Persistencia P;


private Fabrica(){};

    public static Fabrica getInstance(){
    if (instancia == null){
        instancia = new Fabrica();
    }
    return instancia;
}
    
public IControlador getICtrl() {
    if(IC==null)
        IC = new Controlador();
    return IC;
}

public Persistencia getPers() {
    if(P==null)
        P = new Persistencia();
    return P;
}


}
    
