package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados MySQL.
 * 
 * Fornece métodos para abrir e fechar conexões, bem como fechar recursos
 * adicionais como {@link PreparedStatement} e {@link ResultSet}.
 * 
 * Essa implementação utiliza JDBC para realizar a comunicação com o banco.
 */
public class ConexaoBancoDeDados {

    /**
     * Driver JDBC do MySQL.
     */
    private final String driver = "com.mysql.cj.jdbc.Driver";

    /**
     * Endereço do servidor de banco de dados.
     */
    private final String server = "localhost";

    /**
     * Nome do banco de dados.
     */
    private final String bancoDeDados = "db_banco";

    /**
     * URL de conexão com o banco, incluindo configurações de timezone.
     */
    private final String url = "jdbc:mysql://" + server + ":3306/" + bancoDeDados + "?useTimezone=true&serverTimezone=UTC";

    /**
     * Usuário do banco de dados.
     */
    private final String usuario = "root";

    /**
     * Senha do banco de dados.
     */
    private final String senha = "root2025";

    /**
     * Estabelece e retorna uma conexão com o banco de dados.
     *
     * @return Objeto {@link Connection} pronto para uso.
     * @throws RuntimeException em caso de falha ao carregar o driver ou conectar.
     */
    public Connection getConexao() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }

    /**
     * Fecha apenas a conexão com o banco de dados, caso não seja nula.
     *
     * @param con Objeto {@link Connection} a ser fechado.
     */
    public void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fecha a conexão e o {@link PreparedStatement}, caso não sejam nulos.
     *
     * @param con  Objeto {@link Connection} a ser fechado.
     * @param stmt Objeto {@link PreparedStatement} a ser fechado.
     */
    public void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fecha a conexão, o {@link PreparedStatement} e o {@link ResultSet},
     * caso não sejam nulos.
     *
     * @param con  Objeto {@link Connection} a ser fechado.
     * @param stmt Objeto {@link PreparedStatement} a ser fechado.
     * @param rs   Objeto {@link ResultSet} a ser fechado.
     */
    public void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
