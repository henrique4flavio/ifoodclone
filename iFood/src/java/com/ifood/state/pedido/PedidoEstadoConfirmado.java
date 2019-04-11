package com.ifood.state.pedido;

import com.ifood.model.Pedido;

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
        return "Pedido já está confirmado";

    }

    @Override
    public String sairParaEntrega(Pedido pedido) {
                
        pedido.setEstado(new PedidoEstadoSaiuParaEntrega());

        return "Pedido saiu para entrega ";
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Pedido ainda não saiu para entrega";
    }

}
