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

    public Restaurante(String descricao, String foto, String horaDeAbrir, String horaDeFechar, String categoria, double valorDoFrete, int id, String nome, String senha, String email) {
        super(id, nome, senha, email);
        this.descricao = descricao;
        this.foto = foto;
        this.horaDeAbrir = horaDeAbrir;
        this.horaDeAbrir = horaDeFechar;
        this.categoria = categoria;
        this.valorDoFrete = valorDoFrete;
        
    }

    public Restaurante(String descricao, String foto, String horaDeAbrir, String horaDeFechar, String categoria, double valorDoFrete, String nome, String senha, String email) {
        super(nome, senha, email);
        this.descricao = descricao;
        this.foto = foto;
        this.horaDeAbrir = horaDeAbrir;
        this.horaDeFechar = horaDeFechar;
        this.categoria = categoria;
        this.valorDoFrete = valorDoFrete;
    }
    
    public Restaurante(int id){
        this.id= id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getHoraDeAbrir() {
        return horaDeAbrir;
    }

    public void setHoraDeAbrir(String horaDeAbrir) {
        this.horaDeAbrir = horaDeAbrir;
    }

    public String getHoraDeFechar() {
        return horaDeFechar;
    }

    public void setHoraDeFechar(String horaDeFechar) {
        this.horaDeFechar = horaDeFechar;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValorDoFrete() {
        return valorDoFrete;
    }

    public void setValorDoFrete(double valorDoFrete) {
        this.valorDoFrete = valorDoFrete;
    }

    public void update(Observable pedidoSubject, Object arg) {

        if (pedidoSubject instanceof Pedido) {
            Pedido pedido = (Pedido) pedidoSubject;

            EnviarEmailRestaurante email = new EnviarEmailRestaurante();
            email.enviarEmail(this, pedido);

        }
    }
    
     
    
}
