package visao;

import dao.ProdutoDAO;
import modelo.Produto;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 * Classe responsável por exibir o formulário de Balanço Físico-Financeiro,
 * mostrando uma tabela com produtos, seus valores e o valor total do estoque.
 */
public class FrmBalancoFisicoFinanceiro extends javax.swing.JFrame {

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JLabel lblTotalEstoque;
    private javax.swing.JTextField txtTotalEstoque;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnVoltar;

    public FrmBalancoFisicoFinanceiro() {
        initComponents();
        carregarProdutosNaTabela(buscarProdutosDoBanco());
    }

    @SuppressWarnings("unchecked")
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
                carregarProdutosNaTabela(buscarProdutosDoBanco());
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
    }

    private void carregarProdutosNaTabela(java.util.List<Produto> produtos) {
        produtos.sort(java.util.Comparator.comparing(Produto::getDescricao));
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        double totalEstoque = 0.0;
        for (Produto p : produtos) {
            double valorTotal = p.getQtd() * p.getPreco();
            model.addRow(new Object[]{
                p.getDescricao(),
                p.getQtd(),
                String.format("%.2f", p.getPreco()),
                String.format("%.2f", valorTotal)
            });
            totalEstoque += valorTotal;
        }
        txtTotalEstoque.setText(String.format("%.2f", totalEstoque));
    }

    private java.util.List<Produto> buscarProdutosDoBanco() {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.read();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBalancoFisicoFinanceiro().setVisible(true);
            }
        });
    }

    @Override
    public void dispose() {
        super.dispose();
        new FrmMenuPrincipal().setVisible(true);
    }
} 