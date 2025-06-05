package modelo;

public class Categoria {
    private int id;
    private String categoria;
    private String tamanho;
    private String embalagem;

    // Construtor
    public Categoria(int id, String categoria, String tamanho, String embalagem) {
        this.id = id;
        this.categoria = categoria;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }

    // Construtor sem ID (para inserção)
    public Categoria(String categoria, String tamanho, String embalagem) {
        this.categoria = categoria;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }

    public String getEmbalagem() { return embalagem; }
    public void setEmbalagem(String embalagem) { this.embalagem = embalagem; }
}
