package com.ifood.model;

import com.ifood.memento.pedido.PedidoMemento;
import com.ifood.state.pedido.PedidoEstado;
import com.ifood.state.pedido.PedidoEstadoEfetuado;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Pedido extends Observable {

    private int id;
    private String data;
    private Restaurante restaurante;
    private Cliente cliente;
    private double precoTotal;
    private PedidoEstado estado;
    ArrayList<PedidoMemento> estadosSalvos = new ArrayList();

    public Pedido() {
    }

    public String efetuarPedido() {
        return estado.efetuar(this);

    }

    public String confirmarPedido() {
        return estado.confirmar(this);

    }

    public String enviarPedido() {
        return estado.enviar(this);

    }

    public String entregarPedido() {
        return estado.entregar(this);

    }

    public PedidoMemento saveToMemento() {
        return new PedidoMemento(estado);
    }

    public void restoreFromMemento(PedidoMemento memento) {
        estado = memento.getEstadoSalvo();
    }

    public int getId() {
        return id;
    }

    public Pedido setId(int id) {
        this.id = id;
        return this;
    }

    public String getData() {
        return data;
    }

    public Pedido setData(String data) {
        this.data = data;
        return this;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public Pedido setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pedido setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public Pedido setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
        return this;
    }

    public ArrayList<PedidoMemento> getEstadosSalvos() {
        return estadosSalvos;
    }

    public Pedido setEstadosSalvos(ArrayList<PedidoMemento> estadosSalvos) {
        this.estadosSalvos = estadosSalvos;
        return this;
    }


    public Pedido setEstado(PedidoEstado estado) {
        this.estado = estado;
        estadosSalvos.add(this.saveToMemento());
        setChanged();
        notifyObservers();
        return this;

    }

    public PedidoEstado getEstado() {
        return estado;
    }

    

}
