<%-- 
    Document   : clienteHome
    Created on : 27/03/2019, 11:54:35
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
        <h1>Bem Vindo ${cliente.nome}</h1>
    </body>
</html>
