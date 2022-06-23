/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functionality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ihorg
 */
public class AddingForm {
    
    //VARIABLES
    private static Connection conn;
    private static Statement stmt;
    
    public void addRecord(String s) {
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/dvdb","Halyn","123");
            stmt = conn.createStatement();
            stmt.executeUpdate(s);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void sendMessageToEmail(String host, String sender, String password,String recipient, String subject, String text, String image) {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }
        });
        MimeMessage message = new MimeMessage(session);
        try {
            
            message.setFrom(sender);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            
            Multipart emailContent = new MimeMultipart();
            //Text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(text);

            //Attachment body part.
            MimeBodyPart imageAttachment = new MimeBodyPart();
            imageAttachment.attachFile(image);

            //Attach body parts
            emailContent.addBodyPart(textBodyPart);
            emailContent.addBodyPart(imageAttachment);

            //Attach multipart to message
            message.setContent(emailContent);
            Transport.send(message);
            System.out.println("Message Sent");
        } catch (Exception e) {
            System.out.println(e);
        }        
    }
} 
