package principal;

import visao.FrmMenuPrincipal;

/**
 * Classe principal do sistema que inicia a aplicação exibindo a interface gráfica principal.
 */
public class Principal {

    /**
     * Método principal que serve como ponto de entrada da aplicação.Inicializa a interface gráfica principal e a torna visível.
     * @param args classe principal.
     */
    public static void main(String[] args) {
        FrmMenuPrincipal objetotela = new FrmMenuPrincipal(); // Instancia a interface gráfica
        objetotela.setVisible(true); // Torna a janela visível
    }
}
