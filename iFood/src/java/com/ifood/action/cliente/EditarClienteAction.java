    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.action.cliente;

import com.ifood.controller.Action;
import com.ifood.model.Cliente;
import com.ifood.persistence.ClienteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LaisAlves
 */
public class EditarClienteAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = new Cliente(id);

        try {
            ClienteDAO.getInstance().edit(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(ApagarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApagarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("FrontController?action=LerCliente");
    }
    

    }
    

