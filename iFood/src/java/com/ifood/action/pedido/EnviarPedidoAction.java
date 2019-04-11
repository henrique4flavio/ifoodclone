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
import com.ifood.state.pedido.PedidoEstadoSaiuParaEntrega;

/**
 *
 * @author jonat
 */
public class EnviarPedidoAction implements Action {

    public EnviarPedidoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
              int restauranteId = Integer.parseInt(request.getParameter("restauranteId"));

        // produto.getEstado().encaminhar(produto);

        Pedido pedido = new Pedido(id);
        PedidoEstado estado = new PedidoEstadoSaiuParaEntrega();
        pedido.setEstado(estado);

        //pedido.setSituacao(pedido.getEstado().confirmar(pedido));
        try {
            PedidoDAO.getInstance().editEstado(pedido);
        } catch (SQLException ex) {
            Logger.getLogger(EnviarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnviarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("FrontController?pacote=pedido&action=ListarPedidos&id="+restauranteId);

    }
}


