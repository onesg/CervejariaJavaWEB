package br.com.CervejariaJavaWEB.util;

//  ARQUIVO QUE CONTÉM AS INFORMAÇÕES DO EMAIL E SENHA
import br.com.CervejariaJavaWEB.util.AuthenticationEmail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
    
    //  INFORMAÇÕES NECESSÁRIAS
    private static final String SMTP_SERVER = "smtp-mail.outlook.com";
    private static final Integer SMTP_PORT = 25;
    private static final String EMAIL_AUTH = AuthenticationEmail.getAUTH_EMAIL();
    private static final String PASS_AUTH = AuthenticationEmail.getAUTH_PASSWORD();
    private static final Boolean SSL = false;
    private static final Boolean TLS = true;
    
    //  ASSUNTO ESTÁTICO
    private static final String EMAIL_SUBJECT = "Sugestão - CervejariaJava";
    
    public static Boolean _enviarEmail(String d_nome, String d_email, String d_telefone, String d_mensagem) throws EmailException{
        /*
            Exemplo -> d_nome = nome do destinatário.
        */
        
        // CRIANDO OBJETO DO TIPO <SimpleEmail>
        SimpleEmail simpleEmail = new SimpleEmail();
        
        //  AUTENTICAÇÃO DO USUÁRIO
        simpleEmail.setAuthentication(EMAIL_AUTH, PASS_AUTH);
        
        //  DEFININDO SERVIDOR SMTP
        simpleEmail.setHostName(SMTP_SERVER);
        
        //  DEFININDO A PORTA
        simpleEmail.setSmtpPort(SMTP_PORT);
        
        //  DEFININDO AUTENTICAÇÃO SSL
        simpleEmail.setSSL(SSL);
        
        //  DEFININDO AUTENTICAÇÃO TLS
        simpleEmail.setTLS(TLS);
        
        //  DEFININDO ASSUNTO
        simpleEmail.setSubject(EMAIL_SUBJECT);
        
        //  DEFININDO REMETENTE
        simpleEmail.setFrom(EMAIL_AUTH);
        
        //  DEFININDO DESTINATARIO
        simpleEmail.addTo(d_email);
        
        //  DEFININDO MENSAGEM
        simpleEmail.setMsg("Agradeçemos pela sua sugestão "+d_nome+".\n\n"
                            + "Informações:\n"
                            + "E-mail: "+d_email+"\n"
                            + "Telefone: "+d_telefone+"\n"
                            + "Sugestão: "+d_mensagem+"\n\n"
                            + "Caso sua sugestão seja aprovada e implementada, entraremos em contato. Obrigado!");
        
        //  MANDANDO O E-MAIL
        simpleEmail.send();
        return true;
    }
    
}
