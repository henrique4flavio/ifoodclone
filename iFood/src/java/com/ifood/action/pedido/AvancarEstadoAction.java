/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.action.pedido;

import com.ifood.controller.Action;
import com.ifood.memento.pedido.PedidoMemento;
import com.ifood.model.Pedido;
import com.ifood.persistence.PedidoDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonat
 */
public class AvancarEstadoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int restauranteId = Integer.parseInt(request.getParameter("restauranteId"));

        Pedido pedido;
        try {
            pedido = PedidoDAO.getInstance().getPedidoById(id);
            pedido.restoreFromMemento(pedido.getEstadosSalvos().get(1));

            RequestDispatcher view = request.getRequestDispatcher("FrontController?pacote=pedido&action=ListarPedidosRestaurante&id=" + restauranteId);
            view.forward(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfirmarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(EntregarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
