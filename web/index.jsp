<%@page import="com.emergentes.modelo.Blog"%>
<%@page import="java.util.List"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    if (session.getAttribute("logueado")!= "OK")
    {
        response.sendRedirect("login.jsp");
    }
%>

<%
    List<Blog> lista = (List<Blog>)request.getAttribute("lista");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="inicio">
            <span>Usuario :${sessionScope.usuario}</span>  
            <span><a href="login.jsp">Salir</a></span>
        </div>
        <header>
            <h1>BLOG DE ANIME</h1>
        </header>
        
        <a href="MainController?op=nuevo" class="nuevo">NUEVA ENTRADA</a>
        <br>   
        <c:forEach var="item" items="${lista}">
        <hr>  
        <div class="fecha">
            ${item.fecha}
        </div>
            <br>
            <div class="titulo">
                ${item.titulo}<br>
            </div>
            <div class="conte">
                ${item.contenido}<br>
            </div>  
            <div class="consulta">
                <a href="MainController?op=editar&id=${item.id}">modificar</a>
                <a href="MainController?op=eliminar&id=${item.id}" onclick="return(confirm('esta seguro?'))">eliminar</a><br>
            </div>  

                <p class="autor">autor :${sessionScope.usuario} </p>
           
             </c:forEach>
        </table>
    </body>
</html>