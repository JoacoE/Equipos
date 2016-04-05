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
import java.io.FileInputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLXML;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author Joaquin
 */
public class Controlador implements IControlador {
    
    public Controlador(){}
    
    public boolean addUsuario(String nombre, String apellido){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        if(!p.existeUsuario(nombre, apellido)){
            Usuario usr = new Usuario(nombre, apellido);
            p.PersistirUsuario(usr);
            return true;
        }
        else
            return false;
            
//        try{
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
//            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO Tecnico(Nombre, Apellido)" + " VALUES (?,?)");
//            preparedStmt.setString (1, nombre);
//            preparedStmt.setString (2, apellido);
//            preparedStmt.execute();
//            con.close();
//        }catch(Exception ex){}
    }
    
    public boolean addLugar(String local, String seccion){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        if(!p.existeLugar(local, seccion)){
            Lugar lug = new Lugar(local, seccion);
            p.persistirLugar(lug);
            return true;
            }
        else
            return false;
    }
    
    public ArrayList listarEquipos(){
       Fabrica fabrica = Fabrica.getInstance();
       Persistencia p = fabrica.getPers();
       return p.listarEquipos();
    }
    
    public ArrayList listarUsuarios(){
       Fabrica fabrica = Fabrica.getInstance();
       Persistencia p = fabrica.getPers();
       return p.listarUsuarios();
    }
    public ArrayList listarLugares(){
       Fabrica fabrica = Fabrica.getInstance();
       Persistencia p = fabrica.getPers();
       return p.listarLugar();
    }

//    public ArrayList listarTecnicos(){
//        ArrayList tecs = new ArrayList();
//        try{
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM Tecnico");
//            while(rs.next()){
//                  String s1 = rs.getString(1);
//                String s2 = rs.getString(2);
//                String s3 = s1+" "+s2;
//                tecs.add(s3);              
//            }    
//        }catch(Exception ex){}
//        return tecs;
//    }
    
//    public ArrayList listarTareas(){
//        ArrayList tars = new ArrayList();
//        try{
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM Tarea");
//            while(rs.next()){
//                String s1 = rs.getString(1);
//                tars.add(s1);           
//            }    
//        }catch(Exception ex){}
//        return tars;
//    }
    
    public Software addSw(int id, String tipo, String descripcion, String key, int idDisp, int licencias){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        if(p.existeSW(id)==null){
            Software sw = new Software(id, tipo, descripcion, key, idDisp, licencias);
            p.persistirSw(sw);
            return null;
            }
        else
            return p.existeSW(id);     
    }
    
    public ArrayList ListarCat(){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        return p.ListarCategorias();
    }
//        StringTokenizer tokens = new StringTokenizer(nombre);
//        String nom = tokens.nextToken();
//        String ape = tokens.nextToken();
//        try{
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT max(Id) FROM Registro");
//            rs.next();
//            //arranca prueba
//            SQLXML info = con.createSQLXML();
//            OutputStream os = info.setBinaryStream ();
//            FileInputStream fis = new FileInputStream("C:\\Documents and Settings\\Nelson\\Escritorio\\jax-ws-catalog.xml");
//            int read;
//            while ((read = fis.read ()) != -1) {
//                os.write (read);
//            }
//            //termina prueba
//            int id= (int)rs.getInt(1)+1;
//            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO Registro(Id, Nombre_Tecnico, Apellido_Tecnico,Descripcion_Tarea, Fecha, Horas, Archivo_XML)" + "VALUES (?,?,?,?,?,?,?)");
//            preparedStmt.setInt (1, id);
//            preparedStmt.setString (2, nom);
//            preparedStmt.setString (3, ape);
//            preparedStmt.setString (4, tarea);
//            preparedStmt.setString (5, "01/01/16");
//            preparedStmt.setInt (6, horas);
//            preparedStmt.setSQLXML(7, info);
//            
//        
//            preparedStmt.execute();
//            con.close();
//        }catch(Exception ex){}
//        
//        }

public boolean existeCat(String nombre, String padre){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    if(p.ExisteCategoria(nombre, padre))
        return true;
    else
        return false;
}   

public int addCategoria(Categoria cat){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    return p.persistirCategoria(cat);
}
    
public void addDispositivo(Dispositivo disp){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    p.persistirEquipo(disp);

}

public int retornoIdCategoria(Categoria cat){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    return p.devIdCat(cat);
}
    
}
