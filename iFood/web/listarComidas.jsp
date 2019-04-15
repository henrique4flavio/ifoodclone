<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>


    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

    <!-- Include Bootstrap CSS -->

    <!-- Include SmartCart CSS -->
    <link href="vendor/css/smart_cart.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/style.css" />
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/font-awesome.css" />
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/animate.css">
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/responsive.css" />
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap3.min.css">

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
                <div class="menu fixed">
                    <div class="mobile-nav-container"> </div>
                    <nav>
                        <ul>
                            <li><img src="imagens/ifood-logo.png" width="90" align="left"></li>
                        </ul>
                    </nav>
                </div>
                <div class="login">
                    <ul>
                        <li><i class="fa fa-percent"></i>
                        <li><a href="#">Promoções</a></li>
                        <li><a href="#">Meus Pedidos</a></li>
                        <li><a href="LoginController?acao=logout">Sair</a></li>

                    </ul>
                </div>
            </div>
        </div>
    </div>


    <section class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Products
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <!-- BEGIN PRODUCTS -->
                            <c:forEach items="${Comida}" var="Comida">

                                <div class="col-md-4 col-sm-6">
                                    <div class="sc-product-item thumbnail">
                                        <img src="<c:out value = " ${Comida.foto}" />" alt="imagem" width=200
                                        height=200>
                                        <div class="caption">
                                            <h4 data-name="product_name">
                                                <c:out value="${Comida.nome}" />
                                            </h4>
                                            <p data-name="product_desc">
                                                <c:out value="${Comida.descricao}" />
                                                <p>
                                                    <hr class="line">

                                                    <div>
                                                        <strong class="price pull-left">R$
                                                            <c:out value="${Comida.preco}" /> </strong>

                                                        <input name="product_price" value="<c:out value = "
                                                            ${Comida.preco}" />" type="hidden" />
                                                        <input name="product_id" value="<c:out value = "
                                                            ${Comida.id}" />" type="hidden" />
                                                        <button
                                                            class="sc-add-to-cart btn btn-danger btn-sm pull-right">Adicionar
                                                            ao Carrinho</button>
                                                    </div>
                                                    <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                            <!-- END PRODUCTS -->
                        </div>
                    </div>
                </div>

            </div>

            <aside class="col-md-4">

                <!-- Cart submit form -->
                <form action="FrontController?pacote=pedido&action=EfetuarPedido&id=${restaurante.id}" method="POST">
                    <!-- SmartCart element -->
                    s <div id="smartcart"></div>
                    <a class='msg-sucesso sucesso-pedido'>

                        <div id="smartcart">
                            <h4>&nbsp;Frete = R$ ${restaurante.valorDoFrete}</h4>
                        </div>
                </form>

            </aside>
        </div>
    </section>



    <br><br><br><br><br><br><br><br><br><br>

    <footer class="saction9 ">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <center>
                        <div class="email">&copy;LP5 - Padrões de Projeto 2019 / iFood </div>
                    </center>
                    <center>
                        <p class="freetemplates">Jonathas Flavio Laís</a></p>
                    </center>
                </div>
            </div>
        </div>
    </footer>

    <!-- Include jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" type="text/javascript"></script>
    <!-- Include SmartCart -->
    <script src="vendor/js/jquery.smartCart.js" type="text/javascript"></script>
    <!-- Initialize -->
    <script type="text/javascript">
        $(document).ready(function () {
            // Initialize Smart Cart    	
            $('#smartcart').smartCart();
        });
    </script>
</body>

</html>