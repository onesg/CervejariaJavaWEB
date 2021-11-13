package br.com.CervejariaJavaWEB.controller;

import br.com.CervejariaJavaWEB.dao.FornecedorDAO;
import br.com.CervejariaJavaWEB.dao.GenericDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcluirFornecedorCTR", urlPatterns = {"/ExcluirFornecedorCTR"})
public class ExcluirFornecedorCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            GenericDAO dao = new FornecedorDAO();
            
            if(dao._Excluir(Integer.parseInt(request.getParameter("id")))){
                request.setAttribute("status", "sucesso-excluir");
                request.setAttribute("mensagem", "Excluido com sucesso.");
            }else{
                request.setAttribute("status", "erro-excluir");
                request.setAttribute("mensagem", "ERRO AO EXCLUIR.");
            }
        } catch (Exception ex) {
            System.out.println("\u001B[31mExcluirFornecedorCTR - Erro ao excluir fornecedor!! \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
        }
        request.getRequestDispatcher("ListarFornecedorCTR").forward(request, response);
        
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
