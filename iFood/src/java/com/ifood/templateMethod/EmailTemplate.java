package com.ifood.templateMethod;

import com.ifood.model.Cliente;

public abstract class EmailTemplate {

    String nome;
    String tipo;
    String pedidoEstado;
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPedidoEstado(String pedidoEstado) {
        this.pedidoEstado = pedidoEstado;
    }

    public String getNome() {
        return nome;
    }

    public String getPedidoEstado() {
        return pedidoEstado;
    }

    public abstract String getTipo();

    public String assuntoTemplate() {
        return "Olá " + getTipo() + ": " + getNome() + " Notícias sobre o pedido!";
    }
    
    public abstract String getMensagem();

    public String mensagemTemplate() {
        return "Olá " + getTipo() + getMensagem()  + getPedidoEstado();

    }

}
