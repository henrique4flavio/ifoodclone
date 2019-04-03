
package com.ifood.model;


public class PedidoComida {
  
        private int id;
        private Pedido pedido;
        private Comida comida;
        private int quantidade;
        


    public PedidoComida(int id, Pedido pedido, Comida comida, int quantidade) {
        this.id = id;
        this.pedido = pedido;
        this.comida = comida;
        this.quantidade = quantidade;
    }

    public PedidoComida(int id, Pedido pedido, Comida comida) {
        this.id = id;
        this.pedido = pedido;
        this.comida = comida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
        
    public PedidoComida(int id){
    
    }

}
 