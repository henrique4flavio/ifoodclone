/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.action.administrador;

import com.ifood.controller.Action;
import com.ifood.model.Administrador;
import com.ifood.persistence.AdministradorDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonat
 */
public class EditarAdministradorAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    int id = Integer.parseInt(request.getParameter("id"));
        Administrador administrador = new Administrador();
            administrador.setId(id);
        try {
            AdministradorDAO.getInstance().edit(administrador);
        } catch (SQLException ex) {
            Logger.getLogger(ApagarAdministradorAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApagarAdministradorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("FrontController?action=LerAdministrador");
    }
    

    }
