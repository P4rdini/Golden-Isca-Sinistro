/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Util.Calendario;
import com.sun.prism.paint.Stop;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 *
 * @author rafa_
 */
public class HomeEEE extends javax.swing.JFrame {

    Point point = new Point();
    public HomeEEE() { 
        
        
        
        initComponents();
        abrirIsca= new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao > 150){
                    abrirIsca.stop();
                    
                }else{
                    pnIsca.setSize(pnIsca.getWidth(),padrao);
                  
                    padrao += 10;
                }
            }
        });
        fecharIsca= new Timer(10,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao <50){
                    fecharIsca.stop();
                }else{
                    pnIsca.setSize(pnIsca.getWidth(),padrao);
                    
                    padrao -= 10;
                    
                }
            }
        });
         abrirCliente= new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao > 150){
                    abrirCliente.stop();
                    
                }else{
                    pnCliente.setSize(pnCliente.getWidth(),padrao);
                  
                    padrao += 10;
                }
            }
        });
        fecharCliente= new Timer(10,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao <50){
                    fecharCliente.stop();
                }else{
                    pnCliente.setSize(pnCliente.getWidth(),padrao);
                    
                    padrao -= 10;
                    
                }
            }
        });
        abrirSinistro= new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao > 150){
                    abrirSinistro.stop();
                    
                }else{
                    pnSinistro.setSize(pnSinistro.getWidth(),padrao);
                  
                    padrao += 10;
                }
            }
        });
        fecharSinistro= new Timer(10,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao <50){
                    fecharSinistro.stop();
                }else{
                    pnSinistro.setSize(pnSinistro.getWidth(),padrao);
                    
                    padrao -= 10;
                    
                }
            }
        });
        abrirUsuario= new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao > 150){
                    abrirUsuario.stop();
                    
                }else{
                    pnConta.setSize(pnConta.getWidth(),padrao);
                  
                    padrao += 10;
                }
            }
        });
        fecharUsuario= new Timer(10,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao <50){
                    fecharUsuario.stop();
                }else{
                    pnConta.setSize(pnConta.getWidth(),padrao);
                    
                    padrao -= 10;
                    
                }
            }
        });
    
        
           
       pnPrincipal.addMouseListener ( new MouseAdapter () {
       public  void mousePressed (MouseEvent e) {
        point.x = e.getX ();
        point.y = e.getY ();
      }
    });
     pnPrincipal.addMouseMotionListener ( new MouseMotionAdapter () {
       public  void mouseDragged (MouseEvent e) {
        Point p = getLocation ();
        setLocation (p.x + e.getX () - point.x, p.y + e.getY () - point.y);
      }
    });
    
        
    }
    Timer abrirIsca,fecharIsca;
    Timer abrirCliente,fecharCliente;
    Timer abrirSinistro,fecharSinistro;
    Timer abrirUsuario,fecharUsuario;
    Integer padrao = 50;
    boolean ClickIsca=true;
    boolean ClickCliente=true;
    boolean ClickSinistro=true;
    boolean ClickUsuario=true;
    
    
   
   
   /*  public void limpar() {
        taNumeroIsca.setText("");
        tfData.setText("");
        cbCliente.setSelectedIndex(0);
    }

    public void pegarValores() {
        int x = taNumeroIsca.getLineCount();
        ArrayList<Integer> aaa = new ArrayList<Integer>();
        
      

        if (cbCliente.getSelectedIndex() == 0
                || tfData.getText().equals("__/__/____")) {
            JOptionPane.showMessageDialog(null, "Preencha Todos os campos");
        } else {
            try {
                
                String data = tfData.getText();
                String cliente = String.valueOf(cbCliente.getSelectedItem());

                String str[] = taNumeroIsca.getText().split("\n");
                
                for (int h = 0; h <= taNumeroIsca.getLineCount()-1; h++) {
              
                      Isca bbb = new Isca();
                   
                    bbb.setID(Integer.valueOf(str[h]));
                    bbb.setData(data);
                    bbb.setCliente(cliente);
                    Isca.lista.add(bbb);  
             
                        
                     
                    

                }
                
             
                    Isca isca = new Isca();
                isca.Gravar();
                limpar();
            
                
            } catch (NumberFormatException e) {
                System.out.println(e.getStackTrace()+"        "+e.getMessage());
                JOptionPane.showMessageDialog(null, "Campos numero isca contem letra");

            }

        }
    }*/
    
      
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPrincipal = new javax.swing.JPanel();
        pnTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        pnIsca = new javax.swing.JPanel();
        lbIconHome1 = new javax.swing.JLabel();
        lbHome1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnCliente = new javax.swing.JPanel();
        lbIconHome7 = new javax.swing.JLabel();
        lbHome7 = new javax.swing.JLabel();
        pnSinistro = new javax.swing.JPanel();
        lbIconHome3 = new javax.swing.JLabel();
        lbHome3 = new javax.swing.JLabel();
        lbLogo = new javax.swing.JLabel();
        pnHome = new javax.swing.JPanel();
        lbIconHome4 = new javax.swing.JLabel();
        lbHome4 = new javax.swing.JLabel();
        btHome = new javax.swing.JButton();
        pnConta = new javax.swing.JPanel();
        lbIconHome8 = new javax.swing.JLabel();
        lbHome8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnConteudo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(0, 0));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(930, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnPrincipal.setMaximumSize(new java.awt.Dimension(0, 0));

        pnTitulo.setBackground(new java.awt.Color(110, 89, 222));
        pnTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Isca para finalizar: 0");
        pnTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 34, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Clientes Cadastrados:0 ");
        pnTitulo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 34, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Sinistros:0");
        pnTitulo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 34, -1, -1));

        pnMenu.setBackground(new java.awt.Color(54, 33, 89));
        pnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnIsca.setBackground(new java.awt.Color(64, 43, 100));
        pnIsca.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnIsca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnIscaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnIscaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnIscaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnIscaMousePressed(evt);
            }
        });
        pnIsca.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIconHome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconHome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/gps.png"))); // NOI18N
        pnIsca.add(lbIconHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 74, 54));

        lbHome1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbHome1.setForeground(new java.awt.Color(204, 204, 204));
        lbHome1.setText("Isca");
        pnIsca.add(lbHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 12, -1, 32));

        jLabel4.setText("Consultar");
        pnIsca.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel5.setText("Cadastrar");
        pnIsca.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel6.setText("Relatorio");
        pnIsca.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        pnMenu.add(pnIsca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 270, 50));

        pnCliente.setBackground(new java.awt.Color(85, 65, 118));
        pnCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnClienteMouseExited(evt);
            }
        });

        lbIconHome7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconHome7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cliente.png"))); // NOI18N

        lbHome7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbHome7.setForeground(new java.awt.Color(204, 204, 204));
        lbHome7.setText("Cliente");

        javax.swing.GroupLayout pnClienteLayout = new javax.swing.GroupLayout(pnCliente);
        pnCliente.setLayout(pnClienteLayout);
        pnClienteLayout.setHorizontalGroup(
            pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnClienteLayout.createSequentialGroup()
                .addComponent(lbIconHome7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lbHome7))
        );
        pnClienteLayout.setVerticalGroup(
            pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIconHome7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnClienteLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbHome7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnMenu.add(pnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 270, 50));

        pnSinistro.setBackground(new java.awt.Color(64, 43, 100));
        pnSinistro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnSinistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnSinistroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnSinistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnSinistroMouseExited(evt);
            }
        });
        pnSinistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIconHome3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconHome3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/sinistro.png"))); // NOI18N
        pnSinistro.add(lbIconHome3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 74, 54));

        lbHome3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbHome3.setForeground(new java.awt.Color(204, 204, 204));
        lbHome3.setText("Sinistro");
        pnSinistro.add(lbHome3, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 12, -1, 32));

        pnMenu.add(pnSinistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 270, 50));

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png"))); // NOI18N
        pnMenu.add(lbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 88));

        pnHome.setBackground(new java.awt.Color(85, 65, 118));
        pnHome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIconHome4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconHome4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home.png"))); // NOI18N
        pnHome.add(lbIconHome4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 74, 54));

        lbHome4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbHome4.setForeground(new java.awt.Color(204, 204, 204));
        lbHome4.setText("Home");
        pnHome.add(lbHome4, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 12, -1, 32));

        btHome.setBackground(new java.awt.Color(85, 65, 118));
        btHome.setContentAreaFilled(false);
        btHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHomeActionPerformed(evt);
            }
        });
        pnHome.add(btHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 30));

        pnMenu.add(pnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 94, 270, 50));

        pnConta.setBackground(new java.awt.Color(85, 65, 118));
        pnConta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnContaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnContaMouseExited(evt);
            }
        });
        pnConta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIconHome8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconHome8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/conta.png"))); // NOI18N
        pnConta.add(lbIconHome8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 74, 54));

        lbHome8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbHome8.setForeground(new java.awt.Color(204, 204, 204));
        lbHome8.setText("Conta");
        pnConta.add(lbHome8, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 12, -1, 32));

        jButton1.setText("jButton1");
        pnConta.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jButton3.setText("jButton3");
        pnConta.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jButton4.setText("jButton4");
        pnConta.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        pnMenu.add(pnConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 270, 50));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/x.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pnConteudo.setBackground(new java.awt.Color(255, 255, 255));
        pnConteudo.setForeground(new java.awt.Color(255, 255, 255));
        pnConteudo.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addGap(570, 570, 570)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnPrincipalLayout.setVerticalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnConteudo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110))
        );

        getContentPane().add(pnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHomeActionPerformed
/*       JPanel consulta ;
       TelaConsulta c= new TelaConsulta();
       consulta = c.pnPrincipal;
       pnConteudo.removeAll();
       pnConteudo.add(consulta);*/
        CardLayout card = (CardLayout) pnConteudo.getLayout();
        card.show(pnConteudo, "Consulta");
    }//GEN-LAST:event_btHomeActionPerformed

    
    
    private void pnContaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnContaMouseExited
             abrirUsuario.stop();
        fecharUsuario.start();
      
        
    }//GEN-LAST:event_pnContaMouseExited

    private void pnContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnContaMouseClicked
                   if (ClickUsuario){
        fecharUsuario.stop();
        abrirUsuario.start();
        ClickUsuario = false;
          }else{
              abrirUsuario.stop();
             fecharUsuario.start();
              ClickUsuario=true;
          }
        
    }//GEN-LAST:event_pnContaMouseClicked

    private void pnIscaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnIscaMouseEntered
        
    }//GEN-LAST:event_pnIscaMouseEntered

    private void pnIscaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnIscaMouseExited
     abrirIsca.stop();
     fecharIsca.start();
    }//GEN-LAST:event_pnIscaMouseExited

    private void pnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnClienteMouseEntered
      
    }//GEN-LAST:event_pnClienteMouseEntered

    private void pnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnClienteMouseExited
       abrirCliente.stop();
       fecharCliente.start();
    }//GEN-LAST:event_pnClienteMouseExited

    private void pnSinistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnSinistroMouseEntered
        
    }//GEN-LAST:event_pnSinistroMouseEntered

    private void pnSinistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnSinistroMouseExited
        abrirSinistro.stop();
        fecharSinistro.start();
    }//GEN-LAST:event_pnSinistroMouseExited

    private void pnIscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnIscaMouseClicked
    
        if (ClickIsca){
            fecharIsca.stop();
       abrirIsca.start();
            ClickIsca=false;
        }else{
            abrirIsca.stop();
            fecharIsca.start();
            ClickIsca=true;
        }
        
    }//GEN-LAST:event_pnIscaMouseClicked

    private void pnClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnClienteMouseClicked
        if (ClickCliente){
            
        fecharCliente.stop();
      abrirCliente.start();
      ClickCliente=false;
        }else{
            abrirCliente.stop();
            fecharCliente.start();
            ClickCliente=true;
        }
        
        
    }//GEN-LAST:event_pnClienteMouseClicked

    private void pnSinistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnSinistroMouseClicked
          if (ClickSinistro){
        fecharSinistro.stop();
        abrirSinistro.start();
        ClickSinistro = false;
          }else{
              abrirSinistro.stop();
             fecharSinistro.start();
              ClickSinistro=true;
          }
        
        
    }//GEN-LAST:event_pnSinistroMouseClicked

    private void pnIscaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnIscaMousePressed
         pnIsca.setBorder(BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_pnIscaMousePressed

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
            java.util.logging.Logger.getLogger(HomeEEE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeEEE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeEEE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeEEE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeEEE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btHome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbHome1;
    private javax.swing.JLabel lbHome3;
    private javax.swing.JLabel lbHome4;
    private javax.swing.JLabel lbHome7;
    private javax.swing.JLabel lbHome8;
    private javax.swing.JLabel lbIconHome1;
    private javax.swing.JLabel lbIconHome3;
    private javax.swing.JLabel lbIconHome4;
    private javax.swing.JLabel lbIconHome7;
    private javax.swing.JLabel lbIconHome8;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JPanel pnCliente;
    private javax.swing.JPanel pnConta;
    private javax.swing.JPanel pnConteudo;
    private javax.swing.JPanel pnHome;
    private javax.swing.JPanel pnIsca;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnPrincipal;
    private javax.swing.JPanel pnSinistro;
    private javax.swing.JPanel pnTitulo;
    // End of variables declaration//GEN-END:variables

   
}
