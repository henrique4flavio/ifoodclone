package com.ifood.memento.pedido;

import com.ifood.state.pedido.PedidoEstado;

public class PedidoMemento {

    private PedidoEstado estado;

    public PedidoMemento(PedidoEstado estadoSalvar) {
        estado = estadoSalvar;

    }

    public PedidoEstado getEstadoSalvo() {
        return estado;
    }

    public String toString() {
        return estado.getEstado();
    }

}
