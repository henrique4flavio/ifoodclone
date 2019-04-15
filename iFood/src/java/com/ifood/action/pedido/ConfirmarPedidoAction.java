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
import com.ifood.state.pedido.PedidoEstadoConfirmado;

/**
 *
 * @author jonat
 */
public class ConfirmarPedidoAction implements Action {

    public ConfirmarPedidoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int restauranteId = Integer.parseInt(request.getParameter("restauranteId"));

        Pedido pedido;
        try {
            pedido = PedidoDAO.getInstance().getPedidoById(id);
            request.setAttribute("mensagem", pedido.confirmarPedido());


        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfirmarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("FrontController?pacote=pedido&action=ListarPedidosRestaurante&id=" + restauranteId);
    }

}
