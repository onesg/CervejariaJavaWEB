package br.com.CervejariaJavaWEB.controller;

import br.com.CervejariaJavaWEB.dao.ClienteDAO;
import br.com.CervejariaJavaWEB.dao.GenericDAO;
import br.com.CervejariaJavaWEB.model.ClienteMODEL;
import br.com.CervejariaJavaWEB.util.Hashing;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarClienteCTR", urlPatterns = {"/AlterarClienteCTR"})
public class AlterarClienteCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
        ClienteMODEL objClienteModel = new ClienteMODEL();
        
        objClienteModel.setId(Integer.parseInt(request.getParameter("form_cliente_edit_id")));
        objClienteModel.setNome(request.getParameter("form_cliente_edit_nome"));
        objClienteModel.setEmail(request.getParameter("form_cliente_edit_email"));
        objClienteModel.setTelefone(request.getParameter("form_cliente_edit_telefone"));
        objClienteModel.setLogin(request.getParameter("form_cliente_edit_login"));
        objClienteModel.setSenha(Hashing._criptografar(request.getParameter("form_cliente_edit_senha")));
        
        try {
            GenericDAO dao = new ClienteDAO();
            if(dao._Alterar(objClienteModel)){
                request.setAttribute("status", "sucesso-alterar");
                request.setAttribute("mensagem", "Cliente "+objClienteModel.getNome()+" alterado com sucesso.");
                request.getRequestDispatcher("ListarClienteCTR").forward(request, response);
            }else{
                request.setAttribute("status", "erro-alterar");
                request.setAttribute("mensagem", "ERRO AO ALTERAR.");
                request.getRequestDispatcher("CarregarClienteCTR?id="+objClienteModel.getId()).forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println("\u001B[31mAlterarClienteCTR - Erro ao alterar cliente!! \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        //request.getRequestDispatcher("dashboard_clientes.jsp").forward(request, response)
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlterarClienteCTR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlterarClienteCTR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
