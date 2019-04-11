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
        return "Pedido já foi efetuado";
    }

    @Override
    public String confirmar(Pedido pedido) {
      pedido.setEstado(new PedidoEstadoConfirmado());

        return "Pedido confirmado";
    }

    @Override
    public String sairParaEntrega(Pedido pedido) {
        return "Pedido ainda não foi confirmado";
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Pedido ainda não foi confirmado";
    }

}
