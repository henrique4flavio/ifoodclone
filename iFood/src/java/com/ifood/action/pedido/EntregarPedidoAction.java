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
import com.ifood.state.pedido.PedidoEstado;
import com.ifood.state.pedido.PedidoEstadoEntregue;
import javax.servlet.ServletException;

/**
 *
 * @author jonat
 */
public class EntregarPedidoAction implements Action {

    public EntregarPedidoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int restauranteId = Integer.parseInt(request.getParameter("restauranteId"));

        Pedido pedido;
        try {
            pedido = PedidoDAO.getInstance().getPedidoById(id);
            String mensagem = pedido.entregarPedido();
            request.setAttribute("mensagem", mensagem);

            RequestDispatcher view = request.getRequestDispatcher("FrontController?pacote=pedido&action=ListarPedidosRestaurante&id=" + restauranteId);
            view.forward(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfirmarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(EntregarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
