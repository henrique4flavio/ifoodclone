/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.action.restaurante;

import com.ifood.action.restaurante.ApagarRestauranteAction;
import com.ifood.controller.Action;
import com.ifood.model.Restaurante;
import com.ifood.persistence.RestauranteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author flavi
 */
public class EditarRestauranteAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
int id = Integer.parseInt(request.getParameter("id"));
         Restaurante restaurante = new Restaurante();
        restaurante.setId(id);

        try {
            RestauranteDAO.getInstance().edit(restaurante);
        } catch (SQLException ex) {
            Logger.getLogger(ApagarRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApagarRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("FrontController?action=LerRestaurante");
    }
    

    }