package com.ifood.action.administrador;

import com.ifood.controller.Action;
import com.ifood.model.Administrador;
import com.ifood.model.Restaurante;
import com.ifood.persistence.AdministradorDAO;
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
public class CadastrarAdministradorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        String senha = request.getParameter("textSenha");

        Administrador administrador = new Administrador(nome, senha, email);

        try {
            AdministradorDAO.getInstance().save(administrador);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarAdministradorAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarAdministradorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            request.getRequestDispatcher("index.jsp").include(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CadastrarAdministradorAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
