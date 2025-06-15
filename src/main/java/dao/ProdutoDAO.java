package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Produto;

public class ProdutoDAO {

    public void create(Produto p) {

        Connection con = ConexaoBancoDeDados.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produto (descricao,qtd,preco,quantidadeEstoque,quantidadeMinima,quantidadeMaxima)VALUES (?,?,?,?,?,?)");
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
            ConexaoBancoDeDados.closeConnection(con, stmt);
        }
    }

    public List<Produto> read() {
        Connection con = ConexaoBancoDeDados.getConexao();
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
            ConexaoBancoDeDados.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

    public void update(Produto p) {

        Connection con = ConexaoBancoDeDados.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET descricao = ?,qtd = ?,preco = ?,quantidadeEstoque = ?,quantidadeMinima = ?,quantidadeMaxima = ? WHERE idProduto = ?");
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
            ConexaoBancoDeDados.closeConnection(con, stmt);
        }
    }

    public void delete(Produto p) {

        Connection con = ConexaoBancoDeDados.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
            stmt.setInt(1, p.getIdProduto());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover: " + ex);
        } finally {
            ConexaoBancoDeDados.closeConnection(con, stmt);
        }
    }

}
