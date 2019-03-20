package com.ifood.model;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data

@Accessors(chain = true)
public class Cliente extends Usuario implements Serializable {

    private String apelido;
    private String sexo;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> listaPedidos;


}