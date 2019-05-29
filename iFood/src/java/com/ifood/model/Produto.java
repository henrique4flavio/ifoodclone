/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.model;

public abstract class Produto {

    protected String descricao;

   

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public abstract String getDescricao();
}
