package com.ifood.model;

import java.sql.Blob;
import java.util.Observable;
import java.util.Observer;

public class Restaurante extends Usuario implements Observer {

    private String descricao;
    private Blob foto;
    private String horaDeAbrir;
    private String horaDeFechar;
    private String categoria;
    private double valorDoFrete;

    public Restaurante(int id, String nome, String senha, String email) {
        super(id, nome, senha, email);
    }

    public Restaurante() {
    }

    public Restaurante(String descricao, Blob foto, String horaDeAbrir, String horaDeFechar, String categoria, double valorDoFrete, int id, String nome, String senha, String email) {
        super(id, nome, senha, email);
        this.descricao = descricao;
        this.foto = foto;
        this.horaDeAbrir = horaDeAbrir;
        this.horaDeAbrir = horaDeFechar;
        this.categoria = categoria;
        this.valorDoFrete = valorDoFrete;
    }

    public Restaurante(String descricao, Blob foto, String horaDeAbrir, String horaDeFechar, String categoria, double valorDoFrete, String nome, String senha, String email) {
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

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
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

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
