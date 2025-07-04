/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import bean.cmc_vendedor;
import dao.cmc_vendedorDAO;
import javax.swing.JOptionPane;


/**
 *
 * @author notedarckbr
 */
public class JDlgcmc_vendedor extends javax.swing.JDialog {

    /**
     * Creates new form JDlgcmc_vendedor
     */
    
    boolean incluir = false;
    
    public JDlgcmc_vendedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Cadastro de Vendedor");
        Habilitar(Boolean.FALSE);
    }
public void Habilitar(boolean value){
    jTxtcmc_id_vendedor.setEnabled(value);
    jTxtcmc_nome.setEnabled(value);
    jTxtcmc_usuario.setEnabled(value);
    jPwfcmc_senha.setEnabled(value);
    jTxtcmc_email.setEnabled(value);
    
    jFmtcmc_cpf.setEnabled(value);
    jFmtcmc_data_cadastro.setEnabled(value);
    jFmtcmc_data_nacimento.setEnabled(value);
    jFmtcmc_telefone.setEnabled(value);
  
    jChbcmc_ativo.setEnabled(value);
    
    jBtnAlterar.setEnabled(!value);
    jBtnCancelar.setEnabled(value);
    jBtnConfirmar.setEnabled(value);
    jBtnExcluir.setEnabled(!value);
    jBtnIncluir6.setEnabled(!value);
    jBtnPesquisar.setEnabled(!value);
}
 public void limpar(){
    jTxtcmc_id_vendedor.setText("");
    jTxtcmc_email.setText("");
    jTxtcmc_nome.setText("");
    jTxtcmc_usuario.setText("");
    
    jFmtcmc_cpf.setText("");
    jFmtcmc_data_cadastro.setText("");
    jFmtcmc_telefone.setText("");
    jFmtcmc_data_nacimento.setText("");
    
    jChbcmc_ativo.setSelected(false);
    
    jPwfcmc_senha.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnIncluir6 = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jChbcmc_ativo = new javax.swing.JCheckBox();
        jTxtcmc_id_vendedor = new javax.swing.JTextField();
        jTxtcmc_nome = new javax.swing.JTextField();
        jTxtcmc_email = new javax.swing.JTextField();
        jTxtcmc_usuario = new javax.swing.JTextField();
        jPwfcmc_senha = new javax.swing.JPasswordField();
        jFmtcmc_telefone = new javax.swing.JFormattedTextField();
        jFmtcmc_data_nacimento = new javax.swing.JFormattedTextField();
        jFmtcmc_data_cadastro = new javax.swing.JFormattedTextField();
        jFmtcmc_cpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBtnIncluir6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnIncluir6.setText("Incluir");
        jBtnIncluir6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluir6ActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jLabel2.setText("Nome");

        jLabel3.setText("Cpf");

        jLabel4.setText("Email");

        jLabel5.setText("usuario");

        jLabel6.setText("senha");

        jLabel7.setText("telefone");

        jLabel8.setText("data nacimento");

        jLabel9.setText("data cadastro");

        jChbcmc_ativo.setText("Ativo");

        jPwfcmc_senha.setText("jPasswordField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jTxtcmc_email, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(jFmtcmc_data_nacimento))
                .addGap(173, 173, 173))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jBtnIncluir6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtcmc_usuario)
                            .addComponent(jLabel1)
                            .addComponent(jTxtcmc_id_vendedor)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jFmtcmc_data_cadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPwfcmc_senha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTxtcmc_nome, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel6))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jFmtcmc_cpf)
                                    .addComponent(jLabel7)
                                    .addComponent(jFmtcmc_telefone, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
                            .addComponent(jChbcmc_ativo))))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTxtcmc_id_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTxtcmc_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(jTxtcmc_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jFmtcmc_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtcmc_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jPwfcmc_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jFmtcmc_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jFmtcmc_data_nacimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFmtcmc_data_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChbcmc_ativo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir6)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluir6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluir6ActionPerformed
        // TODO add your handling code here:
        Habilitar(Boolean.TRUE);
        limpar();
        incluir = true;
    }//GEN-LAST:event_jBtnIncluir6ActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        Habilitar(Boolean.TRUE);
        incluir = false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
         int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o vendedor?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            cmc_vendedor vendedor = new cmc_vendedor();
            vendedor.setCmc_id_vendedor(Integer.parseInt(jTxtcmc_id_vendedor.getText()));
            cmc_vendedorDAO dao = new cmc_vendedorDAO();
            dao.delete(vendedor);
            limpar();
            Habilitar(Boolean.FALSE);
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:]
          cmc_vendedor vendedor = new cmc_vendedor();

    vendedor.setCmc_id_vendedor(Integer.parseInt(jTxtcmc_id_vendedor.getText()));
    vendedor.setCmc_nome(jTxtcmc_nome.getText());
    vendedor.setCmc_usuario(jTxtcmc_usuario.getText());
    vendedor.setCmc_email(jTxtcmc_email.getText());
    vendedor.setCmc_cpf(jFmtcmc_cpf.getText());
    vendedor.setCmc_telefone(jFmtcmc_telefone.getText());
    vendedor.setCmc_senha(new String(jPwfcmc_senha.getPassword()));

    // Deixa as datas como null para implementar depois
    vendedor.setCmc_data_nascimento(null);
    vendedor.setCmc_data_cadastro(null);

    if(jChbcmc_ativo.isSelected() == true){
                vendedor.setCmc_ativo("S");
        }else{
        vendedor.setCmc_ativo("N");
        }

    cmc_vendedorDAO vendedorDao = new cmc_vendedorDAO();
        if (incluir == true) {
            vendedorDao.insert(vendedor);
        }else{
        vendedorDao.update(vendedor);
        }
    

    Habilitar(Boolean.FALSE);
    limpar();
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        Habilitar(Boolean.FALSE);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        String id = JOptionPane.showInputDialog(null, "Entre com o código?");
        int codigo = Integer.parseInt(id);
        cmc_vendedorDAO dao = new cmc_vendedorDAO();
        cmc_vendedor vendedor = dao.list(codigo);

        if (vendedor == null) {
            JOptionPane.showMessageDialog(null, "Código não encontrado.");
        } else {
            jTxtcmc_id_vendedor.setText(String.valueOf(vendedor.getCmc_id_vendedor()));
            jTxtcmc_nome.setText(vendedor.getCmc_nome());
            jTxtcmc_usuario.setText(vendedor.getCmc_usuario());
            jTxtcmc_email.setText(vendedor.getCmc_email());
            jFmtcmc_cpf.setText(vendedor.getCmc_cpf());
            jFmtcmc_telefone.setText(vendedor.getCmc_telefone());
            jPwfcmc_senha.setText(vendedor.getCmc_senha());
            jFmtcmc_data_nacimento.setText(null);
            jFmtcmc_data_cadastro.setText(null);
            jChbcmc_ativo.setSelected("S".equals(vendedor.getCmc_ativo()));
        }
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgcmc_vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgcmc_vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgcmc_vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgcmc_vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgcmc_vendedor dialog = new JDlgcmc_vendedor(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnIncluir1;
    private javax.swing.JButton jBtnIncluir2;
    private javax.swing.JButton jBtnIncluir3;
    private javax.swing.JButton jBtnIncluir4;
    private javax.swing.JButton jBtnIncluir5;
    private javax.swing.JButton jBtnIncluir6;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JCheckBox jChbcmc_ativo;
    private javax.swing.JFormattedTextField jFmtcmc_cpf;
    private javax.swing.JFormattedTextField jFmtcmc_data_cadastro;
    private javax.swing.JFormattedTextField jFmtcmc_data_nacimento;
    private javax.swing.JFormattedTextField jFmtcmc_telefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPwfcmc_senha;
    private javax.swing.JTextField jTxtcmc_email;
    private javax.swing.JTextField jTxtcmc_id_vendedor;
    private javax.swing.JTextField jTxtcmc_nome;
    private javax.swing.JTextField jTxtcmc_usuario;
    // End of variables declaration//GEN-END:variables
}
