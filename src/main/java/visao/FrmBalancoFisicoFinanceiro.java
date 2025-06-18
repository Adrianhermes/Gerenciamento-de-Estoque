package visao;

import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 * Classe responsável por exibir o formulário de Balanço Físico-Financeiro,
 * mostrando uma tabela com produtos, seus valores e o valor total do estoque.
 */
public class FrmBalancoFisicoFinanceiro extends javax.swing.JFrame {

    /** ScrollPane que envolve a tabela de produtos. */
    private javax.swing.JScrollPane jScrollPane1;

    /** Tabela que exibe os produtos com quantidade, valor unitário e total. */
    private javax.swing.JTable tblProdutos;

    /** Rótulo para o campo de valor total do estoque. */
    private javax.swing.JLabel lblTotalEstoque;

    /** Campo de texto que exibe o valor total do estoque. */
    private javax.swing.JTextField txtTotalEstoque;

    /** Botão para atualizar a tabela com os dados. */
    private javax.swing.JButton btnAtualizar;

    /** Botão para voltar ao menu principal. */
    private javax.swing.JButton btnVoltar;

    /**
     * Construtor da classe FrmBalancoFisicoFinanceiro.
     * Inicializa os componentes e carrega os produtos de exemplo na tabela.
     */
    public FrmBalancoFisicoFinanceiro() {
        initComponents();
        carregarProdutosNaTabela(getProdutosExemplo());
    }

    /**
     * Inicializa os componentes gráficos da tela.
     * Este método é gerado automaticamente pelo editor de formulários.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        lblTotalEstoque = new javax.swing.JLabel();
        txtTotalEstoque = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Produto", "Quantidade", "Valor Unitário", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(tblProdutos);

        lblTotalEstoque.setText("Valor Total do Estoque:");
        txtTotalEstoque.setEditable(false);
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarProdutosNaTabela(getProdutosExemplo());
            }
        });
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrmMenuPrincipal menu = new FrmMenuPrincipal();
                menu.setVisible(true);
                dispose();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTotalEstoque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtualizar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVoltar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalEstoque)
                    .addComponent(txtTotalEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Carrega os produtos informados na tabela e calcula o valor total do estoque.
     *
     * @param produtos Lista de produtos a ser exibida na tabela.
     */
    private void carregarProdutosNaTabela(List<ProdutoExemplo> produtos) {
        produtos.sort(Comparator.comparing(ProdutoExemplo::getNome));
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        double totalEstoque = 0.0;
        for (ProdutoExemplo p : produtos) {
            double valorTotal = p.getValorTotal();
            model.addRow(new Object[]{
                p.getNome(),
                p.getQuantidade(),
                String.format("%.2f", p.getValorUnitario()),
                String.format("%.2f", valorTotal)
            });
            totalEstoque += valorTotal;
        }
        txtTotalEstoque.setText(String.format("%.2f", totalEstoque));
    }

    /**
     * Retorna uma lista de produtos de exemplo para exibição na tabela.
     *
     * @return Lista de objetos {@link ProdutoExemplo}.
     */
    private List<ProdutoExemplo> getProdutosExemplo() {
        return Arrays.asList(
            new ProdutoExemplo("Arroz", 10, 5.50),
            new ProdutoExemplo("Feijão", 5, 7.20),
            new ProdutoExemplo("Macarrão", 20, 3.80)
        );
    }

    /**
     * Classe interna que representa um produto de exemplo com nome, quantidade e valor unitário.
     */
    public static class ProdutoExemplo {

        /** Nome do produto. */
        private String nome;

        /** Quantidade disponível do produto. */
        private int quantidade;

        /** Valor unitário do produto. */
        private double valorUnitario;

        /**
         * Construtor da classe ProdutoExemplo.
         *
         * @param nome Nome do produto.
         * @param quantidade Quantidade em estoque.
         * @param valorUnitario Valor unitário do produto.
         */
        public ProdutoExemplo(String nome, int quantidade, double valorUnitario) {
            this.nome = nome;
            this.quantidade = quantidade;
            this.valorUnitario = valorUnitario;
        }

        /**
         * Retorna o nome do produto.
         *
         * @return Nome do produto.
         */
        public String getNome() { return nome; }

        /**
         * Retorna a quantidade do produto.
         *
         * @return Quantidade disponível.
         */
        public int getQuantidade() { return quantidade; }

        /**
         * Retorna o valor unitário do produto.
         *
         * @return Valor unitário.
         */
        public double getValorUnitario() { return valorUnitario; }

        /**
         * Calcula o valor total do produto com base na quantidade e valor unitário.
         *
         * @return Valor total.
         */
        public double getValorTotal() { return quantidade * valorUnitario; }
    }

    /**
     * Método principal para execução da aplicação.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String args[]) {
        /* Configura o tema Nimbus e inicializa a janela */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBalancoFisicoFinanceiro().setVisible(true);
            }
        });
    }

    /**
     * Fecha a tela atual e exibe o menu principal.
     */
    @Override
    public void dispose() {
        super.dispose();
        new FrmMenuPrincipal().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
