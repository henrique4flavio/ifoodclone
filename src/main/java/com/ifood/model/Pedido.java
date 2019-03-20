/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.model;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Accessors(chain = true)
@Data
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String precoTotal;
   

    @ManyToOne
    private Cliente cliente;

 

}