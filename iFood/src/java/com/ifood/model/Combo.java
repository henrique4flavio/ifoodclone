
package com.ifood.model;

import java.util.ArrayList;
import java.util.Iterator;


public class Combo {
    
     private ArrayList produtoCombo = new ArrayList();

    public void addProduto(Produto produto) {
        produtoCombo.add(produto);
    }

    public void listaProdutoCombo() {
        String descricaoProdutoCombo = "";
        for (Iterator i = produtoCombo.iterator(); i.hasNext();) {
            Produto produto = (Produto) i.next();
            descricaoProdutoCombo = descricaoProdutoCombo
                    + produto.getDescricao();
        }
        System.out.println(descricaoProdutoCombo);
}
}
