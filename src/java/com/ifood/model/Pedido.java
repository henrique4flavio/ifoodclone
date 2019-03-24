package com.ifood.model;

import com.ifood.state.pedido.PedidoEstado;
import java.util.List;

public class Pedido {

    private int id;

    private String precoTotal;
    
    private List<Prato> pratos;
    
    private Restaurante restaurante;
    
    private PedidoEstado estado;

    public Pedido(String precoTotal, List<Prato> pratos, Restaurante restaurante, Cliente cliente) {
        this.precoTotal = precoTotal;
        this.pratos = pratos;
        this.restaurante = restaurante;
        this.cliente = cliente;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }
    
    

    public Pedido(int id) {
        this.id = id;
    }
    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(String precoTotal) {
        this.precoTotal = precoTotal;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante Restaurante) {
        this.restaurante = Restaurante;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    private Cliente cliente;

}
