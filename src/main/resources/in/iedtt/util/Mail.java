package in.iedtt.util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail extends Thread {

	String to;
	String subject;
	String body;
	
	public static void sendNotification(String to, String subject, String body) {
		new Mail(to, subject, body).start();
	}
	
	private Mail(String to, String subject, String body) {
		super();
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	public void sendMail() {
        //Setting up configurations for the email connection to the Google SMTP server using TLS
        Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        //Establishing a session with required user details
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("reddysoumya563@gmail.com", "S@ibaba123");
            }
        });
        try {
            //Creating a Message object to set the email content
            MimeMessage msg = new MimeMessage(session);
            //Storing the comma seperated values to email addresses
//            String to = "reddysoumya563@gmail.com";
            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
            addresses in an array of InternetAddress objects*/
            InternetAddress[] address = InternetAddress.parse(to, true);
            //Setting the recepients from the address variable
            msg.setRecipients(Message.RecipientType.TO, address);
//            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
//            msg.setSubject("Sample Mail : " + timeStamp);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
//            msg.setText("Sampel System Generated mail");
            msg.setText(body);
            msg.setHeader("XPriority", "1");
            Transport.send(msg);
            System.out.println("Mail has been sent successfully");
        } catch (MessagingException mex) {
            System.out.println("Unable to send an email" + mex);
        }
    }
	
	public static void main(String[] args) {
		System.out.println("Mail sending started........................................................");
		new Mail("reddysoumya563@gmail.com", "Test Mail", "Test mail for defect tracking");
	}

	public void run() {
		sendMail();	
	}
}