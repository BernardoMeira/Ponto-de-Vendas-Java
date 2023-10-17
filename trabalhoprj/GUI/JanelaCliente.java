
package trabalhoprj.GUI;

import javax.swing.JOptionPane;
import trabalhoprj.Classes.Cliente;
import trabalhoprj.Classes.Endereco;
import trabalhoprj.OperacaoCadastro;

public class JanelaCliente extends javax.swing.JDialog {
    private OperacaoCadastro operacaoCadastro;
    private Cliente cliente;
    private Endereco endereco;
    private boolean confirmado;

    /**
     * Creates new form JanelaFornercedor
     */
    public JanelaCliente(java.awt.Frame parent, boolean modal){
        super(parent, modal);
        initComponents();
        this.getRootPane().setDefaultButton(buOK);
    }
   
    public JanelaCliente(java.awt.Frame parent, OperacaoCadastro operacaoCadastro, Cliente cliente, Endereco endereco) {
        super(parent, true);
        confirmado = false;
        this.operacaoCadastro = operacaoCadastro;
        this.cliente = cliente;
        this.endereco = endereco;
        initComponents();
        if(operacaoCadastro == operacaoCadastro.ocAlterar || operacaoCadastro == OperacaoCadastro.ocConsultar){
            edNome.setText(cliente.obterNome());
            edCodigo.setText(String.valueOf(cliente.obterCodigo()));
            edTelefone.setText(cliente.obterTelefone());
            edEmail.setText(cliente.obterEmail());
            edCEP.setText(endereco.obterCEP());
            edRua.setText(endereco.obterRua());
            edCidade.setText(endereco.obterCidade());
            edBairro.setText(endereco.obterBairro());
            edEstado.setText(endereco.obterEstado());
        }
        buCancelar.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edNome.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edTelefone.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edCodigo.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar && operacaoCadastro != OperacaoCadastro.ocAlterar);
        edEmail.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edCEP.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edRua.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edCidade.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edBairro.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
        edEstado.setEnabled(operacaoCadastro != OperacaoCadastro.ocConsultar);
    }
    
    public boolean operacaoConfirmada(){
        return confirmado;
    }
    
    public static boolean executar (java.awt.Frame parent,OperacaoCadastro operacaoCadastro, Cliente cliente, Endereco endereco){
        JanelaCliente janelaCliente = new JanelaCliente(parent, operacaoCadastro, cliente, endereco);
        janelaCliente.setLocationRelativeTo(null);
        janelaCliente.setVisible(true);
        return janelaCliente.operacaoConfirmada();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buOK = new javax.swing.JButton();
        buCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        edNome = new javax.swing.JTextField();
        edTelefone = new javax.swing.JTextField();
        edEmail = new javax.swing.JTextField();
        edCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edCEP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        edRua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        edCidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        edBairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        edEstado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Telefone:");

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

        jLabel5.setText("Email:");

        edNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edNomeActionPerformed(evt);
            }
        });

        edCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edCodigoActionPerformed(evt);
            }
        });

        jLabel4.setText("Codigo:");

        edCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edCEPActionPerformed(evt);
            }
        });

        jLabel6.setText("CEP:");

        edRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edRuaActionPerformed(evt);
            }
        });

        jLabel7.setText("Rua:");

        edCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edCidadeActionPerformed(evt);
            }
        });

        jLabel8.setText("Cidade:");

        edBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edBairroActionPerformed(evt);
            }
        });

        jLabel9.setText("Bairro:");

        edEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edEstadoActionPerformed(evt);
            }
        });

        jLabel10.setText("Estado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(24, 24, 24)
                        .addComponent(edCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(edRua, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edTelefone, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edEmail)
                            .addComponent(edCodigo)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buOK, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(edCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(edCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(edRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(edCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(edBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(edEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buOK)
                    .addComponent(buCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buOKActionPerformed
        if(edNome.getText().trim().equals("") || edTelefone.getText().trim().equals("") 
        || edCodigo.getText().trim().equals("")|| edEmail.getText().trim().equals("")
        || edCEP.getText().trim().equals("") || edCidade.getText().trim().equals("")
        || edRua.getText().trim().equals("") || edBairro.getText().trim().equals("")
        || edEstado.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Um dos campos exigidos não está preenchido.","",2);
        } else {
            if(operacaoCadastro != OperacaoCadastro.ocConsultar){
                cliente.atualizarNome(edNome.getText());
                cliente.atualizarTelefone(edTelefone.getText());
                cliente.atualizarCodigo(Integer.valueOf(edCodigo.getText()));
                endereco.atualizarCodigo(Integer.valueOf(edCodigo.getText()));
                cliente.atualizarEmail(edEmail.getText());
                endereco.atualizarCEP(edCEP.getText());
                endereco.atualizarRua(edRua.getText());
                endereco.atualizarCidade(edCidade.getText());
                endereco.atualizarBairro(edBairro.getText());
                endereco.atualizarEstado(edEstado.getText());
                confirmado = true;
            }
        dispose();
        }
    }//GEN-LAST:event_buOKActionPerformed

    private void buCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_buCancelarActionPerformed

    private void edNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edNomeActionPerformed

    private void edCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edCodigoActionPerformed

    private void edCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edCEPActionPerformed

    private void edRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edRuaActionPerformed

    private void edCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edCidadeActionPerformed

    private void edBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edBairroActionPerformed

    private void edEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private javax.swing.JButton buCancelar;
    private javax.swing.JButton buOK;
    private javax.swing.JTextField edBairro;
    private javax.swing.JTextField edCEP;
    private javax.swing.JTextField edCidade;
    private javax.swing.JTextField edCodigo;
    private javax.swing.JTextField edEmail;
    private javax.swing.JTextField edEstado;
    private javax.swing.JTextField edNome;
    private javax.swing.JTextField edRua;
    private javax.swing.JTextField edTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
