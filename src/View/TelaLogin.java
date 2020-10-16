/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.UsuarioDAO;
import Model.Isca;
import Model.Usuario;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author rafa_
 */
public class TelaLogin extends javax.swing.JFrame implements KeyEventDispatcher {

    HashMap login = new HashMap();
    
    public TelaLogin() {
        initComponents();
        Redimencionamento();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
        pegarLogin();
    }
    
    public void Redimencionamento(){
        ImageIcon imagem = new ImageIcon(getClass().getResource("/Resources/bgGolden.jpeg"));
        Image img = imagem.getImage().getScaledInstance(lbLogo.getWidth(), lbLogo.getHeight(), 1);
        lbLogo.setIcon(new ImageIcon(img));
       // lbImgGalinha.setLocation(lbImgGalinha.getX(),lbImgGalinha.getY());
        
    }
    public void logar(){
            String senha = (String) login.get(tfLogin.getText());
            if (senha.equals(tfSenha.getText())){
                Home tela = new Home(tfLogin.getText());
                KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(this);
                setVisible(false);
                tela.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Usuario ou Senha Invalido !");
            }
            
            
       tfSenha.setText("");
    }
            
    public void pegarLogin(){
        UsuarioDAO dao = new UsuarioDAO();
        login =dao.readAll();
        String senha = (String) login.get("adm");
        System.out.println("A senha do hashmap  teste :"+senha);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        tfSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        botaoLogar = new javax.swing.JButton();
        lbLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));
        jPanel2.add(tfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 174, -1));
        jPanel2.add(tfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 174, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Senha:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        botaoLogar.setText("Logar");
        botaoLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLogarActionPerformed(evt);
            }
        });
        jPanel2.add(botaoLogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/bgGolden.jpeg"))); // NOI18N
        jPanel2.add(lbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 390));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLogarActionPerformed
            logar();
             KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(this);
            
    }//GEN-LAST:event_botaoLogarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JPasswordField tfSenha;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean dispatchKeyEvent(KeyEvent ke) {
        if(ke.getID() == KeyEvent.KEY_RELEASED && ke.getKeyCode() == KeyEvent.VK_ENTER){
            logar();
            return true;
        }
        return false; 
    }

   
}
