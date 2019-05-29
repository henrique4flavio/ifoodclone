
package com.ifood.model;


public class Comida extends Produto {

    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private String foto;
    private Restaurante restaurante;
    
    private int restauranteId;

    public Comida(String nome, String descricao, double preco, Restaurante restaurante) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.restaurante = restaurante;
    }

    public Comida(int id, String nome,String foto, String descricao, double preco, Restaurante restaurante) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

   
}
