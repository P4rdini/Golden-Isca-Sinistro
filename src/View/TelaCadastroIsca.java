/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Isca;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author rafa_
 */
public class TelaCadastroIsca extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroIsca
     */
    public TelaCadastroIsca() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPrincipalCadastroIsca = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taID = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taICCID = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        cbOperadora = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbCadastroIscaCliente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID");

        taID.setColumns(20);
        taID.setRows(5);
        jScrollPane1.setViewportView(taID);

        jLabel2.setText("ICCID");

        taICCID.setColumns(20);
        taICCID.setRows(5);
        jScrollPane2.setViewportView(taICCID);

        jLabel3.setText("Operadora");

        cbOperadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "SIERRA", "ESEYE", "KORE", "VIVO" }));

        jLabel4.setText("Cliente");

        cbCadastroIscaCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Cliente 1", "Cliente 2", "Cliente 3" }));

        jLabel5.setText("Tipo");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Retornavel", "Descartavel" }));

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPrincipalCadastroIscaLayout = new javax.swing.GroupLayout(pnPrincipalCadastroIsca);
        pnPrincipalCadastroIsca.setLayout(pnPrincipalCadastroIscaLayout);
        pnPrincipalCadastroIscaLayout.setHorizontalGroup(
            pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                .addGroup(pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel3))
                            .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel4))
                            .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel5))
                            .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbCadastroIscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)))))
                    .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnPrincipalCadastroIscaLayout.setVerticalGroup(
            pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCadastroIscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton1)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrincipalCadastroIsca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrincipalCadastroIsca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//       Isca isca = new Isca(Integer.valueOf(taID.getText()), Integer.valueOf(taICCID.getText()),String.valueOf(cbCliente.getSelectedItem()), String.valueOf(cbOperadora.getSelectedItem()), String.valueOf(cbTipo.getSelectedItem()));

        if (taID.getLineCount() == taICCID.getLineCount()) {
            System.out.println("tamanho igual");
            if (cbCadastroIscaCliente.getSelectedItem().equals("Selecione") || cbOperadora.getSelectedItem().equals("Selecione") || cbTipo.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(null, "Por favor preencher todos os campos");
            } else {
                ArrayList<String> id = new ArrayList<String>();
                ArrayList<String> jaCadastrados = new ArrayList<String>();
                boolean verificacao = false;
                String strID[] = taID.getText().split("\n");
                String strICCID[] = taICCID.getText().split("\n");
                String respCliente = String.valueOf(cbCadastroIscaCliente.getSelectedItem());
                String respOperador = String.valueOf(cbOperadora.getSelectedItem());
                String respTipo = String.valueOf(cbTipo.getSelectedItem());
                Isca consulta = new Isca();

                for (int i = 0; i < strID.length; i++) {

                    if (consulta.PesquisarIsca(Integer.valueOf(strID[i].trim()))) {
                        jaCadastrados.add(strID[i].trim());

                    } else {
                        id.add(strID[i].trim());

                    }
                }

                for (int i = 0; i < id.size(); i++) {
                    Isca resp = new Isca(Integer.valueOf(id.get(i).trim()), strICCID[i].trim(), respCliente, respOperador, respTipo);
                    resp.Gravar();
                    verificacao = true;
                }

                if (!jaCadastrados.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "isca" + jaCadastrados.toString() + " ja estao cadastradas");
                }
                if (verificacao) {
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "a quantidade de ISCAS nao sao iguais do ICCID");
        }
        taICCID.setText("");
        taID.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroIsca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroIsca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroIsca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroIsca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroIsca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbCadastroIscaCliente;
    private javax.swing.JComboBox<String> cbOperadora;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnPrincipalCadastroIsca;
    private javax.swing.JTextArea taICCID;
    private javax.swing.JTextArea taID;
    // End of variables declaration//GEN-END:variables
}