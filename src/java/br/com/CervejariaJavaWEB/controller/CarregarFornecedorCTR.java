package br.com.CervejariaJavaWEB.controller;

import br.com.CervejariaJavaWEB.dao.FornecedorDAO;
import br.com.CervejariaJavaWEB.dao.GenericDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CarregarFornecedorCTR", urlPatterns = {"/CarregarFornecedorCTR"})
public class CarregarFornecedorCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            GenericDAO dao = new FornecedorDAO();
            
            request.setAttribute("fornecedor", dao._Carregar(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("dashboard_fornecedores_edit.jsp").forward(request, response);
            
        } catch (Exception ex) {
            System.out.println("\u001B[31mCarregarFornecedorCTR - Erro ao carregar fornecedor!! \n\nErro: " + ex.getMessage());
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
