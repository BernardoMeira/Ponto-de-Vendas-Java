
package trabalhoprj.GUI;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import trabalhoprj.Classes.Cliente;
import trabalhoprj.Classes.Entidade;
import trabalhoprj.Classes.ItemVenda;
import trabalhoprj.Classes.Produto;
import trabalhoprj.Classes.Venda;
import trabalhoprj.Executar.ControleCadastroCliente;
import trabalhoprj.Executar.ControleCadastroProduto;
import trabalhoprj.Executar.ImprimirTabela;
import trabalhoprj.Modelos.ModeloTabelaItemVenda;
import trabalhoprj.Modelos.ModeloTabelaProdutos;
import trabalhoprj.OperacaoCadastro;

public class JanelaVenda extends javax.swing.JDialog {
    private OperacaoCadastro operacaoCadastro;
    private Venda vendas;
    private boolean confirmado;
    private ModeloTabelaItemVenda modeloItem;
    private ModeloTabelaProdutos modeloProduto;
    private TableRowSorter tableRowSorter;
    private float valortotal;

    /**
     * Creates new form JanelaFornercedor
     */
    public JanelaVenda(java.awt.Frame parent, boolean modal){
        super(parent, modal);
        initComponents();
        this.getRootPane().setDefaultButton(buOK);
    }
   
