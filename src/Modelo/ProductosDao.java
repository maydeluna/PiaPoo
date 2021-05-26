/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author melis
 */
public class ProductosDao {
    Connection con;
    Conexion cn= new Conexion();
    PreparedStatement ps;
    
    public boolean RegistrarProductos(Productos pro){
        String sql = "INSERT INTO productos (codigo, nombre, proveedor, stock, precio) VALUES (?, ?, ?, ?, ?)";
        try{
            con= cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
             ps.setString(2, pro.getNombre());
              ps.setString(3, pro.getProveedor());
               ps.setInt(4, pro.getStock());      
        ps.setDouble(5, pro.getPrecio());
        ps.execute();
        return true;
        
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
}
