/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author gerson
 */
public class ConexionDB {
    public static Connection ObtenerConexion(){
        Connection conexion=null;
       try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection ("jdbc:mysql://localhost/db_farmacia","root", "");

        } catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e.toString(), "Error de Conexion", 2);
            }
       return conexion;
    }
}
