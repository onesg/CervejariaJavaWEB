package br.com.CervejariaJavaWEB.controller;

import br.com.CervejariaJavaWEB.dao.AdminDAO;
import br.com.CervejariaJavaWEB.dao.GenericDAO;
import br.com.CervejariaJavaWEB.model.AdminMODEL;
import br.com.CervejariaJavaWEB.util.Hashing;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LogarAdminCTR", urlPatterns = {"/LogarAdminCTR"})
public class LogarAdminCTR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        //
        AdminMODEL objAdminModel = new AdminMODEL();

        objAdminModel.setLogin(request.getParameter("form_admin_login"));
        objAdminModel.setSenha(Hashing._criptografar(request.getParameter("form_admin_senha")));
        String error = "";
        try {
            GenericDAO daoList = new AdminDAO();
            //  VERIFICANDO SE EXISTE
            Boolean user = false;
            Boolean pass = false;
            for (Object object : daoList._Listar()) {
                AdminMODEL admin = (AdminMODEL) object;
                if (admin.getLogin().equals(objAdminModel.getLogin())) {
                    //  EXISTE USUARIO
                    user = true;
                    if (admin.getSenha().equals(objAdminModel.getSenha())) {
                        //  SENHAS IGUAIS, PODE LOGAR
                        pass = true;
                        break;
                    } else {
                        //  SENHAS DIFERENTES, NAO PODE LOGAR
                        error = "senha";
                        request.setAttribute("status", "erro-logar");
                        request.setAttribute("mensagem", "Senha está incorreta.");
                        pass = false;
                        break;
                    }
                } else {
                    //  NAO EXISTE USUARIO
                    error = "404";
                    request.setAttribute("status", "erro-logar");
                    request.setAttribute("mensagem", "Administrador não existe.");
                }
            }
            if (user == true && pass == true) {
                //  PODE IR PARA DASHBOARD
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            } else {
                //  NAO PODE, VOLTAR PARA LOGIN
                if(!error.equals("senha") && !error.equals("404")){     //  NECESSARIO CASO NAO EXISTA NENHUM ADM CADASTRADO
                    request.setAttribute("status", "erro-logar");
                    request.setAttribute("mensagem", "Administrador não existe.");
                }
                request.getRequestDispatcher("form_login.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println("\u001B[31mLogarAdminCTR - Erro ao logar como administrador!! \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LogarAdminCTR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LogarAdminCTR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
