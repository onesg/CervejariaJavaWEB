package br.com.CervejariaJavaWEB.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

@WebServlet(name = "DeslogarAdminCTR", urlPatterns = {"/DeslogarAdminCTR"})
public class DeslogarAdminCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            HttpSession session = request.getSession(true); //  RECUPERANDO A SESSÃO
            session.invalidate();   //  INVALIDANDO A SESSÃO
            response.sendRedirect("form_login.jsp");    //  REDIRECIONANDO PARA PÁGINA DE LOGIN
        } catch (Exception ex) {
            System.out.println("\u001B[31mDeslogarAdminCTR - Erro ao deslogar como administrador!! \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
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
