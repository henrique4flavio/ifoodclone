package com.ifood.state.pedido;

import com.ifood.model.Pedido;

/**
 *
 * @author jonat
 */
public interface PedidoEstado {

    public String efetuar(Pedido pedido);

    public String confirmar(Pedido pedido);

    public String enviar(Pedido pedido);

    public String entregar(Pedido pedido);

    public String getEstado();

}
