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

        <title>iFood</title>

        <!-- Custom fonts for this template-->
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="vendor/css/sb-admin-2.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">



                <li class="nav-item active">
                    <a class="nav-link" href="index.html">
                        <img src="${restaurante.foto}" alt="logo" width=190 height=160>
                        </li>


                        <!-- Sidebar - Brand -->
                        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                            <div class="sidebar-brand-text mx-3">Bem Vindo ${restaurante.nome} <sup>;)</sup></div>
                        </a>

                        <hr class="sidebar-divider my-0">

                        <li class="nav-item active">
                            <a class="nav-link" href="index.html">
                                <i class="fas fa-fw fa-tachometer-alt"></i>
                                <span>Dashboard</span></a>
                        </li>

                        <hr class="sidebar-divider">

                        <li class="nav-item">
                            <a class="nav-link" href="FrontController?pacote=login&action=Logout">
                                <i class="fas fa-fw fa-chart-area"></i>
                                <span>Logout</span></a>
                        </li>




                        <hr class="sidebar-divider d-none d-md-block">
                        </ul>

                        <div id="content-wrapper" class="d-flex flex-column">

                            <!-- Main Content -->
                            <div id="content">

                                <!-- Topbar -->
                                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                                    <img src="imagens/ifood-logo.png" width="90" align="left">

                                    <!-- Sidebar Toggle (Topbar) -->
                                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                                        <i class="fa fa-bars"></i>
                                    </button>

                                    <!-- Topbar Navbar -->
                                    <ul class="navbar-nav ml-auto">

                                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                                        <li class="nav-item dropdown no-arrow d-sm-none">
                                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <i class="fas fa-search fa-fw"></i>
                                            </a>
                                            <!-- Dropdown - Messages -->
                                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                                <form class="form-inline mr-auto w-100 navbar-search">
                                                    <div class="input-group">
                                                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                                        <div class="input-group-append">
                                                            <button class="btn btn-primary" type="button">
                                                                <i class="fas fa-search fa-sm"></i>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </li>        
                                    </ul>

                                </nav>
                                <!-- End of Topbar -->

                                <!-- Begin Page Content -->

                                <div class="container-fluid">
                                    
                                        <!-- Page Heading -->

                                        <!-- DataTales Example -->
                                        <div class="card shadow mb-4">
                                            <div class="card-header py-3">
                                                <h6 class="m-0 font-weight-bold text-primary">Lista de Pedidos </h6>
                                            </div>
                                            <div class="card-body">
                                                <div class="table-responsive">
                                                    <span style="margin-left: 750px; color: #F00"> ${mensagem} </span>
                                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                                        <thead>
                                                            <tr>
                                                                <th>Codigo</th>
                                                                <th>Data e Hora</th>

                                                                <th>Cliente</th>
                                                                <th>Endereço de Entrega</th>
                                                                <th>Pedido</th> 
                                                                <th>Total R$</th>
                                                                <th>Status</th>
                                                                <th>Ação</th>

                                                            </tr>
                                                        </thead>
                                                        <tfoot>
                                                            <tr>
                                                                <th>Codigo</th>
                                                                <th>Data e Hora</th>

                                                                <th>Cliente</th>
                                                                <th>Endereço de Entrega</th>
                                                                <th>Pedido</th> 
                                                                <th>Total R$</th>
                                                                <th>Status</th>
                                                                <th>Ação</th>

                                                            </tr>
                                                        </tfoot>
                                                        <tbody>
                                                            <c:forEach items="${Pedido}" var="Pedido">


                                                                <tr>

                                                                    <td><c:out value = "${Pedido.id}" /></td>
                                                                    <td><c:out value = "${Pedido.data}" /></td>

                                                                    <td><c:out value = "${Pedido.cliente.nome}" /></td>
                                                                    <td><c:out value = "${Pedido.cliente.rua} ${Pedido.cliente.numero} ${Pedido.cliente.bairro} CEP: ${Pedido.cliente.cep}" /></td>
                                                                    <td>

                                                                        <c:forEach items="${PedidoComida}" var="PedidoComida">
                                                                            <c:if  test="${PedidoComida.pedido.id  == Pedido.id}"> 
                                                                                <c:out value = "${PedidoComida.comida.nome}" /> qtd: <c:out value = "${PedidoComida.quantidade}" />

                                                                            </c:if>

                                                                        </c:forEach>
                                                                    </td>

                                                                    <td><c:out value = "${Pedido.precoTotal}" /></td>
                                                                    <td><c:out value = "${Pedido.estado.estado}" /></td>

                                                                    <td>
                                                                        <form action ="FrontController?pacote=pedido&action=ConfirmarPedido&id=${Pedido.id}&restauranteId=${restaurante.id}" method="post">
                                                                            <input type="submit" value="Confirmar"/>
                                                                        </form>
                                                                        <form action ="FrontController?pacote=pedido&action=EnviarPedido&id=${Pedido.id}&restauranteId=${restaurante.id}" method="post">
                                                                            <input type="submit" value="Enviar"/>
                                                                        </form>
                                                                        <form action ="FrontController?pacote=pedido&action=EntregarPedido&id=${Pedido.id}&restauranteId=${restaurante.id}" method="post">
                                                                            <input type="submit" value="Entregar"/>
                                                                        </form>



                                                                    </td>



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
