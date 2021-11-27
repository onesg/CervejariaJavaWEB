package br.com.CervejariaJavaWEB.dao;

import br.com.CervejariaJavaWEB.model.ClienteMODEL;
import br.com.CervejariaJavaWEB.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements GenericDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public ClienteDAO() {
        try {
            this.conn = ConnectionFactory._conectar();
        } catch (Exception ex) {
            System.out.println("\u001B[31mClienteDAO - Erro ao criar conexão. \n\nErro: " + ex.getMessage());
        }
    }

    @Override
    public Boolean _Cadastrar(Object object) throws Exception {
        try {
            ClienteMODEL clienteModel = (ClienteMODEL) object;

            String SQL = "INSERT INTO cliente VALUES(default,?,?,?,?,?);";

            this.stmt = this.conn.prepareStatement(SQL);
            this.stmt.setString(1, clienteModel.getNome());
            this.stmt.setString(2, clienteModel.getEmail());
            this.stmt.setString(3, clienteModel.getTelefone());
            this.stmt.setString(4, clienteModel.getLogin());
            this.stmt.setString(5, clienteModel.getSenha());
            this.stmt.executeUpdate();

            System.out.println("\u001B[32mClienteDAO - Cliente " + clienteModel.getNome() + " cadastrado com sucesso.");
            return true;
        } catch (Exception ex) {
            System.out.println("\u001B[31mClienteDAO - Erro ao Cadastrar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
    }

    @Override
    public List<Object> _Listar() throws Exception {
        List<Object> listaClientes = new ArrayList<>();
        try {

            String SQL = "SELECT * FROM cliente;";

            this.stmt = this.conn.prepareStatement(SQL);
            this.rs = this.stmt.executeQuery();

            while (this.rs.next()) {
                ClienteMODEL clienteMODEL = new ClienteMODEL();
                clienteMODEL.setId(this.rs.getInt("id_cliente"));
                clienteMODEL.setNome(this.rs.getString("nome_cliente"));
                clienteMODEL.setEmail(this.rs.getString("email_cliente"));
                clienteMODEL.setTelefone(this.rs.getString("telefone_cliente"));
                clienteMODEL.setLogin(this.rs.getString("login_cliente"));
                clienteMODEL.setSenha(this.rs.getString("senha_cliente"));
                listaClientes.add(clienteMODEL);
            }

            System.out.println("\u001B[32mClienteDAO - Clientes listados com sucesso.");

        } catch (Exception ex) {
            System.out.println("\u001B[31mClienteDAO - Erro ao Listar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
        return listaClientes;
    }

    @Override
    public Boolean _Alterar(Object object) throws Exception {
        try {
            ClienteMODEL clienteModel = (ClienteMODEL) object;
            
            String SQL = "UPDATE cliente SET "
                    + "nome_cliente = ?, "
                    + "email_cliente = ?, "
                    + "telefone_cliente = ?, "
                    + "login_cliente = ?, "
                    + "senha_cliente = ? "
                    + "WHERE id_cliente = ?;";

            this.stmt = this.conn.prepareStatement(SQL);
            this.stmt.setString(1, clienteModel.getNome());
            this.stmt.setString(2, clienteModel.getEmail());
            this.stmt.setString(3, clienteModel.getTelefone());
            this.stmt.setString(4, clienteModel.getLogin());
            this.stmt.setString(5, clienteModel.getSenha());
            this.stmt.setInt(6, clienteModel.getId());
            this.stmt.executeUpdate();

            System.out.println("\u001B[32mClienteDAO - Cliente " + clienteModel.getNome() + " alterado com sucesso.");
            return true;
        } catch (Exception ex) {
            System.out.println("\u001B[31mClienteDAO - Erro ao Alterar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
    }

    @Override
    public Boolean _Excluir(Integer id) throws Exception {
        try {
            
            String SQL = "DELETE FROM cliente WHERE id_cliente = ?";
            
            this.stmt = this.conn.prepareStatement(SQL);
            this.stmt.setInt(1, id);
            this.stmt.executeUpdate();
            
            System.out.println("\u001B[32mClienteDAO - Cliente foi excluido com sucesso.");
            return true;
        } catch (Exception ex) {
            System.out.println("\u001B[31mClienteDAO - Erro ao Excluir. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
    }

    @Override
    public Object _Carregar(Integer id) throws Exception {
        ClienteMODEL clienteMODEL = new ClienteMODEL();
        try {
            
            String SQL = "SELECT * FROM cliente WHERE id_cliente = ?;";
            
            this.stmt = this.conn.prepareStatement(SQL);
            this.stmt.setInt(1, id);
            this.rs = this.stmt.executeQuery();
            rs.next();
            
            clienteMODEL.setId(rs.getInt("id_cliente"));
            clienteMODEL.setNome(rs.getString("nome_cliente"));
            clienteMODEL.setEmail(rs.getString("email_cliente"));
            clienteMODEL.setTelefone(rs.getString("telefone_cliente"));
            clienteMODEL.setLogin(rs.getString("login_cliente"));
            clienteMODEL.setSenha(rs.getString("senha_cliente"));
            
        } catch (Exception ex) {
            System.out.println("\u001B[31mClienteDAO - Erro ao Carregar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
        return clienteMODEL;
    }
    
    public Integer _Count() throws Exception {
        
        //  CONTADOR DE CLIENTES
        Integer c = 0;
        
        try {
            
            String SQL = "SELECT COUNT(*) FROM cliente;";
            
            this.stmt = this.conn.prepareStatement(SQL);
            this.rs = this.stmt.executeQuery();
            rs.next();
            
            if(rs.getInt("count") != 0){
                c = rs.getInt("count");
            }
            
        } catch (Exception ex) {
            System.out.println("\u001B[31mClienteDAO - Erro ao Contar. \n\nErro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            ConnectionFactory._desconectar(conn, stmt, rs);
        }
        return c;
    }

}
