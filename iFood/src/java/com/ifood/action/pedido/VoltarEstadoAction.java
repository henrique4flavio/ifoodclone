package com.ifood.action.pedido;

import com.ifood.controller.Action;
import com.ifood.model.Pedido;
import com.ifood.persistence.PedidoDAO;
import com.ifood.state.pedido.PedidoEstadoConfirmado;
import com.ifood.state.pedido.PedidoEstadoEntregue;
import com.ifood.state.pedido.PedidoEstadoEnviado;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoltarEstadoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int restauranteId = Integer.parseInt(request.getParameter("restauranteId"));

        Pedido pedido;
        try {
            pedido = PedidoDAO.getInstance().getPedidoById(id);

            for (Iterator i = pedido.getEstadosSalvos().iterator(); i.hasNext();) {
                System.out.println(i.next());

            }
            pedido.restoreFromMemento(pedido.getEstadosSalvos().get(1));

            System.out.println(pedido.getEstado().getEstado());

            try {

                PedidoDAO.getInstance().editEstado(pedido);
            } catch (SQLException ex) {
                Logger.getLogger(VoltarEstadoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher view = request.getRequestDispatcher("FrontController?pacote=pedido&action=ListarPedidosRestaurante&id=" + restauranteId);
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(VoltarEstadoAction.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VoltarEstadoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
