package com.ifood.model;

import com.ifood.state.pedido.PedidoEstado;
import com.ifood.state.pedido.PedidoEstadoEfetuado;
import java.sql.Date;
import java.util.List;
import java.util.Observable;

public class Pedido extends Observable {

    private int id;
    private String data;
    private Restaurante restaurante;
    private Cliente cliente;
    private double precoTotal;
    private PedidoEstado estado;

    public Pedido(Restaurante restaurante, Cliente cliente) {
        this.restaurante = restaurante;
        this.cliente = cliente;
        this.estado = new PedidoEstadoEfetuado();

    }

    public Pedido(int id) {
        this.id = id;
    }

    public Pedido(String data, Restaurante restaurante, Cliente cliente, double precoTotal) {
        this.data = data;
        this.restaurante = restaurante;
        this.cliente = cliente;
        this.precoTotal = precoTotal;
        this.estado = new PedidoEstadoEfetuado();
    }

    public Pedido(int id, String data, Restaurante restaurante, Cliente cliente, double precoTotal) {
        this.data = data;
        this.restaurante = restaurante;
        this.cliente = cliente;
        this.precoTotal = precoTotal;
        this.estado = new PedidoEstadoEfetuado();
        this.id = id;
    }
    
    public Pedido(int id, String data, Restaurante restaurante, Cliente cliente, double precoTotal, PedidoEstado estado) {
        this.data = data;
        this.restaurante = restaurante;
        this.cliente = cliente;
        this.precoTotal = precoTotal;
        this.estado = new PedidoEstadoEfetuado();
        this.id = id;
        this.estado=estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
        setChanged();

    }

}
