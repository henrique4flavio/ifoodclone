package com.ifood.state.pedido;

import com.ifood.model.Pedido;

/**
 *
 * @author jonat
 */
public class PedidoEstadoEntregue implements PedidoEstado {

    private String estado = "Entregue";

    public String getEstado() {
        return estado;
    }

    public PedidoEstadoEntregue() {
    }

    @Override
    public String efetuar(Pedido pedido) {
        return "Pedido já foi entregue";
    }

    @Override
    public String confirmar(Pedido pedido) {
        return "Pedido já foi entregue";
    }

    @Override
    public String enviar(Pedido pedido) {
        return "Pedido ja foi entregue";
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Produto já foi entregue";
    }

}
