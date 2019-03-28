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
        <h1>Restaurantes</h1>
        <table border='1'>    
            <tr>       
                <th>Restaurante</th>
                <th>Remetente</th>
                <th>Destinatario</th>
                <th>Situação</th>


            </tr>    

            <c:forEach items="${Restaurante}" var="Restaurante">
                <tr>

                    <td><c:out value = "${Restaurante.nome}" /></td>
                    <td><c:out value = "${Restaurante.email}" /></td>
                    <td><c:out value = "${Restaurante.descricao}" /></td>
                    <td><c:out value = "${Restaurante.horaDeAbrir}" /></td>
                    <td><c:out value = "${Restaurante.horaDeFechar}" /></td>
                    <td><c:out value = "${Restaurante.categoria}" /></td>
                    <td><c:out value = "${Restaurante.valorDoFrete}" /></td>
                    <td><img src="ImagemUpController?acao=displayImagem&id=${Restaurante.id}" /></td>

                </tr>
            </c:forEach>
        </table>
        <form action ="index.jsp" method="post">
            <input type="submit" value="Novo Restaurante"/>
        </form>                    


    </body>
</html>
