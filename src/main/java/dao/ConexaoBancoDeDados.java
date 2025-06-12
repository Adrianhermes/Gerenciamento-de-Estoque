package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBancoDeDados {

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String server = "localhost";
    private static final String bancoDeDados = "db_banco";
    private static final String url = "jdbc:mysql://" + server + ":3306/" + bancoDeDados + "?useTimezone=true&serverTimezone=UTC";
    private static final String usuario = "root";
    private static final String senha = "root2025";//senha do banco de dados

    public static Connection getConexao() {
        try {
            Class.forName(driver);

            return DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

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