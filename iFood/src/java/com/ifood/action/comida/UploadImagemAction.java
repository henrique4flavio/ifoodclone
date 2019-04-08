/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.action.comida;


import com.ifood.controller.Action;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author jonat
 */
public class UploadImagemAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        try {
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
                    nome = "img1.jpg";
                    StringBuffer bn = new StringBuffer();
                    bn.append("C:/ifoodImagens/comidas/"); // caminho
                    bn.append(nome);
                    File uploadedFile = new File(bn.toString());
                    try {
                        item.write(uploadedFile);
                    } catch (Exception ex) {
                        Logger.getLogger(UploadImagemAction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            nome = "C:/ifoodImagens/comidas/" + nome;
        } catch (FileUploadException ex) {
            Logger.getLogger(UploadImagemAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
