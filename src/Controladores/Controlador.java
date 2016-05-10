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
import javax.swing.JInternalFrame;

/**
 *
 * @author Joaquin
 */
public class Controlador implements IControlador {
    
    private javax.swing.JInternalFrame ventana;
    private Categoria Ncat;
    
    public Controlador(){}

    public void setVentana(JInternalFrame ventana) {
        this.ventana = ventana;
    }

    public JInternalFrame getVentana() {
        return ventana;
    }    
    
    public void setNcat(Categoria Ncat) {
        this.Ncat = Ncat;
    }

    public Categoria getNcat() {
        return Ncat;
    }
    
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
    
    public void asociarEquipoSw(int idDispo, int idSw){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        p.asociarEquipo(idDispo, idSw);
    }
    public boolean validarEquipo(int id){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        Dispositivo dispo = p.findEquipo(id);
        if(dispo==null)
            return false;
        else
            if (dispo.getTipo().getNombrePadre().equals("Computadora"))
                return true;
            else
                return false;
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
    
    public void addSw(int id, String tipo, String descripcion, String key, int licencias){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        Software sw = new Software(id, tipo, descripcion, key, licencias);
        p.persistirSw(sw);
    }
    public boolean validarSW(int id){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        return p.validarSoft(id);
    }
    public Software retKey(int id){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        return p.retKey(id);
    }
    
    public ArrayList ListarCat(){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        return p.ListarCategorias();
    }
    public ArrayList listarSWporEquipo(int id){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        return p.listarSWporEquipo(id);
    }
    
    public ArrayList ListarEquipos(){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        return p.listarEquipos();
    }
    
    public void eliminarEquipo(int id){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        p.eliminarEquipo(id);
    }
    public boolean puedoEliminar(int id){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        Dispositivo disp = p.findEquipo(id);
        if(disp.getEstado().equals("DESUSO")&& disp.getLugar().getLocal().equals("Central")&& disp.getLugar().getSeccion().equals("Deposito"))
            return true;
        else
            return false;
    }
    
    public void actualizarEquipo(Dispositivo disp){
        Fabrica fabrica = Fabrica.getInstance();
        Persistencia p = fabrica.getPers();
        p.actualizarEquipo(disp);
    
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

public Categoria findCategoria(int id){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    return p.findCategoria(id);
}

public Dispositivo findDispositivo(int id){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    return p.findEquipo(id);
}

public Lugar findLugar(int id){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    return p.findLugar(id);
}
public Usuario findUsuario(int id){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    return p.findUsuario(id);
}    

public void eliminarUsuario(int id){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    p.eliminarUsuario(id);
}
public ArrayList findEquipoPorSW(int id){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    return p.findEquipoPorSW(id);
}

public ArrayList listarSoftware(){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    return p.listarSoftware();
}

public void eliminarSw(int id){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    p.eliminarSw(id);
}

public boolean puedoEliminarSw(int id){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    return p.puedoEliminarSW(id);      
}
public void desasociarSw(int id){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    p.desasociarSw(id);
}

public Software findSw(int id){
    Fabrica fabrica = Fabrica.getInstance();
    Persistencia p = fabrica.getPers();
    return p.findSw(id);
}

}

