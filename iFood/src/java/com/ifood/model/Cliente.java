package com.ifood.model;

import java.awt.Image;
import java.util.List;


public class Cliente extends Usuario {


    private String cpf;
    private String endereco;
    public Image photo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

   

    
}
