<%-- 
    Document   : login
    Created on : 27/03/2019, 11:12:22
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ifood</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">    
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100" style="background-image: url('images/capa.png');">
                <div class="wrap-login100 p-t-30 p-b-50">
                    <br><br>
                    <span class="login100-form-title p-b-41">
                        Entre ou Cadastre-se
                    </span>
                    <form class="login100-form validate-form p-b-33 p-t-5" action="LoginController?acao=logar" method="post">

                        <div class="wrap-input100 validate-input" data-validate = "Enter username">
                            <input class="input100" type="text" name="textEmail" placeholder="Email">
                            <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Enter password">
                            <input class="input100" type="password" name="textSenha" placeholder="Senha">
                            <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                        </div>

                        <div class="container-login100-form-btn m-t-32">
                            <button class="login100-form-btn">
                                Entrar
                            </button>
                        </div>
                        <center><a href="menu.jsp">Não tenho Cadastro!</a></center>

                    </form>
                </div>
            </div>
        </div>

        <div id="dropDownSelect1"></div>
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>
