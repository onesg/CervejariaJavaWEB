package br.com.CervejariaJavaWEB.dao;

import br.com.CervejariaJavaWEB.model.CategoriaMODEL;
import br.com.CervejariaJavaWEB.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements GenericDAO{
    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public CategoriaDAO() {
        try {
            this.conn = ConnectionFactory._conectar();
        } catch (Exception ex) {
            System.out.println("\u001B[31mCategoriaDAO - Erro ao criar conexão. \n\nErro: " + ex.getMessage());
        }
    }

    @Override
    public Boolean _Cadastrar(Object object) throws Exception {
        try {
            CategoriaMODEL categoriaModel = (CategoriaMODEL) object;

            String SQL = "INSERT INTO categoria VALUES(default,?,?);";

            this.stmt = this.conn.prepareStatement(SQL);
            this.stmt.setString(1, categoriaModel.getNome());
            this.stmt.setString(2, categoriaModel.getDescricao());
            
            this.stmt.executeUpdate();

            System.out.println("\u001B[32mCategoriaDAO - Categoria " + categoriaModel.getNome()+ " cadastrada com sucesso.");
            return true;
        } catch (Exception ex) {
            System.out.println("\u001B[31mCategoriaDAO - Erro ao Cadastrar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
    }

    @Override
    public List<Object> _Listar() throws Exception {
        List<Object> listaCategorias = new ArrayList<>();
        try {

            String SQL = "SELECT * FROM categoria;";

            this.stmt = this.conn.prepareStatement(SQL);
            this.rs = this.stmt.executeQuery();

            while (this.rs.next()) {
                CategoriaMODEL categoriaMODEL = new CategoriaMODEL();
                categoriaMODEL.setId(this.rs.getInt("id_categoria"));
                categoriaMODEL.setNome(this.rs.getString("nome_categoria"));
                categoriaMODEL.setDescricao(this.rs.getString("descricao_categoria"));
                
                listaCategorias.add(categoriaMODEL);
            }

            System.out.println("\u001B[32mCategoriaDAO - Categorias listadas com sucesso.");

        } catch (Exception ex) {
            System.out.println("\u001B[31mCategoriaDAO - Erro ao Listar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
        return listaCategorias;
    }

    @Override
    public Boolean _Alterar(Object object) throws Exception {
        try {
            CategoriaMODEL categoriaModel = (CategoriaMODEL) object;
            
            String SQL = "UPDATE categoria SET "
                    + "nome_categoria = ?, "
                    + "descricao_categoria = ?"
                    + "WHERE id_categoria = ?;";

            this.stmt = this.conn.prepareStatement(SQL);
            this.stmt.setString(1, categoriaModel.getNome());
            this.stmt.setString(2, categoriaModel.getDescricao());
            this.stmt.setInt(3, categoriaModel.getId());
            this.stmt.executeUpdate();

            System.out.println("\u001B[32mCategoriaDAO - Categoria " + categoriaModel.getNome() + " alterada com sucesso.");
            return true;
        } catch (Exception ex) {
            System.out.println("\u001B[31mCategoriaDAO - Erro ao Alterar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
    }

    @Override
    public Boolean _Excluir(Integer id) throws Exception {
        try {
            
            String SQL = "DELETE FROM categoria WHERE id_categoria = ?";
            
            this.stmt = this.conn.prepareStatement(SQL);
            this.stmt.setInt(1, id);
            this.stmt.executeUpdate();
            
            System.out.println("\u001B[32mCategoriaDAO - Categoria foi excluida com sucesso.");
            return true;
        } catch (Exception ex) {
            System.out.println("\u001B[31mCategoriaDAO - Erro ao Excluir. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Object _Carregar(Integer id) throws Exception {
        CategoriaMODEL categoriaMODEL = new CategoriaMODEL();
        try {
            
            String SQL = "SELECT * FROM categoria WHERE id_categoria = ?;";
            
            this.stmt = this.conn.prepareStatement(SQL);
            this.stmt.setInt(1, id);
            this.rs = this.stmt.executeQuery();
            rs.next();
            
            categoriaMODEL.setId(rs.getInt("id_categoria"));
            categoriaMODEL.setNome(rs.getString("nome_categoria"));
            categoriaMODEL.setDescricao(rs.getString("descricao_categoria"));
            
            
            
        } catch (Exception ex) {
            System.out.println("\u001B[31mCategoriaDAO - Erro ao Carregar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
        return categoriaMODEL;
    }
    
}
