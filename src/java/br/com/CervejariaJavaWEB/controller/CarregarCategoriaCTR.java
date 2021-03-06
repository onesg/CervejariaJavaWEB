package br.com.CervejariaJavaWEB.controller;

import br.com.CervejariaJavaWEB.dao.CategoriaDAO;
import br.com.CervejariaJavaWEB.dao.GenericDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CarregarCategoriaCTR", urlPatterns = {"/CarregarCategoriaCTR"})
public class CarregarCategoriaCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            GenericDAO dao = new CategoriaDAO();
            
            request.setAttribute("categoria", dao._Carregar(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("dashboard_categorias_edit.jsp").forward(request, response);
            
        } catch (Exception ex) {
            System.out.println("\u001B[31mCarregarCategoriaCTR - Erro ao carregar categoria!! \n\nErro: " + ex.getMessage());
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
