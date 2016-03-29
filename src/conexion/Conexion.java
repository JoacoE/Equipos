
package conexion;
/**
 *
 * @author Joaquin
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    Conexion(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://serverdtv:1433;databaseName=Tecnicos","tecnico","tecnico");
        }catch(Exception ex){}
    
    }
  
    
}
