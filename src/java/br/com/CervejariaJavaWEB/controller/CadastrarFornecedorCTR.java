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

@WebServlet(name = "CadastrarFornecedorCTR", urlPatterns = {"/CadastrarFornecedorCTR"})
public class CadastrarFornecedorCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        FornecedorMODEL objFornecedorModel = new FornecedorMODEL();
        
        objFornecedorModel.setCnpj(request.getParameter("form_fornecedor_cnpj"));
        objFornecedorModel.setRazao_social(request.getParameter("form_fornecedor_razao_social"));
        objFornecedorModel.setEmail(request.getParameter("form_fornecedor_email"));
        objFornecedorModel.setTelefone(request.getParameter("form_fornecedor_telefone"));
        objFornecedorModel.setEndereco(request.getParameter("form_fornecedor_endereco"));
        objFornecedorModel.setCidade(request.getParameter("form_fornecedor_cidade"));
        objFornecedorModel.setEstado(request.getParameter("form_fornecedor_estado"));
        
        
        try {
            GenericDAO dao = new FornecedorDAO();
            if(dao._Cadastrar(objFornecedorModel)){
                request.setAttribute("status", "sucesso-cadastrar");
                request.setAttribute("mensagem", "Fornecedor "+objFornecedorModel.getRazao_social()+" cadastrado com sucesso.");
            }else{
                request.setAttribute("status", "erro-cadastrar");
                request.setAttribute("mensagem", "ERRO AO CADASTRAR.");
            }
        } catch (Exception ex) {
            System.out.println("\u001B[31mCadastrarFornecedorCTR - Erro ao cadastrar fornecedor!! \n\nErro: " + ex.getMessage());
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
