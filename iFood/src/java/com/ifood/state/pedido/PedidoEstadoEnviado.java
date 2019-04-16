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
public class PedidoEstadoEnviado implements PedidoEstado {

    private String estado = "Enviado";

    public String getEstado() {
        return estado;
    }

    public PedidoEstadoEnviado() {
    }

    @Override
    public String efetuar(Pedido pedido) {
        return "Pedido já saiu para enrtrega";
    }

    @Override
    public String confirmar(Pedido pedido) {
        return "Não é possivel alterar o estado pois o pedido já foi Enviado";
    }

    @Override
    public String enviar(Pedido pedido) {
        return "Não é possivel alterar o estado pois o pedido já foi Enviado";
    }

    @Override
    public String entregar(Pedido pedido) {
        try {
            pedido.setEstado(new PedidoEstadoEntregue());
            PedidoDAO.getInstance().editEstado(pedido);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoEstadoEnviado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoEstadoEnviado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Estado alterado! Pedido Entregue";
    }

}
