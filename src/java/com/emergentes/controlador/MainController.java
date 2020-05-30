package com.emergentes.controlador;

import com.emergentes.modelo.Blog;
import com.emergentes.utiles.ConexionBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


            String op;
            op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
            ArrayList<Blog> lista = new ArrayList<Blog>();            
            ConexionBD canal = new ConexionBD();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;

            if (op.equals("list")) {
                try {
                    String sql = "select * from blog";
                    ps = conn.prepareStatement(sql);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        Blog lib = new Blog();
                        lib.setId(rs.getInt("id"));
                        lib.setFecha(rs.getString("fecha"));
                        lib.setTitulo(rs.getString("titulo"));
                        lib.setContenido(rs.getString("contenido"));
                        lista.add(lib);
                    }
                    
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("error en SQL "+ex.getMessage());
                } finally {
                    canal.desconectar();
                }
            }
           if (op.equals("nuevo")) {
                Blog b = new Blog();
                request.setAttribute("blog", b);
                request.getRequestDispatcher("editar.jsp").forward(request, response);

            }
            if (op.equals("eliminar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                try{    
                    String sql = "delete from blog where id = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, id);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println("error en SQL "+ex.getMessage());
                } finally {
                    canal.desconectar();
                }
                response.sendRedirect("MainController");
            }
            if(op.equals("editar"))
            {
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String sql = "select * from blog where id = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, id);
                    rs = ps.executeQuery();
                    Blog bl = new Blog();
                    while (rs.next()) {
                        
                        bl.setId(rs.getInt("id"));
                        bl.setFecha(rs.getString("fecha"));
                        bl.setTitulo(rs.getString("titulo"));
                        bl.setContenido(rs.getString("contenido")); 
                    }
                    request.setAttribute("blog", bl);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                } catch (SQLException ex) {
                  System.out.println("error en SQL "+ex.getMessage());
                }
       
            }
        
        } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        
        Blog obj = new Blog();
        obj.setId(id);
        obj.setFecha(fecha);
        obj.setTitulo(titulo);
        obj.setContenido(contenido);
        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        if (id == 0){
            try {
                String sql = "insert into blog (titulo, contenido) values (?,?)";               
                ps = conn.prepareStatement(sql);
                ps.setString(1, obj.getTitulo());
                ps.setString(2, obj.getContenido());                
                ps.executeUpdate();                
            } catch (SQLException ex) {
                    System.out.println("error en SQL "+ex.getMessage());
                } finally {
                    canal.desconectar();
                }   response.sendRedirect("MainController");            
        }
         // si el registr ya existe
        else{
            try {
                String sql = "update blog set titulo =?, contenido =? where id = ?";
                ps = conn.prepareStatement(sql);                
                ps.setString(1, obj.getTitulo());
                ps.setString(2, obj.getContenido());
                ps.setInt(3, obj.getId());
                ps.executeUpdate(); 
                
                sql = "update blog set fecha = ? where id = ?";
                ps = conn.prepareStatement(sql);                
                ps.setString(1, obj.getFecha());
                ps.setInt(2, obj.getId());
                
                
                ps.executeUpdate();  
            } catch (SQLException ex) {
                System.out.println("error al actualizar"+ex.getMessage());
            }
            response.sendRedirect("MainController");            
        }  

    }

}
