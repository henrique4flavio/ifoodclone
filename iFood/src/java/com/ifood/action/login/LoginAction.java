/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.action.login;

import com.ifood.controller.Action;
import com.ifood.model.Administrador;
import com.ifood.model.Cliente;
import com.ifood.model.Restaurante;
import com.ifood.persistence.AdministradorDAO;
import com.ifood.persistence.ClienteDAO;
import com.ifood.persistence.RestauranteDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jonat
 */
public class LoginAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setAttribute("msgErro", null);
        try {
            loginAdministrador(request, response);
            loginCliente(request, response);
            loginRestaurante(request, response);
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("msgErro", true);
        RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loginAdministrador(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        String email = request.getParameter("textEmail");
        String senha = request.getParameter("textSenha");
        Administrador administrador = AdministradorDAO.getInstance().logar(email, senha);
        if (administrador != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("administrador", administrador);
            session.setAttribute("usuario", administrador);
            session.setAttribute("tipo", "administrador");
            RequestDispatcher view = request.getRequestDispatcher("/administradorHome.jsp");
            view.forward(request, response);
            
            return;

        }
    }

    public void loginCliente(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        String email = request.getParameter("textEmail");
        String senha = request.getParameter("textSenha");
        Cliente cliente = ClienteDAO.getInstance().logar(email, senha);
        if (cliente != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("cliente", cliente);
            session.setAttribute("usuario", cliente);
            session.setAttribute("tipo", "cliente");
            request.setAttribute("Restaurante", RestauranteDAO.getInstance().list());

            RequestDispatcher view = request.getRequestDispatcher("/clienteHome.jsp");
            view.forward(request, response);

            return;
        }
    }

    public void loginRestaurante(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        String email = request.getParameter("textEmail");
        String senha = request.getParameter("textSenha");
        Restaurante restaurante = RestauranteDAO.getInstance().logar(email, senha);
        if (restaurante
                != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("restaurante", restaurante);
            session.setAttribute("usuario", restaurante);
            session.setAttribute("tipo", "restaurante");
            RequestDispatcher view = request.getRequestDispatcher("/restauranteHome.jsp");
            view.forward(request, response);

            return;

        }
    }

}
