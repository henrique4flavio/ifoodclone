package com.ifood.model;

import java.sql.Blob;
import java.sql.Date;

public class Restaurante extends Usuario {

    private String descricao;
    private Blob foto;
    private Date horaDeAbrir;
    private Date horaDeFechar;
    private String categoria;
    private double valorDoFrete;

    public Restaurante(int id, String nome, String senha, String email) {
        super(id, nome, senha, email);
    }
    
    

    public Restaurante() {
    }

    public Restaurante(String descricao, Blob foto, Date horaDeAbrir, Date horaDeFechar, String categoria, double valorDoFrete, int id, String nome, String senha, String email) {
        super(id, nome, senha, email);
        this.descricao = descricao;
        this.foto = foto;
        this.horaDeAbrir = horaDeAbrir;
        this.horaDeAbrir = horaDeFechar;
        this.categoria = categoria;
        this.valorDoFrete = valorDoFrete;
    }

    public Restaurante(String descricao, Blob foto, String endereco, Date horaDeAbrir, Date horaDeFechar, String categoria, double valorDoFrete, String nome, String senha, String email) {
        super(nome, senha, email);
        this.descricao = descricao;
        this.foto = foto;
        this.horaDeAbrir = horaDeAbrir;
        this.horaDeFechar = horaDeFechar;
        this.categoria = categoria;
        this.valorDoFrete = valorDoFrete;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public Date getHoraDeAbrir() {
        return horaDeAbrir;
    }

    public void setHoraDeAbrir(Date horaDeAbrir) {
        this.horaDeAbrir = horaDeAbrir;
    }

    public Date getHoraDeFechar() {
        return horaDeFechar;
    }

    public void setHoraDeFechar(Date horaDeFechar) {
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

}
