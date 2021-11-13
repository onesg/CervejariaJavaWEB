package br.com.CervejariaJavaWEB.dao;

import br.com.CervejariaJavaWEB.model.AdminMODEL;
import br.com.CervejariaJavaWEB.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO implements GenericDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public AdminDAO() {
        try {
            this.conn = ConnectionFactory._conectar();
        } catch (Exception ex) {
            System.out.println("\u001B[31mAdminDAO - Erro ao criar conexão. \n\nErro: " + ex.getMessage());
        }
    }

    @Override
    public Boolean _Cadastrar(Object object) throws Exception {
        try {
            AdminMODEL adminModel = (AdminMODEL) object;

            String SQL = "INSERT INTO admin_user VALUES(default,?,?);";

            this.stmt = this.conn.prepareStatement(SQL);
            this.stmt.setString(1, adminModel.getLogin());
            this.stmt.setString(2, adminModel.getSenha());
            this.stmt.executeUpdate();

            System.out.println("\u001B[32mAdminDAO - Administrador " + adminModel.getLogin() + " cadastrado com sucesso.");
            return true;
        } catch (Exception ex) {
            System.out.println("\u001B[31mAdminDAO - Erro ao Cadastrar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
    }

    @Override
    public List<Object> _Listar() throws Exception {
        List<Object> listaAdmins = new ArrayList<>();
        try {

            String SQL = "SELECT * FROM admin_user;";

            this.stmt = this.conn.prepareStatement(SQL);
            this.rs = this.stmt.executeQuery();

            while (this.rs.next()) {
                AdminMODEL adminMODEL = new AdminMODEL();
                adminMODEL.setId(this.rs.getInt("id_admin_user"));
                adminMODEL.setLogin(this.rs.getString("login_admin_user"));
                adminMODEL.setSenha(this.rs.getString("senha_admin_user"));
                listaAdmins.add(adminMODEL);
            }

            System.out.println("\u001B[32mAdminDAO - Administradores listados com sucesso.");

        } catch (Exception ex) {
            System.out.println("\u001B[31mAdminDAO - Erro ao Listar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
        return listaAdmins;
    }

    @Override
    public Boolean _Alterar(Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean _Excluir(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object _Carregar(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
