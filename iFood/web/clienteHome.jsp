<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>iFood</title>
        <link href='https://fonts.googleapis.com/css?family=Lobster+Two:400,700' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600,300,700' rel='stylesheet' type='text/css' />

        <!--MOBILE DEVICE-->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>

        <!--CSS-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/style.css"/>
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/font-awesome.css"/>
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/animate.css">
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/responsive.css"/>
        <!--JS-->

        <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="js/modernizr.js"></script>
        <script src="js/scripts.js"></script>
        <script src="js/waypoints.min.js"></script>
    </head>

    <body>
        <!-- Paste this code after body tag -->
        <!-- Ends -->


        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <div class="menu fixed">
                        <div class="mobile-nav-container"> </div>
                        <div class="mobile-nav-btn"><img class="nav-open" src=					      "https://s3-us-west-2.amazonaws.com/s.cdpn.io/6214/nav-open.png" alt="Nav Button Open" /> <img class="nav-close" src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/6214/nav-close.png" alt="Nav Button Close" /> </div>
                        <nav>
                            <ul>
                                <li><img src="imagens/ifood-logo.png" width="90" align="left"></li>			
                            </ul>
                        </nav>
                    </div>
                    <div class="login">
                        <ul>
                            <li><i class="fa fa-percent"></i>
                                <a href="#">Promoções</a></li>
                            <li><a href="#">Meus Pedidos</a></li>
                            <li><a href="LoginController?acao=logout">Sair</a></li>

                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">

            <div class="col-md-9">
                <p>

                    <span class="contactcor border"> <h5>Bem-Vindo ${cliente.nome}</h5></span><br>
                    <img src="imagens/icon.png" width="6%"> 

                    <span>ENDEREÇO DE ENTREGA: </span>
                    <span>${cliente.rua} ${cliente.numero} ${cliente.bairro} </span><br> <span>CEP: ${cliente.cep}</span>
                </p>

            </div>




        </div>





        <section class="saction3">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <div class="ordaring">
                            <h2 class="os-animation" data-os-animation="zoomIn" data-os-animation-delay="0.50s">Faça seu pedido rápido!</h2>
                            <div class="dotted os-animation" data-os-animation="bounceInLeft" data-os-animation-delay="1s"></div>
                            <p class="os-animation" data-os-animation="zoomIn" data-os-animation-delay="0.50s">Em apenas 4 etapas</p>
                            <div class="dotted1 os-animation" data-os-animation="bounceInRight" data-os-animation-delay="1s"></div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3 col-md-3 col-sm-6">
                        <figure class="step os-animation" data-os-animation="fadeInLeft" data-os-animation-delay="0.50s"> <img src="imagens/one.png" alt="" /> </figure>
                        <div class="arrow" > <img src="imagens/arrow.png" alt="" /> </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-6">
                        <figure class="step os-animation" data-os-animation="fadeInLeft" data-os-animation-delay="1.5s"> <img src="imagens/two.png" alt="" /> </figure>
                        <div class="arrow1 "> <img src="imagens/arrow.png" alt="" /> </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-6">
                        <figure class="step os-animation" data-os-animation="fadeInLeft" data-os-animation-delay="2.5s"> <img src="imagens/thrww.png" alt="" /> </figure>
                        <div class="arrow"> <img src="imagens/arrow.png" alt="" /> </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-6">
                        <figure class="step1 os-animation" data-os-animation="fadeInLeft" data-os-animation-delay="3.5s"> <img src="imagens/four.png" alt="" /> </figure>
                    </div>
                </div>
            </div>
        </section>

        <section class="saction1">
            <br><br>

            <div class="container" id="offer">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 border-secondary">
                        <div class="dotted3 os-animation" data-os-animation="bounceInLeft" data-os-animation-delay="2s"></div>
                        <div class="special">
                            <h2 class="os-animation" data-os-animation="bounceInDown" data-os-animation-delay="0.50s">Restaurantes</h2>
                            <div class="dotted4 os-animation" data-os-animation="bounceInRight" data-os-animation-delay="2s"></div>
                        </div>
                    </div>
                </div>

                <c:forEach items="${Restaurante}" var="Restaurante">

                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <div class="slider clearfix os-animation" data-os-animation="fadeInDown
                             " data-os-animation-delay="0.20s">
                            <div class="img clearfix"> <img src="<c:out value = "${Restaurante.foto}"/>" alt="imagem" width=100 height=100> </div>
                            <div class="title clearfix">
                                <h3><c:out value = "${Restaurante.nome}"/></h3>
                                <p><c:out value = "${Restaurante.descricao}"/> </p>
                                <a href="FrontController?pacote=comida&action=ListarComidas&id=<c:out value = "${Restaurante.id}"/>">FAZER PEDIDO &#10152;</a> </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </section>

        <footer class="saction9">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <center><div class="email">&copy;LP5 - Padrões de Projeto 2019  / iFood </div></center>
                        <center> <p class="freetemplates">Jonathas Flavio Laís</a></p> </center>
                    </div>
                </div>
            </div>
        </footer>
        <script type="text/javascript" src="js/sidemenu.js"></script>
    </body>
</html>

