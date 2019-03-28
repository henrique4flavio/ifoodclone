<%-- 
    Document   : restauranteHome
    Created on : 27/03/2019, 11:55:44
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bem Vindo ${restaurante.nome}</h1>
        
        
        <form action="ImagemUpController?acao=uploadImagem&id=${restaurante.id}" method="post" enctype="multipart/form-data">
            
            <input type="file" name="foto"/><br/>
        
            
            <input type="submit" value="Cadastrar"/>

            
        </form>
        
    </body>
</html>
