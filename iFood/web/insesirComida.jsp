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
         <a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i class="fa fa-user fa-lg"></i></a>
          <ul class="dropdown-menu settings-menu dropdown-menu-right">
            <li><a class="dropdown-item" href="/iFood"><i class="fa fa-sign-out fa-lg"></i> Logout</a></li>
          </ul>
        <h1>Bem Vindo ${restaurante.nome}</h1>
        
         
        
        <img src="${restaurante.foto}" alt="logo" width=100 height=80>

        
    <form action="FrontController?pacote=comida&action=CadastrarComida&id=${usuario.id}" method="post">
            Nome:
            <input type="text" name="textNome"/><br/>          
            Descrição
            <input type="text" name="textDescricao"/><br/>
            Preço do prato:
            <input type="text" name="textPreco"/><br/>
        
            
            
                       
            <input type="submit" value="Cadastrar"/>

            
        </form>
        
        
          

            
        
    </body>
</html>
