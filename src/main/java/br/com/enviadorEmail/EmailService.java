package br.com.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public void enviar(String nome, String emailDestinatario) {
		
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("javarodrigo9@gmail.com", "senha"));
			email.setSSLOnConnect(true);
			
			email.setFrom("javarodrigo9@gmail.com");
			email.setSubject("Parabéns, você foi convidado para a ListaVIP");
			email.setMsg("Olá " + nome +".Você acaba de ser convidado para a ListaVIP");
			email.addTo(emailDestinatario);
			email.send();
			
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

}
