package modelo;

/**
 * Representa uma categoria de produto com informações como
 * identificação, nome da categoria, tamanho e tipo de embalagem.
 */
public class Categoria {

    /**
     * Identificador único da categoria.
     */
    private int idCategoria;

    /**
     * Nome da categoria.
     */
    private String categoria;

    /**
     * Tamanho da categoria ou produto.
     */
    private String tamanho;

    /**
     * Tipo de embalagem da categoria ou produto.
     */
    private String embalagem;

    /**
     * Obtém o identificador da categoria.
     * 
     * @return o id da categoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * Define o identificador da categoria.
     * 
     * @param idCategoria o id a ser atribuído
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Obtém o nome da categoria.
     * 
     * @return o nome da categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define o nome da categoria.
     * 
     * @param categoria o nome da categoria a ser atribuído
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtém o tamanho da categoria.
     * 
     * @return o tamanho da categoria
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * Define o tamanho da categoria.
     * 
     * @param tamanho o tamanho a ser atribuído
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Obtém o tipo de embalagem da categoria.
     * 
     * @return o tipo de embalagem
     */
    public String getEmbalagem() {
        return embalagem;
    }

    /**
     * Define o tipo de embalagem da categoria.
     * 
     * @param embalagem o tipo de embalagem a ser atribuído
     */
    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    /**
     * Retorna a representação em String da categoria,
     * que neste caso é o nome da categoria.
     * 
     * @return o nome da categoria
     */
    @Override
    public String toString() {
        return this.getCategoria();
    }

}
