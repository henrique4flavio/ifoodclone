/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.action.comida;

import com.ifood.controller.Action;
import com.ifood.persistence.ComidaDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarComidasAction implements Action {

    private Object view;

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {

            int restauranteId = Integer.parseInt(request.getParameter("id"));

            request.setAttribute("Comida", ComidaDAO.getInstance().list(restauranteId));
            RequestDispatcher view
                    = request.getRequestDispatcher("/listarComidas.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ListarComidasAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
        }
    }

}
