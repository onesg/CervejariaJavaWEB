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
        String telefone = request.getParameter("form_sugestao_telefone");
        String texto = request.getParameter("form_sugestao_texto");
        
        try {
            
            //  TENTANDO ENVIAR O EMAIL
            SendEmail._enviarEmail(nome, email, telefone, texto);
            
            request.setAttribute("status", "Sugestão enviada com sucesso.");
            request.getRequestDispatcher("form_sugestao.jsp").forward(request, response);
            
        } catch (Exception ex) {
            
            request.setAttribute("status", "Sugestão não foi enviada.");
            request.getRequestDispatcher("form_sugestao.jsp").forward(request, response);
            
            System.out.println("SugestaoCTR - Erro ao enviar sugestão: \n"+ex.getMessage());
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
