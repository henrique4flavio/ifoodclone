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

        <h1>Cadastro de Cliente</h1>
        
        
        
        <form action="FrontController?pacote=cliente&action=CadastrarCliente" method="post">
            Nome:
            <input type="text" name="textNome"/><br/>
           
            Email:
            <input type="text" name="textEmail"/><br/>
            Senha:
            <input type="text" name="textSenha"/><br/>
            cpf:
            <input type="text" name="textCpf"/><br/>

            rua:
            <input type="text" name="textRua"/><br/>
            numero:
            <input type="text" name="textNumero"/><br/>
            Bairro:
            <input type="text" name="textBairro"/><br/>

            Cep:
            <input type="text" name="textCep"/><br/>


            <input type="submit" value="Cadastrar"/>

            
        </form>

    </body>
</html>
