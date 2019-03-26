package com.ifood.model;

import java.awt.Image;
import java.sql.Date;

public class Restaurante extends Usuario {
    
    private String descricao;
    private Image foto;
    private Date horaDeAbrir;
    private Date horaDeFechar;
    private String categoria;
    private double valorDoFrete;

    public Restaurante(String descricao, Image foto, String endereco, Date horaDeAbrir, Date horaDeFechar, String categoria, double valorDoFrete, String nome, String senha, String email) {
        super(nome, senha, email);
        this.descricao = descricao;
        this.foto = foto;
        this.endereco = endereco;
        this.horaDeAbrir = horaDeAbrir;
        this.horaDeFechar = horaDeFechar;
        this.categoria = categoria;
        this.valorDoFrete = valorDoFrete;
    }

    public Restaurante(String descricao, String endereco, Date horaDeAbrir, Date horaDeFechar, String categoria, double valorDoFrete, String nome, String senha, String email) {
        super(nome, senha, email);
        this.descricao = descricao;
        this.endereco = endereco;
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

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
