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
            con.close();
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
        con.close();
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
            con.close();
        }catch(Exception ex){}
        return null;

    }
    public void eliminarUsuario(int id){
    try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            Statement stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement("DELETE FROM Usuario WHERE id_Usr ='"+id+"'");
            preparedStmt.execute();
            con.close();
            
        }catch(Exception ex){}
    
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
        con.close();
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
            con.close();
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
            con.close();
        }catch(Exception ex){}
        return null;

    }
    //SOFTWARE------------------------------------------------------------------
    public void asociarEquipo(int idDispo, int idSw){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO Disp_Sw(id_Dispositivo, id_Software)" + " VALUES (?,?)");
            preparedStmt.setInt (1, idDispo);
            preparedStmt.setInt (2, idSw);
            preparedStmt.execute();
            con.close();
        }catch(Exception ex){} 
        
    
    
    }
    public boolean existeSW(int id){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");          
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Software WHERE id_Software='"+id+"'");
            if(rs.next()){
                 con.close();
                return true;
                
            }
            else{ 
                 con.close();
                return false;
            }
           
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
                if(rs.getInt(5)==id_equipo){
                     con.close();
                    return "id_Equipo";
                }
                if(rs.getInt(6)==licencias){
                    con.close();
                    return "licencia";}
            }
            con.close();
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
                 con.close();
                return sw;
            }
            else
                 con.close();
                return null;
        }catch(Exception ex){}
         
        return null;
    }
    
    public ArrayList listarSWporEquipo(int id){
        ArrayList listaSw = new ArrayList();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");          
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Disp_Sw WHERE id_Dispositivo='"+id+"'");  
            while(rs.next()){    
                int idsw = rs.getInt(2);
                Statement stmt1 = con.createStatement();
                ResultSet rs1 = stmt1.executeQuery("SELECT * FROM Software WHERE id_Software='"+idsw+"'");
                if(rs1.next()){
                Software sw = new Software(rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getInt(5));                        
                listaSw.add(sw);
                }
            }
            con.close();
            return listaSw;
        }catch(Exception ex){}
        return listaSw;
    }
    
        public ArrayList listarSoftware(){
        ArrayList listaSw = new ArrayList();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");          
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Software");  
            while(rs.next()){
                Software sw = new Software(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));                        
                listaSw.add(sw);
            }
            con.close();
            return listaSw;
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
                String proc = " ";
                String memoria = " ";
                String HDD = " ";
                Categoria cat = findCategoria(rs.getInt(9));
                int id = rs.getInt(1);
                String marca = rs.getString(2);
                String modelo = rs.getString(3);
                if(cat.getNombrePadre().equals("Computadora")){
                    proc = rs.getString(4);
                    memoria = rs.getString(5);
                    HDD = rs.getString(6);
                }
                Lugar lug = findLugar(rs.getInt(7));
                Usuario usu = findUsuario(rs.getInt(8));
                
                String ip = rs.getString(10);
                Date fecha = rs.getDate(11);
                String proveedor = rs.getString(12);
                String estado = rs.getString(13);
                int garantia = rs.getInt(14);
                int factura = rs.getInt(15);
                //Categoria cate = findCategoria(idCategoria);
