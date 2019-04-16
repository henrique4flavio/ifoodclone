<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/style.css"/>
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap3.min.css">

        <title>iFood</title>

        <!-- Custom fonts for this template-->
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="vendor/css/sb-admin-2.css" rel="stylesheet">

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
                            <li><a href="FrontController?pacote=pedido&action=ListarPedidosCliente&id=${cliente.id}">Meus Pedidos</a></li>
                            <li><a href="FrontController?pacote=login&action=Logout">Sair</a></li>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
        
                                <div class="container-fluid">

                                    <!-- Page Heading -->

                                    <!-- DataTales Example -->
                                    <div class="card shadow mb-4">
                                        <div class="card-header py-3">
                                            <h6 class="m-0 font-weight-bold text-primary">Pedidos de ${cliente.nome}</h6>
                                        </div>
                                        <div class="card-body">
                                            <div class="table-responsive">
                                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                                    <thead>
                                                        <tr>
                                                            <th>Codigo</th>
                                                            <th>Data e Hora</th>
                                                            <th>Restaurante</th>

                                                            <th>Endereço de Entrega</th>
                                                            <th>Pedido</th>

                                                            <th>Total R$</th>
                                                            <th>Status</th>

                                                        </tr>
                                                    </thead>
                                                    
                                                    <tbody>
                                                        <c:forEach items="${Pedido}" var="Pedido">


                                                            <tr>

                                                                <td><c:out value = "${Pedido.id}" /></td>
                                                                <td><c:out value = "${Pedido.data}" /></td>
                                                                <td><c:out value = "${Pedido.restaurante.nome}" /></td>

                                                                <td><c:out value = "${Pedido.cliente.rua} ${Pedido.cliente.numero} ${Pedido.cliente.bairro} CEP: ${Pedido.cliente.cep}" /></td>
                                                                <td>

                                                                    <c:forEach items="${PedidoComida}" var="PedidoComida">
                                                                        <c:if  test="${PedidoComida.pedido.id  == Pedido.id}"> 
                                                                            <c:out value = "${PedidoComida.comida.nome}" />

                                                                        </c:if>

                                                                    </c:forEach>
                                                                </td>

                                                                <td><c:out value = "${Pedido.precoTotal}" /></td>
                                                                <td><c:out value = "${Pedido.estado.estado}" /></td>
                                                                                                                               

                                                            </tr>

                                                        </c:forEach>

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <!-- /.container-fluid -->





                                <!-- Footer -->
                                <footer class="sticky-footer bg-white">
                                    <div class="container my-auto">
                                        <div class="copyright text-center my-auto">
                                            <span>Copyright &copy; Your Website 2019</span>
                                        </div>
                                    </div>
                                </footer>
                            </div>
                        </div>

                        <script src="js/sb-admin-2.js"></script>

                        </body>

                        </html>
