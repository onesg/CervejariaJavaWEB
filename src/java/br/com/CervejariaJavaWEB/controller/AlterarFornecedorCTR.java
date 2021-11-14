package br.com.CervejariaJavaWEB.controller;

import br.com.CervejariaJavaWEB.dao.FornecedorDAO;
import br.com.CervejariaJavaWEB.dao.GenericDAO;
import br.com.CervejariaJavaWEB.model.FornecedorMODEL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarFornecedorCTR", urlPatterns = {"/AlterarFornecedorCTR"})
public class AlterarFornecedorCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        FornecedorMODEL objFornecedorModel = new FornecedorMODEL();
        
        objFornecedorModel.setId(Integer.parseInt(request.getParameter("form_fornecedor_edit_id")));
        objFornecedorModel.setCnpj(request.getParameter("form_fornecedor_edit_cnpj"));
        objFornecedorModel.setRazao_social(request.getParameter("form_fornecedor_edit_razao_social"));
        objFornecedorModel.setEmail(request.getParameter("form_fornecedor_edit_email"));
        objFornecedorModel.setTelefone(request.getParameter("form_fornecedor_edit_telefone"));
        objFornecedorModel.setEndereco(request.getParameter("form_fornecedor_edit_endereco"));
        objFornecedorModel.setCidade(request.getParameter("form_fornecedor_edit_cidade"));
        objFornecedorModel.setEstado(request.getParameter("form_fornecedor_edit_estado"));
        
        try {
            GenericDAO dao = new FornecedorDAO();
            if(dao._Alterar(objFornecedorModel)){
                request.setAttribute("status", "sucesso-alterar");
                request.setAttribute("mensagem", "Fornecedor "+objFornecedorModel.getRazao_social()+" alterado com sucesso.");
                request.getRequestDispatcher("ListarFornecedorCTR").forward(request, response);
            }else{
                request.setAttribute("status", "erro-alterar");
                request.setAttribute("mensagem", "ERRO AO ALTERAR.");
                request.getRequestDispatcher("CarregarFornecedorCTR?id="+objFornecedorModel.getId()).forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println("\u001B[31mAlterarFornecedorCTR - Erro ao alterar fornecedor!! \n\nErro: " + ex.getMessage());
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
