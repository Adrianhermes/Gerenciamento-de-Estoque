package dao;

import modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDAO {

    public void create(Categoria c) {

        Connection con = ConexaoBancoDeDados.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO categoria (categoria,tamanho,embalagem)VALUES (?,?,?)");
            stmt.setString(1, c.getCategoria());
            stmt.setString(2, c.getTamanho());
            stmt.setString(3, c.getEmbalagem());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConexaoBancoDeDados.closeConnection(con, stmt);
        }
    }

    public List<Categoria> read() {
        Connection con = ConexaoBancoDeDados.getConexao();
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
            ConexaoBancoDeDados.closeConnection(con, stmt, rs);
        }

        return categorias;

    }

    public void update(Categoria c) {

        Connection con = ConexaoBancoDeDados.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE categoria SET categoria = ?,tamanho = ?,embalagem = ? WHERE idCategoria = ?");
            stmt.setString(1, c.getCategoria());
            stmt.setString(2, c.getTamanho());
            stmt.setString(3, c.getEmbalagem());
            stmt.setInt(4, c.getIdCategoria());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
        } finally {
            ConexaoBancoDeDados.closeConnection(con, stmt);
        }
    }
    public void delete(Categoria c) {

        Connection con = ConexaoBancoDeDados.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM categoria WHERE idCategoria = ?");
            stmt.setInt(1, c.getIdCategoria());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover: " + ex);
        } finally {
            ConexaoBancoDeDados.closeConnection(con, stmt);
        }
    }

}
