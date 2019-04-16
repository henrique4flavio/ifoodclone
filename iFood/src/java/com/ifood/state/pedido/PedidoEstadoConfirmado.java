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
public class PedidoEstadoConfirmado implements PedidoEstado {

    private String estado = "Confirmado";

    public String getEstado() {
        return estado;
    }

    public PedidoEstadoConfirmado() {
    }

    @Override
    public String efetuar(Pedido pedido) {
        return "Esse Pedido já foi efetuado";
    }

    @Override
    public String confirmar(Pedido pedido) {
        return "Não é possivel Confirmar pois o pedido já está Confirmado";

    }

    @Override
    public String enviar(Pedido pedido) {

        try {
            pedido.setEstado(new PedidoEstadoEnviado());
            PedidoDAO.getInstance().editEstado(pedido);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoEstadoConfirmado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoEstadoConfirmado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Estado alterado! Pedido Enviado";
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Não é possivel Entregar pois o pedido ainda não foi Enviado";
    }

}
