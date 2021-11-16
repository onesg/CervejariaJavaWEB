package br.com.CervejariaJavaWEB.dao;

import br.com.CervejariaJavaWEB.model.FornecedorMODEL;
import br.com.CervejariaJavaWEB.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO implements GenericDAO{
    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public FornecedorDAO() {
        try {
            this.conn = ConnectionFactory._conectar();
        } catch (Exception ex) {
            System.out.println("\u001B[31mFornecedorDAO - Erro ao criar conexão. \n\nErro: " + ex.getMessage());
        }
    }

    @Override
    public Boolean _Cadastrar(Object object) throws Exception {
        try {
            FornecedorMODEL fornecedorModel = (FornecedorMODEL) object;

            String SQL = "INSERT INTO fornecedor VALUES(default,?,?,?,?,?,?,?);";

            this.stmt = this.conn.prepareStatement(SQL);
            this.stmt.setString(1, fornecedorModel.getCnpj());
            this.stmt.setString(2, fornecedorModel.getRazao_social());
            this.stmt.setString(3, fornecedorModel.getEmail());
            this.stmt.setString(4, fornecedorModel.getTelefone());
            this.stmt.setString(5, fornecedorModel.getEndereco());
            this.stmt.setString(6, fornecedorModel.getCidade());
            this.stmt.setString(7, fornecedorModel.getEstado());
            
            this.stmt.executeUpdate();

            System.out.println("\u001B[32mFornecedorDAO - Fornecedor " + fornecedorModel.getRazao_social() + " cadastrado com sucesso.");
            return true;
        } catch (Exception ex) {
            System.out.println("\u001B[31mFornecedorDAO - Erro ao Cadastrar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
    }

    @Override
    public List<Object> _Listar() throws Exception {
        List<Object> listaFornecedores = new ArrayList<>();
        try {

            String SQL = "SELECT * FROM fornecedor;";

            this.stmt = this.conn.prepareStatement(SQL);
            this.rs = this.stmt.executeQuery();

            while (this.rs.next()) {
                FornecedorMODEL fornecedorMODEL = new FornecedorMODEL();
                fornecedorMODEL.setId(this.rs.getInt("id_fornecedor"));
                fornecedorMODEL.setCnpj(this.rs.getString("cnpj_fornecedor"));
                fornecedorMODEL.setRazao_social(this.rs.getString("razao_social_fornecedor"));
                fornecedorMODEL.setEmail(this.rs.getString("email_fornecedor"));
                fornecedorMODEL.setTelefone(this.rs.getString("telefone_fornecedor"));
                fornecedorMODEL.setEndereco(this.rs.getString("endereco_fornecedor"));
                fornecedorMODEL.setCidade(this.rs.getString("cidade_fornecedor"));
                fornecedorMODEL.setEstado(this.rs.getString("estado_fornecedor"));
                listaFornecedores.add(fornecedorMODEL);
            }

            System.out.println("\u001B[32mFornecedorDAO - Fornecedores listados com sucesso.");

        } catch (Exception ex) {
            System.out.println("\u001B[31mFornecedorDAO - Erro ao Listar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
        return listaFornecedores;
    }

    @Override
    public Boolean _Alterar(Object object) throws Exception {
        try {
            FornecedorMODEL fornecedorModel = (FornecedorMODEL) object;
            
            String SQL = "UPDATE fornecedor SET "
                    + "cnpj_fornecedor = ?, "
                    + "razao_social_fornecedor = ?, "
                    + "email_fornecedor = ?, "
                    + "telefone_fornecedor = ?, "
                    + "endereco_fornecedor = ?, "
                    + "cidade_fornecedor = ?, "
                    + "estado_fornecedor = ? "
                    + "WHERE id_fornecedor = ?;";

            this.stmt = this.conn.prepareStatement(SQL);
            this.stmt.setString(1, fornecedorModel.getCnpj());
            this.stmt.setString(2, fornecedorModel.getRazao_social());
            this.stmt.setString(3, fornecedorModel.getEmail());
            this.stmt.setString(4, fornecedorModel.getTelefone());
            this.stmt.setString(5, fornecedorModel.getEndereco());
            this.stmt.setString(6, fornecedorModel.getCidade());
            this.stmt.setString(7, fornecedorModel.getEstado());
            this.stmt.setInt(8, fornecedorModel.getId());
            this.stmt.executeUpdate();

            System.out.println("\u001B[32mFornecedorDAO - Fornecedor " + fornecedorModel.getRazao_social()+ " alterado com sucesso.");
            return true;
        } catch (Exception ex) {
            System.out.println("\u001B[31mFornecedorDAO - Erro ao Alterar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
    }

    @Override
    public Boolean _Excluir(Integer id) throws Exception {
        try {
            
            String SQL = "DELETE FROM fornecedor WHERE id_fornecedor = ?";
            
            this.stmt = this.conn.prepareStatement(SQL);
            this.stmt.setInt(1, id);
            this.stmt.executeUpdate();
            
            System.out.println("\u001B[32mFornecedorDAO - Fornecedor foi excluido com sucesso.");
            return true;
        } catch (Exception ex) {
            System.out.println("\u001B[31mFornecedorDAO - Erro ao Excluir. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
    }

    @Override
    public Object _Carregar(Integer id) throws Exception {
        FornecedorMODEL fornecedorMODEL = new FornecedorMODEL();
        try {
            
            String SQL = "SELECT * FROM fornecedor WHERE id_fornecedor = ?;";
            
            this.stmt = this.conn.prepareStatement(SQL);
            this.stmt.setInt(1, id);
            this.rs = this.stmt.executeQuery();
            rs.next();
            
            fornecedorMODEL.setId(rs.getInt("id_fornecedor"));
            fornecedorMODEL.setCnpj(rs.getString("cnpj_fornecedor"));
            fornecedorMODEL.setRazao_social(rs.getString("razao_social_fornecedor"));
            fornecedorMODEL.setEmail(rs.getString("email_fornecedor"));
            fornecedorMODEL.setTelefone(rs.getString("telefone_fornecedor"));
            fornecedorMODEL.setEndereco(rs.getString("endereco_fornecedor"));
            fornecedorMODEL.setCidade(rs.getString("cidade_fornecedor"));
            fornecedorMODEL.setEstado(rs.getString("estado_fornecedor"));
            
        } catch (Exception ex) {
            System.out.println("\u001B[31mFornecedorDAO - Erro ao Carregar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
        return fornecedorMODEL;
    }
    
}
