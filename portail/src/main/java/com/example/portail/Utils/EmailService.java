package com.example.portail.Utils;

import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
    public void sendEmail(String to, String subject, String body)
            throws AddressException, MessagingException {

        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.user", "portail.smartup@gmail.com");// email
        properties.put("mail.smtp.password", "zqmpyxolmbxvlmdv");// password
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress("portail.smartup@gmail.com"));// email
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(body);

        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", "portail.smartup@gmail.com", "zqmpyxolmbxvlmdv");// email and password
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
