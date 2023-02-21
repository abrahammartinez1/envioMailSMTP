import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Main {
    public static void main(String[] args) {

        // Información de autenticación del servidor SMTP
        String host = "smtp-relay.sendinblue.com";
        String username = "informatica@forta.es";
        String password = "ndZXRvz5c7Vp3CAT";

        // Información del mensaje
        String to = "abranllis@gmail.com";
        String subject = "Proyecto parado";
        String body = "Tenemos un problema con el proyecto, llámame por favor.";

        // Configuración de las propiedades del servidor SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");

        // Creación de una sesión de correo electrónico
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Creación del mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            // Envío del mensaje
            Transport.send(message);

            System.out.println("El correo electrónico se ha enviado correctamente.");

        } catch (MessagingException e) {
            System.out.println("Ha ocurrido un error al enviar el correo electrónico: " + e.getMessage());
        }
    }
}
