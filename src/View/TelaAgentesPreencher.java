/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Missao;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author rafa_
 */
public class TelaAgentesPreencher extends javax.swing.JFrame {
    List<Missao> missao = new ArrayList<Missao>();
    List<Missao> lista = new ArrayList<Missao>( );
    public TelaAgentesPreencher(List<Missao> lista) {
        initComponents();
        missao = lista;
        this.lista = lista;
        mostrarEquipes(lista);
    }

    private TelaAgentesPreencher() {

    }
     public void mostrarEquipes(List<Missao> lista){
        
//        JPanel Painel = new JPanel();
//        Painel.setSize(500, 32); //32
//        Painel.setVisible(true);
        GridBagConstraints gbc = new GridBagConstraints();
        
        for(int i=0;i<lista.size();i++){
       // listaPainel.get(i).setBorder(javax.swing.BorderFactory.createEtchedBorder());
            if (i==0){
               
          JLabel nome = new JLabel();
          JLabel horarioInicio = new JLabel();
          JLabel horariofim = new JLabel();
          JLabel totalKM = new JLabel();
          JLabel varredura = new JLabel();
          nome.setText("Nome: "+lista.get(i).getAgente().getNome());
          horarioInicio.setText("Horario do Inicio: ");
          horariofim.setText("Horario do Fim: ");
          totalKM.setText("Total de Km: ");
          varredura.setText("Locais feito varredura: ");
         
          JTextField tfhorarioInicio = new JTextField(3);
          JTextField tftotalKM = new JTextField(3);
          JTextField tfhorarioFim = new JTextField(3);
          JTextField tfvarredura = new JTextField(10);
          
          
//          nome.setLocation(10, altura);
//          varredura.setLocation(100, altura);
//          totalKM.setLocation(202, altura);
//          horarioInicio.setLocation(352, altura);
//          horariofim.setLocation(402, altura);
           gbc.gridx =0;
           gbc.gridy = 0;
       
       //    gbc.gridheight=50;
  //         gbc.fill = GridBagConstraints.HORIZONTAL;
          pnTelaAgentesPreencherConteudo.add(nome,gbc);
         gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(horarioInicio,gbc);
           gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(tfhorarioInicio,gbc);
          gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(horariofim,gbc);
           gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(tfhorarioFim,gbc);
           gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(totalKM,gbc);
           gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(tftotalKM,gbc);
           gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(varredura,gbc);
           gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(tfvarredura,gbc);
           gbc.gridx=0;
           gbc.gridy+=10;
          
//       
          
          
          
          
        //  pnTelaAgentesPreencherConteudo.add(Painel);
          
            }else{
               
                JLabel nome = new JLabel();
          JLabel horarioInicio = new JLabel();
          JLabel horariofim = new JLabel();
          JLabel totalKM = new JLabel();
          JLabel varredura = new JLabel();
          
          JTextField tfhorarioInicio = new JTextField(3);
          JTextField tftotalKM = new JTextField(3);
          JTextField tfhorarioFim = new JTextField(3);
          JTextField tfvarredura = new JTextField(10);
          
          nome.setText("Nome: "+lista.get(i).getAgente().getNome()+"        ");
          horarioInicio.setText("Horario do Inicio: ");
          horariofim.setText("Horario do Fim: ");
          totalKM.setText("Total de Km: ");
          varredura.setText("Locais feito varredura: ");
          
     
          
       
         //  gbc.gridheight=0;
          pnTelaAgentesPreencherConteudo.add(nome,gbc); 
          gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(horarioInicio,gbc);
           gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(tfhorarioInicio,gbc);
          gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(horariofim,gbc);
           gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(tfhorarioFim,gbc);
           gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(totalKM,gbc);
           gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(tftotalKM,gbc);
           gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(varredura,gbc);
           gbc.gridx+=5;
          pnTelaAgentesPreencherConteudo.add(tfvarredura,gbc);
           gbc.gridx=0;
           gbc.gridy+=10;
            }
          
          
        }
        setSize(getWidth()+1, getHeight()+1);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTelaAgentesPreencherConteudo = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnTelaAgentesPreencherConteudo.setMaximumSize(new java.awt.Dimension(804, 389));
        pnTelaAgentesPreencherConteudo.setName(""); // NOI18N
        pnTelaAgentesPreencherConteudo.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTelaAgentesPreencherConteudo, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(9, 9, 9)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(pnTelaAgentesPreencherConteudo, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Component[] componente =  pnTelaAgentesPreencherConteudo.getComponents();
        List<JTextField> listaTexto = new ArrayList<JTextField>();
//            JTextField horarioInicio = (JTextField) pnTelaAgentesPreencherConteudo.getComponent(2);
//            JTextField horarioFim = (JTextField) pnTelaAgentesPreencherConteudo.getComponent(4);
//            JTextField totalKM = (JTextField) pnTelaAgentesPreencherConteudo.getComponent(6);
//            JTextField varredura = (JTextField) pnTelaAgentesPreencherConteudo.getComponent(8);
//          if(horarioInicio.getText().isEmpty() || horarioFim.getText().isEmpty()
//             || totalKM.getText().isEmpty() || varredura.getText().isEmpty()){
//              System.out.println("Preencha todos os campos");
//              
                int vazio=0;
                int tamanho =2;
            for (int i=0 ; i<lista.size();i++){
               for(int j=2;j<=8;j=j+2){
                   listaTexto.add((JTextField) pnTelaAgentesPreencherConteudo.getComponent(tamanho));
               tamanho+=2;
               }
               tamanho+=1;
            }
           
        for(JTextField a:listaTexto){
            if(a.getText().isEmpty()){
                vazio++;
            }
        }
        tamanho =0;
        if(vazio !=0){
            JOptionPane.showMessageDialog(null,"Por favor preencher todos os campos");
        }else{
            for(int i=0;i<missao.size();i++){
                missao.get(i).setHorarioInicio(listaTexto.get(i).getText());
                missao.get(i).setHorarioFim(listaTexto.get(i+1).getText());
                missao.get(i).setTotalKm(Integer.valueOf(listaTexto.get(i+2).getText()));
                missao.get(i).setVarredura(listaTexto.get(i+3).getText());
            }
            
            
            TelaMissao tela = new TelaMissao(lista);
            tela.setVisible(true);
            setVisible(false);
        }
        
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAgentesPreencher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAgentesPreencher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAgentesPreencher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAgentesPreencher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAgentesPreencher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel pnTelaAgentesPreencherConteudo;
    // End of variables declaration//GEN-END:variables
}
