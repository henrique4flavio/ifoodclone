package com.ifood.state.pedido;

import com.ifood.model.Pedido;

/**
 *
 * @author jonat
 */
public class PedidoEstadoSaiuParaEntrega implements PedidoEstado {

    private String estado = "Saiu Para Entrega";

    public String getEstado() {
        return estado;
    }

    public PedidoEstadoSaiuParaEntrega() {
    }

    @Override
    public String efetuar(Pedido pedido) {
        return "Pedido ja foi efetuado";
    }

    @Override
    public String confirmar(Pedido pedido) {
        return "Pedido já foi confirmado";
    }

    @Override
    public String sairParaEntrega(Pedido pedido) {
        return "Pedido já saiu para entrega";
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Pedido Entregue";
    }

}
