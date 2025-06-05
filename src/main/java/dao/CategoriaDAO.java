package dao;

import modelo.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    // Método para inserir uma nova categoria
    public void inserirCategoria(Categoria categoria) {
        String sql = "INSERT INTO categoria (categoria, tamanho, embalagem) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBancoDeDados.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getCategoria());
            stmt.setString(2, categoria.getTamanho());
            stmt.setString(3, categoria.getEmbalagem());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todas as categorias
    public List<Categoria> listarCategorias() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        try (Connection conn = ConexaoBancoDeDados.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Categoria cat = new Categoria(
                        rs.getInt("id"),
                        rs.getString("categoria"),
                        rs.getString("tamanho"),
                        rs.getString("embalagem")
                );
                lista.add(cat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Método para atualizar uma categoria
    public void atualizarCategoria(Categoria categoria) {
        String sql = "UPDATE categoria SET categoria = ?, tamanho = ?, embalagem = ? WHERE id = ?";

        try (Connection conn = ConexaoBancoDeDados.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getCategoria());
            stmt.setString(2, categoria.getTamanho());
            stmt.setString(3, categoria.getEmbalagem());
            stmt.setInt(4, categoria.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para deletar uma categoria
    public void deletarCategoria(int id) {
        String sql = "DELETE FROM categoria WHERE id = ?";

        try (Connection conn = ConexaoBancoDeDados.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
