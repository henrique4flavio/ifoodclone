<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Administradors</h1>
        <table border='1'>    
            <tr>       
                <th>Nome</th>
                <th>Email</th>



            </tr>    

            <c:forEach items="${Administrador}" var="Administrador">
                <tr>

                    <td><c:out value = "${Administrador.nome}" /></td>
                    <td><c:out value = "${Administrador.email}" /></td>



                    <td>
                        <form action ="FrontController?pacote=administrador&action=EditarAdministrador&id=${Administrador.id}" method="post">
                            <input type="submit" value="Editar"/>
                        </form>
                        <form action ="FrontController?pacote=administrador&action=ApagarAdministrador&id=${Administrador.id}" method="post">
                            <input type="submit" value="Apagar"/>
                        </form>

                    </td>

                </tr>
            </c:forEach>
        </table>
        <form action ="index.jsp" method="post">
            <input type="submit" value="Novo Administrador"/>
        </form>                    


    </body>
</html>
