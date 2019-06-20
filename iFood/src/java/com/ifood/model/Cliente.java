package com.ifood.model;

import com.ifood.templateMethod.EnviarEmailCliente;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Cliente extends Usuario implements Observer {

    private String cpf;
    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private int id;

    public Cliente() {
    }

    public String getCpf() {
        return cpf;
    }

    public Cliente setCpf(String cpf) {
        this.cpf = cpf;
        return this;

    }

    public String getRua() {
        return rua;
    }

    public Cliente setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Cliente setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Cliente setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Cliente setCep(String cep) {
        this.cep = cep;
        return this;
    }
    
    
    
    
    
    
    

    @Override
    public void update(Observable pedidoSubject, Object arg) {

        if (pedidoSubject instanceof Pedido) {
            Pedido pedido = (Pedido) pedidoSubject;

//            EnviarEmailCliente email = new EnviarEmailCliente();
//            email.enviarEmail(this, pedido);
//
        }
    }

}