//                if(cate.getNombrePadre().equals("Computadora"))      
                String notas = rs.getString(17);
                Dispositivo disp = new Dispositivo(id,marca,modelo,proc,memoria,HDD,lug,usu,cat,ip,fecha,proveedor,estado,garantia,factura,null,notas);
                equipos.add(disp);
            }
        con.close();    
        }catch(Exception ex){}
        return equipos;
    }
    public void eliminarEquipo(int id){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            Statement stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement("DELETE FROM Dispositivo WHERE id_Dispositivo ='"+id+"'");
            preparedStmt.execute();
            con.close();
            
        }catch(Exception ex){}
    }
    public void persistirEquipo(Dispositivo disp){
               // StringTokenizer tokens = new StringTokenizer(nombre);
//        String nom = tokens.nextToken();
//        String ape = tokens.nextToken();       
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            Statement stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO Dispositivo(id_Dispositivo, Marca,Modelo,Procesador, Memoria, HDD, id_Lugar, id_Usuario, id_Categoria, IP, Fecha_Compra, Proveedor, Estado, Garantia, Factura, Archivo_XML, Nota)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");            
            if(disp.getTipo().getNombrePadre().equals("Computadora")){               
                SQLXML info = con.createSQLXML();
                OutputStream os = info.setBinaryStream ();
                FileInputStream fis = new FileInputStream(disp.getArchivo().getAbsolutePath());
                int read;
                while ((read = fis.read ()) != -1) {
                    os.write (read);
                }
                preparedStmt.setString (4, disp.getProcesador());
                preparedStmt.setString (5, disp.getMemoria());
                preparedStmt.setString (6, disp.getHDD());
                preparedStmt.setSQLXML(16, info);
            }
            preparedStmt.setInt (1, disp.getIdDisp());
            preparedStmt.setString (2,disp.getMarca());
            preparedStmt.setString (3, disp.getModelo());
            preparedStmt.setString (4, disp.getProcesador());
            preparedStmt.setString (5, disp.getMemoria());
            preparedStmt.setString (6, disp.getHDD());
            preparedStmt.setInt (7, disp.getLugar().getId());
            preparedStmt.setInt (8, disp.getUsuario().getId());
            preparedStmt.setInt (9, disp.getTipo().getId());
            preparedStmt.setString (10, disp.getIp());
            preparedStmt.setDate (11,  new java.sql.Date(disp.getFecha_compra().getYear(),disp.getFecha_compra().getMonth(),disp.getFecha_compra().getDay()));
            preparedStmt.setString (12, disp.getProveedor());
            preparedStmt.setString (13, disp.getEstado());
            preparedStmt.setInt (14, disp.getGarantia());
            preparedStmt.setInt (15, disp.getFactura());
            preparedStmt.setSQLXML(16, null);
            preparedStmt.setString (17, disp.getNota());                 
            preparedStmt.execute();
            con.close();
        }catch(Exception ex){}       
    }
    
    public void actualizarEquipo(Dispositivo disp){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            Statement stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement("UPDATE Dispositivo SET id_Dispositivo=?, Marca=?,Modelo=?,Procesador=?, Memoria=?, HDD=?, id_Lugar=?, id_Usuario=?, id_Categoria=?, IP=?, Fecha_Compra=?, Proveedor=?, Estado=?, Garantia=?, Factura=?, Archivo_XML=?, Nota=? WHERE id_Dispositivo='"+disp.getIdDisp()+"'");          
            if(disp.getTipo().getNombrePadre().equals("Computadora")){
                
//                SQLXML info = con.createSQLXML();
//                OutputStream os = info.setBinaryStream ();
//                FileInputStream fis = new FileInputStream(disp.getArchivo().getAbsolutePath());
//                int read;
//                while ((read = fis.read ()) != -1) {
//                    os.write (read);
//                }
                preparedStmt.setString (4, disp.getProcesador());
                preparedStmt.setString (5, disp.getMemoria());
                preparedStmt.setString (6, disp.getHDD());
//                preparedStmt.setSQLXML(16, info);
            }
            preparedStmt.setInt (1, disp.getIdDisp());
            preparedStmt.setString (2,disp.getMarca());
            preparedStmt.setString (3, disp.getModelo());
            preparedStmt.setString (4, disp.getProcesador());
            preparedStmt.setString (5, disp.getMemoria());
            preparedStmt.setString (6, disp.getHDD());
            preparedStmt.setInt (7, disp.getLugar().getId());
            preparedStmt.setInt (8, disp.getUsuario().getId());
            preparedStmt.setInt (9, disp.getTipo().getId());
            preparedStmt.setString (10, disp.getIp());
            preparedStmt.setDate (11,  new java.sql.Date(disp.getFecha_compra().getYear(),disp.getFecha_compra().getMonth(),disp.getFecha_compra().getDay()));
            preparedStmt.setString (12, disp.getProveedor());
            preparedStmt.setString (13, disp.getEstado());
            preparedStmt.setInt (14, disp.getGarantia());
            preparedStmt.setInt (15, disp.getFactura());
            preparedStmt.setSQLXML(16, null);
            preparedStmt.setString (17, disp.getNota());     
            preparedStmt.execute();
            con.close();
        }catch(Exception ex){}
        
    
    }
        
    public Dispositivo findEquipo(int id){ 
        try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Dispositivo WHERE id_Dispositivo ='"+id+"'");
                if(rs.next()){
                    String proc = " ";
                    String memoria = " ";
                    String HDD = " ";
                    Categoria cat = findCategoria(rs.getInt(9));
                    String marca = rs.getString(2);
                    String modelo = rs.getString(3);
                    if(cat.getNombrePadre().equals("Computadora")){
                        proc = rs.getString(4);
                        memoria = rs.getString(5);
                        HDD = rs.getString(6);
                    }
                    Lugar lug = findLugar(rs.getInt(7));
                    Usuario usu = findUsuario(rs.getInt(8));                    
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
                    return disp;
                }
                con.close();
            }catch(Exception ex){}
            return null;

    }
    public ArrayList findEquipoPorSW(int id){
        try{
            ArrayList equipos = new ArrayList();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Equipos","tecnico","tecnico");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_Dispositivo FROM Disp_Sw WHERE id_Software ='"+id+"'");
            while(rs.next()){
                equipos.add(rs.getInt(1));            
            }
            return equipos;
        }
        catch(Exception ex){}
        return null;
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
            con.close();
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
                con.close();
                return true;
            }
            con.close();
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
            con.close();
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
                con.close();
                return cat;
            }
            con.close();
        }catch(Exception ex){}
        return null;

    }

    
}


          