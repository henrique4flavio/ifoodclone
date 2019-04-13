package com.ifood.state.pedido;

import com.ifood.model.Pedido;
import com.ifood.persistence.PedidoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonat
 */
public class PedidoEstadoEfetuado implements PedidoEstado {

    private String estado = "Efetuado";

    public String getEstado() {
        return estado;
    }

    public PedidoEstadoEfetuado() {
    }

    @Override
    public String efetuar(Pedido pedido) {
        return "Pedido já foi efetuado";
    }

    @Override
    public String confirmar(Pedido pedido) {
        try {
            pedido.setEstado(new PedidoEstadoConfirmado());
            PedidoDAO.getInstance().editEstado(pedido);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoEstadoEfetuado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoEstadoEfetuado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Pedido confirmado";
    }

    @Override
    public String enviar(Pedido pedido) {
        return "Pedido ainda não foi confirmado";
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Pedido ainda não foi confirmado";
    }

}
