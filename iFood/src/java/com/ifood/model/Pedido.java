package com.ifood.model;

import com.ifood.state.pedido.PedidoEstado;
import java.util.List;

public class Pedido {

    private int id;

    private String precoTotal;
    
    private List<Comida> comidas;
    
    private Restaurante restaurante;
    
    private PedidoEstado estado;
    
    private Cliente cliente;

    public Pedido(String precoTotal, List<Comida> comidas, Restaurante restaurante, Cliente cliente) {
        this.precoTotal = precoTotal;
        this.comidas = comidas;
        this.restaurante = restaurante;
        this.cliente = cliente;
    }

    public Pedido() {
    }

    public Pedido(int id) {
        this.id = id;
    }
    
    

    
    
    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
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

    public List<Comida> getPratos() {
        return comidas;
    }

    public void setPratos(List<Comida> comidas) {
        this.comidas = comidas;
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


}
