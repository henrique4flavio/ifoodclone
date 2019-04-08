<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>

<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
                <script src="vendor/js/cadastro.js" type="text/javascript"></script>

    </head>
    <body>

        <form class="form-horizontal" action="FrontController?pacote=cliente&action=CadastrarCliente" method="post">


                <div class="form-group">

                    <div class="col-md-11 control-label">
                        <p class="help-block">* Campo Obrigatório </p>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-2 control-label" for="Nome">Nome *</label>  
                    <div class="col-md-8">
                        <input id="Nome" name="textNome" placeholder="" class="form-control input-md" required="" type="text">
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-2 control-label" for="Nome">CPF *</label>  
                    <div class="col-md-2">
                        <input id="cpf" name="textCpf" placeholder="Apenas números" class="form-control input-md" required="" type="text" maxlength="11" pattern="[0-9]+$">
                    </div>

                <!-- Prepended text-->
                <div class="form-group">
                    <label class="col-md-2 control-label" for="prependedtext">Telefone *</label>
                    <div class="col-md-2">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                            <input id="prependedtext" name="textTelefone" class="form-control" placeholder="XX XXXXX-XXXX" required="" type="text" maxlength="13" pattern="\[0-9]{2}\ [0-9]{4,6}-[0-9]{3,4}$"
                                   OnKeyPress="formatar('## #####-####', this)">
                        </div>
                    </div>
                </div> 

                <!-- Prepended text-->
                <div class="form-group">
                    <label class="col-md-2 control-label" for="prependedtext">Email *</label>
                    <div class="col-md-5">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                            <input id="prependedtext" name="textEmail" class="form-control" placeholder="email@email.com" required="" type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" >
                        </div>
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-md-2 control-label" for="prependedtext">Senha *</label>
                    <div class="col-md-5">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input type="password" name="textSenha" class="form-control" placeholder="Senha">
                        </div>
                    </div>
                </div>


                <!-- Search input-->
                <div class="form-group">
                    <label class="col-md-2 control-label" for="CEP">CEP *</label>
                    <div class="col-md-2">
                        <input id="cep" name="textCep" placeholder="Apenas números" class="form-control input-md" required="" value="" type="search" maxlength="8" pattern="[0-9]+$">
                    </div>
                    <div class="col-md-2">
                        <button type="button" class="btn btn-primary" onclick="pesquisacep(cep.value)">Pesquisar</button>
                    </div>
                </div>

                <!-- Prepended text-->
                <div class="form-group">
                    <label class="col-md-2 control-label" for="prependedtext">Endereço</label>
                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon">Rua</span>
                            <input id="rua" name="textRua" class="form-control" placeholder="" required="" readonly="readonly" type="text">
                        </div>
                    </div>

                    <div class="col-md-2">
                        <div class="input-group">
                            <span class="input-group-addon">Nº *</span>
                            <input id="numero" name="textNumero" class="form-control" placeholder="" required=""  type="text">
                        </div>

                    </div>

                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon">Bairro</span>
                            <input id="bairro" name="textBairro" class="form-control" placeholder="" required="" readonly="readonly" type="text">
                        </div>

                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-2 control-label" for="prependedtext"></label>
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon">Cidade</span>
                            <input id="cidade" name="textCidade" class="form-control" placeholder="" required=""  readonly="readonly" type="text">
                        </div>
                    </div>

                    <div class="col-md-2">
                        <div class="input-group">
                            <span class="input-group-addon">Estado</span>
                            <input id="estado" name="textEstado" class="form-control" placeholder="" required=""  readonly="readonly" type="text">
                        </div>                         
                    </div>
                </div>

                <!-- Button (Double) -->
                <div class="form-group">
                    <label class="col-md-2 control-label" for="Cadastrar"></label>
                    <div class="col-md-8">
                        <button id="Cadastrar" name="Cadastrar" class="btn btn-success" type="Submit">Cadastrar</button>
                        <button id="Cancelar" name="Cancelar" class="btn btn-danger" type="Reset">Cancelar</button>
                    </div>
                </div>

            </div>
        </form>
    </body>
</html>