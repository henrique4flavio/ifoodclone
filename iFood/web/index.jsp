<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ifood</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">    
        <link rel="stylesheet" type="text/css" href="vendor/css/util.css">
        <link rel="stylesheet" type="text/css" href="vendor/css/main.css">
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100" style="background-image: url('vendor/images/capa.png');">
                <div class="wrap-login100 p-t-30 p-b-50">
                    <br><br>
                    <span class="login100-form-title p-b-41">
                        Entre ou Cadastre-se
                    </span>
                    <c:if test="${msgErro == true}">
                        <div class="alert col-md-12 col-sm-12 alert-icon alert-danger alert-dismissible fade in" role="alert" >
                            <div class="col-md-2 col-sm-2 icon-wrapper text-center">
                                <div class="col-md-10 col-sm-10">
                                    <strong style="color: #F00">Erro. Usuário ou Senha Incorretos! </strong> 
                                </div>
                            </div>
                        </c:if>
                        <form class="login100-form validate-form p-b-33 p-t-5" action="FrontController?pacote=login&action=Login" method="post">

                            <div class="wrap-input100 validate-input" data-validate = "Enter username">
                                <input class="input100" type="text" name="textEmail" placeholder="Email" required="">
                                <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                            </div>

                            <div class="wrap-input100 validate-input" data-validate="Enter password">
                                <input class="input100" type="password" name="textSenha" placeholder="Senha" required="">
                                <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                            </div>

                            <div class="container-login100-form-btn m-t-32">
                                <button class="login100-form-btn">
                                    Entrar
                                </button>
                            </div>
                            <center><a href="cadastrarCliente.jsp">Não tenho Cadastro!</a></center>
                            <!--                        <center><a href="menu.jsp">Não tenho Cadastro!</a></center>-->

                        </form>
                    </div>
                </div>
            </div>

            <div id="dropDownSelect1"></div>
            <script src="vendor/bootstrap/js/popper.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
            <script src="vendor/js/main.js"></script>

    </body>
</html>
