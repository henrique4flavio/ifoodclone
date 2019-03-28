<%-- 
    Document   : administradorHome
    Created on : 27/03/2019, 11:55:29
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
        <li class="dropdown"><a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i class="fa fa-user fa-lg"></i></a>
          <ul class="dropdown-menu settings-menu dropdown-menu-right">
            <li><a class="dropdown-item" href="/iFood"><i class="fa fa-sign-out fa-lg"></i> Logout</a></li>
          </ul>
        </li>
        <h1>Bem vindo ${administrador.nome}</h1>
        
       <form action="FrontController?pacote=restaurante&action=CadastrarRestaurante" method="post">
            Nome:
            <input type="text" name="textNome"/><br/>

            Email:
            <input type="text" name="textEmail"/><br/>
            Senha:
            <input type="text" name="textSenha"/><br/>
            Categoria:
            <input type="text" name="textCategoria"/><br/>
            Valor do Frete:
            <input type="text" name="textValorDoFrete"/><br/>
            Hora de Abrir:
            <input type="text" name="textHoraDeAbrir"/><br/>
            Hora de Fechar:
            <input type="text" name="textHoraDeFechar"/><br/>
            Descricao:
            <input type="text" name="textDescricao"/><br/>
            Foto:
            <input type="file" name="foto" size="50"/> 

            <input type="submit" value="Cadastrar"/>


        </form>


    </body>
</html>
