package com.ifood.state.pedido;

import com.ifood.model.Pedido;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String confirmar(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sairParaEntrega(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String entregar(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
