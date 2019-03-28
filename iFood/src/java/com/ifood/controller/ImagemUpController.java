/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.controller;

import com.ifood.model.Cliente;
import com.ifood.persistence.DatabaseLocator;
import com.ifood.persistence.RestauranteDAO;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author jonat
 */
@MultipartConfig(maxFileSize = 16177215)

public class ImagemUpController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("uploadImagem")) {
            uploadImagem(request, response);
        } else {
            if (acao.equals("displayImagem")) {
                displayImagem(request, response);

            }
        }
    }

    private void uploadImagem(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        InputStream foto = null;

        Part filePart = request.getPart("foto");
        if (filePart
                != null) {
            foto = filePart.getInputStream();

            Connection conn = null;
            PreparedStatement comando = null;

            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "update restaurante set foto =? WHERE id =?";
            comando = conn.prepareStatement(sql);
            comando.setBlob(1, foto);
            comando.setInt(2, id);

            comando.execute();
            comando.close();
            conn.close();

        }

    }

    private void displayImagem(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException, SQLException {
        
       int id = Integer.parseInt(request.getParameter("id"));  
        
        // recupera a imagem do banco em um Array de Bytes  
        byte[] imagemStream = RestauranteDAO.getInstance().get(id).getFoto().getBytes(1, 5000);

        response.setContentType( "image/jpeg" );  
        OutputStream out = response.getOutputStream();  
        out.write(imagemStream);  
        out.flush();  
    }                 

    

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ImagemUpController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImagemUpController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ImagemUpController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImagemUpController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
