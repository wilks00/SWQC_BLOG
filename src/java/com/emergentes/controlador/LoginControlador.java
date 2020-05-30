
package com.emergentes.controlador;

import com.emergentes.utiles.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginControlador", urlPatterns = {"/LoginControlador"})
public class LoginControlador extends HttpServlet {

 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = (request.getParameter("action") == null) ? "view" : request.getParameter("action");
        if (action.equals("view")) { 
            response.sendRedirect("login.jsp");
        }
        if(action.equals("logout"))
        {   
          HttpSession ses = request.getSession();
          ses.invalidate();
          response.sendRedirect("login.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String usuario = request.getParameter("usuario");
            String pasword = request.getParameter("pasword");
            ResultSet rs;
            ConexionBD canal = new ConexionBD();
            Connection cn = canal.conectar();
            
            String sql = "select * from login where usuario = ? and pass = ? limit 1";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pasword);
            rs = ps.executeQuery();
            
            if(rs.next()) {
                HttpSession ses = request.getSession();
                ses.setAttribute("logueado","OK");
                ses.setAttribute("usuario",usuario);
                response.sendRedirect("MainController");
            }
            else{
                response.sendRedirect("login.jsp");
            }   
        } catch (SQLException ex) {
            System.out.println("falla al abrir la base de datos"+ ex.getMessage());
        }
    }

}
