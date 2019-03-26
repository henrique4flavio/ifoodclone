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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
 
}
