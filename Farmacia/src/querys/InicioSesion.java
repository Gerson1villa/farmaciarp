/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import pharmacy.ConexionDB;

/**
 *
 * @author gerson
 */
public class InicioSesion {
    String usuario;
    String contrasenia;
    
    public InicioSesion(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    } 
    
    public int verificarVacio(){
        if((this.usuario.equals("")) || (this.usuario.equals(null) || this.contrasenia.equals("")) || (this.contrasenia.equals(null))){
            JOptionPane.showMessageDialog(null, "Verifique, Algunos de los campos esta vacio");
            return 0;   
        }
        else
        {
            int x = verificarBD();
            if(x == 0){
                JOptionPane.showMessageDialog(null, "Verifique, Datos ingresados Incorrectos");
                return 0;
            }
            else{
                
                return x;
            }
        }
    }
    
      
    public int verificarBD(){
      /*
        1 administrador
        2 vendedor
      */
        Connection conexion = ConexionDB.ObtenerConexion();
        String u = "";
        String c = "";
        int id = 0;
        int contador = 0;
        try{
            Statement comando = (Statement)conexion.createStatement();
            ResultSet datos = comando.executeQuery("Select idtipousuario, usuario, contrasenia FROM tbl_usuario WHERE usuario = '"+usuario+"';");
            while(datos.next()){
                contador++;
                u = datos.getString("usuario");
                c = datos.getString("contrasenia");
                id = datos.getInt("idtipousuario");
            }
            
        }catch(Exception ex){
      
        }
        if(contador == 0){
            return 0;
        }
        else{
            if((this.usuario.equals(u)) && (this.contrasenia.equals(c))){
                return id;
            }
            else{
                return 0;
            }
        }
    }
}
