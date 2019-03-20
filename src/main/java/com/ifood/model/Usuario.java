/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.model;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.MappedSuperclass;


@Data
@MappedSuperclass
@Accessors(chain = true)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String cpf;
    private String senha;
    private String email;


}