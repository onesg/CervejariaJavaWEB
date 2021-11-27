package br.com.CervejariaJavaWEB.controller;

import br.com.CervejariaJavaWEB.dao.ClienteDAO;
import br.com.CervejariaJavaWEB.dao.FornecedorDAO;
import br.com.CervejariaJavaWEB.dao.CategoriaDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ContarCTR", urlPatterns = {"/ContarCTR"})
public class ContarCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            //  INSTANCIANDO CLIENTES
            ClienteDAO daoCliente = new ClienteDAO();
            request.setAttribute("QtdClientes", daoCliente._Count());
            
            //  INSTANCIANDO FORNECEDORES
            FornecedorDAO daoFornecedor = new FornecedorDAO();
            request.setAttribute("QtdFornecedores", daoFornecedor._Count());
            
            //  INSTANCIANDO CATEGORIAS
            CategoriaDAO daoCategoria = new CategoriaDAO();
            request.setAttribute("QtdCategorias", daoCategoria._Count());
            
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            
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
