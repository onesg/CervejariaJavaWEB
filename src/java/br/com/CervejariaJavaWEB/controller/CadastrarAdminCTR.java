package br.com.CervejariaJavaWEB.controller;

import br.com.CervejariaJavaWEB.model.AdminMODEL;
import br.com.CervejariaJavaWEB.dao.GenericDAO;
import br.com.CervejariaJavaWEB.dao.AdminDAO;
import br.com.CervejariaJavaWEB.util.Hashing;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarAdminCTR", urlPatterns = {"/CadastrarAdminCTR"})
public class CadastrarAdminCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        /*/
        System.out.println("\nINFORMAÇÕES DO FORMULARIO:");
        System.out.println("LOGIN: " + request.getParameter("form_admin_login"));
        System.out.println("SENHA: " + request.getParameter("form_admin_senha") + "\n");
        /*/

        AdminMODEL objAdminModel = new AdminMODEL();

        objAdminModel.setLogin(request.getParameter("form_admin_login"));
        objAdminModel.setSenha(Hashing._criptografar(request.getParameter("form_admin_senha")));

        try {
            GenericDAO daoList = new AdminDAO();
            //  VERIFICANDO
            Boolean status = false;
            for (Object object : daoList._Listar()) {
                AdminMODEL admin = (AdminMODEL) object;
                if (admin.getLogin().equals(objAdminModel.getLogin())) {
                    status = true;
                    break;
                }
            }
            if (status != true) {
                GenericDAO dao = new AdminDAO();
                if (dao._Cadastrar(objAdminModel)) {
                    request.setAttribute("status", "sucesso-cadastrar");
                    request.setAttribute("mensagem", "Administrador " + objAdminModel.getLogin() + " foi cadastrado com sucesso.");
                } else {
                    request.setAttribute("status", "erro-cadastrar");
                    request.setAttribute("mensagem", "ERRO AO CADASTRAR.");
                }
            } else {
                System.err.println("\u001B[31mAdministrador já existe.");
                request.setAttribute("status", "erro-cadastrar");
                request.setAttribute("mensagem", "Usuário já existe.");
            }
        } catch (Exception ex) {
            System.out.println("\u001B[31mCadastrarAdminCTR - Erro ao cadastrar administrador!! \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
        }
        request.getRequestDispatcher("form_register.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarAdminCTR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarAdminCTR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
