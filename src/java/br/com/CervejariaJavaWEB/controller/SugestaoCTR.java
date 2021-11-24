package br.com.CervejariaJavaWEB.controller;

import br.com.CervejariaJavaWEB.util.AuthenticationEmail;   //  ARQUIVO QUE CONTÉM AS INFORMAÇÕES DO EMAIL E SENHA

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.SimpleEmail;

@WebServlet(name = "SugestaoCTR", urlPatterns = {"/SugestaoCTR"})
public class SugestaoCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //
        try {
            
            //  PEGANDO AS INFORMAÇÕES DO FORMULÁRIO
            String nome = request.getParameter("form_sugestao_nome");
            String email = request.getParameter("form_sugestao_email");
            String telefone = request.getParameter("form_sugestao_telefone");
            String texto = request.getParameter("form_sugestao_texto");
            
            
            // CRIANDO OBJETO DO TIPO <SimpleEmail>
            SimpleEmail simpleEmail = new SimpleEmail();
            
            //  ATRIBUTOS DO EMAIL
            simpleEmail.addTo(email);  //  DESTINATÁRIO DO EMAIL
            simpleEmail.setFrom(AuthenticationEmail.getAUTH_EMAIL());    //  REMETENTE DO EMAIL
            simpleEmail.setSubject("Sugestão - CervejariaJava"); //  ASSUNTO DO EMAIL
            
            //  MENSAGEM DO EMAIL
            simpleEmail.setMsg(
                    "Agradeçemos pela sua sugestão "+nome+".\n\n"
                            + "Informações:\n"
                            + "E-mail: "+email+"\n"
                            + "Telefone: "+telefone+"\n"
                            + "Sugestão: "+texto+"\n\n"
                            + "Caso sua sugestão seja aprovada e implementada, entraremos em contato. Obrigado!"
            );
            
            //  AUTENTICAÇÃO (USUÁRIO E SENHA)
            simpleEmail.setAuthentication(AuthenticationEmail.getAUTH_EMAIL(), AuthenticationEmail.getAUTH_PASSWORD());
            
            simpleEmail.setHostName("smtp-mail.outlook.com");   //  SMTP PARA ENVIAR
            simpleEmail.setSmtpPort(587); //  PORTA SMTP
            simpleEmail.setSSL(true);   //  SEGURANÇA SSL
            simpleEmail.setTLS(true);   //  SEGURANÇA TLS
            
            simpleEmail.send(); //  ENVIAR O EMAIL
            
            request.setAttribute("status", "Sugestão enviada com sucesso.");
            request.getRequestDispatcher("form_sugestao.jsp").forward(request, response);
            
            
        } catch (Exception ex) {
            request.setAttribute("status", "Sugestão não foi enviada.");
            request.getRequestDispatcher("form_sugestao.jsp").forward(request, response);
            System.out.println("SugestaoCTR - Erro ao enviar sugestão: "+ex.getMessage());
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
