package com.ifood.model;

public class Administrador extends Usuario {

    public Administrador(String nome, String senha, String email) {
        super(nome, senha, email);
    }

    public Administrador(int id, String nome, String senha, String email) {
        super(id, nome, senha, email);
    }

   public Administrador(int id){
       this.id=id;
   }
}
