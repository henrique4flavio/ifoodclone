package com.ifood.model;

import com.ifood.state.pedido.PedidoEstado;
import com.ifood.state.pedido.PedidoEstadoEfetuado;
import java.sql.Date;
import java.util.List;
import java.util.Observable;

public class Pedido extends Observable {

    private int id;
    private Date data;
    private int comida_id;
    private int restaurante_id;    
    private int cliente_id;
    private int qtd;
    private double precoTotal;
    private PedidoEstado estado;  

    public Pedido(Date data, int comida_id, int restaurante_id, int cliente_id, int qtd, double precoTotal) {
        this.data = data;
        this.comida_id = comida_id;
        this.restaurante_id = restaurante_id;
        this.cliente_id = cliente_id;
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

    public int getComida_id() {
        return comida_id;
    }

    public void setComida_id(int comida_id) {
        this.comida_id = comida_id;
    }

    public int getRestaurante_id() {
        return restaurante_id;
    }

    public void setRestaurante_id(int restaurante_id) {
        this.restaurante_id = restaurante_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
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
