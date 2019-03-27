/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.action.cliente;

import com.ifood.controller.Action;
import com.ifood.model.Cliente;
import com.ifood.persistence.ClienteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonat
 */
public class CadastrarClienteAction implements Action{
   

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        String senha = request.getParameter("textSenha");
        String cpf = request.getParameter("textCpf");
        String rua = request.getParameter("textRua");
        String numero = request.getParameter("textNumero");
        String bairro = request.getParameter("textBairro");
        String cep = request.getParameter("textCep");



        Cliente cliente = new Cliente(cpf, rua, numero, bairro, cep, nome, senha, email);

        try {
            ClienteDAO.getInstance().save(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            request.getRequestDispatcher("index.jsp").include(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CadastrarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
