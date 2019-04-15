/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.action.comida;

import com.ifood.controller.Action;
import com.ifood.persistence.ComidaDAO;
import com.ifood.persistence.RestauranteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListarComidasAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int restauranteId = Integer.parseInt(request.getParameter("id"));


            boolean create = true;
            HttpSession session = request.getSession(create);
            String usuario = (String) session.getAttribute("tipo");
            if (usuario.equals("restaurante")) {
                request.setAttribute("restaurante", RestauranteDAO.getInstance().getRestauranteById(restauranteId));
                request.setAttribute("Comida", ComidaDAO.getInstance().list(restauranteId));

                RequestDispatcher view = request.getRequestDispatcher("/listarComidasRestaurante.jsp");
                view.forward(request, response);

            }
            if (usuario.equals("cliente")) {
              request.setAttribute("Comida", ComidaDAO.getInstance().list(restauranteId));
              request.setAttribute("restaurante", RestauranteDAO.getInstance().getRestauranteById(restauranteId));

                RequestDispatcher view = request.getRequestDispatcher("/listarComidas.jsp");
                view.forward(request, response);

            }
        } catch (ServletException ex) {
            Logger.getLogger(ListarComidasAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarComidasAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListarComidasAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
