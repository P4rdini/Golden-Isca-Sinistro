/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author rafa_
 */
public class TelaCadastroCliente extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroCliente
     */
    public TelaCadastroCliente() {
        initComponents();
    }

    public void LimparCadastroCliente(){
        cbCadastroClienteStatus.setSelectedIndex(0);
        cbCadastroClientePessoa.setSelectedIndex(0);
        tfCadastroClienteCpfCnpj.setText("");
        cbCadastroClienteInadimplente.setSelectedIndex(0);
        tfCadastroClienteNome.setText("");
        tfCadastroClienteEmail.setText("");
        tfCadastroClienteCep.setText("");
        tfCadastroClienteEndereco.setText("");
        cbCadastroClienteUF.setSelectedIndex(0);
        tfCadastroClienteCidade.setText("");
        tfCadastroClienteBairro.setText("");
        tfCadastroClienteComplemento.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCadastroCliente = new javax.swing.JPanel();
        pnPrincipalCadastroCliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbCadastroClienteStatus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbCadastroClientePessoa = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tfCadastroClienteCpfCnpj = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfCadastroClienteNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfCadastroClienteEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfCadastroClienteCep = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfCadastroClienteEndereco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbCadastroClienteUF = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tfCadastroClienteCidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbCadastroClienteInadimplente = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        tfCadastroClienteBairro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfCadastroClienteComplemento = new javax.swing.JTextField();
        btCadastroClienteSalvar = new javax.swing.JButton();
        btCadastroClienteLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Status *");

        cbCadastroClienteStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Ativo", "Inativo" }));

        jLabel2.setText("Pessoa");

        cbCadastroClientePessoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "J", "F" }));

        jLabel3.setText("CPF/CNPJ ");

        jLabel4.setText("Nome *");

        jLabel5.setText("E-mail");

        jLabel6.setText("CEP");

        jLabel7.setText("Endereço");

        jLabel8.setText("UF");

        cbCadastroClienteUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        jLabel9.setText("Cidade");

        jLabel10.setText("Inadimplente");

        cbCadastroClienteInadimplente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

        jLabel11.setText("Bairro");

        jLabel12.setText("Complemento");

        btCadastroClienteSalvar.setText("Salvar");
        btCadastroClienteSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroClienteSalvarActionPerformed(evt);
            }
        });

        btCadastroClienteLimpar.setText("Limpar");
        btCadastroClienteLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroClienteLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPrincipalCadastroClienteLayout = new javax.swing.GroupLayout(pnPrincipalCadastroCliente);
        pnPrincipalCadastroCliente.setLayout(pnPrincipalCadastroClienteLayout);
        pnPrincipalCadastroClienteLayout.setHorizontalGroup(
            pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalCadastroClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPrincipalCadastroClienteLayout.createSequentialGroup()
                        .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPrincipalCadastroClienteLayout.createSequentialGroup()
                                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfCadastroClienteNome, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnPrincipalCadastroClienteLayout.createSequentialGroup()
                                            .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(cbCadastroClienteStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(43, 43, 43)
                                            .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(cbCadastroClientePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel4))
                                .addGap(34, 34, 34)
                                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(tfCadastroClienteEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnPrincipalCadastroClienteLayout.createSequentialGroup()
                                        .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(tfCadastroClienteCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(39, 39, 39)
                                        .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbCadastroClienteInadimplente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnPrincipalCadastroClienteLayout.createSequentialGroup()
                                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(tfCadastroClienteCep, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCadastroClienteEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCadastroClienteUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPrincipalCadastroClienteLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(22, 22, 22)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnPrincipalCadastroClienteLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(0, 65, Short.MAX_VALUE))
                                    .addComponent(tfCadastroClienteCidade))))
                        .addContainerGap())
                    .addGroup(pnPrincipalCadastroClienteLayout.createSequentialGroup()
                        .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(tfCadastroClienteBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(tfCadastroClienteComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(113, 113, 113))))
            .addGroup(pnPrincipalCadastroClienteLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btCadastroClienteSalvar)
                .addGap(69, 69, 69)
                .addComponent(btCadastroClienteLimpar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnPrincipalCadastroClienteLayout.setVerticalGroup(
            pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalCadastroClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCadastroClienteStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCadastroClientePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCadastroClienteCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCadastroClienteInadimplente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCadastroClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCadastroClienteEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCadastroClienteCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCadastroClienteEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCadastroClienteUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCadastroClienteCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCadastroClienteBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCadastroClienteComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(pnPrincipalCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastroClienteSalvar)
                    .addComponent(btCadastroClienteLimpar))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnCadastroClienteLayout = new javax.swing.GroupLayout(pnCadastroCliente);
        pnCadastroCliente.setLayout(pnCadastroClienteLayout);
        pnCadastroClienteLayout.setHorizontalGroup(
            pnCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroClienteLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(pnPrincipalCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        pnCadastroClienteLayout.setVerticalGroup(
            pnCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnPrincipalCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCadastroCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCadastroCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastroClienteLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroClienteLimparActionPerformed
         LimparCadastroCliente();
    }//GEN-LAST:event_btCadastroClienteLimparActionPerformed

    private void btCadastroClienteSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroClienteSalvarActionPerformed
     if (cbCadastroClienteStatus.getSelectedIndex() == 0 ||
             tfCadastroClienteNome.getText().equals("")){
         JOptionPane.showMessageDialog(null,"Preenchar Todos com campos obrigadorios demarcado com * ");
     }else{
         Cliente cli = new Cliente();
         boolean respStatus;
         boolean respInadimplente;
         String respPessoa;
         if(cbCadastroClienteStatus.getSelectedItem().equals("Sim")){
             respStatus = true;
         }else{
             respStatus = false;
         }
         if(cbCadastroClienteInadimplente.getSelectedItem().equals("Sim")){
             respInadimplente = true;
         }else{
             respInadimplente = false;
         }
         if(cbCadastroClientePessoa.getSelectedItem().equals("F")){
             respPessoa= "Fisica";
         }else{
             respPessoa = "Juridica";
         }
         cli.setStatus(respStatus);
         cli.setPessoa(respPessoa);
         cli.setCpfCnpj(Integer.valueOf(tfCadastroClienteCpfCnpj.getText()));
         cli.setInadimplente(respInadimplente);
         cli.setNome(tfCadastroClienteNome.getText());
         cli.setEmail(tfCadastroClienteEmail.getText());
         cli.setCep(tfCadastroClienteCep.getText());
         cli.setEndereco(tfCadastroClienteEndereco.getText());
         cli.setUF((String)cbCadastroClienteUF.getSelectedItem());
         cli.setCidade(tfCadastroClienteCidade.getText());
         cli.setBairro(tfCadastroClienteBairro.getText());
         cli.setComplemento(tfCadastroClienteComplemento.getText());
         
     /*    if (cli.Gravar(cli)){
             JOptionPane.showMessageDialog(null,"Cliente Salvo com Sucesso");
         }else{
             JOptionPane.showMessageDialog(null,"Nao foi Possivel Salvar o Cliente ");
         }*/
         
     }
    }//GEN-LAST:event_btCadastroClienteSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastroClienteLimpar;
    private javax.swing.JButton btCadastroClienteSalvar;
    private javax.swing.JComboBox<String> cbCadastroClienteInadimplente;
    private javax.swing.JComboBox<String> cbCadastroClientePessoa;
    private javax.swing.JComboBox<String> cbCadastroClienteStatus;
    private javax.swing.JComboBox<String> cbCadastroClienteUF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnCadastroCliente;
    private javax.swing.JPanel pnPrincipalCadastroCliente;
    private javax.swing.JTextField tfCadastroClienteBairro;
    private javax.swing.JTextField tfCadastroClienteCep;
    private javax.swing.JTextField tfCadastroClienteCidade;
    private javax.swing.JTextField tfCadastroClienteComplemento;
    private javax.swing.JTextField tfCadastroClienteCpfCnpj;
    private javax.swing.JTextField tfCadastroClienteEmail;
    private javax.swing.JTextField tfCadastroClienteEndereco;
    private javax.swing.JTextField tfCadastroClienteNome;
    // End of variables declaration//GEN-END:variables
}
