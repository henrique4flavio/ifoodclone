package com.ifood.action.restaurante;

import com.ifood.controller.Action;
import com.ifood.model.Restaurante;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifood.persistence.RestauranteDAO;


/**
 *
 * @author daniela.costa
 */
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
        String foto = request.getParameter("foto");


        Restaurante restaurante = new Restaurante();
        restaurante.setCategoria(categoria);
        restaurante.setDescricao(descricao);
        restaurante.setValorDoFrete(frete);
        restaurante.setHoraDeFechar(null);
        restaurante.setHoraDeAbrir(null);
        restaurante.setNome(nome);
        restaurante.setEmail(email);
        restaurante.setSenha(senha);
        restaurante.setFoto(null);
        try {
            RestauranteDAO.getInstance().save(restaurante);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {


            request.getRequestDispatcher("index.jsp").include(request, response);

        } catch (ServletException ex) {
            Logger.getLogger(CadastrarRestauranteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
