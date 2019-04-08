<%-- 
    Document   : imagem
    Created on : 07/04/2019, 02:22:50
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>TESTE ARQUIVOS</title>
    </head>
    <body>

        <form action="FrontController?pacote=restaurante&action=UploadImagem&id=1" method="post" enctype="multipart/form-data" name="formulario" id="formulario">
            <input type="file" name="arquivo">
                <br>
                    <input type="submit" value="enviar">
        </form>
    </body>
</html>