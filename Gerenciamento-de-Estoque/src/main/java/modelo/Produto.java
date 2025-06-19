package modelo;

/**
 * Classe que representa um produto no sistema de gerenciamento de estoque.
 * Contém informações como descrição, quantidade, preço e limites de estoque.
 */
public class Produto {

    /**
     * Identificador único do produto.
     */
    private int idProduto;

    /**
     * Descrição do produto.
     */
    private String descricao;

    /**
     * Quantidade do produto cadastrada na operação.
     */
    private int qtd;

    /**
     * Preço unitário do produto.
     */
    private double preco;

    /**
     * Quantidade atual do produto em estoque.
     */
    private int quantidadeEstoque;

    /**
     * Quantidade mínima permitida do produto em estoque.
     */
    private int quantidadeMinima;

    /**
     * Quantidade máxima permitida do produto em estoque.
     */
    private int quantidadeMaxima;

    /**
     * Construtor padrão da classe Produto.
     */
    public Produto() {
    }

    /**
     * Construtor completo da classe Produto.
     * 
     * @param idProduto         ID do produto.
     * @param descricao         Descrição do produto.
     * @param qtd               Quantidade cadastrada.
     * @param preco             Preço unitário.
     * @param quantidadeEstoque Quantidade atual em estoque.
     * @param quantidadeMinima  Quantidade mínima permitida.
     * @param quantidadeMaxima  Quantidade máxima permitida.
     */
    public Produto(int idProduto, String descricao, int qtd, double preco, int quantidadeEstoque, int quantidadeMinima, int quantidadeMaxima) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.qtd = qtd;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeMaxima = quantidadeMaxima;
    }

    /**
     * Retorna a quantidade informada no cadastro.
     * 
     * @return Quantidade.
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * Define a quantidade informada no cadastro.
     * 
     * @param qtd Quantidade.
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * Retorna o ID do produto.
     * 
     * @return ID do produto.
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * Define o ID do produto.
     * 
     * @param idProduto ID do produto.
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * Retorna a descrição do produto.
     * 
     * @return Descrição.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do produto.
     * 
     * @param descricao Descrição.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o preço unitário do produto.
     * 
     * @return Preço.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço unitário do produto.
     * 
     * @param preco Preço.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Retorna a quantidade atual do produto em estoque.
     * 
     * @return Quantidade em estoque.
     */
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * Define a quantidade atual do produto em estoque.
     * 
     * @param quantidadeEstoque Quantidade em estoque.
     */
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * Retorna a quantidade mínima permitida para o produto.
     * 
     * @return Quantidade mínima.
     */
    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    /**
     * Define a quantidade mínima permitida para o produto.
     * 
     * @param quantidadeMinima Quantidade mínima.
     */
    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    /**
     * Retorna a quantidade máxima permitida para o produto.
     * 
     * @return Quantidade máxima.
     */
    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    /**
     * Define a quantidade máxima permitida para o produto.
     * 
     * @param quantidadeMaxima Quantidade máxima.
     */
    public void setQuantidadeMaxima(int quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }
}
