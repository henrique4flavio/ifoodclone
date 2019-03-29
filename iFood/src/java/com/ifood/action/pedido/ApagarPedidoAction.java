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

/**
 *
 * @author jonat
 */
public class ApagarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
int id = Integer.parseInt(request.getParameter("id"));
        Pedido pedido = new Pedido(id);

        try {
            PedidoDAO.getInstance().delete(pedido);
        } catch (SQLException ex) {
            Logger.getLogger(ApagarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApagarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("FrontController?action=ApagarPedido");
    }

  
}
