package com.ifood.email;

import com.ifood.controller.Action;
import com.ifood.model.Cliente;
import com.ifood.persistence.ClienteDAO;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnviarEmailCliente {

public static void enviarEmail(Cliente cliente) {
    

        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("projetoifoodclone@gmail.com", "Ifoodclone01");
                    }
                });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("projetoifoodclone@gmail.com")); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse("jonathas.maraujo@gmail.com");

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Bem Vinda ao Ifood.");//Assunto
            message.setText("Ola lais chatinha!");
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