    public JanelaVenda(java.awt.Frame parent, OperacaoCadastro operacaoCadastro, Venda vendas) {
        super(parent, true);
        confirmado = false;
        this.operacaoCadastro = operacaoCadastro;
        this.vendas = vendas;
        initComponents();
        if(operacaoCadastro == operacaoCadastro.ocAlterar || operacaoCadastro == OperacaoCadastro.ocConsultar){
            ClienteBox.setEditable(false);
            ProdutoBox.setEditable(false);
            edData.setText(vendas.obterData());
            edHora.setText(vendas.obterHora());
            edCodigoVenda.setText(String.valueOf(vendas.obterCodigoVenda()));
            if (vendas.obterFormaPagamento().equals(BuRadio1.getText())){
                BuRadio1.setSelected(true);
            } else if (vendas.obterFormaPagamento().equals(BuRadio2.getText())){
                BuRadio2.setSelected(true);
            }
        }
        ClienteBox.setEditable(true);
        ProdutoBox.setEditable(true);
        ClienteBox.setSelectedItem(vendas.obterCliente());
        ProdutoBox.setSelectedItem("");
        buCancelar.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edData.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edHora.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        BuRadio1.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        BuRadio2.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        ClienteBox.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        ProdutoBox.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        Adicionar.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edCodigoVenda.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar && operacaoCadastro != OperacaoCadastro.ocAlterar);
        edQuantidade.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        buImprimir.setEnabled(operacaoCadastro == OperacaoCadastro.ocConsultar);
    }
    
    public boolean operacaoConfirmada(){
        return confirmado;
    }
    
    public static boolean executar (java.awt.Frame parent,OperacaoCadastro operacaoCadastro, Venda outros){
        JanelaVenda janelaOutros = new JanelaVenda(parent, operacaoCadastro, outros);
        janelaOutros.setLocationRelativeTo(null);
        janelaOutros.setVisible(true);
        return janelaOutros.operacaoConfirmada();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        edHora = new javax.swing.JTextField();
        edData = new javax.swing.JTextField();
        buOK = new javax.swing.JButton();
        buCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BuRadio2 = new javax.swing.JRadioButton();
        BuRadio1 = new javax.swing.JRadioButton();
        ClienteBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ProdutoBox = new javax.swing.JComboBox<>();
        Adicionar = new javax.swing.JButton();
        edQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        edCodigoVenda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabItens = new javax.swing.JTable();
        buImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Data:");

        jLabel2.setText("Cliente:");

        edHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edHoraActionPerformed(evt);
            }
        });

        edData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edDataActionPerformed(evt);
            }
        });

        buOK.setText("Ok");
        buOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buOKActionPerformed(evt);
            }
        });

        buCancelar.setText("Cancelar");
        buCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Hora:");

        jLabel3.setText("Forma de pagamento:");

        buttonGroup1.add(BuRadio2);
        BuRadio2.setText("Dinheiro");

        buttonGroup1.add(BuRadio1);
        BuRadio1.setText("Cartão de Crédito");
        BuRadio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuRadio1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BuRadio2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BuRadio1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(BuRadio2)
                .addComponent(BuRadio1))
        );

        ClienteBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteBoxActionPerformed(evt);
            }
        });

        jLabel5.setText("Produto:");

        ProdutoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdutoBoxActionPerformed(evt);
            }
        });

        Adicionar.setText("Adicionar");
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
            }
        });

        edQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edQuantidadeActionPerformed(evt);
            }
        });

        jLabel6.setText("Quantidade:");

        jLabel7.setText("Codigo da venda:");

        edCodigoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edCodigoVendaActionPerformed(evt);
            }
        });

        tabItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabItens);

        buImprimir.setText("Imprimir");
        buImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ProdutoBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Adicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buCancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buOK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(edData, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(6, 6, 6)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(edHora, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(7, 7, 7)
                                .addComponent(ClienteBox, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel7)
                        .addComponent(edCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(edHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ClienteBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ProdutoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Adicionar)
                    .addComponent(edQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buCancelar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edHoraActionPerformed

    private void edDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edDataActionPerformed

    private void buOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buOKActionPerformed
        if(edData.getText().trim().equals("") || edHora.getText().trim().equals("") || edCodigoVenda.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Um dos campos exigidos não está preenchido.","",2);
        } else {
            if(operacaoCadastro != OperacaoCadastro.ocConsultar){
                vendas.atualizarData(edData.getText());
                vendas.atualizarHora(edHora.getText());
                vendas.atualizarCodigoVenda(Integer.valueOf(edCodigoVenda.getText()));
                vendas.atualizarCliente(String.valueOf(ClienteBox.getSelectedItem()));
                vendas.atualizarValorTotal(valortotal);
                if(BuRadio1.isSelected()){
                    vendas.atualizarFormaPagamento(BuRadio1.getText());
                } else if (BuRadio2.isSelected()){
                    vendas.atualizarFormaPagamento(BuRadio2.getText());
                }

                confirmado = true;
            }
        dispose();
        }
    }//GEN-LAST:event_buOKActionPerformed

    private void buCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_buCancelarActionPerformed

    private void BuRadio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuRadio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuRadio1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        modeloItem = new ModeloTabelaItemVenda(new ArrayList<ItemVenda>());
        modeloProduto = new ModeloTabelaProdutos(new ArrayList<Produto>());
        tabItens.setModel(modeloItem);
        if (modeloItem.getRowCount() >= 0) {
            modeloItem.carregar(vendas.obterCodigoVenda());
        }
        
        try{
        ControleCadastroCliente controleCadastroCliente = new ControleCadastroCliente();
        ArrayList<Entidade> entidades = controleCadastroCliente.obterLista();
        
        for(int i = 0; i < entidades.size(); i++){
            Cliente cliente = (Cliente)entidades.get(i);
            ClienteBox.addItem(cliente.obterNome());
        }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try{
            
        ControleCadastroProduto controleCadastroProduto = new ControleCadastroProduto();
        ArrayList<Entidade> entidades = controleCadastroProduto.obterLista();
        
        for(int i = 0; i < entidades.size(); i++){
            Produto produto = (Produto)entidades.get(i);
            ProdutoBox.addItem(produto.obterNome());
        }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

    private void ClienteBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClienteBoxActionPerformed

    private void ProdutoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdutoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProdutoBoxActionPerformed

    private void edQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edQuantidadeActionPerformed

    private void edCodigoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edCodigoVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edCodigoVendaActionPerformed

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        if (Integer.valueOf(edQuantidade.getText()) >= 0 && edQuantidade.getText() != null){
            Produto produto = modeloProduto.acharProduto(String.valueOf(ProdutoBox.getSelectedItem()));
            ItemVenda item = new ItemVenda();
            item.atualizarCodigoProduto(produto.obterCodigo());
            item.atualizarCodigoVenda(Integer.valueOf(edCodigoVenda.getText()));
            item.atualizarQuantidadeVenda(Integer.valueOf(edQuantidade.getText()));
            item.atualizarPreco(produto.obterPreco());
            item.atualizarTotalItem(produto.obterQuantidadeEstoque());
            modeloItem.incluirItemVenda(item);
            valortotal += (item.obterPreco() * item.obterQuantidadeVenda() + vendas.obterValorTotal());
            produto.atualizarUltimaVenda(edData.getText());
            produto.atualizarQuantidadeEstoque(produto.obterQuantidadeEstoque() - item.obterQuantidadeVenda());
            modeloProduto.atualizarProduto(-1, produto);
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade invalida","",2);
        }
    }//GEN-LAST:event_AdicionarActionPerformed

    private void buImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buImprimirActionPerformed
        new ImprimirTabela(tabItens, vendas);
    }//GEN-LAST:event_buImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaCliente dialog = new JanelaCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Adicionar;
    private javax.swing.JRadioButton BuRadio1;
    private javax.swing.JRadioButton BuRadio2;
    private javax.swing.JComboBox<String> ClienteBox;
    private javax.swing.JComboBox<String> ProdutoBox;
    private javax.swing.JButton buCancelar;
    private javax.swing.JButton buImprimir;
    private javax.swing.JButton buOK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField edCodigoVenda;
    private javax.swing.JTextField edData;
    private javax.swing.JTextField edHora;
    private javax.swing.JTextField edQuantidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabItens;
    // End of variables declaration//GEN-END:variables
}
