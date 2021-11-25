package br.com.CervejariaJavaWEB.controller;

import br.com.CervejariaJavaWEB.util.SendEmail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SugestaoCTR", urlPatterns = {"/SugestaoCTR"})
public class SugestaoCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //  PEGANDO AS INFORMAÇÕES DO FORMULÁRIO
        String nome = request.getParameter("form_sugestao_nome");
        String email = request.getParameter("form_sugestao_email");
        String texto = request.getParameter("form_sugestao_texto");
        
        try {
            
            //  TENTANDO ENVIAR O EMAIL
            SendEmail._enviarEmail(nome, email, texto);
            
            request.setAttribute("status", "sucesso-sugestao");
            request.setAttribute("mensagem", "Sugestão enviada com sucesso.");
            System.out.println("\u001B[32mSugestaoCTR - Sugestão enviada com sucesso.");
            
        } catch (Exception ex) {
            request.setAttribute("status", "erro-sugestao");
            request.setAttribute("mensagem", "Sugestão não foi enviada.");
            System.out.println("\u001B[31mSugestaoCTR - Erro ao enviar sugestão! \n\nErro: "+ex.getMessage());
        }
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
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
