/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ifood.model.Administrador;
import com.ifood.model.Restaurante;
import com.ifood.model.Cliente;
import com.ifood.persistence.AdministradorDAO;
import com.ifood.persistence.ClienteDAO;
import com.ifood.persistence.RestauranteDAO;


public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        String acao = request.getParameter("acao");
        if (acao.equals("logar")) {
            logar(request, response);
        } else {
            if (acao.equals("logout")) {
                logout(request, response);
            }

        }
    }

//    
    private void logar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException, SQLException {

        String email = request.getParameter("textEmail");
        String senha = request.getParameter("textSenha");

        request.setAttribute("msgErro1", null);

        Cliente cliente = ClienteDAO.getInstance().logar(email, senha);
        if (cliente != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("cliente", cliente);
            session.setAttribute("usuario", cliente);
            session.setAttribute("tipo", "cliente");
            RequestDispatcher view = request.getRequestDispatcher("/clienteHome.jsp");
            view.forward(request, response);

        }

        Administrador administrador = AdministradorDAO.getInstance().logar(email, senha);
        if (administrador != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("administrador", administrador);
            session.setAttribute("usuario", administrador);
            session.setAttribute("tipo", "administrador");
            RequestDispatcher view = request.getRequestDispatcher("/administradorHome.jsp");
            view.forward(request, response);
        }

        Restaurante restaurante = RestauranteDAO.getInstance().logar(email, senha);
        if (restaurante != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("restaurante", restaurante);
            session.setAttribute("usuario", restaurante);
            session.setAttribute("tipo", "restaurante");
            RequestDispatcher view = request.getRequestDispatcher("/restauranteHome.jsp");
            view.forward(request, response);
        } else {
            request.setAttribute("msgErro", "Usuário/Senha inválidos!");
            RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
            view.forward(request, response);
        }

    }

    private void logout(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();

        }
        try {
            response.sendRedirect("index.jsp");
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
