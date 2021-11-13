package br.com.CervejariaJavaWEB.controller;

import br.com.CervejariaJavaWEB.dao.FornecedorDAO;
import br.com.CervejariaJavaWEB.dao.GenericDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarFornecedorCTR", urlPatterns = {"/ListarFornecedorCTR"})
public class ListarFornecedorCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            GenericDAO dao = new FornecedorDAO();
            request.setAttribute("ListaFornecedores", dao._Listar());
            request.getRequestDispatcher("dashboard_fornecedores.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
