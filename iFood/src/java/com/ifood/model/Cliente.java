package com.ifood.model;

import java.util.List;

public class Cliente extends Usuario {

    private String cpf;
    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private int id;

 
    public Cliente(String cpf, String rua, String numero, String bairro, String cep, String nome, String senha, String email) {
        super(nome, senha, email);
        this.cpf = cpf;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Cliente(int id, String nome, String senha, String email) {
        super(id, nome, senha, email);
    }
    
    
    public Cliente(int id){
        this.id= id;
    }
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
