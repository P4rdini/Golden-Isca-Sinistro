/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

/**
 *
 * @author rafa_
 */
//* Classe calendario que retorna o dia mes e ano selecionado  */
public class Calendario extends javax.swing.JFrame {
    /* instanciamos um objeto do tipo Calendar para manipularmos as datas */
    private Calendar data = Calendar.getInstance();
    /* criamos um lista de labels onde cada uma corresponde a um dia da semana da nossa tela*/
    ArrayList<JLabel> ListaLb = new ArrayList<JLabel>();
    
    ArrayList<Boolean> ListaVerificacao = new ArrayList<Boolean>();
    /* pegamos o mes atual atravez da funcao get da classe Calendar*/
    private Integer Mes = data.get(Calendar.MONTH);
    /* Aqui criamos uma variavel para cada mes do ano , com o valor de todas de dias daquele mes */
    private int janeiro = 31;
    private int fevereiro = 29;
    private int marco = 31;
    private int abril = 31;
    private int maio = 31;
    private int junho = 30;
    private int julho = 31;
    private int agosto = 31;
    private int setembro = 30;
    private int outubro = 31;
    private int novembro = 30;
    private int dezembro = 31;
    private boolean v1 = true;
    /* Aqui declado o objeto que vai receber o valor da  data selecionado , neste caso ira aparecer em um Campo de texto */
    JTextField caixa;

    /**
     * No construtor precisamos que seja enviado um Objetivo do Tipo TextFild que iremos atribuir o valor
     * selecionado do Calendario 
     *@param CaixaDeCombinacao Objetivo do tipo campo de texto que recebe no dia mes e ano selecionado no calendario   */
    public Calendario(JTextField CaixaDeCombinacao) {
        /*Funcao responsavel da parte de Swing da nossa tela */
        initComponents();
        /*Aqui estamos atribuindo na nossa variavel local o Campo de texto*/
        caixa = CaixaDeCombinacao;
        /*setamos o modelo do nosso Jspinner atraves do metodo 'modelo' da nossa classe*/
        spAno.setModel(modelo());
        /*setamos nosso Jlabel usando a Classe Calendar que nos retorna o mes atual*/
        Mes(data.get(Calendar.MONTH));
        /** setamos o Jspinner com o ano atual utilizando c classe Calendar */
        spAno.setValue(data.get(Calendar.YEAR));
        /*Esse metodo preenchemos as Label correspondendo a os dia da semana do mes que o Calendario se encontra  */
        PreencherDias();

    }
/**
 * Esse construtor usava para testes 
 */
    private Calendario() {
        initComponents();
        spAno.setModel(modelo());
        /*setamos nosso Jlabel usando a Classe Calendar que nos retorna o mes atual*/
        Mes(data.get(Calendar.MONTH));
        /** setamos o Jspinner com o ano atual utilizando c classe Calendar */
        spAno.setValue(data.get(Calendar.YEAR));
        /*Esse metodo preenchemos as Label correspondendo a os dia da semana do mes que o Calendario se encontra  */
        PreencherDias();
    }
    
    /**
     * Metodo que atribui nas Labels dia o numeral 0 a esqueda do numero para deixar com o Formato dd/mm/aaaa
     */
    public void ArrumarDia(){
        /* percorremos a lista de labels inteira */
        for (int i=0;i<ListaLb.size();i++){
            /**
             * Verificamos que a Label esta dentro dos valores de 1 a 9 
             * se estiver acrescentemos o numeral 0 a esqueda 
             * Se nao estiver passa para a proxima Label
             */
            if(ListaLb.get(i).getText().equals("1") ||
                    ListaLb.get(i).getText().equals("2") ||
                    ListaLb.get(i).getText().equals("3") ||
                    ListaLb.get(i).getText().equals("4") ||
                    ListaLb.get(i).getText().equals("5") ||
                    ListaLb.get(i).getText().equals("6") ||
                    ListaLb.get(i).getText().equals("7") ||
                    ListaLb.get(i).getText().equals("8") ||
                    ListaLb.get(i).getText().equals("9")){
                ListaLb.get(i).setText("0"+ListaLb.get(i).getText());
                
            }
        
        }
    }
    
