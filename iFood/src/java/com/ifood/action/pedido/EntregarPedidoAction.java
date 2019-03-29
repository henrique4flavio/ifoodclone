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
        // produto.getEstado().encaminhar(produto);

        Pedido pedido = new Pedido(id);
        PedidoEstado estado = new PedidoEstadoEntregue();
        pedido.setEstado(estado);

        //pedido.setSituacao(pedido.getEstado().confirmar(pedido));
        try {
            PedidoDAO.getInstance().edit(pedido);
        } catch (SQLException ex) {
            Logger.getLogger(EntregarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EntregarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("FrontController?action=ListarPedidos");

    }

}
