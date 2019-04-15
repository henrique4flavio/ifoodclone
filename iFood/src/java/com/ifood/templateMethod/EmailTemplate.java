package com.ifood.templateMethod;

import com.ifood.model.Cliente;
import com.ifood.model.Pedido;

/**
 *
 * @author jonat
 */
public abstract class EmailTemplate {

    String nomeCliente;
    String nomeRestaurante;
    String pedidoEstado;
    String CodPedido;
    
    public String assuntoTemplate(){
        return "Olá " +getNomeCliente() + " Notícias sobre seu pedido!";
        
    }

    public String mensagemTemplate() {
        return "Olá " +getNomeCliente()+ " seu pedido no restaurante: "+getNomeRestaurante()+ " mudou para o estado " +getPedidoEstado();

    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(Cliente cliente) {
        this.nomeCliente = cliente.getNome();
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public String getCodPedido() {
        return CodPedido;
    }

    public void setCodPedido(String CodPedido) {
        this.CodPedido = CodPedido;
    }

    public void setNomeRestaurante(Pedido pedido) {
        this.nomeRestaurante = pedido.getRestaurante().getNome();
    }

    public String getPedidoEstado() {
        return pedidoEstado;
    }

    public void setPedidoEstado(Pedido pedido) {
        this.pedidoEstado = pedido.getEstado().getEstado();
    }

}
