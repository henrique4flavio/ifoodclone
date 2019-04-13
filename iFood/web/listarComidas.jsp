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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Include Bootstrap CSS -->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap3.min.css">

        <!-- Include SmartCart CSS -->
        <link href="vendor/css/smart_cart.min.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <br />
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
                                            <img src="<c:out value = "${Comida.foto}"/>" alt="imagem" width=200 height=200>
                                            <div class="caption">
                                                <h4 data-name="product_name"><c:out value = "${Comida.nome}" /></h4>
                                                <p data-name="product_desc"><c:out value = "${Comida.descricao}" /><p>
                                                <hr class="line">

                                                <div>
                                                    <strong class="price pull-left">R$<c:out value = "${Comida.preco}" /> </strong>

                                                    <input name="product_price" value="<c:out value = "${Comida.preco}" />" type="hidden" />
                                                    <input name="product_id" value="<c:out value = "${Comida.id}" />" type="hidden" />
                                                    <button class="sc-add-to-cart btn btn-success btn-sm pull-right">Adicionar ao Carrinho</button>
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
                    <form action="FrontController?pacote=pedido&action=EfetuarPedido&id=27" method="POST"> 
                        <!-- SmartCart element -->
                        <div id="smartcart"></div>
                    </form>

                </aside>
            </div>
        </section>

        <!-- Include jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" type="text/javascript" ></script>
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
