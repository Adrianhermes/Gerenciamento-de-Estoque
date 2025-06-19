/**
 * O pacote view contém a classe Mensagem.
 */
package visao;

/**
 * A classe Mensagem é uma subclasse da classe Exception.
 * Ela é usada para criar uma exceção personalizada com uma mensagem específica.
 */
public class Mensagem extends Exception {

    /**
     * Construtor que inicializa a exceção Mensagem com uma mensagem específica.
     *
     * @param mensagem A mensagem da exceção.
     */
    public Mensagem(String mensagem){
        super(mensagem);
    }
}
