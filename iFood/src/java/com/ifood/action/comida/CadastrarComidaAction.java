/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.action.comida;

import com.ifood.controller.Action;
import com.ifood.model.Comida;
import com.ifood.model.Restaurante;
import com.ifood.persistence.ComidaDAO;
import com.ifood.persistence.RestauranteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarComidaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            String nome = request.getParameter("textNome");
            String descricao = request.getParameter("textDescricao");
            String preco = request.getParameter("textPreco");
            double precoComida = Double.parseDouble(preco);

            int restauranteId = Integer.parseInt(request.getParameter("id"));
            Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteById(restauranteId);

            Comida comida = new Comida(nome, descricao, precoComida, restaurante);
            ComidaDAO.getInstance().save(comida);
            
            
            request.setAttribute("comida", ComidaDAO.getInstance().getComida(nome, precoComida, restauranteId));
            
            try {
                request.getRequestDispatcher("inserirImagemComida.jsp").include(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(CadastrarComidaAction.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            request.setAttribute("mensagemSucesso", "Comida criado com sucesso!");
            


        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarComidaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarComidaAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
