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

@WebServlet(name = "AlterarCategoriaCTR", urlPatterns = {"/AlterarCategoriaCTR"})
public class AlterarCategoriaCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CategoriaMODEL objCategoriaModel = new CategoriaMODEL();
        
        objCategoriaModel.setId(Integer.parseInt(request.getParameter("form_categoria_edit_id")));
        objCategoriaModel.setNome(request.getParameter("form_categoria_edit_nome"));
        objCategoriaModel.setDescricao(request.getParameter("form_categoria_edit_descricao"));
        
        try {
            GenericDAO dao = new CategoriaDAO();
            if(dao._Alterar(objCategoriaModel)){
                request.setAttribute("status", "sucesso-alterar");
                request.setAttribute("mensagem", "Categoria "+objCategoriaModel.getNome()+" alterada com sucesso.");
                request.getRequestDispatcher("ListarCategoriaCTR").forward(request, response);
            }else{
                request.setAttribute("status", "erro-alterar");
                request.setAttribute("mensagem", "ERRO AO ALTERAR.");
                request.getRequestDispatcher("CarregarCategoriaCTR?id="+objCategoriaModel.getId()).forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println("\u001B[31mAlterarCategoriaCTR - Erro ao alterar categoria!! \n\nErro: " + ex.getMessage());
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
