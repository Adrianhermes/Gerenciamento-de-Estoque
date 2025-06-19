package visao;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import dao.CategoriaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableRowSorter;
import modelo.Categoria;

/**
 * Classe responsável pela interface gráfica de cadastro de categorias no
 * sistema. Permite visualizar, cadastrar, editar e excluir categorias com base
 * nas informações armazenadas no banco de dados.
 */
public class FrmCadastroDeCategoria extends javax.swing.JFrame {

    /**
     * Construtor da classe FrmCadastroDeCategoria. Inicializa os componentes da
     * interface gráfica, define a ordenação da tabela e carrega os dados
     * existentes no banco.
     */
    public FrmCadastroDeCategoria() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) JTCategoria.getModel();
        JTCategoria.setRowSorter(new TableRowSorter(modelo));
        readJTable();
    }

    /**
     * Lê as categorias armazenadas no banco de dados por meio do
     * {@link CategoriaDAO} e preenche a tabela com os dados recuperados.
     */
    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) JTCategoria.getModel();
        modelo.setNumRows(0); // Limpa a tabela antes de inserir novos dados
        CategoriaDAO cdao = new CategoriaDAO();

        for (Categoria c : cdao.read()) {
            modelo.addRow(new Object[]{
                c.getIdCategoria(),
                c.getCategoria(),
                c.getTamanho(),
                c.getEmbalagem()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRemover = new javax.swing.JButton();
        jCadastrar = new javax.swing.JButton();
        jFechar = new javax.swing.JButton();
        JTFEmbalagem = new javax.swing.JTextField();
        JTFTamanho = new javax.swing.JComboBox<>();
        JTFCategoria = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTCategoria = new javax.swing.JTable();
        jEditar = new javax.swing.JButton();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Categoria:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tamanho:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Embalagem:");

        jRemover.setText("Remover");
        jRemover.setPreferredSize(new java.awt.Dimension(70, 35));
        jRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoverActionPerformed(evt);
            }
        });

        jCadastrar.setText("Cadastrar");
        jCadastrar.setPreferredSize(new java.awt.Dimension(70, 35));
        jCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastrarActionPerformed(evt);
            }
        });

        jFechar.setText("Voltar");
        jFechar.setPreferredSize(new java.awt.Dimension(70, 35));
        jFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFecharActionPerformed(evt);
            }
        });

        JTFEmbalagem.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        JTFEmbalagem.setInheritsPopupMenu(true);

        JTFTamanho.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        JTFTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequeno", "Medio", "Grande" }));
        JTFTamanho.setAutoscrolls(true);
        JTFTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFTamanhoActionPerformed(evt);
            }
        });

        JTFCategoria.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        JTFCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFCategoriaActionPerformed(evt);
            }
        });

        JTCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Categoria", "Tamanho", "Embalagem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTCategoria.setAutoscrolls(false);
        JTCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTCategoriaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTCategoriaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(JTCategoria);

        jEditar.setText("Editar");
        jEditar.setPreferredSize(new java.awt.Dimension(70, 35));
        jEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addComponent(jRemover, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jFechar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jFecharActionPerformed

    private void jCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastrarActionPerformed

        /**
         * Captura os dados informados nos campos da interface e realiza o
         * cadastro de uma nova categoria no banco de dados. Após o cadastro, a
         * tabela é atualizada e os campos de entrada são limpos.
         */
        Categoria c = new Categoria();
        CategoriaDAO cdao = new CategoriaDAO();

        // Define os valores da nova categoria com base nos campos da interface
        c.setCategoria(JTFCategoria.getText());
        c.setTamanho(JTFTamanho.getSelectedItem().toString());
        c.setEmbalagem(JTFEmbalagem.getText());

        // Salva a nova categoria no banco de dados
        cdao.create(c);

        // Atualiza a tabela com os dados mais recentes
        readJTable();

        // Limpa os campos da interface
        JTFCategoria.setText("");
        JTFTamanho.setSelectedIndex(0);
        JTFEmbalagem.setText("");

    }//GEN-LAST:event_jCadastrarActionPerformed

    private void jRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoverActionPerformed

        /**
         * Exclui a categoria selecionada na tabela. Obtém o ID da categoria da
         * linha selecionada e solicita ao {@link CategoriaDAO} que remova o
         * registro correspondente do banco de dados. Após a exclusão, a tabela
         * é atualizada.
         */
        Categoria c = new Categoria();
        CategoriaDAO cdao = new CategoriaDAO();

        // Recupera o ID da categoria selecionada na tabela
        c.setIdCategoria(Integer.parseInt(
                JTCategoria.getValueAt(JTCategoria.getSelectedRow(), 0).toString()
        ));

        // Exclui a categoria do banco de dados
        cdao.delete(c);

        // Atualiza a tabela com os dados mais recentes
        readJTable();

    }//GEN-LAST:event_jRemoverActionPerformed

    private void JTFCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFCategoriaActionPerformed

    private void jEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditarActionPerformed

        /**
         * Atualiza os dados da categoria selecionada na tabela com os valores
         * informados nos campos da interface. Após a atualização no banco de
         * dados, a tabela é recarregada e os campos de entrada são limpos.
         */
        Categoria c = new Categoria();
        CategoriaDAO cdao = new CategoriaDAO();

        // Define os dados atualizados da categoria com base na interface
        c.setIdCategoria(Integer.parseInt(
                JTCategoria.getValueAt(JTCategoria.getSelectedRow(), 0).toString()
        ));
        c.setCategoria(JTFCategoria.getText());
        c.setTamanho(JTFTamanho.getSelectedItem().toString());
        c.setEmbalagem(JTFEmbalagem.getText());

        // Atualiza a categoria no banco de dados
        cdao.update(c);

        // Recarrega os dados na tabela
        readJTable();

        // Limpa os campos da interface
        JTFCategoria.setText("");
        JTFTamanho.setSelectedIndex(0);
        JTFEmbalagem.setText("");

    }//GEN-LAST:event_jEditarActionPerformed

    private void JTFTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFTamanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFTamanhoActionPerformed

    private void JTCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTCategoriaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTCategoriaKeyReleased

    private void JTCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTCategoriaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTCategoriaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroDeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroDeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroDeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroDeCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroDeCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTCategoria;
    private javax.swing.JTextField JTFCategoria;
    private javax.swing.JTextField JTFEmbalagem;
    private javax.swing.JComboBox<String> JTFTamanho;
    private javax.swing.JButton jCadastrar;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JButton jEditar;
    private javax.swing.JButton jFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jRemover;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
