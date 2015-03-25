/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServerAdmin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aC-Ma_000
 */
public class ConexionBD {
      
    public static Connection GetConnection()
    {
        Connection conexion=null;
      
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost/PhoneBook";
            String usuarioDB="root";
            String passwordDB="";
            conexion= DriverManager.getConnection(servidor,usuarioDB,passwordDB);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("Error1 en la Conexión con la BD "+ex.getMessage());
            conexion=null;
        }
        catch(SQLException ex)
        {
           System.out.println("Error1 en la Conexión con la BD "+ex.getMessage()); 
            conexion=null;
        }
        catch(Exception ex)
        {
            System.out.println("Error1 en la Conexión con la BD "+ex.getMessage());
            conexion=null;
        }
        finally
        {
            return conexion;
        }
    }
}