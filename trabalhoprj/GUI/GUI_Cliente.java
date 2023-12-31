
package trabalhoprj.GUI;

import trabalhoprj.Classes.Cliente;
import trabalhoprj.Modelos.ModeloTabelaCliente;
import trabalhoprj.OperacaoCadastro;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import trabalhoprj.Classes.Endereco;
import trabalhoprj.Modelos.ModeloEndereco;

public class GUI_Cliente extends javax.swing.JDialog {
    private ModeloTabelaCliente modeloCliente;
    private ModeloEndereco modeloEndereco;
    private TableRowSorter tableRowSorter;

    /**
     * Creates new form GUI_Fornecedor
     */
    public GUI_Cliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getRootPane().setDefaultButton(buBuscar);
        modeloCliente = new ModeloTabelaCliente(new ArrayList<Cliente>());
        modeloEndereco = new ModeloEndereco(new ArrayList<Endereco>());
        tabCliente.setModel(modeloCliente);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabCliente = new javax.swing.JTable();
        buIncluir = new javax.swing.JButton();
        buAlterar = new javax.swing.JButton();
        buExcluir = new javax.swing.JButton();
        buSelecionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        edFiltro = new javax.swing.JTextField();
        buBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tabCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabCliente);

        buIncluir.setText("Incluir");
        buIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buIncluirActionPerformed(evt);
            }
        });

        buAlterar.setText("Alterar");
        buAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buAlterarActionPerformed(evt);
            }
        });

        buExcluir.setText("Excluir");
        buExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buExcluirActionPerformed(evt);
            }
        });

        buSelecionar.setText("Selecionar");
        buSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buSelecionarActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtragem:");

        edFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edFiltroKeyTyped(evt);
            }
        });

        buBuscar.setText("Buscar");
        buBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(buSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(buAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                        .addComponent(buSelecionar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buIncluirActionPerformed
    Cliente cliente = new Cliente();
    Endereco endereco = new Endereco();
    if (JanelaCliente.executar(null, OperacaoCadastro.ocIncluir, cliente, endereco)){
        modeloCliente.incluirCliente(cliente);
        modeloEndereco.incluirEndereco(endereco);
        }
    }//GEN-LAST:event_buIncluirActionPerformed

    private void buAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buAlterarActionPerformed
    int index = tabCliente.getSelectedRow();
    if (index >= 0){
        Cliente cliente = modeloCliente.obterCliente(index);
        Endereco endereco = modeloEndereco.acharEndereco(cliente.obterCodigo());
        if (JanelaCliente.executar(null, OperacaoCadastro.ocAlterar, cliente, endereco)){
            modeloCliente.atualizarCliente(index, cliente);
            modeloEndereco.atualizarEndereco(endereco);
            }
        }
    }//GEN-LAST:event_buAlterarActionPerformed

    private void buExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buExcluirActionPerformed
    int index = tabCliente.getSelectedRow();
    if (index >= 0){
        JFrame frame = new JFrame("Excluir");
        int Resposta = JOptionPane.showConfirmDialog(frame,"Deseja excluir o cadastro?", "", JOptionPane.YES_NO_OPTION);
        if (Resposta == JOptionPane.YES_OPTION) {
            Cliente cliente = modeloCliente.obterCliente(index);
            Endereco endereco = modeloEndereco.acharEndereco(cliente.obterCodigo());
            modeloCliente.excluirCliente(index, cliente);
            modeloEndereco.excluirEndereco(endereco);
            }
        }
    }//GEN-LAST:event_buExcluirActionPerformed

    private void buSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buSelecionarActionPerformed
        int index = tabCliente.getSelectedRow();
        if (index >= 0){
            Cliente cliente = modeloCliente.obterCliente(index);
            Endereco endereco = modeloEndereco.acharEndereco(cliente.obterCodigo());
            JanelaCliente.executar(null, OperacaoCadastro.ocConsultar, cliente, endereco);
        }
    }//GEN-LAST:event_buSelecionarActionPerformed

    private void edFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edFiltroKeyTyped

    }//GEN-LAST:event_edFiltroKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (modeloCliente.getRowCount() >= 0) {
            modeloCliente.carregar();
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void buBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buBuscarActionPerformed
        tableRowSorter = new TableRowSorter(modeloCliente);
        tableRowSorter.setRowFilter(RowFilter.regexFilter( "(?i)" + edFiltro.getText(),0,1,2,3,4,5));
        tabCliente.setRowSorter(tableRowSorter);
    }//GEN-LAST:event_buBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI_Cliente dialog = new GUI_Cliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buAlterar;
    private javax.swing.JButton buBuscar;
    private javax.swing.JButton buExcluir;
    private javax.swing.JButton buIncluir;
    private javax.swing.JButton buSelecionar;
    private javax.swing.JTextField edFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabCliente;
    // End of variables declaration//GEN-END:variables
}
