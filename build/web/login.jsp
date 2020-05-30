
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section>
            <h1>AUTENTIFICACION</h1>
            <form action="LoginControlador" method="post">
                <label>USUARIO</label>
                <input type="text" name="usuario">
                <label>CONTRASEÑA</label>
                <input type="password" name="pasword">
                <input class="boton" type="submit" value="ACCEDER">
            </form>
        </section>
    </body>
</html>

