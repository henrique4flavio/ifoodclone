package com.ifood.model;

import com.ifood.state.pedido.PedidoEstado;
import com.ifood.state.pedido.PedidoEstadoEfetuado;
import java.sql.Date;
import java.util.List;

public class Pedido {

    private int id;
    private Date data;
    private Comida comida;
    private Restaurante restaurante;    
    private Cliente cliente;
    private int qtd;
    private double precoTotal;
    private PedidoEstado estado;  

    public Pedido(Date data, Comida comida, Restaurante restaurante, Cliente cliente, int qtd, double precoTotal) {
        this.data = data;
        this.comida = comida;
        this.restaurante = restaurante;
        this.cliente = cliente;
        this.qtd = qtd;
        this.precoTotal = precoTotal;
        this.estado = new PedidoEstadoEfetuado();
    }
    
    
public Pedido(int id){
    this.id= id;
}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }


   

}
