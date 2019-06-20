package com.ifood.model;

import com.ifood.templateMethod.EnviarEmailRestaurante;
import java.util.Observable;
import java.util.Observer;

public class Restaurante extends Usuario implements Observer {

    private String descricao;
    private String foto;
    private String horaDeAbrir;
    private String horaDeFechar;
    private String categoria;
    private double valorDoFrete;

    public Restaurante() {
    }

    public String getDescricao() {
        return descricao;
    }

    public Restaurante setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getFoto() {
        return foto;
    }

    public Restaurante setFoto(String foto) {
        this.foto = foto;
        return this;

    }

    public String getHoraDeAbrir() {
        return horaDeAbrir;
    }

    public Restaurante setHoraDeAbrir(String horaDeAbrir) {
        this.horaDeAbrir = horaDeAbrir;
        return this;

    }

    public String getHoraDeFechar() {
        return horaDeFechar;
    }

    public Restaurante setHoraDeFechar(String horaDeFechar) {
        this.horaDeFechar = horaDeFechar;
        return this;

    }

    public String getCategoria() {
        return categoria;
    }

    public Restaurante setCategoria(String categoria) {
        this.categoria = categoria;
        return this;

    }

    public double getValorDoFrete() {
        return valorDoFrete;
    }

    public Restaurante setValorDoFrete(double valorDoFrete) {
        this.valorDoFrete = valorDoFrete;
        return this;

    }

    public void update(Observable pedidoSubject, Object arg) {

        if (pedidoSubject instanceof Pedido) {
            Pedido pedido = (Pedido) pedidoSubject;

           // EnviarEmailRestaurante email = new EnviarEmailRestaurante();
            // email.enviarEmail(this, pedido);
        }
    }

}
