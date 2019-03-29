package com.ifood.action.pedido;

import com.ifood.controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifood.model.Pedido;
import com.ifood.persistence.PedidoDAO;
import javax.servlet.ServletException;

/**
 *
 * @author jonat
 */
public class ListarPedidosAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
try {
            request.setAttribute("Pedido", PedidoDAO.getInstance().list());
            RequestDispatcher view
                    = request.getRequestDispatcher("/pedidos.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ListarPedidosAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
        }
    }

    }
    
   