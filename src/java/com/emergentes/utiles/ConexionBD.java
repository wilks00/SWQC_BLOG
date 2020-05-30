package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private    String url = "jdbc:mysql://localhost:3306/bd_blog";
    private    String usuario = "root";
    private    String password = "";
    
    protected Connection conn = null;
    
    public ConexionBD (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null){
                System.out.println("conexion ok"+ conn);
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("falla en el driver"+ ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("falla en el driver"+ ex.getMessage());
        }
    }
    public Connection conectar()
    {
        return conn;
    }
    public void desconectar(){
        try {
            System.out.println("cerrando la base de datos"+ conn);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("error de sql"+ ex.getMessage());
        }
    }
}
