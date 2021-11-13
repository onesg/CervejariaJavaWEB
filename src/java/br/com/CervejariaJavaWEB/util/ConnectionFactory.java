package br.com.CervejariaJavaWEB.util;

//  IMPORTANDO BIBLIOTECAS SQL
import java.sql.*;

public class ConnectionFactory {

    //  INFORMAÇÕES SOBRE O BANCO DE DADOS. (POSTGRESQL)
    private static final String driver = "org.postgresql.Driver";                   //  DRIVER
    private static final String banco = "CervejariaJavaWEB";                        //  NOME DO BANCO
    private static final String url = "jdbc:postgresql://localhost:5432/" + banco;  //  URL DO BANCO
    private static final String user = "postgres";                                  //  USUARIO DO BANCO
    private static final String pass = "123456";                                    //  SENHA DO BANCO

    //  METODO PARA CONEXÃO.
    public static Connection _conectar() throws Exception {
        try {
            Class.forName(driver);
            System.out.println("\u001B[32mConnectionFactory - Conexão realizada com sucesso.");
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            throw new Exception("\u001B[31mConnectionFactory - Erro de Conexão! \n\nError: " + ex.getMessage());
        }
    }

    //  METODO PARA DESCONEXÃO.
    public static void _desconectar(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
            System.out.println("\u001B[32mConnectionFactory - Desconexão realizada com sucesso.");
        } catch (Exception ex) {
            throw new Exception("\u001B[31mConnectionFactory - Erro ao fechar a conexão. \n\nErro: " + ex.getMessage());
        }
    }

}
