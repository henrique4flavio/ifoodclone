

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                </li>


                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                    <div class="sidebar-brand-text mx-3">Bem Vindo ${administrador.nome} <sup>;)</sup></div>
                </a>

                <hr class="sidebar-divider my-0">

                <li class="nav-item active">
                    <a class="nav-link" href="index.html">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span></a>
                </li>

                <hr class="sidebar-divider">

                <li class="nav-item">
                    <a class="nav-link" href="charts.html">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>Alterar dados do Administrador</span></a>
                </li>




                <hr class="sidebar-divider d-none d-md-block">
            </ul>

            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

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

                    <div class="container-fluid">


                        <div class="container">
                            <div class="mt-5 mb-5 text-center">
                                <h2>Cadastro de Restaurantes</h2>
                            </div>
                            <ul class="step d-flex flex-nowrap">
                                <li class="step-item active">
                                    <a href="#!" class="">Informações do Restaurante</a>
                                </li>
                                <li class="step-item">
                                    <a href="#!" class="">Logo do Restaurante</a>
                                </li>

                            </ul> 


                            <form class="form-horizontal" action="FrontController?pacote=restaurante&action=CadastrarRestaurante" method="post">

                                <!-- Text input-->

                                <div class="form-group">
                                    <label class="col-md-4 control-label" >Nome : </label>  
                                    <div class="col-md-6">
                                        <input id="txtproduto" name="textNome" type="text"  class="form-control input-md" required="">

                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" >E-mail : </label>  
                                    <div class="col-md-6">
                                        <input id="txtproduto" name="textEmail" type="text"  class="form-control input-md" required="">

                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" >Senha : </label>  
                                    <div class="col-md-6">
                                        <input id="txtproduto" name="textSenha" type="text"  class="form-control input-md" required="">

                                    </div>
                                </div>

                                <!-- Select Basic -->
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Categoria : </label>
                                    <div class="col-md-4">
                                        <select id="txtgrupo" name="textCategoria" class="form-control">
                                            <option value="Hamburgeria">Hamburgeria</option>
                                            <option value="Pizzaria">Pizzaria</option>
                                            <option value="Comida Japonesa">Comida Japonesa</option>
                                            <option value="Churrascaria">Churrascaria</option>
                                            <option value="Pastelaria">Pastelaria</option>
                                            <option value="Lanchonete">Lanchonete</option>
                                            <option value="Restaurante de fast food">Restaurante de fast food</option>
                                            <option value="Bar">Bar</option>
                                        </select>
                                    </div>
                                </div>



                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Taxa de Frete R$: </label>  
                                    <div class="col-md-2">
                                        <input id="txtestoque_minimo" name="textValorDoFrete" type="number" placeholder="" class="form-control input-md" required="">

                                    </div>
                                </div>

                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Hora de Abrir : </label>  
                                    <div class="col-md-2">
                                        <input id="txtestoque_atual" name="textHoraDeAbrir" type="time" placeholder="" class="form-control input-md">

                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label">Hora de Fechar : </label>  
                                    <div class="col-md-2">
                                        <input id="txtestoque_atual" name="textHoraDeFechar" type="time" placeholder="" class="form-control input-md">

                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label">Descrição : </label>  
                                    <div class="col-md-6">
                                        <input id="txtproduto" name="textDescricao" type="text" placeholder="Descrição do Restaurante" class="form-control input-md" required="">

                                    </div>
                                </div>


                                <!-- Button (Double) -->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="btnsalvar"></label>
                                    <div class="col-md-8">
                                        <input type="submit" value="Cadastrar"  class="btn btn-primary">
                                    </div>
                                </div>

                            </form>
                        </div>


                    </div>
                </div>

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
