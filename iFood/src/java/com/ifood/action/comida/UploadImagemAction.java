/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.action.comida;

import com.ifood.controller.Action;
import com.ifood.model.Comida;
import com.ifood.persistence.ComidaDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author jonat
 */
public class UploadImagemAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {

            int id = Integer.parseInt(request.getParameter("id"));

            Comida comida = ComidaDAO.getInstance().getComidaById(id);


            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(50 * 1024 * 1024);
            String nome = "";
            List items = upload.parseRequest(request); // request vem na controladora

            // Processa os itens do upload
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.getFieldName().equals("arquivo")) {

                    Random r = new Random();
                    Random s = new Random();
                    int chave = r.nextInt() + s.nextInt();

                    nome = Integer.toString(chave);

                    StringBuffer bn = new StringBuffer();
                    bn.append("C:/Users/jonat/Documents/NetBeansProjects/ifoodclone/iFood/web/imagens/comidas/"); // colocar o caminho do seu computador
                    bn.append(nome + ".png");
                    File uploadedFile = new File(bn.toString());
                    try {
                        item.write(uploadedFile);
                    } catch (Exception ex) {
                        Logger.getLogger(UploadImagemAction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            nome = "imagens/comidas/" + nome + ".png";

            comida.setFoto(nome);
            ComidaDAO.getInstance().edit(comida);

            boolean create = true;
            HttpSession session = request.getSession(create);
            response.sendRedirect(session.getAttribute("tipo")+"Home.jsp");

            session.getAttribute("tipo");

        } catch (FileUploadException ex) {
            Logger.getLogger(UploadImagemAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UploadImagemAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UploadImagemAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
