/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import BaseDatos.AdministradorBD;
import java.sql.ResultSet;

/**
 *
 * @author Angel Sierra
 */
public class GestorMarcas {
//    Connection conexion =  new ConexionBD().GetConnection();
    
    public String listaMarcas(){
        String listaMarca = null;
//        Statement stmt=null;
        ResultSet rst=null;
        try{
        //conectándose a la base de datos
     
//        stmt = conexion.createStatement();
//            rst = stmt.executeQuery("SELECT * FROM  `marcas` ");
            AdministradorBD admi = new AdministradorBD();
            rst = admi.marcas_Imagen();
            //out.println(value);
            
            listaMarca = "<table class=\"tablesorter\" cellspacing=\"1\" cellpadding=\"1\" id=\"reservations\" ><thead><tr><th>ID</th><th>Imagen</th><th>Nombre Marca</th><th></th></tr></thead><tbody> ";
            while(rst.next()){

         String idMarca = rst.getString("idMarca");
          String NombreMarca = rst.getString("NombreMarca");
          String urlImage= rst.getString("urlImage");
                
                listaMarca =  listaMarca +"<tr><td>"+idMarca+"</td><td><input width=\"50px\" height=\"50px\" type=\"image\" src=\"images/Marcas/"+urlImage+"\" title=\"MinImg\"></td><td>"+NombreMarca+"</td><td><a href=\"Gestor_Marcas_Crear_Marcas.jsp?idMarca="+idMarca+"\"><input type=\"image\" src=\"images/icn_edit.png\" title=\"Editar_Marca\"></a><a onclick=\"eliminarMarca("+idMarca+")\"><input type=\"image\" src=\"images/icn_trash.png\" title=\"Eliminar_Marca\"></a></td></tr>";
               
            }
            //Conexion.close
            rst.close();
    }catch(Exception e){
        listaMarca= "Error en Consulta: "+ e.getMessage();
    }
        listaMarca = listaMarca + "</tbody></tbody></table>"; 
        
        return listaMarca;
}
    
    public String crearMarcas(String marca, String urlImage)
    {
        String crearMarcas = null; 
        
        return crearMarcas; 
    }
    
}
