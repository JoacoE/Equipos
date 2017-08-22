
package conexion;
/**
 *
 * @author Joaquin
 */

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    
    public Connection con;
    
    public Conexion(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.con = DriverManager.getConnection("jdbc:sqlserver://Joaquin:1433;databaseName=Equipos","joaquin","joaquin");
            
           
        }catch(Exception ex){}
    
    }
  
    
}

