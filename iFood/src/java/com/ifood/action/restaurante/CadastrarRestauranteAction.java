package com.ifood.action.restaurante;

import com.ifood.controller.Action;
import com.ifood.model.Restaurante;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifood.persistence.RestauranteDAO;
import java.sql.Blob;
import javax.servlet.ServletException;

import javax.servlet.annotation.MultipartConfig;

public class CadastrarRestauranteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        String senha = request.getParameter("textSenha");
        String categoria = request.getParameter("textCategoria");
        String valorDoFrete = request.getParameter("textValorDoFrete");
        double frete = Double.parseDouble(valorDoFrete);

        String horaDeAbrir = request.getParameter("textHoraDeAbrir");
        String horaDeFechar = request.getParameter("textHoraDeFechar");
        String descricao = request.getParameter("textDescricao");
        String foto = "";

        Restaurante restaurante = new Restaurante();
            restaurante.setCategoria(categoria)
                    .setValorDoFrete(frete)
                    .setHoraDeAbrir(horaDeAbrir)
                    .setHoraDeFechar(horaDeFechar)
                    .setDescricao(descricao)
                    .setFoto(foto)
                    .setNome(nome)
                    .setEmail(email)
                    .setSenha(senha);
        
        
        try {
            RestauranteDAO.getInstance().save(restaurante);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}