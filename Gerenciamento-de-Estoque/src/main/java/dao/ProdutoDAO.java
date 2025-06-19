package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Produto;

/**
 * Classe responsável por realizar as operações de persistência no banco de dados
 * para objetos da classe {@link Produto}, como inserir, listar, atualizar e excluir.
 * 
 * Utiliza a classe {@link ConexaoBancoDeDados} para abrir e fechar conexões JDBC.
 */
public class ProdutoDAO {

    /**
     * Instância de {@link ConexaoBancoDeDados} utilizada para manipulação da conexão com o banco de dados.
     */
    private final ConexaoBancoDeDados conexaoBD = new ConexaoBancoDeDados();

    /**
     * Insere um novo produto no banco de dados.
     * 
     * @param p Objeto {@link Produto} com os dados a serem inseridos.
     */
    public void create(Produto p) {
        Connection con = conexaoBD.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produto (descricao, qtd, preco, quantidadeEstoque, quantidadeMinima, quantidadeMaxima) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getQuantidadeEstoque());
            stmt.setInt(5, p.getQuantidadeMinima());
            stmt.setInt(6, p.getQuantidadeMaxima());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            conexaoBD.closeConnection(con, stmt);
        }
    }

    /**
     * Recupera todos os produtos cadastrados no banco de dados.
     * 
     * @return Lista de objetos {@link Produto} encontrados.
     */
    public List<Produto> read() {
        Connection con = conexaoBD.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQtd(rs.getInt("qtd"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                produto.setQuantidadeMinima(rs.getInt("quantidadeMinima"));
                produto.setQuantidadeMaxima(rs.getInt("quantidadeMaxima"));

                produtos.add(produto);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex);
        } finally {
            conexaoBD.closeConnection(con, stmt, rs);
        }

        return produtos;
    }

    /**
     * Atualiza os dados de um produto existente no banco de dados.
     * 
     * @param p Objeto {@link Produto} com os dados atualizados.
     */
    public void update(Produto p) {
        Connection con = conexaoBD.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET descricao = ?, qtd = ?, preco = ?, quantidadeEstoque = ?, quantidadeMinima = ?, quantidadeMaxima = ? WHERE idProduto = ?");
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getQuantidadeEstoque());
            stmt.setInt(5, p.getQuantidadeMinima());
            stmt.setInt(6, p.getQuantidadeMaxima());
            stmt.setInt(7, p.getIdProduto());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
        } finally {
            conexaoBD.closeConnection(con, stmt);
        }
    }

    /**
     * Exclui um produto do banco de dados com base no seu ID.
     * 
     * @param p Objeto {@link Produto} que contém o ID do produto a ser removido.
     */
    public void delete(Produto p) {
        Connection con = conexaoBD.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
            stmt.setInt(1, p.getIdProduto());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover: " + ex);
        } finally {
            conexaoBD.closeConnection(con, stmt);
        }
    }
}
