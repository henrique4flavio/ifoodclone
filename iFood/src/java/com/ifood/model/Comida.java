
package com.ifood.model;

import java.awt.Image;

public class Comida {

    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private Image foto;
    private Restaurante restaurante;
    
    private int restauranteId;

    public Comida(int id, String nome, String descricao, double preco, Image foto, Restaurante restaurante) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.foto = foto;
        this.restaurante = restaurante;
    }

    public Comida(int id, String nome, String descricao, double preco, Restaurante restaurante) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.restaurante = restaurante;
    }
    
    public Comida(int restauranteId){
        this.restauranteId = restauranteId;
    }
    
    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

   
}
