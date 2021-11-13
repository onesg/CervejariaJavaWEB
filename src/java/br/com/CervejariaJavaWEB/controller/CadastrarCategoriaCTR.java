package br.com.CervejariaJavaWEB.controller;

import br.com.CervejariaJavaWEB.dao.CategoriaDAO;
import br.com.CervejariaJavaWEB.dao.GenericDAO;
import br.com.CervejariaJavaWEB.model.CategoriaMODEL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarCategoriaCTR", urlPatterns = {"/CadastrarCategoriaCTR"})
public class CadastrarCategoriaCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CategoriaMODEL objCategoriaModel = new CategoriaMODEL();
        
        objCategoriaModel.setNome(request.getParameter("form_categoria_nome"));
        objCategoriaModel.setDescricao(request.getParameter("form_categoria_descricao"));
        
        try {
            GenericDAO dao = new CategoriaDAO();
            if(dao._Cadastrar(objCategoriaModel)){
                request.setAttribute("status", "sucesso-cadastrar");
                request.setAttribute("mensagem", "Categoria "+objCategoriaModel.getNome()+" cadastrada com sucesso.");
            }else{
                request.setAttribute("status", "erro-cadastrar");
                request.setAttribute("mensagem", "ERRO AO CADASTRAR.");
            }
        } catch (Exception ex) {
            System.out.println("\u001B[31mCadastrarCategoriaCTR - Erro ao cadastrar categoria!! \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
        }
        request.getRequestDispatcher("ListarCategoriaCTR").forward(request, response);
        
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
