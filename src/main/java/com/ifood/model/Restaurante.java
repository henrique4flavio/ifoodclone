/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.model;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Entity

@Accessors(chain = true)
public class Restaurante extends Usuario implements Serializable {

    @ManyToOne
    private Administrador administrador;

}
