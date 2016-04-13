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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLXML;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class Persistencia {

    public Persistencia() {
    }
    
    //USUARIOS------------------------------------------------------------------
    public void PersistirUsuario(Usuario usr){
              
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT max(id_Usr) FROM Usuario");
            rs.next();
            int id= (int)rs.getInt(1)+1;
            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO Usuario(id_Usr, Nombre, Apellido)" + " VALUES (?,?,?)");
            preparedStmt.setInt (1, id);
            preparedStmt.setString (2, usr.getNombre());
            preparedStmt.setString (3, usr.getApellido());
            preparedStmt.execute();
            con.close();
        }catch(Exception ex){}
    }
    
    public boolean existeUsuario(String nombre, String apellido){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");          
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_Usr FROM Usuario WHERE Nombre='"+nombre+"'and Apellido ='"+apellido+"'");
            if(rs.next()) 
                return true;
        }catch(Exception ex){}
        return false;
    }
    public ArrayList listarUsuarios(){
    ArrayList Ausu = new ArrayList();
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");          
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Usuario");
        while(rs.next()){
            Usuario u = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3));
            Ausu.add(u);
            //rs.next();
        }
    }catch(Exception ex){}   
    return Ausu;
    }
    
    public Usuario findUsuario(int id){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Usuario WHERE id_Usr ='"+id+"'");
            if(rs.next()){
                Usuario usu = new Usuario(rs.getInt(1),rs.getString(2), rs.getString(3));
                return usu;
            }
        }catch(Exception ex){}
        return null;

    }
    
    //LUGARES-------------------------------------------------------------------
    
    public boolean existeLugar(String local, String seccion){
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");          
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id_Lugar FROM Lugar WHERE Local='"+local+"'and Seccion ='"+seccion+"'");
        if(rs.next()) 
            return true;
    }catch(Exception ex){}
    return false;
    }
    
    public void persistirLugar(Lugar lug){              
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT max(id_Lugar) FROM Lugar");
            rs.next();
            int id= (int)rs.getInt(1)+1;
            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO Lugar(id_Lugar, Local, Seccion)" + " VALUES (?,?,?)");
            preparedStmt.setInt (1, id);
            preparedStmt.setString (2, lug.getLocal());
            preparedStmt.setString (3, lug.getSeccion());
            preparedStmt.execute();
            con.close();
        }catch(Exception ex){}
    }
    
        public ArrayList listarLugar(){
        ArrayList ALug = new ArrayList();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");          
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Lugar");
            while(rs.next()){
                Lugar l = new Lugar(rs.getInt(1),rs.getString(2),rs.getString(3));
                ALug.add(l);
                //rs.next();
            }
        }catch(Exception ex){}   
        return ALug;
    }
        public Lugar findLugar(int id){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Lugar WHERE id_Lugar ='"+id+"'");
            if(rs.next()){
                Lugar lug = new Lugar(rs.getInt(1),rs.getString(2), rs.getString(3));
                return lug;
            }
        }catch(Exception ex){}
        return null;

    }
    //SOFTWARE------------------------------------------------------------------
    
    public boolean existeSW(int id){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");          
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Software WHERE id_Software='"+id+"'");
            if(rs.next()){
                return true;
            }
            else 
                return false;
        }catch(Exception ex){}      
    return true;
    }
    public boolean persistirSw(Software sw){              
        try{
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM Dispositivo WHERE id_Dispositivo='"+sw.getIdDisp()+"'");
//            if(rs.next()){
//                //rs.next();
//                int cat = rs.getInt(6);
//                Statement stmt1 = con.createStatement();
//                ResultSet rs1 = stmt1.executeQuery("SELECT * FROM Categoria WHERE id_Categoria='"+cat+"'");
//                rs1.next();
//                String str1 = rs1.getString(2);
//                String str2 = rs1.getString(3);
//                if(str1.equals("Computadora") || str2.equals("Computadora")){ 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO Software(id_Software, Tipo, Descripcion, Cd_Key, Cant_Licencias)" + " VALUES (?,?,?,?,?)");
            preparedStmt.setInt (1, sw.getIdSw());
            preparedStmt.setString (2, sw.getTipo());
            preparedStmt.setString (3, sw.getDescripcion());
            preparedStmt.setString (4, sw.getCdKey());

            preparedStmt.setInt (5, sw.getCantLicencias());
            preparedStmt.execute();
            con.close();
            return true;
        }
    catch(Exception ex){}    
    return false;
    
    }
    
    public String validarSoft(int id, int licencias, int id_equipo){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");          
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Software WHERE id_Software='"+id+"'");          
            int cantidad=0;
            while(rs.next()){
                cantidad++;
                if(rs.getInt(5)==id_equipo)
                    return "id_Equipo";
                if(rs.getInt(6)==licencias)
                    return "licencia";
            }    
        }catch(Exception ex){}
        return "valido";
    }
    public Software retKey(int id){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");          
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Software WHERE id_Software='"+id+"'");          
            if(rs.next()){
                Software sw = new Software(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                return sw;
            }
            else
                return null;
        }catch(Exception ex){}
        return null;
    }
        //DISPOSITIVOS--------------------------------------------------------------

    public ArrayList listarEquipos(){
        ArrayList equipos = new ArrayList();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");          
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Dispositivo");
            while(rs.next()){
                int id = rs.getInt(1);
                String marca = rs.getString(2);
                String modelo = rs.getString(3);
                String proc = rs.getString(4);
                String memoria = rs.getString(5);
                String HDD = rs.getString(6);
                Lugar lug = findLugar(rs.getInt(7));
                Usuario usu = findUsuario(rs.getInt(8));
                Categoria cat = findCategoria(rs.getInt(9));
                String ip = rs.getString(10);
                Date fecha = rs.getDate(11);
                String proveedor = rs.getString(12);
                String estado = rs.getString(13);
                int garantia = rs.getInt(14);
                int factura = rs.getInt(15);
                //Categoria cate = findCategoria(idCategoria);
//                if(cate.getNombrePadre().equals("Computadora"))
//                    
                String notas = rs.getString(17);
                Dispositivo disp = new Dispositivo(id,marca,modelo,proc,memoria,HDD,lug,usu,cat,ip,fecha,proveedor,estado,garantia,factura,null,notas);
       
                        equipos.add(disp);
                    }
                                 
                
        }catch(Exception ex){}
        return equipos;
    }
    
    public void persistirEquipo(Dispositivo disp){
               // StringTokenizer tokens = new StringTokenizer(nombre);
//        String nom = tokens.nextToken();
//        String ape = tokens.nextToken();
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            Statement stmt = con.createStatement();
            SQLXML info = con.createSQLXML();
            OutputStream os = info.setBinaryStream ();
            FileInputStream fis = new FileInputStream(disp.getArchivo().getAbsolutePath());
            int read;
            while ((read = fis.read ()) != -1) {
                os.write (read);
            }
            //termina prueba
            //int id= (int)rs.getInt(1)+1;
            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO Dispositivo(id_Dispositivo, Marca,Modelo, id_Lugar, id_Usuario, id_Categoria, IP, Fecha_Compra, Proveedor, Estado, Garantia, Factura, Archivo_XML, Nota)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStmt.setInt (1, disp.getIdDisp());
            preparedStmt.setString (2,disp.getMarca());
            preparedStmt.setString (3, disp.getModelo());
            preparedStmt.setInt (4, disp.getLugar().getId());
            preparedStmt.setInt (5, disp.getUsuario().getId());
            preparedStmt.setInt (6, disp.getTipo().getId());
            preparedStmt.setString (7, disp.getIp());
            preparedStmt.setDate (8,  new java.sql.Date(disp.getFecha_compra().getYear(),disp.getFecha_compra().getMonth(),disp.getFecha_compra().getDay()));
            preparedStmt.setString (9, disp.getProveedor());
            preparedStmt.setString (10, disp.getEstado());
            preparedStmt.setInt (11, disp.getGarantia());
            preparedStmt.setInt (12, disp.getFactura());
            preparedStmt.setSQLXML(13, info);
            preparedStmt.setString (14, disp.getNota());
            
        
            preparedStmt.execute();
            con.close();
        }catch(Exception ex){}
        
        }
        
        
    
    
    //CATEGORIAS---------------------------------------------------------------
    
    public ArrayList ListarCategorias(){
        ArrayList Acat = new ArrayList();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");          
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Categoria");
            while(rs.next()){
                Categoria cat = new Categoria(rs.getInt(1),rs.getString(2), rs.getString(3));
                Acat.add(cat);
                //rs.next();
            }
        }catch(Exception ex){}   
        return Acat;
    }
    public boolean ExisteCategoria(String nombre, String padre){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");          
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Categoria WHERE Categoria='"+nombre+"' and Categoria_Padre='"+padre+"'");
            if(rs.next()){
                return true;
            }
        }catch(Exception ex){}  
        return false;
    }
    
    public int persistirCategoria(Categoria cat){              
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT max(id_Categoria) FROM Categoria");
            rs.next();
            int id= (int)rs.getInt(1)+1;
            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO Categoria(id_Categoria, Categoria, Categoria_Padre)" + " VALUES (?,?,?)");
            preparedStmt.setInt (1, id);
            preparedStmt.setString (2, cat.getNombre());
            preparedStmt.setString (3, cat.getNombrePadre());
            preparedStmt.execute();
            con.close();
            return id;
        }catch(Exception ex){}
        return 0;
    }
    public int devIdCat(Categoria cat){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_Categoria FROM Categoria WHERE Categoria ='"+cat.getNombre()+"'and Categoria_Padre='"+cat.getNombrePadre()+"'");
            rs.next();
            int id= (int)rs.getInt(1);
            return id;
        }catch(Exception ex){}
        return 0;
    }
   
    
    public Categoria findCategoria(int id){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Categoria WHERE id_Categoria ='"+id+"'");
            if(rs.next()){
                Categoria cat = new Categoria(rs.getInt(1),rs.getString(2), rs.getString(3));
                return cat;
            }
        }catch(Exception ex){}
        return null;

    }

    
}


          