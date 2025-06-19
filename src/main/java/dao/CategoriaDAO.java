package dao;

import modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe responsável por realizar operações de persistência (CRUD)
 * relacionadas à entidade {@link Categoria} no banco de dados.
 * 
 * Utiliza a classe {@link ConexaoBancoDeDados} para abrir e fechar conexões.
 * 
 * As operações incluem: inserção, leitura, atualização e exclusão de categorias.
 */
public class CategoriaDAO {

    /**
     * Instância da classe de conexão com o banco de dados.
     */
    private final ConexaoBancoDeDados conexaoBD = new ConexaoBancoDeDados();

    /**
     * Insere uma nova categoria no banco de dados.
     *
     * @param c Objeto {@link Categoria} contendo os dados a serem inseridos.
     */
    public void create(Categoria c) {
        Connection con = conexaoBD.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO categoria (categoria, tamanho, embalagem) VALUES (?, ?, ?)");
            stmt.setString(1, c.getCategoria());
            stmt.setString(2, c.getTamanho());
            stmt.setString(3, c.getEmbalagem());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            conexaoBD.closeConnection(con, stmt);
        }
    }

    /**
     * Recupera todas as categorias cadastradas no banco de dados.
     *
     * @return Lista de objetos {@link Categoria} contendo os dados encontrados.
     */
    public List<Categoria> read() {
        Connection con = conexaoBD.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Categoria> categorias = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM categoria");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setCategoria(rs.getString("categoria"));
                categoria.setTamanho(rs.getString("tamanho"));
                categoria.setEmbalagem(rs.getString("embalagem"));

                categorias.add(categoria);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex);
        } finally {
            conexaoBD.closeConnection(con, stmt, rs);
        }

        return categorias;
    }

    /**
     * Atualiza os dados de uma categoria existente no banco de dados.
     *
     * @param c Objeto {@link Categoria} com os novos dados a serem atualizados.
     */
    public void update(Categoria c) {
        Connection con = conexaoBD.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE categoria SET categoria = ?, tamanho = ?, embalagem = ? WHERE idCategoria = ?");
            stmt.setString(1, c.getCategoria());
            stmt.setString(2, c.getTamanho());
            stmt.setString(3, c.getEmbalagem());
            stmt.setInt(4, c.getIdCategoria());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
        } finally {
            conexaoBD.closeConnection(con, stmt);
        }
    }

    /**
     * Exclui uma categoria do banco de dados.
     *
     * @param c Objeto {@link Categoria} que será removido com base no ID.
     */
    public void delete(Categoria c) {
        Connection con = conexaoBD.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM categoria WHERE idCategoria = ?");
            stmt.setInt(1, c.getIdCategoria());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover: " + ex);
        } finally {
            conexaoBD.closeConnection(con, stmt);
        }
    }
}
