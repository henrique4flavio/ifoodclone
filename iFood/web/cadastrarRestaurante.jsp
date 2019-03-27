<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Cadastro de Restaurantes</h1>
        
        
        
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
            <input type="file" accept="image/png,image/jpeg,image/gif" name="foto"/><br/>

            
            <input type="submit" value="Cadastrar"/>

            
        </form>

    </body>
</html>
