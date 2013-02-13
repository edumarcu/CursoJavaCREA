package curso.demo18;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class Demo01 {

    public static void main(String[] args) throws MessagingException {
        // http://www.oracle.com/technetwork/java/javamail/faq/index.html#gmail
        /*

         Properties connprops = new Properties();

         connprops.setProperty("mail.smtp.host", "rootnode.es");
         connprops.setProperty("mail.smtp.port", "465"); // 25 465 587
         connprops.setProperty("mail.smtp.user", "curso@rootnode.es");
         connprops.setProperty("mail.smtp.auth", "true");

         //        connprops.setProperty("mail.smtp.starttls.enable", "true");
         connprops.setProperty("mail.smtp.ssl.enable", "true");

         Session session = Session.getInstance(connprops);
         session.setDebug(true);

         MimeMessage email = new MimeMessage(session);
         email.setFrom();
         email.setRecipients(Message.RecipientType.TO, "vjimenez@rootnode.es");
         email.setSubject("Test Email");
         email.setText("Cuerpo del mensaje"); // , "UTF-8", "html" );
         email.setSentDate(new Date());

         // BodyPart text = new MimeBodyPart();
         // text.setText("Cuerpo del mensaje");
         //
         // BodyPart attachment = new MimeBodyPart();
         // attachment.setDataHandler(new DataHandler(new FileDataSource("/ruta/al/archivo")));
         // attachment.setFileName("archivo.png");
         //
         // // Cambiar el email.setText
         // MimeMultipart multipart = new MimeMultipart();
         // multipart.addBodyPart(text);
         // multipart.addBodyPart(attachment);
         // email.setContent(multipart);

         Transport transport = session.getTransport("smtp");
         transport.connect("curso@rootnode.es", "curso");
         transport.sendMessage(email, email.getAllRecipients());
         transport.close();

         System.out.println("DONE!");
         */

         Properties connprops = new Properties();
         connprops.setProperty("mail.smtps.host", "smtp.gmail.com");
         Session session = Session.getInstance(connprops);

        String host = "smtp.gmail.com";
        String username = "user";
        String password = "passwd";
        Properties props = new Properties();
        props.put("mail.smtps.auth", "true");

        MimeMessage msg = new MimeMessage(session);
         msg.setRecipients(Message.RecipientType.TO, "edumarcu@hotmail.com");
         msg.setSubject("Test Email");
         msg.setText("Cuerpo del mensaje"); // , "UTF-8", "html" );
         msg.setSentDate(new Date());

        // set the message content here
        Transport t = session.getTransport("smtps");
        try {
            t.connect(host, username, password);
            t.sendMessage(msg, msg.getAllRecipients());
        } finally {
            t.close();
        }

    }
}
