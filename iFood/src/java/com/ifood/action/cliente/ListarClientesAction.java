/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.action.cliente;

import com.ifood.controller.Action;
import com.ifood.persistence.ClienteDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LaisAlves
 */
public class ListarClientesAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
 try {
            request.setAttribute("Cliente", ClienteDAO.getInstance().list());
            RequestDispatcher view
                    = request.getRequestDispatcher("/clientes.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ListarClientesAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
        }
    }
    }
    