    /**
     * Metodo converte o Mes selecionado de texto para numero
     * @param str Valor do mes selecionado 
     * @return o mes selecionado em numeral 
     */
    public String ConverterMes(String str){
            
        if (str.equals("Janeiro")) return "01";
        
        if (str.equals("Fevereiro")) return "02";
        if (str.equals("Março")) return "03";
        if (str.equals("Abril")) return "04";
        if (str.equals("Maio")) return "05";
        if (str.equals("Junho")) return "06";
        if (str.equals("Julho")) return "07";
        if (str.equals("Agosto")) return "08";
        if (str.equals("Setembro")) return "09";
        
        if (str.equals("Outubro")) return "10";
        if (str.equals("Novembro")) return "11";
        if (str.equals("Dezembro")) return "12";
       
        
        
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnCalendario = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbMes = new javax.swing.JLabel();
        btLeft = new javax.swing.JButton();
        btRight = new javax.swing.JButton();
        spAno = new javax.swing.JSpinner();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        d1 = new javax.swing.JLabel();
        d8 = new javax.swing.JLabel();
        d15 = new javax.swing.JLabel();
        d22 = new javax.swing.JLabel();
        d29 = new javax.swing.JLabel();
        d36 = new javax.swing.JLabel();
        lbSeg = new javax.swing.JLabel();
        d2 = new javax.swing.JLabel();
        d9 = new javax.swing.JLabel();
        d16 = new javax.swing.JLabel();
        d23 = new javax.swing.JLabel();
        d30 = new javax.swing.JLabel();
        d37 = new javax.swing.JLabel();
        lbTer = new javax.swing.JLabel();
        lbQua = new javax.swing.JLabel();
        lbQui = new javax.swing.JLabel();
        lbSex = new javax.swing.JLabel();
        lbSab = new javax.swing.JLabel();
        d3 = new javax.swing.JLabel();
        d10 = new javax.swing.JLabel();
        d17 = new javax.swing.JLabel();
        d24 = new javax.swing.JLabel();
        d31 = new javax.swing.JLabel();
        d38 = new javax.swing.JLabel();
        d39 = new javax.swing.JLabel();
        d32 = new javax.swing.JLabel();
        d25 = new javax.swing.JLabel();
        d18 = new javax.swing.JLabel();
        d11 = new javax.swing.JLabel();
        d4 = new javax.swing.JLabel();
        d5 = new javax.swing.JLabel();
        d12 = new javax.swing.JLabel();
        d19 = new javax.swing.JLabel();
        d26 = new javax.swing.JLabel();
        d33 = new javax.swing.JLabel();
        d40 = new javax.swing.JLabel();
        d6 = new javax.swing.JLabel();
        d13 = new javax.swing.JLabel();
        d20 = new javax.swing.JLabel();
        d27 = new javax.swing.JLabel();
        d34 = new javax.swing.JLabel();
        d41 = new javax.swing.JLabel();
        d7 = new javax.swing.JLabel();
        d14 = new javax.swing.JLabel();
        d21 = new javax.swing.JLabel();
        d28 = new javax.swing.JLabel();
        d35 = new javax.swing.JLabel();
        d42 = new javax.swing.JLabel();
        lbDom = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnCalendario.setBackground(new java.awt.Color(255, 255, 255));
        pnCalendario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setForeground(new java.awt.Color(102, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMes.setText("Janeiro");
        jPanel4.add(lbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 8, -1, -1));

        btLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_prev_15px.png"))); // NOI18N
        btLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLeftActionPerformed(evt);
            }
        });
        jPanel4.add(btLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 25, 25));

        btRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_right_button_15px.png"))); // NOI18N
        btRight.setToolTipText("");
        btRight.setBorder(null);
        btRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRightActionPerformed(evt);
            }
        });
        jPanel4.add(btRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 2, 25, 25));

        spAno.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spAnoStateChanged(evt);
            }
        });
        jPanel4.add(spAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 5, 75, 23));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 270, 10));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        d1.setText("0");
        d1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 7);
        jPanel3.add(d1, gridBagConstraints);

        d8.setBackground(new java.awt.Color(102, 102, 255));
        d8.setText("0");
        d8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d8MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel3.add(d8, gridBagConstraints);

        d15.setBackground(new java.awt.Color(102, 102, 255));
        d15.setText("0");
        d15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d15MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel3.add(d15, gridBagConstraints);

        d22.setBackground(new java.awt.Color(102, 102, 255));
        d22.setText("0");
        d22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d22MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel3.add(d22, gridBagConstraints);

        d29.setBackground(new java.awt.Color(102, 102, 255));
        d29.setText("0");
        d29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d29MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel3.add(d29, gridBagConstraints);

        d36.setBackground(new java.awt.Color(102, 102, 255));
        d36.setText("0");
        d36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d36MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel3.add(d36, gridBagConstraints);

        lbSeg.setBackground(new java.awt.Color(102, 102, 255));
        lbSeg.setForeground(new java.awt.Color(255, 51, 51));
        lbSeg.setText("SEG");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 10);
        jPanel3.add(lbSeg, gridBagConstraints);

        d2.setText("0");
        d2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d2MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d2, gridBagConstraints);

        d9.setText("0");
        d9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d9MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d9, gridBagConstraints);

        d16.setText("0");
        d16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d16MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d16, gridBagConstraints);

        d23.setText("0");
        d23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d23MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d23, gridBagConstraints);

        d30.setText("0");
        d30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d30MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d30, gridBagConstraints);

        d37.setText("0");
        d37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d37MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 15);
        jPanel3.add(d37, gridBagConstraints);

        lbTer.setBackground(new java.awt.Color(102, 102, 255));
        lbTer.setForeground(new java.awt.Color(255, 51, 51));
        lbTer.setText("TER");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(lbTer, gridBagConstraints);

        lbQua.setBackground(new java.awt.Color(102, 102, 255));
        lbQua.setForeground(new java.awt.Color(255, 51, 51));
        lbQua.setText("QUA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(lbQua, gridBagConstraints);

        lbQui.setBackground(new java.awt.Color(102, 102, 255));
        lbQui.setForeground(new java.awt.Color(255, 51, 51));
        lbQui.setText("QUI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(lbQui, gridBagConstraints);

        lbSex.setBackground(new java.awt.Color(102, 102, 255));
        lbSex.setForeground(new java.awt.Color(255, 51, 51));
        lbSex.setText("SEX");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(lbSex, gridBagConstraints);

        lbSab.setBackground(new java.awt.Color(102, 102, 255));
        lbSab.setForeground(new java.awt.Color(255, 51, 51));
        lbSab.setText("SAB");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 6);
        jPanel3.add(lbSab, gridBagConstraints);

        d3.setText("0");
        d3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d3MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d3, gridBagConstraints);

        d10.setText("0");
        d10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d10MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d10, gridBagConstraints);

        d17.setText("0");
        d17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d17MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d17, gridBagConstraints);

        d24.setText("0");
        d24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d24MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d24, gridBagConstraints);

        d31.setText("0");
        d31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d31MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d31, gridBagConstraints);

        d38.setText("0");
        d38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d38MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 15);
        jPanel3.add(d38, gridBagConstraints);

        d39.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 15);
        jPanel3.add(d39, gridBagConstraints);

        d32.setText("0");
        d32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d32MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d32, gridBagConstraints);

        d25.setText("0");
        d25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d25MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d25, gridBagConstraints);

        d18.setText("0");
        d18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d18MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d18, gridBagConstraints);

        d11.setText("0");
        d11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d11MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d11, gridBagConstraints);

        d4.setText("0");
        d4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d4MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d4, gridBagConstraints);

        d5.setText("0");
        d5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d5MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d5, gridBagConstraints);

        d12.setText("0");
        d12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d12MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d12, gridBagConstraints);

        d19.setText("0");
        d19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d19MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d19, gridBagConstraints);

        d26.setText("0");
        d26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d26MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d26, gridBagConstraints);

        d33.setText("0");
        d33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d33MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d33, gridBagConstraints);

        d40.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 15);
        jPanel3.add(d40, gridBagConstraints);

        d6.setText("0");
        d6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d6MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d6, gridBagConstraints);

        d13.setText("0");
        d13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d13MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d13, gridBagConstraints);

        d20.setText("0");
        d20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d20MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d20, gridBagConstraints);

        d27.setText("0");
        d27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d27MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d27, gridBagConstraints);

        d34.setText("0");
        d34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d34MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 15);
        jPanel3.add(d34, gridBagConstraints);

        d41.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 15);
        jPanel3.add(d41, gridBagConstraints);

        d7.setText("0");
        d7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d7MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 6);
        jPanel3.add(d7, gridBagConstraints);

        d14.setText("0");
        d14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d14MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 6);
        jPanel3.add(d14, gridBagConstraints);

        d21.setText("0");
        d21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d21MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 6);
        jPanel3.add(d21, gridBagConstraints);

        d28.setText("0");
        d28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d28MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 6);
        jPanel3.add(d28, gridBagConstraints);

        d35.setText("0");
        d35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d35MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 6);
        jPanel3.add(d35, gridBagConstraints);

        d42.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 6);
        jPanel3.add(d42, gridBagConstraints);

        lbDom.setBackground(new java.awt.Color(102, 102, 255));
        lbDom.setForeground(new java.awt.Color(255, 51, 51));
        lbDom.setText("DOM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 10);
        jPanel3.add(lbDom, gridBagConstraints);

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 290, 150));

        javax.swing.GroupLayout pnCalendarioLayout = new javax.swing.GroupLayout(pnCalendario);
        pnCalendario.setLayout(pnCalendarioLayout);
        pnCalendarioLayout.setHorizontalGroup(
            pnCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCalendarioLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnCalendarioLayout.setVerticalGroup(
            pnCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCalendarioLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(pnCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 180));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRightActionPerformed
        /** verifica se esta no ultimo mes do ano
         caso for verdadeiro o mes recebe o valor -1 */
        if (Mes == 11) {
            Mes = -1;
        }
        /*Passa para o proximo mes*/
        Mes++;
        /*Metodo da classe atual que seta o mes*/
        Mes(Mes);
        /* Metodo para Preencher as Label com os respectivos dias do mes */
        PreencherDias();
        /**Verifica se o mes Atual corresponde a o primeiro mes do ano*/
        if (Mes == 0) {
            /*declara variavel do tipo inteiro que recebe o valor do ano atual e adiciona mais um  */
            Integer ano = (Integer) spAno.getValue() + 1;
            /*Seta o novo valor do ano no Objetivo Jspinner */
            spAno.setValue(ano);
        }


    }//GEN-LAST:event_btRightActionPerformed

    private void btLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLeftActionPerformed
        /** verifica se esta no ultimo mes do ano
         caso for verdadeiro o mes recebe o valor 12 */
        if (Mes == 0) {
            Mes = 12;

        }
        /*Passa para o mes anterior */
        Mes--;
        /*Metodo da classe atual que seta o mes*/
        Mes(Mes);
        /* Metodo para Preencher as Label com os respectivos dias do mes */
        PreencherDias();
        /**Verifica se o mes Atual corresponde a o ultimo mes do ano*/
        if (Mes == 11) {
            /*declara variavel do tipo inteiro que recebe o valor do ano atual e subtrai  um  */
            Integer ano = (Integer) spAno.getValue() - 1;
            /*Seta o novo valor do ano no Objetivo Jspinner */
            spAno.setValue(ano);
        }
    }//GEN-LAST:event_btLeftActionPerformed

    private void d1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1MouseClicked
         /*Verifica se a Label selecionado se estar em vermelho */
        if (ListaLb.get(0).getForeground().equals(Color.RED)) {
            /**
             * Metodo que acrescenta o valor 0 a esquerda dos numero no intervalo de 1 a 9*/
            ArrumarDia();
            /*Setamos o campo de texto com o valor selecionado */
            caixa.setText(ListaLb.get(0).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            /*Deixa nossa tela invisivel */
            setVisible(false);
        } else {
            /*Percorre todo a lista de Label*/
            for (JLabel lbs : ListaLb) {
                /*Seta a cor de Todas a label para Preto */
                lbs.setForeground(Color.BLACK);
            }
            /*Seta a cor para vermelho para label atual */
            ListaLb.get(0).setForeground(Color.red);
        }
    }//GEN-LAST:event_d1MouseClicked

    private void d2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d2MouseClicked
        if (ListaLb.get(1).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(1).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(1).setForeground(Color.red);
        }
    }//GEN-LAST:event_d2MouseClicked

    private void spAnoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spAnoStateChanged
        PreencherDias();
    }//GEN-LAST:event_spAnoStateChanged

    private void d3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d3MouseClicked
        if (ListaLb.get(2).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(2).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(2).setForeground(Color.red);
        }
    }//GEN-LAST:event_d3MouseClicked

    private void d4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d4MouseClicked
         if (ListaLb.get(3).getForeground().equals(Color.RED)) {
             ArrumarDia();
            caixa.setText(ListaLb.get(3).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(3).setForeground(Color.red);
        }
    }//GEN-LAST:event_d4MouseClicked

    private void d5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d5MouseClicked
        if (ListaLb.get(4).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(4).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(4).setForeground(Color.red);
        }
    }//GEN-LAST:event_d5MouseClicked

    private void d6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d6MouseClicked
         if (ListaLb.get(5).getForeground().equals(Color.RED)) {
             ArrumarDia();
            caixa.setText(ListaLb.get(5).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(5).setForeground(Color.red);
        }
    }//GEN-LAST:event_d6MouseClicked

    private void d7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d7MouseClicked
         if (ListaLb.get(6).getForeground().equals(Color.RED)) {
             ArrumarDia();
            caixa.setText(ListaLb.get(6).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(6).setForeground(Color.red);
        }
    }//GEN-LAST:event_d7MouseClicked

    private void d8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d8MouseClicked
         if (ListaLb.get(7).getForeground().equals(Color.RED)) {
             ArrumarDia();
            caixa.setText(ListaLb.get(7).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(7).setForeground(Color.red);
        }
    }//GEN-LAST:event_d8MouseClicked

    private void d9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d9MouseClicked
         if (ListaLb.get(8).getForeground().equals(Color.RED)) {
             ArrumarDia();
            caixa.setText(ListaLb.get(8).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(8).setForeground(Color.red);
        }
    }//GEN-LAST:event_d9MouseClicked

    private void d10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d10MouseClicked
         if (ListaLb.get(9).getForeground().equals(Color.RED)) {
             ArrumarDia();
            caixa.setText(ListaLb.get(9).getText() + "/" + ConverterMes(lbMes.getText())+ "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(9).setForeground(Color.red);
        }
    }//GEN-LAST:event_d10MouseClicked

    private void d11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d11MouseClicked
        if (ListaLb.get(10).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(10).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(10).setForeground(Color.red);
        }
    }//GEN-LAST:event_d11MouseClicked

    private void d12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d12MouseClicked
        if (ListaLb.get(11).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(11).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(11).setForeground(Color.red);
        }
    }//GEN-LAST:event_d12MouseClicked

    private void d13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d13MouseClicked
        if (ListaLb.get(12).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(12).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(12).setForeground(Color.red);
        }
    }//GEN-LAST:event_d13MouseClicked

    private void d14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d14MouseClicked
        if (ListaLb.get(13).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(13).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(13).setForeground(Color.red);
        }
    }//GEN-LAST:event_d14MouseClicked

    private void d15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d15MouseClicked
        if (ListaLb.get(14).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(14).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(14).setForeground(Color.red);
        }
    }//GEN-LAST:event_d15MouseClicked

    private void d16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d16MouseClicked
        if (ListaLb.get(15).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(15).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(15).setForeground(Color.red);
        }
    }//GEN-LAST:event_d16MouseClicked

    private void d17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d17MouseClicked
        if (ListaLb.get(16).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(16).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(16).setForeground(Color.red);
        }
    }//GEN-LAST:event_d17MouseClicked

    private void d18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d18MouseClicked
        if (ListaLb.get(17).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(17).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(17).setForeground(Color.red);
        }
    }//GEN-LAST:event_d18MouseClicked

    private void d19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d19MouseClicked
        if (ListaLb.get(18).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(18).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(18).setForeground(Color.red);
        }
    }//GEN-LAST:event_d19MouseClicked

    private void d20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d20MouseClicked
        if (ListaLb.get(19).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(19).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(19).setForeground(Color.red);
        }
    }//GEN-LAST:event_d20MouseClicked

    private void d21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d21MouseClicked
        if (ListaLb.get(20).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(20).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(20).setForeground(Color.red);
        }
    }//GEN-LAST:event_d21MouseClicked

    private void d22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d22MouseClicked
        if (ListaLb.get(21).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(21).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(21).setForeground(Color.red);
        }
    }//GEN-LAST:event_d22MouseClicked

    private void d23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d23MouseClicked
        if (ListaLb.get(22).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(22).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(22).setForeground(Color.red);
        }
    }//GEN-LAST:event_d23MouseClicked

    private void d24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d24MouseClicked
        if (ListaLb.get(23).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(23).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(23).setForeground(Color.red);
        }
    }//GEN-LAST:event_d24MouseClicked

    private void d25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d25MouseClicked
        if (ListaLb.get(24).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(24).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(24).setForeground(Color.red);
        }
    }//GEN-LAST:event_d25MouseClicked

    private void d26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d26MouseClicked
        if (ListaLb.get(25).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(25).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(25).setForeground(Color.red);
        }
    }//GEN-LAST:event_d26MouseClicked

    private void d27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d27MouseClicked
        if (ListaLb.get(26).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(26).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(26).setForeground(Color.red);
        }
    }//GEN-LAST:event_d27MouseClicked

    private void d28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d28MouseClicked
        if (ListaLb.get(27).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(27).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(27).setForeground(Color.red);
        }
    }//GEN-LAST:event_d28MouseClicked

    private void d29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d29MouseClicked
        if (ListaLb.get(28).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(28).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(28).setForeground(Color.red);
        }
    }//GEN-LAST:event_d29MouseClicked

    private void d30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d30MouseClicked
        if (ListaLb.get(29).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(29).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(29).setForeground(Color.red);
        }
    }//GEN-LAST:event_d30MouseClicked

    private void d31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d31MouseClicked
        if (ListaLb.get(30).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(30).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(30).setForeground(Color.red);
        }
    }//GEN-LAST:event_d31MouseClicked

    private void d32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d32MouseClicked
        if (ListaLb.get(31).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(31).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(31).setForeground(Color.red);
        }
    }//GEN-LAST:event_d32MouseClicked

    private void d33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d33MouseClicked
        if (ListaLb.get(32).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(32).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(32).setForeground(Color.red);
        }
    }//GEN-LAST:event_d33MouseClicked

    private void d34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d34MouseClicked
        if (ListaLb.get(33).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(33).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(33).setForeground(Color.red);
        }
    }//GEN-LAST:event_d34MouseClicked

    private void d35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d35MouseClicked
        if (ListaLb.get(34).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(34).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(34).setForeground(Color.red);
        }
    }//GEN-LAST:event_d35MouseClicked

    private void d36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d36MouseClicked
        if (ListaLb.get(35).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(35).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(35).setForeground(Color.red);
        }
    }//GEN-LAST:event_d36MouseClicked

    private void d37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d37MouseClicked
        if (ListaLb.get(36).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(36).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(36).setForeground(Color.red);
        }
    }//GEN-LAST:event_d37MouseClicked

    private void d38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d38MouseClicked
        if (ListaLb.get(37).getForeground().equals(Color.RED)) {
            ArrumarDia();
            caixa.setText(ListaLb.get(37).getText() + "/" + ConverterMes(lbMes.getText()) + "/" + spAno.getValue());
            setVisible(false);
        } else {
            for (JLabel lbs : ListaLb) {
                lbs.setForeground(Color.BLACK);
            }
            ListaLb.get(37).setForeground(Color.red);
        }
    }//GEN-LAST:event_d38MouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calendario().setVisible(true);
            }
        });
    }
    /**
     * Metodo para setar a Label Mes com o valor de entrada
     * @param resp Valor Inteiro correspondendo o mes do ano 
     */
    public void Mes(int resp) {

        switch (resp) {
            case 0:
                lbMes.setText("Janeiro");
                break;
            case 1:
                lbMes.setText("Fevereiro");
                break;
            case 2:
                lbMes.setText("Março");
                break;
            case 3:
                lbMes.setText("Abril");
                break;
            case 4:
                lbMes.setText("Maio");
                break;
            case 5:
                lbMes.setText("Junho");
                break;
            case 6:
                lbMes.setText("Julho");
                break;
            case 7:
                lbMes.setText("Agosto");
                break;
            case 8:
                lbMes.setText("Setembro");
                break;
            case 9:
                lbMes.setText("Outubro");
                break;
            case 10:
                lbMes.setText("Novembro");
                break;
            case 11:
                lbMes.setText("Dezembro");
                break;
        }
    }
    /**
     * Metodo que retorna um modelo do Jspinner referente a os Anos
     * @return Retorna um Modelo de Jspinner 
     */
    public SpinnerListModel modelo() {
        /*Declaracao de Modelo do Objetivo Jspinner */
        SpinnerListModel model = new SpinnerListModel();
        /*Declaracao de uma lista*/
        ArrayList lista = new ArrayList();
        /*Laco de repeticao que inicia no ano de 2000 e finaliza em 2051*/
        for (int i = 2000; i < 2051; i++) {
            /*Atribui o valor da Variavel i para lista */
            lista.add(i);
        }
        /* Seta a lista do Objeto de modelo do Jspinner referente a os anos */
        model.setList(lista);
        /*retorna o modelo criado */
        return model;
    }
    /**
     * Metodo que seta os componente da tela com os valores dos dias mes e ano 
     */
    public void PreencherDias() {
        /*Verifica se o ano atual e bisexto ou nao */
        boolean anoBisexto = AnoBisexto();
        
        
        /**
         * Aqui atribuimos todos as Label da tela para a lista
         * Essa parte do codigo precisa melhorar , uma forma melhor de fazer isso
         * seria criar um metodo que cria todos as label ja colocando na tela e preenchendo na lista utilizando um laco de repeticao
         * a tela foi feita antes , por esse motivo adicionamos manualmente 
        */
        ListaLb.add(d1);
        ListaLb.add(d2);
        ListaLb.add(d3);
        ListaLb.add(d4);
        ListaLb.add(d5);
        ListaLb.add(d6);
        ListaLb.add(d7);
        ListaLb.add(d8);
        ListaLb.add(d9);
        ListaLb.add(d10);
        ListaLb.add(d11);
        ListaLb.add(d12);
        ListaLb.add(d13);
        ListaLb.add(d14);
        ListaLb.add(d15);
        ListaLb.add(d16);
        ListaLb.add(d17);
        ListaLb.add(d18);
        ListaLb.add(d19);
        ListaLb.add(d20);
        ListaLb.add(d21);
        ListaLb.add(d22);
        ListaLb.add(d23);
        ListaLb.add(d24);
        ListaLb.add(d25);
        ListaLb.add(d26);
        ListaLb.add(d27);
        ListaLb.add(d28);
        ListaLb.add(d29);
        ListaLb.add(d30);
        ListaLb.add(d31);
        ListaLb.add(d32);
        ListaLb.add(d33);
        ListaLb.add(d34);
        ListaLb.add(d35);
        ListaLb.add(d36);
        ListaLb.add(d37);
        ListaLb.add(d38);
        ListaLb.add(d39);
        ListaLb.add(d40);
        ListaLb.add(d41);
        ListaLb.add(d42);
        /*Nesse laco estamos inicializando todas as Labels como vazio */
        for (int i = 0; i < 42; i++) {
            ListaLb.get(i).setText("");
        }
        /* Variavel local recebe o valor qual dia semana comeca o mes/ano da entrada*/ 
        int diadasemana = DiaDaSemana((int) spAno.getValue(), Mes, 0);
        /*Declaracao do iterador*/
        int j = 1;
        /**
         * Laco que verifica qual mes que a tela se encontra e preenche os dias equivalente a o mes correspondente 
         */
        switch (Mes) {
            case 0:
                /* Laco de repeticao que iniciado com o valor do dia da semana e vai ate o total de quantidade de dias do mes */
                for (int i = diadasemana; i < janeiro + diadasemana; i++) {
                    /*Setar o valor da labels comecando pelo primeiro dia da semana correspondente ao mes/ano */
                    ListaLb.get(i).setText(String.valueOf(j));
                    /*Variavel recebe mais um*/
                    j++;
                }
                break;
            case 1:
                if (anoBisexto) {
                    for (int i = diadasemana; i < fevereiro + diadasemana; i++) {
                        ListaLb.get(i).setText(String.valueOf(j));
                        j++;
                    }
                } else {
                    for (int i = diadasemana; i < fevereiro - 1 + diadasemana; i++) {
                        ListaLb.get(i).setText(String.valueOf(j));
                        j++;
                    }
                }
                break;
            case 2:
                for (int i = diadasemana; i < marco + diadasemana; i++) {
                    ListaLb.get(i).setText(String.valueOf(j));
                    j++;
                }
                break;
            case 3:
                for (int i = diadasemana; i < abril + diadasemana; i++) {
                    ListaLb.get(i).setText(String.valueOf(j));
                    j++;
                }
                break;
            case 4:
                for (int i = diadasemana; i < maio + diadasemana; i++) {
                    ListaLb.get(i).setText(String.valueOf(j));
                    j++;
                }
                break;
            case 5:
                for (int i = diadasemana; i < junho + diadasemana; i++) {
                    ListaLb.get(i).setText(String.valueOf(j));
                    j++;
                }
                break;
            case 6:
                for (int i = diadasemana; i < julho + diadasemana; i++) {
                    ListaLb.get(i).setText(String.valueOf(j));
                    j++;
                }
                break;
            case 7:
                for (int i = diadasemana; i < agosto + diadasemana; i++) {
                    ListaLb.get(i).setText(String.valueOf(j));
                    j++;
                }
                break;
            case 8:
                for (int i = diadasemana; i < setembro + diadasemana; i++) {
                    ListaLb.get(i).setText(String.valueOf(j));
                    j++;
                }
                break;
            case 9:
                for (int i = diadasemana; i < outubro + diadasemana; i++) {
                    ListaLb.get(i).setText(String.valueOf(j));
                    j++;
                }
                break;
            case 10:
                for (int i = diadasemana; i < novembro + diadasemana; i++) {
                    ListaLb.get(i).setText(String.valueOf(j));
                    j++;
                }
                break;
            case 11:
                for (int i = diadasemana; i < dezembro + diadasemana; i++) {
                    ListaLb.get(i).setText(String.valueOf(j));
                    j++;
                }
        }
        

    }
    /**
     * Metodo que verifica se o ano e bisexto 
     * @return retorna verdadeiro caso o ano seja bisexto , retorna falso caso nao seja bisexto
     */
    public boolean AnoBisexto() {
        /*Variavel inteiro recebe o valor do Objeto Jspinner referente ao ano da tela*/ 
        Integer ano = (Integer) spAno.getValue();
        
        Integer resp = (ano + 4) % 4;

        if (ano % 4 == 0) {
            //e ano Bisexto
            return true;
        } else {
            // nao e ano bisexto
            return false;
        }

    }
    
    
    
    /**
     * Metodo que verifica qual dia da semana comeca referente ao mes e ano da tela
     * @param ano Valor do Ano da tela
     * @param mes Valor do mes da tela
     * @param dia Valor do dia da tela
     * @return Retorna qual dia da semana comeca referente a data de entrada 
     */
    public int DiaDaSemana(int ano, int mes, int dia) {
        /*Seta com os parametros de entrada o Calendar */
        data.set(ano, mes, dia);
        /*Variavel de inteiro que vai receber o valor referente ao dia da semana que o mes/ano comeca*/
        int diaDaSemana = 0;
        /*Variavel de inteiro que recebe os valores dos dias da semana */
        int semana = data.get(Calendar.DAY_OF_WEEK);
        switch (semana) {
            case Calendar.SUNDAY:
                // domingo
                diaDaSemana = 1;
                break;
            case Calendar.MONDAY:
                //segunda
                diaDaSemana = 2;
                break;
            case Calendar.TUESDAY:
                //terca
                diaDaSemana = 3;
                break;
            case Calendar.WEDNESDAY:
                //quarta
                diaDaSemana = 4;
                break;
            case Calendar.THURSDAY:
                //quinta
                diaDaSemana = 5;
                break;
            case Calendar.FRIDAY:
                //sexta
                diaDaSemana = 6;
                break;
            case Calendar.SATURDAY:
                //sabado
                diaDaSemana = 7;
                break;
            default:
                break;
        }
        
        return diaDaSemana;

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLeft;
    private javax.swing.JButton btRight;
    private javax.swing.JLabel d1;
    private javax.swing.JLabel d10;
    private javax.swing.JLabel d11;
    private javax.swing.JLabel d12;
    private javax.swing.JLabel d13;
    private javax.swing.JLabel d14;
    private javax.swing.JLabel d15;
    private javax.swing.JLabel d16;
    private javax.swing.JLabel d17;
    private javax.swing.JLabel d18;
    private javax.swing.JLabel d19;
    private javax.swing.JLabel d2;
    private javax.swing.JLabel d20;
    private javax.swing.JLabel d21;
    private javax.swing.JLabel d22;
    private javax.swing.JLabel d23;
    private javax.swing.JLabel d24;
    private javax.swing.JLabel d25;
    private javax.swing.JLabel d26;
    private javax.swing.JLabel d27;
    private javax.swing.JLabel d28;
    private javax.swing.JLabel d29;
    private javax.swing.JLabel d3;
    private javax.swing.JLabel d30;
    private javax.swing.JLabel d31;
    private javax.swing.JLabel d32;
    private javax.swing.JLabel d33;
    private javax.swing.JLabel d34;
    private javax.swing.JLabel d35;
    private javax.swing.JLabel d36;
    private javax.swing.JLabel d37;
    private javax.swing.JLabel d38;
    private javax.swing.JLabel d39;
    private javax.swing.JLabel d4;
    private javax.swing.JLabel d40;
    private javax.swing.JLabel d41;
    private javax.swing.JLabel d42;
    private javax.swing.JLabel d5;
    private javax.swing.JLabel d6;
    private javax.swing.JLabel d7;
    private javax.swing.JLabel d8;
    private javax.swing.JLabel d9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbDom;
    private javax.swing.JLabel lbMes;
    private javax.swing.JLabel lbQua;
    private javax.swing.JLabel lbQui;
    private javax.swing.JLabel lbSab;
    private javax.swing.JLabel lbSeg;
    private javax.swing.JLabel lbSex;
    private javax.swing.JLabel lbTer;
    private javax.swing.JPanel pnCalendario;
    private javax.swing.JSpinner spAno;
    // End of variables declaration//GEN-END:variables
}
