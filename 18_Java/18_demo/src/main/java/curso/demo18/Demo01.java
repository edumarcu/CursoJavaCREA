package curso.demo18;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 * e-mail
 * @author EM
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println("Welcome to e-mail sender!");

        Properties props = mailProperties("rootnode.es", "587",
                "curso@rootnode.es", "true", "true", "true");
        System.out.println("props ok!");
        Session s = Session.getInstance(props);
        MimeMessage email = composeMail(s, "edumarcu@hotmail.com", "Prueba Curso", ""); //from
        System.out.println("compose ok!");
        sendMail(s, email, "rootnode.es", "curso@rootnode.es", "curso");
        System.out.println("send ok!");

    }

    public static void sendMail (Session session, MimeMessage email,
            String smtpServer, String user, String pass) {

        try {
            Transport t = session.getTransport("smtp");
            t.connect(smtpServer, user, pass);
            t.sendMessage(email, email.getAllRecipients());
        } catch (Exception e) {
            System.err.println("Exception sending Message: " + e);
        }
    }

    public static MimeMessage composeMail (Session session, String to,
            String subject, String body) {

        MimeMessage email = new MimeMessage(session);
        try {
            email.setFrom();
            email.setRecipients(Message.RecipientType.TO, to);
            email.setSubject(subject);
            email.setText(body);
            email.setFrom();
        } catch (Exception e) {
            System.err.println("Exception composing Message: " + e);
        }

        return email;
    }


    public static Properties mailProperties(String host, String port, String user,
            String auth, String starttls, String ssl) {

        Properties props = new Properties();

        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.smtp.port", port);
        props.setProperty("mail.smtp.user", user);
        props.setProperty("mail.smtp.auth", auth);

        props.setProperty("mail.smtp.starttls.enable", starttls);
        props.setProperty("mail.smtp.ssl.enable", ssl);

        return props;
    }
}
