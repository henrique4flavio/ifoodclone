package com.ifood.action.restaurante;

import com.ifood.controller.Action;
import com.ifood.model.Restaurante;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifood.persistence.RestauranteDAO;
import java.sql.Blob;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

 
public class ListarRestaurantesAction implements Action {

    private Object view;

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {

            request.setAttribute("Restaurante", RestauranteDAO.getInstance().list());
            RequestDispatcher view
                    = request.getRequestDispatcher("/restaurantes.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ListarRestaurantesAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
        }
    }

}

