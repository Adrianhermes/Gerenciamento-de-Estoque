
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoBancoDeDados {
/**
 * Classe para gerenciar a conexão com o banco de dados.
 */
    private static Connection conexao = null;

    /**
     * Método para obter a conexão com o banco de dados.
     * Se a conexão já existe, retorna a conexão existente.
     * Se a conexão não existe, tenta estabelecer uma nova conexão.
     * @return A conexão com o banco de dados.
     */
    public static Connection getConexao() {
        if (conexao == null) {
            try {
                String driver = "com.mysql.cj.jdbc.Driver";
                Class.forName(driver);

                String server = "localhost"; 
                String bancoDeDados = "db_gerenciamento";
                String url = "jdbc:mysql://" + server + ":3306/" + bancoDeDados + "?useTimezone=true&serverTimezone=UTC";
                String usuario = "root";
                String senha = "root2025";//senha do banco de dados

                conexao = DriverManager.getConnection(url, usuario, senha);

                if (conexao != null) {
                    System.out.println("Status: Conectado!");
                } else {
                    System.out.println("Status: NÃO CONECTADO!");
                }
            } catch (ClassNotFoundException e) {
                System.out.println("O driver não foi encontrado. " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Não foi possível conectar...");
            }
        }
        return conexao;
    }

    /**
     * Método para preparar uma declaração SQL.
     * @param query A consulta SQL a ser preparada.
     * @return Um objeto PreparedStatement que representa a consulta SQL preparada.
     */
    public PreparedStatement prepareStatement(String query) {
        
        return null;
        
    }
}
