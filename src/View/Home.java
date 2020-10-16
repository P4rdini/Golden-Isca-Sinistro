/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ClienteDAO;
import Model.Agente;
import Model.Cliente;
import Model.Isca;
import Model.Sinistro;
import Model.Usuario;
import Util.Calendario;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author rafa_
 */
public class Home extends javax.swing.JFrame {

    private String Usuario;
    ArrayList<Isca> lista = new ArrayList<Isca>();
    Point point = new Point();

    public Home(String Login) {
        initComponents();
        ckBox.setSelected(true);
        Redimencionamento();
        ClienteDAO dao = new ClienteDAO();

        //   tfData.setFormatterFactory(Util.Mascara.getData());
        Usuario = Login;
        lbLogin.setText("Usuario:" + Login);
        abrirIsca = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao > 150) {
                    abrirIsca.stop();

                } else {
                    pnIsca.setSize(pnIsca.getWidth(), padrao);

                    padrao += 10;
                }
            }
        });
        fecharIsca = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao < 50) {
                    fecharIsca.stop();
                } else {
                    pnIsca.setSize(pnIsca.getWidth(), padrao);

                    padrao -= 10;

                }
            }
        });
        abrirCliente = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao > 150) {
                    abrirCliente.stop();

                } else {
                    pnCliente.setSize(pnCliente.getWidth(), padrao);

                    padrao += 10;
                }
            }
        });
        fecharCliente = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao < 50) {
                    fecharCliente.stop();
                } else {
                    pnCliente.setSize(pnCliente.getWidth(), padrao);

                    padrao -= 10;

                }
            }
        });
        abrirSinistro = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao > 150) {
                    abrirSinistro.stop();

                } else {
                    pnSinistro.setSize(pnSinistro.getWidth(), padrao);

                    padrao += 10;
                }
            }
        });
        fecharSinistro = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao < 50) {
                    fecharSinistro.stop();
                } else {
                    pnSinistro.setSize(pnSinistro.getWidth(), padrao);

                    padrao -= 10;

                }
            }
        });
        abrirUsuario = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao > 150) {
                    abrirUsuario.stop();

                } else {
                    pnConta.setSize(pnConta.getWidth(), padrao);

                    padrao += 10;
                }
            }
        });
        fecharUsuario = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (padrao < 50) {
                    fecharUsuario.stop();
                } else {
                    pnConta.setSize(pnConta.getWidth(), padrao);

                    padrao -= 10;

                }
            }
        });
        pnTitulo.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                point.x = e.getX();
                point.y = e.getY();
            }
        });
        pnTitulo.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();
                setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
            }
        });
        ModeloTabela(String.valueOf(cbFiltro.getSelectedItem()), null);
        MostrarCliente();
    }
    Timer abrirIsca, fecharIsca;
    Timer abrirCliente, fecharCliente;
    Timer abrirSinistro, fecharSinistro;
    Timer abrirUsuario, fecharUsuario;
    Integer padrao = 50;
    boolean ClickIsca = true;
    boolean ClickCliente = true;
    boolean ClickSinistro = true;
    boolean ClickUsuario = true;

    private Home() {

    }

    public void Redimencionamento() {
        ImageIcon imagem = new ImageIcon(getClass().getResource("/Resources/LogoEscudo.png"));
        Image img = imagem.getImage().getScaledInstance(lbLogo.getWidth(), lbLogo.getHeight(), 1);
        lbLogo.setIcon(new ImageIcon(img));

        ImageIcon imagem1 = new ImageIcon(getClass().getResource("/Resources/LogoEscrito.png"));
        Image img1 = imagem1.getImage().getScaledInstance(lbLogoEscrita.getWidth(), lbLogoEscrita.getHeight(), 1);
        lbLogoEscrita.setIcon(new ImageIcon(img1));

    }

    public void MostrarCliente() {
        cbCadastroIscaCliente.removeAllItems();
        cbClienteConsultaAlterar.removeAllItems();
        cbClienteAtivacao.removeAllItems();
        cbClienteSinistro.removeAllItems();
        cbClienteSinistro.addItem("Selecione");
        cbCadastroIscaCliente.addItem("Selecione");
        cbClienteConsultaAlterar.addItem("Selecione");
        cbClienteAtivacao.addItem("Selecione");
        ClienteDAO dao = new ClienteDAO();
        ArrayList<String> nomes = dao.nomeCliente();
        for (int i = 0; i < nomes.size(); i++) {
            cbCadastroIscaCliente.addItem(nomes.get(i));
            cbClienteConsultaAlterar.addItem(nomes.get(i));
            cbClienteAtivacao.addItem(nomes.get(i));
            cbClienteSinistro.addItem(nomes.get(i));
        }
    }
    public void ModeloTabela(String str,String conteudo){
        if(str.equals("Todos")){
            Tabela.setModel(Isca.getTableModel());
            
        }
        if(str.equals("Expirado")){
            Tabela.setModel(Isca.getTableIscaCancelar());
            
        }
        if(str.equals("Todos Ativos")){
            Tabela.setModel(Isca.getTableModelTodosAtivos());
        }
        if(str.equals("Data")){
            Tabela.setModel(Isca.getTableModelPesquisa("dataAtivacao", conteudo));
        }
        if(str.equals("Cliente")){
            Tabela.setModel(Isca.getTableModelPesquisa("cliente", conteudo));
        }
        if(str.equals("ID")){
            Tabela.setModel(Isca.getTableModelPesquisa("id", conteudo));
        }
        ((DefaultTableCellRenderer) Tabela.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            for(int i=0;i<Tabela.getColumnCount();i++){
                Tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
            }
            Tabela.setAutoCreateRowSorter(true);
            Tabela.getColumnModel().getColumn(2).setPreferredWidth(145);
            Tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
            Tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
            Tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
//            Tabela.getColumnModel().getColumn(6).setPreferredWidth(90);
    }
    public void LimparCadastroIsca() {
        taICCID.setText("");
        taID.setText("");
        cbOperadora.setSelectedIndex(0);
        cbCadastroIscaCliente.setSelectedIndex(0);
        cbTipo.setSelectedIndex(0);
    }

    public void pegarValores() {
        int x = taNumeroIsca.getLineCount();
        ArrayList<Isca> aaa = new ArrayList<Isca>();
        String str1 = tfCalendario.getText();
        int resp;
        /*  for (int i=0;i<str1.length();i++){
         if(str1.charAt(i) == '/'){
                
         }else{
         resp = str1.charAt(i);
         }
         }*/

        Isca consulta = new Isca();
        ArrayList<Integer> naoCadastrados = new ArrayList<Integer>();
        if (tfCalendario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha Todos os campos");
        } else {
            try {

                String str[] = taNumeroIsca.getText().split("\n");

                for (int h = 0; h <= taNumeroIsca.getLineCount() - 1; h++) {
                    if (consulta.PesquisarIsca(Integer.valueOf(str[h]))) {

                        Isca bbb = new Isca();
                        bbb.setID(Integer.valueOf(str[h]));
                        // bbb.setData(data);
                        if(cbClienteAtivacao.getSelectedIndex() != 0){
                            bbb.setCliente((String) cbClienteAtivacao.getSelectedItem());
                        }
                        bbb.setDataAtivacao(tfCalendario.getText());
                        bbb.setStatus(true);
                        aaa.add(bbb);

                    } else {
                        naoCadastrados.add(Integer.valueOf(str[h]));
                    }

                }
                if (!naoCadastrados.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "as seguintes isca nao possuem cadastros" + naoCadastrados.toString());
                }
                //  if (aaa.size() !=  0 ){
                Isca isca = new Isca(aaa);
                limpar();
                /*   }else{
                 lbMsg.setText("essas isca ja possuem cadastro"+aaa.toString());
                 lbMsg.setBackground(Color.red);
                 lbMsg.setForeground(Color.white);
                 System.out.println("essas isca ja possuem cadastro"+aaa.toString());
                 }*/
                JOptionPane.showMessageDialog(null, "Ativado com sucesso");
                naoCadastrados = null;

            } catch (NumberFormatException e) {
                System.out.println(e.getStackTrace() + "        " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Campos numero isca contem letra");

            }
            
        }
        
    }

    public void limpar() {
        taNumeroIsca.setText("");
        tfCalendario.setText("");
        cbClienteAtivacao.setSelectedIndex(0);

    }

    public void LimparSinistro() {
        cbClienteSinistro.setSelectedIndex(0);
        cbTipoAcionamento.setSelectedIndex(0);
        cbTipoOcorrencia.setSelectedIndex(0);
        tfInformante.setText("");
        tfContato.setText("");
        tfHoraOcorrencia.setText("");
        tfHoraAcionamento.setText("");
        tfHoraTermino.setText("");
        tfNomeAgente.setText("");
        tfPlacaAgente.setText("");
        tfHoraChegadaAgente.setText("");
        tfPlaca.setText("");
        tfCarreta.setText("");
        tfModelo.setText("");
        tfCor.setText("");
        tfValorCarga.setText("");
        tfCoordenadas.setText("");
        tfCidade.setText("");
        tfNome.setText("");
        tfCPF.setText("");
        tfContatoCondutor.setText("");
        taDescricao.setText("");
        tfIsca.setText("");
        tfVarredura.setText("");
        tfReside.setText("");
    }

    public void LimparCadastroCliente() {
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

        pnPrincipal = new javax.swing.JPanel();
        pnInformacoes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        pnHome = new javax.swing.JPanel();
        lbIconHome4 = new javax.swing.JLabel();
        lbHome4 = new javax.swing.JLabel();
        btHome = new javax.swing.JButton();
        pnIsca = new javax.swing.JPanel();
        lbIconHome1 = new javax.swing.JLabel();
        lbHome1 = new javax.swing.JLabel();
        btIsca = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btAtivarIsca = new javax.swing.JButton();
        pnCliente = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lbIconHome7 = new javax.swing.JLabel();
        lbHome7 = new javax.swing.JLabel();
        btCliente = new javax.swing.JButton();
        pnSinistro = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbIconHome3 = new javax.swing.JLabel();
        lbHome3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btSinistro = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        pnConta = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lbIconHome8 = new javax.swing.JLabel();
        lbHome8 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btConta = new javax.swing.JButton();
        lbLogo = new javax.swing.JLabel();
        lbLogoEscrita = new javax.swing.JLabel();
        pnConteudo = new javax.swing.JPanel();
        pnConsulta = new javax.swing.JPanel();
        pnPrincipal2 = new javax.swing.JPanel();
        pnTabela = new javax.swing.JPanel();
        cbFiltro = new javax.swing.JComboBox<>();
        btPesquisar = new javax.swing.JButton();
        tfPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnConsultaAlterar = new javax.swing.JPanel();
        pnPrincipalAlterar = new javax.swing.JPanel();
        lbIDConsultaAlterar = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        tfICCIDConsultaAlterar = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cbStatusConsultaAlterar = new javax.swing.JComboBox<>();
        pnConsultaAlterarCalendario = new javax.swing.JPanel();
        tfConsultaAlterarCalendario = new javax.swing.JTextField();
        btConsultaAlterarCalendario = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        btSalvarConsultaAlterar = new javax.swing.JButton();
        cbOperadoraConsultaAlterar = new javax.swing.JComboBox<>();
        cbTipoConsultaAlterar = new javax.swing.JComboBox<>();
        cbClienteConsultaAlterar = new javax.swing.JComboBox<>();
        btVoltarConsultaAlterar = new javax.swing.JButton();
        pnCadastroSinistro = new javax.swing.JPanel();
        pnOcorrencia = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbClienteSinistro = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbTipoOcorrencia = new javax.swing.JComboBox<>();
        pnVeiculo = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        tfPlaca = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfCarreta = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfModelo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tfCor = new javax.swing.JTextField();
        tfValorCarga = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tfCoordenadas = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        tfIsca = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfInformante = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfHoraOcorrencia = new javax.swing.JTextField();
        tfContato = new javax.swing.JTextField();
        btSalvarSinistro = new javax.swing.JButton();
        btLimparSinistro = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        pnCondutor = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tfCPF = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tfContatoCondutor = new javax.swing.JTextField();
        pnAcionamento = new javax.swing.JPanel();
        tfHoraTermino = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfHoraChegadaAgente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfHoraAcionamento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfPlacaAgente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfNomeAgente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbTipoAcionamento = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        tfTotalKM = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        tfVarredura = new javax.swing.JTextField();
        lbReside = new javax.swing.JLabel();
        tfReside = new javax.swing.JTextField();
        pnCadastroIsca = new javax.swing.JPanel();
        pnPrincipalCadastroIsca = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        taID = new javax.swing.JTextArea();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        taICCID = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        cbOperadora = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        cbCadastroIscaCliente = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        ckBox = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        pnAtivacao = new javax.swing.JPanel();
        pnPrincipalAtivacao = new javax.swing.JPanel();
        lbNomeIsca = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        btAplicar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taNumeroIsca = new javax.swing.JTextArea();
        lbMsg = new javax.swing.JLabel();
        pnCalendario = new javax.swing.JPanel();
        tfCalendario = new javax.swing.JTextField();
        btCalendario = new javax.swing.JButton();
        cbClienteAtivacao = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        pnCadastroCliente = new javax.swing.JPanel();
        pnPrincipalCadastroCliente = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        cbCadastroClienteStatus = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        cbCadastroClientePessoa = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        tfCadastroClienteCpfCnpj = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        tfCadastroClienteNome = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        tfCadastroClienteEmail = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        tfCadastroClienteCep = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        tfCadastroClienteEndereco = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        cbCadastroClienteUF = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        tfCadastroClienteCidade = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        cbCadastroClienteInadimplente = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        tfCadastroClienteBairro = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        tfCadastroClienteComplemento = new javax.swing.JTextField();
        btCadastroClienteSalvar = new javax.swing.JButton();
        btCadastroClienteLimpar = new javax.swing.JButton();
        pnPrincipalMudarSenha = new javax.swing.JPanel();
        pnNovoCadastro = new javax.swing.JPanel();
        tfSenha = new javax.swing.JTextField();
        tfConfirmacao = new javax.swing.JTextField();
        lbConfirmacao = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        btCriar = new javax.swing.JButton();
        lbTitulo = new javax.swing.JLabel();
        lbMostrarUsuario = new javax.swing.JLabel();
        pnTelaConsultaSinistro = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbConsultarSinistro = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        pnTitulo = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btX = new javax.swing.JButton();
        lbLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnPrincipal.setMaximumSize(new java.awt.Dimension(0, 0));
        pnPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnInformacoes.setBackground(new java.awt.Color(110, 89, 222));
        pnInformacoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnInformacoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Isca para finalizar: 0");
        pnInformacoes.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 34, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Clientes Cadastrados:0 ");
        pnInformacoes.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 34, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Sinistros:0");
        pnInformacoes.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 34, -1, -1));

        pnPrincipal.add(pnInformacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 58, 860, 90));

        pnMenu.setBackground(new java.awt.Color(54, 33, 89));
        pnMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnMenu.setToolTipText("");
        pnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        pnMenu.add(pnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 270, 50));

        pnIsca.setBackground(new java.awt.Color(64, 43, 100));
        pnIsca.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnIsca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnIscaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnIscaMouseExited(evt);
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

        btIsca.setBackground(new java.awt.Color(64, 43, 100));
        btIsca.setContentAreaFilled(false);
        btIsca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btIscaMouseEntered(evt);
            }
        });
        btIsca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIscaActionPerformed(evt);
            }
        });
        pnIsca.add(btIsca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, 20));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Cadastrar");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel33MouseEntered(evt);
            }
        });
        pnIsca.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Ativar");
        pnIsca.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        btAtivarIsca.setBackground(new java.awt.Color(64, 43, 100));
        btAtivarIsca.setContentAreaFilled(false);
        btAtivarIsca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAtivarIscaMouseEntered(evt);
            }
        });
        btAtivarIsca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtivarIscaActionPerformed(evt);
            }
        });
        pnIsca.add(btAtivarIsca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, 20));

        pnMenu.add(pnIsca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 270, 50));

        pnCliente.setBackground(new java.awt.Color(85, 65, 118));
        pnCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnClienteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnClienteMouseExited(evt);
            }
        });
        pnCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(85, 65, 118));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(85, 65, 118));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIconHome7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconHome7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cliente.png"))); // NOI18N
        jPanel8.add(lbIconHome7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 74, 54));

        lbHome7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbHome7.setForeground(new java.awt.Color(204, 204, 204));
        lbHome7.setText("Cliente");
        jPanel8.add(lbHome7, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 12, -1, 32));

        btCliente.setBackground(new java.awt.Color(85, 65, 118));
        btCliente.setContentAreaFilled(false);
        btCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClienteActionPerformed(evt);
            }
        });
        jPanel8.add(btCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 30));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnCliente.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnMenu.add(pnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 270, 50));

        pnSinistro.setBackground(new java.awt.Color(64, 43, 100));
        pnSinistro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnSinistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnSinistroMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnSinistroMouseExited(evt);
            }
        });
        pnSinistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(64, 43, 100));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(64, 43, 100));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIconHome3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconHome3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/sinistro.png"))); // NOI18N
        jPanel4.add(lbIconHome3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 74, 54));

        lbHome3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbHome3.setForeground(new java.awt.Color(204, 204, 204));
        lbHome3.setText("Sinistro");
        jPanel4.add(lbHome3, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 12, -1, 32));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnSinistro.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setText("Cadastrar");
        pnSinistro.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        btSinistro.setBackground(new java.awt.Color(64, 43, 100));
        btSinistro.setContentAreaFilled(false);
        btSinistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSinistroMouseEntered(evt);
            }
        });
        btSinistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSinistroActionPerformed(evt);
            }
        });
        pnSinistro.add(btSinistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 150, 30));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(202, 202, 202));
        jLabel57.setText("Relatorio");
        pnSinistro.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jButton7.setBackground(new java.awt.Color(85, 65, 118));
        jButton7.setContentAreaFilled(false);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        pnSinistro.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 110, 30));

        pnMenu.add(pnSinistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 270, 50));

        pnConta.setBackground(new java.awt.Color(85, 65, 118));
        pnConta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnContaMouseClicked(evt);
            }
        });
        pnConta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(64, 43, 100));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(85, 65, 118));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIconHome8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconHome8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/conta.png"))); // NOI18N
        jPanel10.add(lbIconHome8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 74, 54));

        lbHome8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbHome8.setForeground(new java.awt.Color(204, 204, 204));
        lbHome8.setText("Conta");
        jPanel10.add(lbHome8, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 12, -1, 32));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnConta.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Mudar Senha");
        pnConta.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btConta.setBackground(new java.awt.Color(85, 65, 118));
        btConta.setContentAreaFilled(false);
        btConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btContaActionPerformed(evt);
            }
        });
        pnConta.add(btConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 20));

        pnMenu.add(pnConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 270, 50));

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LogoEscudo.png"))); // NOI18N
        pnMenu.add(lbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 190, 110));

        lbLogoEscrita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LogoEscrito.png"))); // NOI18N
        pnMenu.add(lbLogoEscrita, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 270, 40));

        pnPrincipal.add(pnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pnConteudo.setLayout(new java.awt.CardLayout());

        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Expirado", "Todos Ativos", "Todos", "ID", "Cliente", "Data" }));
        cbFiltro.setToolTipText("");
        cbFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFiltroItemStateChanged(evt);
            }
        });

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabela.setFocusable(false);
        Tabela.setIntercellSpacing(new java.awt.Dimension(0, 0));
        Tabela.setRowHeight(25);
        Tabela.setSelectionBackground(new java.awt.Color(232, 57, 95));
        Tabela.setShowVerticalLines(false);
        Tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Tabela);

        jLabel27.setText("Filtro");

        jButton3.setText("Copiar ICCID");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnTabelaLayout = new javax.swing.GroupLayout(pnTabela);
        pnTabela.setLayout(pnTabelaLayout);
        pnTabelaLayout.setHorizontalGroup(
            pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabelaLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel27)
                .addGap(204, 204, 204)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTabelaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnTabelaLayout.createSequentialGroup()
                        .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfPesquisa)
                        .addGap(18, 18, 18)
                        .addComponent(btPesquisar)))
                .addContainerGap())
        );
        pnTabelaLayout.setVerticalGroup(
            pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabelaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        jButton2.setText("Desativar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Desativar Todos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPrincipal2Layout = new javax.swing.GroupLayout(pnPrincipal2);
        pnPrincipal2.setLayout(pnPrincipal2Layout);
        pnPrincipal2Layout.setHorizontalGroup(
            pnPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipal2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAlterar)
                .addGap(180, 180, 180)
                .addComponent(jButton4)
                .addGap(65, 65, 65)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btExcluir)
                .addGap(124, 124, 124))
            .addGroup(pnPrincipal2Layout.createSequentialGroup()
                .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 114, Short.MAX_VALUE))
        );
        pnPrincipal2Layout.setVerticalGroup(
            pnPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipal2Layout.createSequentialGroup()
                .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btAlterar)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnConsultaLayout = new javax.swing.GroupLayout(pnConsulta);
        pnConsulta.setLayout(pnConsultaLayout);
        pnConsultaLayout.setHorizontalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnPrincipal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnConsultaLayout.setVerticalGroup(
            pnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnPrincipal2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );

        pnConteudo.add(pnConsulta, "Consulta");

        pnPrincipalAlterar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIDConsultaAlterar.setText("ID:  765002");
        pnPrincipalAlterar.add(lbIDConsultaAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, 19));

        jLabel28.setText("ICCID:");
        pnPrincipalAlterar.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 50, 19));
        pnPrincipalAlterar.add(tfICCIDConsultaAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 130, -1));

        jLabel29.setText("Cliente:");
        pnPrincipalAlterar.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel30.setText("Operadora:");
        pnPrincipalAlterar.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 60, -1));

        jLabel31.setText("Tipo:");
        pnPrincipalAlterar.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel32.setText("Status:");
        pnPrincipalAlterar.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        cbStatusConsultaAlterar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));
        pnPrincipalAlterar.add(cbStatusConsultaAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 90, -1));

        pnConsultaAlterarCalendario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfConsultaAlterarCalendario.setEditable(false);
        pnConsultaAlterarCalendario.add(tfConsultaAlterarCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, -1));

        btConsultaAlterarCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_calendar_20px.png"))); // NOI18N
        btConsultaAlterarCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConsultaAlterarCalendarioMouseClicked(evt);
            }
        });
        btConsultaAlterarCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaAlterarCalendarioActionPerformed(evt);
            }
        });
        pnConsultaAlterarCalendario.add(btConsultaAlterarCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 30, 30));

        pnPrincipalAlterar.add(pnConsultaAlterarCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        jLabel40.setText("Data De Ativação");
        pnPrincipalAlterar.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 110, -1));

        btSalvarConsultaAlterar.setText("Salvar");
        btSalvarConsultaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarConsultaAlterarActionPerformed(evt);
            }
        });
        pnPrincipalAlterar.add(btSalvarConsultaAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 73, -1));

        cbOperadoraConsultaAlterar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIERRA", "ESEYE", "KORE", "VIVO" }));
        pnPrincipalAlterar.add(cbOperadoraConsultaAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        cbTipoConsultaAlterar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Retornavel", "Descartavel" }));
        pnPrincipalAlterar.add(cbTipoConsultaAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        cbClienteConsultaAlterar.setMaximumSize(new java.awt.Dimension(80, 24));
        pnPrincipalAlterar.add(cbClienteConsultaAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 100, -1));

        btVoltarConsultaAlterar.setText("Voltar");
        btVoltarConsultaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarConsultaAlterarActionPerformed(evt);
            }
        });
        pnPrincipalAlterar.add(btVoltarConsultaAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        javax.swing.GroupLayout pnConsultaAlterarLayout = new javax.swing.GroupLayout(pnConsultaAlterar);
        pnConsultaAlterar.setLayout(pnConsultaAlterarLayout);
        pnConsultaAlterarLayout.setHorizontalGroup(
            pnConsultaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnConsultaAlterarLayout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(pnPrincipalAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        pnConsultaAlterarLayout.setVerticalGroup(
            pnConsultaAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConsultaAlterarLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(pnPrincipalAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        pnConteudo.add(pnConsultaAlterar, "ConsultaAlterar");

        pnOcorrencia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Ocorrencia", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        pnOcorrencia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Cliente");
        pnOcorrencia.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        cbClienteSinistro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Cliente1", "Cliente2", "Cliente3" }));
        pnOcorrencia.add(cbClienteSinistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, -1));

        jLabel5.setText("Tipo de Ocorrencia ");
        pnOcorrencia.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        cbTipoOcorrencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Suspeita de Sinistro", "Sinistro Confirmado", "Preservacao" }));
        pnOcorrencia.add(cbTipoOcorrencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 130, -1));

        pnVeiculo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Veiculo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnVeiculo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("Placa :");
        pnVeiculo.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        pnVeiculo.add(tfPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 80, -1));

        jLabel14.setText("Carreta:");
        pnVeiculo.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
        pnVeiculo.add(tfCarreta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 80, -1));

        jLabel16.setText("Modelo:");
        pnVeiculo.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));
        pnVeiculo.add(tfModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 136, -1));

        jLabel18.setText("Cor:");
        pnVeiculo.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));
        pnVeiculo.add(tfCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 100, -1));
        pnVeiculo.add(tfValorCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 130, -1));

        jLabel20.setText("Valor da carga:");
        pnVeiculo.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));
        pnVeiculo.add(tfCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 136, -1));

        jLabel24.setText("Cidade:");
        pnVeiculo.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));
        pnVeiculo.add(tfCoordenadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 130, -1));

        jLabel25.setText("Coordenadas:");
        pnVeiculo.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));

        jLabel54.setText("Isca:");
        pnVeiculo.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));
        pnVeiculo.add(tfIsca, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 100, -1));

        pnOcorrencia.add(pnVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 820, 90));

        jLabel9.setText("Informante:");
        pnOcorrencia.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        tfInformante.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pnOcorrencia.add(tfInformante, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 74, 24));

        jLabel15.setText("Contato");
        pnOcorrencia.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, -1, -1));

        jLabel17.setText("Hora da ocorrencia");
        pnOcorrencia.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        tfHoraOcorrencia.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pnOcorrencia.add(tfHoraOcorrencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 74, 23));
        pnOcorrencia.add(tfContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 100, 23));

        btSalvarSinistro.setText("Salvar");
        btSalvarSinistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarSinistroActionPerformed(evt);
            }
        });
        pnOcorrencia.add(btSalvarSinistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, -1, -1));

        btLimparSinistro.setText("Limpar");
        btLimparSinistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparSinistroActionPerformed(evt);
            }
        });
        pnOcorrencia.add(btLimparSinistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, -1, -1));

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        taDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descricao", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jScrollPane3.setViewportView(taDescricao);

        pnOcorrencia.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 590, 150));

        pnCondutor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Condutor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel19.setText("Nome:");

        jLabel21.setText("Cpf:");

        jLabel22.setText("Contato:");

        javax.swing.GroupLayout pnCondutorLayout = new javax.swing.GroupLayout(pnCondutor);
        pnCondutor.setLayout(pnCondutorLayout);
        pnCondutorLayout.setHorizontalGroup(
            pnCondutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCondutorLayout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(19, 19, 19)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfContatoCondutor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );
        pnCondutorLayout.setVerticalGroup(
            pnCondutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCondutorLayout.createSequentialGroup()
                .addGroup(pnCondutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCondutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(tfContatoCondutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCondutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnOcorrencia.add(pnCondutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 810, -1));

        pnAcionamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Acionamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnAcionamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnAcionamento.add(tfHoraTermino, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 116, -1));

        jLabel12.setText("Hora do termino");
        pnAcionamento.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        tfHoraChegadaAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHoraChegadaAgenteActionPerformed(evt);
            }
        });
        pnAcionamento.add(tfHoraChegadaAgente, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 80, -1));

        jLabel11.setText("Hora de chegada:");
        pnAcionamento.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));
        pnAcionamento.add(tfHoraAcionamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 80, -1));

        jLabel10.setText("Hora Inicio:");
        pnAcionamento.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        tfPlacaAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPlacaAgenteActionPerformed(evt);
            }
        });
        pnAcionamento.add(tfPlacaAgente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 90, -1));

        jLabel8.setText("Placa:");
        pnAcionamento.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));
        pnAcionamento.add(tfNomeAgente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 90, -1));

        jLabel7.setText("Agente:");
        pnAcionamento.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        cbTipoAcionamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Antenista", "Pronta-Resposta", "Escolta" }));
        cbTipoAcionamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoAcionamentoItemStateChanged(evt);
            }
        });
        pnAcionamento.add(cbTipoAcionamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 120, -1));

        jLabel6.setText("Tipo:");
        pnAcionamento.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel55.setText("Total Km:");
        pnAcionamento.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));
        pnAcionamento.add(tfTotalKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 90, -1));

        jLabel56.setText("Varredura:");
        pnAcionamento.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));
        pnAcionamento.add(tfVarredura, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 210, -1));

        lbReside.setText("Reside:");
        pnAcionamento.add(lbReside, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));
        pnAcionamento.add(tfReside, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 110, -1));

        pnOcorrencia.add(pnAcionamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 810, 140));

        javax.swing.GroupLayout pnCadastroSinistroLayout = new javax.swing.GroupLayout(pnCadastroSinistro);
        pnCadastroSinistro.setLayout(pnCadastroSinistroLayout);
        pnCadastroSinistroLayout.setHorizontalGroup(
            pnCadastroSinistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroSinistroLayout.createSequentialGroup()
                .addComponent(pnOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        pnCadastroSinistroLayout.setVerticalGroup(
            pnCadastroSinistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCadastroSinistroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnConteudo.add(pnCadastroSinistro, "Sinistro");

        jLabel35.setText("ID");

        taID.setColumns(20);
        taID.setRows(5);
        jScrollPane6.setViewportView(taID);

        jLabel36.setText("ICCID");

        taICCID.setColumns(20);
        taICCID.setRows(5);
        jScrollPane7.setViewportView(taICCID);

        jLabel37.setText("Operadora");

        cbOperadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "SIERRA", "ESEYE", "KORE", "VIVO" }));

        jLabel38.setText("Cliente");

        cbCadastroIscaCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbCadastroIscaCliente.setMaximumSize(new java.awt.Dimension(80, 24));

        jLabel39.setText("Tipo");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Retornavel", "Descartavel" }));

        jButton6.setText("Salvar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        ckBox.setText("Numeracao ID completo");

        jButton5.setText("Copiar ID's");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPrincipalCadastroIscaLayout = new javax.swing.GroupLayout(pnPrincipalCadastroIsca);
        pnPrincipalCadastroIsca.setLayout(pnPrincipalCadastroIscaLayout);
        pnPrincipalCadastroIscaLayout.setHorizontalGroup(
            pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                .addGroup(pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckBox)
                            .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                                .addGroup(pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                                        .addGap(105, 105, 105)
                                        .addComponent(jLabel36))
                                    .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(jLabel37))
                                            .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(jLabel38))
                                            .addComponent(cbOperadora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbCadastroIscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel39))
                                    .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jButton6))))))
                    .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5)))
                .addContainerGap(346, Short.MAX_VALUE))
        );
        pnPrincipalCadastroIscaLayout.setVerticalGroup(
            pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(ckBox)
                .addGap(1, 1, 1)
                .addGroup(pnPrincipalCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnPrincipalCadastroIscaLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel37)
                        .addGap(6, 6, 6)
                        .addComponent(cbOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCadastroIscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel39)
                        .addGap(6, 6, 6)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnCadastroIscaLayout = new javax.swing.GroupLayout(pnCadastroIsca);
        pnCadastroIsca.setLayout(pnCadastroIscaLayout);
        pnCadastroIscaLayout.setHorizontalGroup(
            pnCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrincipalCadastroIsca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnCadastroIscaLayout.setVerticalGroup(
            pnCadastroIscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrincipalCadastroIsca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnConteudo.add(pnCadastroIsca, "CadastroIsca");

        pnPrincipalAtivacao.setForeground(new java.awt.Color(51, 51, 0));
        pnPrincipalAtivacao.setPreferredSize(new java.awt.Dimension(500, 500));

        lbNomeIsca.setBackground(new java.awt.Color(255, 255, 0));
        lbNomeIsca.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbNomeIsca.setText("Numero da isca ");

        lbData.setBackground(new java.awt.Color(255, 255, 255));
        lbData.setText("Data");

        btAplicar.setText("Aplicar");
        btAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAplicarActionPerformed(evt);
            }
        });

        taNumeroIsca.setColumns(20);
        taNumeroIsca.setRows(5);
        taNumeroIsca.setBorder(null);
        jScrollPane2.setViewportView(taNumeroIsca);

        pnCalendario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfCalendario.setEditable(false);
        pnCalendario.add(tfCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, -1));

        btCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_calendar_20px.png"))); // NOI18N
        btCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCalendarioMouseClicked(evt);
            }
        });
        btCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalendarioActionPerformed(evt);
            }
        });
        pnCalendario.add(btCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 30, 30));

        cbClienteAtivacao.setToolTipText("");
        cbClienteAtivacao.setMaximumSize(new java.awt.Dimension(80, 24));

        jLabel53.setText("Cliente");

        javax.swing.GroupLayout pnPrincipalAtivacaoLayout = new javax.swing.GroupLayout(pnPrincipalAtivacao);
        pnPrincipalAtivacao.setLayout(pnPrincipalAtivacaoLayout);
        pnPrincipalAtivacaoLayout.setHorizontalGroup(
            pnPrincipalAtivacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalAtivacaoLayout.createSequentialGroup()
                .addGroup(pnPrincipalAtivacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPrincipalAtivacaoLayout.createSequentialGroup()
                        .addGroup(pnPrincipalAtivacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPrincipalAtivacaoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnPrincipalAtivacaoLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(lbNomeIsca)))
                        .addGroup(pnPrincipalAtivacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPrincipalAtivacaoLayout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(lbData))
                            .addGroup(pnPrincipalAtivacaoLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(btAplicar))
                            .addGroup(pnPrincipalAtivacaoLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabel53))
                            .addGroup(pnPrincipalAtivacaoLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(pnCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnPrincipalAtivacaoLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(cbClienteAtivacao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnPrincipalAtivacaoLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(lbMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        pnPrincipalAtivacaoLayout.setVerticalGroup(
            pnPrincipalAtivacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalAtivacaoLayout.createSequentialGroup()
                .addGroup(pnPrincipalAtivacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPrincipalAtivacaoLayout.createSequentialGroup()
                        .addComponent(lbMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbClienteAtivacao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAplicar))
                    .addGroup(pnPrincipalAtivacaoLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lbNomeIsca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnAtivacaoLayout = new javax.swing.GroupLayout(pnAtivacao);
        pnAtivacao.setLayout(pnAtivacaoLayout);
        pnAtivacaoLayout.setHorizontalGroup(
            pnAtivacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAtivacaoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(pnPrincipalAtivacao, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
        );
        pnAtivacaoLayout.setVerticalGroup(
            pnAtivacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAtivacaoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(pnPrincipalAtivacao, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pnConteudo.add(pnAtivacao, "AtivarIsca");

        pnPrincipalCadastroCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setText("Status *");
        pnPrincipalCadastroCliente.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        cbCadastroClienteStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Ativo", "Inativo" }));
        pnPrincipalCadastroCliente.add(cbCadastroClienteStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 33, -1, -1));

        jLabel42.setText("Pessoa");
        pnPrincipalCadastroCliente.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 12, -1, -1));

        cbCadastroClientePessoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "J", "F" }));
        pnPrincipalCadastroCliente.add(cbCadastroClientePessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 33, -1, -1));

        jLabel43.setText("CPF/CNPJ * ");
        pnPrincipalCadastroCliente.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 12, -1, -1));
        pnPrincipalCadastroCliente.add(tfCadastroClienteCpfCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 36, 77, -1));

        jLabel44.setText("Nome *");
        pnPrincipalCadastroCliente.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 75, -1, -1));
        pnPrincipalCadastroCliente.add(tfCadastroClienteNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 96, 154, -1));

        jLabel45.setText("E-mail");
        pnPrincipalCadastroCliente.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 75, -1, -1));
        pnPrincipalCadastroCliente.add(tfCadastroClienteEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 96, 190, -1));

        jLabel46.setText("CEP");
        pnPrincipalCadastroCliente.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 151, -1, -1));
        pnPrincipalCadastroCliente.add(tfCadastroClienteCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 175, 102, -1));

        jLabel47.setText("Endereço");
        pnPrincipalCadastroCliente.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 151, -1, -1));
        pnPrincipalCadastroCliente.add(tfCadastroClienteEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 175, 123, -1));

        jLabel48.setText("UF");
        pnPrincipalCadastroCliente.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 151, -1, -1));

        cbCadastroClienteUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
        pnPrincipalCadastroCliente.add(cbCadastroClienteUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 172, -1, -1));

        jLabel49.setText("Cidade");
        pnPrincipalCadastroCliente.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));
        pnPrincipalCadastroCliente.add(tfCadastroClienteCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 98, -1));

        jLabel50.setText("Inadimplente");
        pnPrincipalCadastroCliente.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 12, -1, -1));

        cbCadastroClienteInadimplente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        pnPrincipalCadastroCliente.add(cbCadastroClienteInadimplente, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 33, -1, -1));

        jLabel51.setText("Bairro");
        pnPrincipalCadastroCliente.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 222, -1, -1));
        pnPrincipalCadastroCliente.add(tfCadastroClienteBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 243, 136, -1));

        jLabel52.setText("Complemento");
        pnPrincipalCadastroCliente.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 222, -1, -1));
        pnPrincipalCadastroCliente.add(tfCadastroClienteComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 243, 160, -1));

        btCadastroClienteSalvar.setText("Salvar");
        btCadastroClienteSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroClienteSalvarActionPerformed(evt);
            }
        });
        pnPrincipalCadastroCliente.add(btCadastroClienteSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        btCadastroClienteLimpar.setText("Limpar");
        btCadastroClienteLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroClienteLimparActionPerformed(evt);
            }
        });
        pnPrincipalCadastroCliente.add(btCadastroClienteLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        javax.swing.GroupLayout pnCadastroClienteLayout = new javax.swing.GroupLayout(pnCadastroCliente);
        pnCadastroCliente.setLayout(pnCadastroClienteLayout);
        pnCadastroClienteLayout.setHorizontalGroup(
            pnCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroClienteLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(pnPrincipalCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        pnCadastroClienteLayout.setVerticalGroup(
            pnCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnPrincipalCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        pnConteudo.add(pnCadastroCliente, "CadastroCliente");

        lbConfirmacao.setText("Confirmacao da Senha:");

        lbSenha.setText("Senha:");

        lbUsuario.setText("Usuario:");

        btCriar.setText("Criar");
        btCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCriarActionPerformed(evt);
            }
        });

        lbTitulo.setText("Mudar Senha");

        javax.swing.GroupLayout pnNovoCadastroLayout = new javax.swing.GroupLayout(pnNovoCadastro);
        pnNovoCadastro.setLayout(pnNovoCadastroLayout);
        pnNovoCadastroLayout.setHorizontalGroup(
            pnNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNovoCadastroLayout.createSequentialGroup()
                .addGroup(pnNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnNovoCadastroLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btCriar))
                    .addGroup(pnNovoCadastroLayout.createSequentialGroup()
                        .addGroup(pnNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnNovoCadastroLayout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(lbSenha))
                            .addGroup(pnNovoCadastroLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbConfirmacao)))
                        .addGap(18, 18, 18)
                        .addGroup(pnNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnNovoCadastroLayout.createSequentialGroup()
                                .addComponent(lbUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbMostrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                            .addComponent(tfConfirmacao)
                            .addComponent(tfSenha, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNovoCadastroLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbTitulo)
                .addGap(161, 161, 161))
        );
        pnNovoCadastroLayout.setVerticalGroup(
            pnNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNovoCadastroLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lbTitulo)
                .addGap(18, 18, 18)
                .addGroup(pnNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbUsuario)
                    .addComponent(lbMostrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSenha)
                    .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnNovoCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbConfirmacao)
                    .addComponent(tfConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCriar)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnPrincipalMudarSenhaLayout = new javax.swing.GroupLayout(pnPrincipalMudarSenha);
        pnPrincipalMudarSenha.setLayout(pnPrincipalMudarSenhaLayout);
        pnPrincipalMudarSenhaLayout.setHorizontalGroup(
            pnPrincipalMudarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalMudarSenhaLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(pnNovoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(370, Short.MAX_VALUE))
        );
        pnPrincipalMudarSenhaLayout.setVerticalGroup(
            pnPrincipalMudarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalMudarSenhaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(pnNovoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        pnConteudo.add(pnPrincipalMudarSenha, "Mudar Senha");

        tbConsultarSinistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tbConsultarSinistro);

        jButton8.setText("Gerar Relatorio");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(721, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(462, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(113, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnTelaConsultaSinistroLayout = new javax.swing.GroupLayout(pnTelaConsultaSinistro);
        pnTelaConsultaSinistro.setLayout(pnTelaConsultaSinistroLayout);
        pnTelaConsultaSinistroLayout.setHorizontalGroup(
            pnTelaConsultaSinistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTelaConsultaSinistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTelaConsultaSinistroLayout.setVerticalGroup(
            pnTelaConsultaSinistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTelaConsultaSinistroLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnConteudo.add(pnTelaConsultaSinistro, "consultaSinistro");
        pnTelaConsultaSinistro.getAccessibleContext().setAccessibleName("");

        pnPrincipal.add(pnConteudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 860, 560));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Minimizar.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btX.setBackground(new java.awt.Color(255, 255, 255));
        btX.setForeground(new java.awt.Color(51, 0, 255));
        btX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/x.png"))); // NOI18N
        btX.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btX.setBorderPainted(false);
        btX.setContentAreaFilled(false);
        btX.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btXMouseEntered(evt);
            }
        });
        btX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXActionPerformed(evt);
            }
        });

        lbLogin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout pnTituloLayout = new javax.swing.GroupLayout(pnTitulo);
        pnTitulo.setLayout(pnTituloLayout);
        pnTituloLayout.setHorizontalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 417, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnTituloLayout.setVerticalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addGroup(pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTituloLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnPrincipal.add(pnTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 860, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 694, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btIscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIscaActionPerformed
     //   MostrarCliente();
        CardLayout cards = (CardLayout) pnConteudo.getLayout();

        cards.show(pnConteudo, "CadastroIsca");
        abrirIsca.stop();
        fecharIsca.start();
    }//GEN-LAST:event_btIscaActionPerformed

    private void btSinistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSinistroActionPerformed
     //   MostrarCliente();
        CardLayout card = (CardLayout) pnConteudo.getLayout();
        card.show(pnConteudo, "Sinistro");
    }//GEN-LAST:event_btSinistroActionPerformed

    private void btHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHomeActionPerformed

        CardLayout card = (CardLayout) pnConteudo.getLayout();
        card.show(pnConteudo, "Consulta");
        ModeloTabela(cbFiltro.getSelectedItem().toString(),tfPesquisa.getText());
    }//GEN-LAST:event_btHomeActionPerformed

    private void btXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btXActionPerformed

    private void btClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClienteActionPerformed
        CardLayout card = (CardLayout) pnConteudo.getLayout();
        card.show(pnConteudo, "CadastroCliente");
    }//GEN-LAST:event_btClienteActionPerformed

    private void pnIscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnIscaMouseClicked

        if (ClickIsca) {
            fecharIsca.stop();
            abrirIsca.start();
            ClickIsca = false;
        } else {
            abrirIsca.stop();
            fecharIsca.start();
            ClickIsca = true;
        }
    }//GEN-LAST:event_pnIscaMouseClicked

    private void pnIscaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnIscaMouseExited
        abrirIsca.stop();
        fecharIsca.start();
    }//GEN-LAST:event_pnIscaMouseExited

    private void pnClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnClienteMouseClicked
        if (ClickCliente) {
            fecharCliente.stop();
            abrirCliente.start();
            ClickCliente = false;
        } else {
            abrirCliente.stop();
            fecharCliente.start();
            ClickCliente = true;
        }
    }//GEN-LAST:event_pnClienteMouseClicked

    private void pnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnClienteMouseExited
        abrirCliente.stop();
        fecharCliente.start();
    }//GEN-LAST:event_pnClienteMouseExited

    private void pnSinistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnSinistroMouseClicked
        if (ClickSinistro) {
            fecharSinistro.stop();
            abrirSinistro.start();
            ClickSinistro = false;
        } else {
            abrirSinistro.stop();
            fecharSinistro.start();
            ClickSinistro = true;
        }
    }//GEN-LAST:event_pnSinistroMouseClicked

    private void pnSinistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnSinistroMouseExited
        abrirSinistro.stop();
        fecharSinistro.start();
    }//GEN-LAST:event_pnSinistroMouseExited

    private void pnContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnContaMouseClicked
        if (ClickUsuario) {
            fecharUsuario.stop();
            abrirUsuario.start();
            ClickUsuario = false;
        } else {
            abrirUsuario.stop();
            fecharUsuario.start();
            ClickUsuario = true;
        }
    }//GEN-LAST:event_pnContaMouseClicked

    private void btIscaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btIscaMouseEntered
            fecharIsca.stop();

    }//GEN-LAST:event_btIscaMouseEntered

    private void btAtivarIscaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAtivarIscaMouseEntered
        fecharIsca.stop();
    }//GEN-LAST:event_btAtivarIscaMouseEntered

    private void btAtivarIscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtivarIscaActionPerformed
     //   MostrarCliente();
        CardLayout cards = (CardLayout) pnConteudo.getLayout();

        cards.show(pnConteudo, "AtivarIsca");

        abrirIsca.stop();
        fecharIsca.start();
    }//GEN-LAST:event_btAtivarIscaActionPerformed

    private void jLabel33MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseEntered
        abrirIsca.start();
    }//GEN-LAST:event_jLabel33MouseEntered

    private void btAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAplicarActionPerformed

        pegarValores();

    }//GEN-LAST:event_btAplicarActionPerformed

    private void btCalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCalendarioMouseClicked
        Calendario c = new Calendario(tfCalendario);
        c.setVisible(true);
        c.setLocation(pnCalendario.getX() + 380, pnCalendario.getY() - 60);

    }//GEN-LAST:event_btCalendarioMouseClicked

    private void btCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalendarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCalendarioActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
            String coluna = (String) cbFiltro.getSelectedItem();
        String str = tfPesquisa.getText();
        if (cbFiltro.getSelectedIndex() == 5) {

            /*  for (int i = 0; i <= str.length(); i++) {
             if (str.charAt(i) == '/') {
             resp += str.charAt(i);
             }
             }*/
        //    Tabela.setModel(Isca.getTableModelPesquisa("dataAtivacao", str));
            ModeloTabela("Data",str);
        }
        if (cbFiltro.getSelectedIndex() == 4) {
        //    Tabela.setModel(Isca.getTableModelPesquisa("cliente", str));
            ModeloTabela("Cliente", str);
        }
        if (cbFiltro.getSelectedIndex() == 3) {
      //      Tabela.setModel(Isca.getTableModelPesquisa("id", str));
            ModeloTabela("ID", str);
        }
        if (cbFiltro.getSelectedIndex() == 2) {
            ModeloTabela("Todos",null);
        }
        if (cbFiltro.getSelectedIndex() == 1) {
            ModeloTabela("Todos Ativos",null);
        }
        if (cbFiltro.getSelectedIndex() == 0) {
            ModeloTabela("Expirado",null);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        Object obj = Tabela.getValueAt(Tabela.getSelectedRow(), 1);
        int resp;
        resp = Integer.valueOf(obj.toString());
        Isca isca = new Isca();
        if (isca.ExcluirIsca(resp)) {
            JOptionPane.showMessageDialog(null, "Item foi excluido com sucesso");
            
            ModeloTabela(cbFiltro.getSelectedItem().toString(),tfPesquisa.getText());
        } else {
        ModeloTabela(cbFiltro.getSelectedItem().toString(),tfPesquisa.getText());
            JOptionPane.showMessageDialog(null, "Nao foi possivel excluir este item ");
        }

    }//GEN-LAST:event_btExcluirActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //       Isca isca = new Isca(Integer.valueOf(taID.getText()), Integer.valueOf(taICCID.getText()),String.valueOf(cbCliente.getSelectedItem()), String.valueOf(cbOperadora.getSelectedItem()), String.valueOf(cbTipo.getSelectedItem()));
        boolean limpar = false;
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

                try {
                    if (ckBox.isSelected()) {
                        try {
                            limpar = true;
                            for (int i = 0; i < strID.length; i++) {

                                if (consulta.PesquisarIsca(Integer.valueOf(strID[i].substring(7, 14).trim()))) {
                                    jaCadastrados.add(strID[i].trim());

                                } else {
                                    id.add(strID[i].trim());

                                }
                            }

                            for (int i = 0; i < id.size(); i++) {
                                Isca resp = new Isca(Integer.valueOf(id.get(i).substring(7, 14).trim()), strICCID[i].trim(), respCliente, respOperador, respTipo);
                                resp.Gravar();
                                verificacao = true;
                            }
                            if (!jaCadastrados.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "isca" + jaCadastrados.toString() + " ja estao cadastradas");
                            }
                            if (verificacao) {
                                JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                            }

                        } catch (StringIndexOutOfBoundsException s) {
                            JOptionPane.showMessageDialog(null, "Para Cadastrar o ID Nao completo , Desmarque a Opçao 'Numeraçao ID Completo' ");
                            limpar = false;
                        }
                    } else {
                        limpar = true;
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

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Para Cadastrar o ID Completo , Ative a Opçao 'Numeraçao ID Completo' ");
                    limpar = false;
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "a quantidade de ISCAS nao sao iguais do ICCID");
        }
        if (limpar) {
            LimparCadastroIsca();

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btConsultaAlterarCalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConsultaAlterarCalendarioMouseClicked
        Calendario c = new Calendario(tfConsultaAlterarCalendario);
        c.setVisible(true);
        c.setLocation(pnConsultaAlterarCalendario.getX() + 380, pnConsultaAlterarCalendario.getY() - 60);
    }//GEN-LAST:event_btConsultaAlterarCalendarioMouseClicked

    private void btConsultaAlterarCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaAlterarCalendarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btConsultaAlterarCalendarioActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
      //  MostrarCliente();
        Object obj = Tabela.getValueAt(Tabela.getSelectedRow(), 1);
        Isca isca = new Isca();
        List<Isca> lista = new ArrayList<Isca>();
        lista = isca.pegarValores((String) obj);
        lbIDConsultaAlterar.setText("ID :" + lista.get(0).getID());
        tfICCIDConsultaAlterar.setText(lista.get(0).getIccid());
        if (lista.get(0).isStatus()) {
            cbStatusConsultaAlterar.setSelectedIndex(0);
        } else {
            cbStatusConsultaAlterar.setSelectedIndex(1);
        }
        cbOperadoraConsultaAlterar.setSelectedItem(lista.get(0).getOperadora());
        cbTipoConsultaAlterar.setSelectedItem(lista.get(0).getTipo());
        tfConsultaAlterarCalendario.setText(lista.get(0).getDataAtivacao());
        cbClienteConsultaAlterar.setSelectedItem(lista.get(0).getCliente());
        isca = null;
        lista = null;
        CardLayout card = (CardLayout) pnConteudo.getLayout();
        card.show(pnConteudo, "ConsultaAlterar");
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btXMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXMouseEntered
        btX.setBackground(Color.red);
    }//GEN-LAST:event_btXMouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Isca isca = new Isca();
        Object id = Tabela.getValueAt(Tabela.getSelectedRow(), 1);
        if (isca.Desativar(Integer.valueOf(id.toString()))) {
        ModeloTabela(cbFiltro.getSelectedItem().toString(),tfPesquisa.getText());
            JOptionPane.showMessageDialog(null, "Isca " + id + " Desativada com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um ID para desativar !");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btCadastroClienteSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroClienteSalvarActionPerformed
        if (cbCadastroClienteStatus.getSelectedIndex() == 0
                || tfCadastroClienteNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preenchar Todos com campos obrigadorios demarcado com * ");
        } else {
            Cliente cli = new Cliente();
            boolean respStatus;
            boolean respInadimplente;
            String respPessoa;
            if (cbCadastroClienteStatus.getSelectedItem().equals("Sim")) {
                respStatus = true;
            } else {
                respStatus = false;
            }
            if (cbCadastroClienteInadimplente.getSelectedItem().equals("Sim")) {
                respInadimplente = true;
            } else {
                respInadimplente = false;
            }
            if (cbCadastroClientePessoa.getSelectedItem().equals("F")) {
                respPessoa = "Fisica";
            } else {
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
            cli.setUF((String) cbCadastroClienteUF.getSelectedItem());
            cli.setCidade(tfCadastroClienteCidade.getText());
            cli.setBairro(tfCadastroClienteBairro.getText());
            cli.setComplemento(tfCadastroClienteComplemento.getText());

            int resp = cli.Gravar(cli);

            if (resp == -1) {
                JOptionPane.showMessageDialog(null, "Cliente ja cadastrado");
            } else if (resp == -2) {
                JOptionPane.showMessageDialog(null, "CPF/CNPJ ja cadastrado");
            } else if (resp == 0) {
                JOptionPane.showMessageDialog(null, "Nao foi Possivel Salvar o Cliente ");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente Salvo com Sucesso");
                LimparCadastroCliente();
            }

        }
        MostrarCliente();
    }//GEN-LAST:event_btCadastroClienteSalvarActionPerformed

    private void btCadastroClienteLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroClienteLimparActionPerformed
        LimparCadastroCliente();
    }//GEN-LAST:event_btCadastroClienteLimparActionPerformed

    private void btVoltarConsultaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarConsultaAlterarActionPerformed
        ModeloTabela(cbFiltro.getSelectedItem().toString(),tfPesquisa.getText());
        CardLayout card = (CardLayout) pnConteudo.getLayout();
        card.show(pnConteudo, "Consulta");
    }//GEN-LAST:event_btVoltarConsultaAlterarActionPerformed

    private void btSalvarConsultaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarConsultaAlterarActionPerformed
        if (cbStatusConsultaAlterar.getSelectedIndex() == 1 && tfConsultaAlterarCalendario.getText().isEmpty() == false) {
            JOptionPane.showMessageDialog(null, "Para concluir a alteração , Ative a opção 'STATUS' ");
            System.out.println("status" + cbStatusConsultaAlterar.getSelectedIndex() + "\n calendario" + tfConsultaAlterarCalendario.getText().isEmpty());
        } else if (tfConsultaAlterarCalendario.getText().isEmpty() == true && cbStatusConsultaAlterar.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Para Ativar a isca , precisa preencher a Data de Ativacao");
            System.out.println("status" + cbStatusConsultaAlterar.getSelectedIndex() + "\n calendario" + tfConsultaAlterarCalendario.getText().isEmpty());
        } else {
            boolean status;
            String id = (String) lbIDConsultaAlterar.getText().substring(4);
            if (cbStatusConsultaAlterar.getSelectedIndex() == 0) {
                status = true;
            } else {
                status = false;
            }
            Isca isca = new Isca(status, Integer.valueOf(id), tfICCIDConsultaAlterar.getText(), String.valueOf(cbClienteConsultaAlterar.getSelectedItem()), String.valueOf(tfConsultaAlterarCalendario.getText()), String.valueOf(cbOperadoraConsultaAlterar.getSelectedItem()), String.valueOf(cbTipoConsultaAlterar.getSelectedItem()));

            if (isca.Alterar()) {
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Nao foi possivel salvar");
            }
        }
    }//GEN-LAST:event_btSalvarConsultaAlterarActionPerformed

    private void btContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btContaActionPerformed
        lbMostrarUsuario.setText(Usuario);
        CardLayout card = (CardLayout) pnConteudo.getLayout();
        card.show(pnConteudo, "Mudar Senha");
    }//GEN-LAST:event_btContaActionPerformed

    private void btCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCriarActionPerformed
        if (tfSenha.getText().equals(tfConfirmacao.getText())) {
            Usuario usuario = new Usuario(lbMostrarUsuario.getText(), tfSenha.getText());
            boolean resp = usuario.update();
            if (resp) {
                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso !");
            } else {
                System.out.println("verificar erro");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite a mesma senha nos dois campos ");
            tfSenha.setText("");
            tfConfirmacao.setText("");
        }

    }//GEN-LAST:event_btCriarActionPerformed

    private void cbFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFiltroItemStateChanged


    }//GEN-LAST:event_cbFiltroItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String str = new String();
        if(cbFiltro.getSelectedIndex()==0){
        for (int i = 0; i < Tabela.getRowCount(); i++) {
            str = str + (String) Tabela.getValueAt(i, 1) + "\n";
        }
        Clipboard clip = getToolkit().getSystemClipboard();

        StringSelection ss = new StringSelection(str.trim());
        clip.setContents(ss, ss);
            System.out.println("rodouu condicao expirado");
            
        }else{
            
        for (int i = 0; i < Tabela.getRowCount(); i++) {
            str = str + (String) Tabela.getValueAt(i, 2) + "\n";
        }
        Clipboard clip = getToolkit().getSystemClipboard();

        StringSelection ss = new StringSelection(str.trim());
        clip.setContents(ss, ss);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String str[] = taID.getText().split("\n");
        String resp = new String();
        if (ckBox.isSelected()) {
            for (int i = 0; i < str.length; i++) {
                resp = resp + str[i].substring(7, 14) + "\n";
            }
            Clipboard clip = getToolkit().getSystemClipboard();

            StringSelection ss = new StringSelection(resp.trim());
            clip.setContents(ss, ss);
        } else {
            for (int i = 0; i < str.length; i++) {
                resp = resp + str[i].toString() + "\n";
            }
            Clipboard clip = getToolkit().getSystemClipboard();

            StringSelection ss = new StringSelection(resp.trim());
            clip.setContents(ss, ss);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(cbFiltro.getSelectedIndex() == 0){
        int resp = JOptionPane.showConfirmDialog(null, "Deseja Desativar Todas as Iscas","",JOptionPane.YES_NO_OPTION );
           if (resp == JOptionPane.YES_OPTION){
              Isca isca = new Isca();
              List<Object> listaID = new ArrayList<Object>();
              for(int i=0;i<Tabela.getRowCount();i++){
                  isca.Desativar(Integer.valueOf(Tabela.getValueAt(i, 0).toString()));
              }
            ModeloTabela(cbFiltro.getSelectedItem().toString(),tfPesquisa.getText());
            JOptionPane.showMessageDialog(null, "Iscas Desativadas");
           }else{
               System.out.println("Nao");
           }
            
        }else{
            int resp = JOptionPane.showConfirmDialog(null, "Deseja Desativar Todas as Iscas","",JOptionPane.YES_NO_OPTION );
           if (resp == JOptionPane.YES_OPTION){
              Isca isca = new Isca();
              List<Object> listaID = new ArrayList<Object>();
              for(int i=0;i<Tabela.getRowCount();i++){
                  isca.Desativar(Integer.valueOf(Tabela.getValueAt(i, 1).toString()));
              }
            ModeloTabela(cbFiltro.getSelectedItem().toString(),tfPesquisa.getText());
            JOptionPane.showMessageDialog(null, "Iscas Desativadas");
           }else{
               System.out.println("Nao");
           }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btSalvarSinistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarSinistroActionPerformed
                        if (cbClienteSinistro.getSelectedIndex() == 0
                        || cbTipoAcionamento.getSelectedIndex() == 0
                        || cbTipoOcorrencia.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Por favor Preencha todos os campos obrigatorios : Cliente , Tipo da Ocorrencia , Tipo do Acionamento ");
                    } else {
                        Sinistro sinistro = new Sinistro();
                        Agente agente = new Agente();
                        
                        
                        sinistro.setCarreta(tfCarreta.getText());
                        sinistro.setCidade(tfCidade.getText());
                        sinistro.setCliente(cbClienteSinistro.getSelectedItem().toString());
                        sinistro.setContato(tfContato.getText());
                        sinistro.setContatoCondutor(tfContatoCondutor.getText());
                        sinistro.setCoordenadas(tfCoordenadas.getText());
                        sinistro.setCor(tfCor.getText());
                        sinistro.setCpfCondutor(tfCPF.getText());
                        sinistro.setDescricao(taDescricao.getText());
                        agente.setHoraInicio(tfHoraAcionamento.getText());
                        agente.setHoraChegada(tfHoraChegadaAgente.getText());
                        sinistro.setHoraOcorrencia(tfHoraOcorrencia.getText());
                        agente.setHoraFim(tfHoraTermino.getText());
                        agente.setNome(tfNomeAgente.getText());
                        agente.setPlaca(tfPlacaAgente.getText());
                        agente.setReside(tfReside.getText());
                        agente.setVarredura(tfVarredura.getText());
                        sinistro.setInformante(tfInformante.getText());
                        sinistro.setModelo(tfModelo.getText());
                        sinistro.setNomeCondutor(tfNome.getText());
                        sinistro.setPlaca(tfPlaca.getText());
                        sinistro.setTipoAcionamento(cbTipoAcionamento.getSelectedItem().toString());
                        sinistro.setTipoOcorrencia(cbTipoOcorrencia.getSelectedItem().toString());
                        if(tfTotalKM.getText().isEmpty()){
                            agente.setTotalKM(0);
                        }else{
                            agente.setTotalKM(Integer.valueOf(tfTotalKM.getText()));
                        }
                        
                        if(tfValorCarga.getText().isEmpty()){
                            sinistro.setValorCarga(0);
                        }else{
                        sinistro.setValorCarga(Double.valueOf(tfValorCarga.getText().toString()));
                            
                        }
                        if(tfIsca.getText().isEmpty()){
                            sinistro.setIsca(0);
                        }else{
                            
                        sinistro.setIsca(Integer.valueOf(tfIsca.getText()));
                        }
                        sinistro.setAgente(agente);
                        if (sinistro.Gravar(sinistro)) {
                                JOptionPane.showMessageDialog(null, "Dados Salvo com Sucesso");
                            } else {
                                JOptionPane.showMessageDialog(null, "Nao foi possivel salvar os dados");
                            }
            
                    }
                        LimparSinistro();
    }//GEN-LAST:event_btSalvarSinistroActionPerformed

    private void btLimparSinistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparSinistroActionPerformed
            LimparSinistro();
    }//GEN-LAST:event_btLimparSinistroActionPerformed

    private void tfHoraChegadaAgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHoraChegadaAgenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHoraChegadaAgenteActionPerformed

    private void cbTipoAcionamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoAcionamentoItemStateChanged
        if(cbTipoAcionamento.getSelectedIndex() ==1){
            //                 pnAcionamento.removeAll();
            //                 pnAcionamento.setLayout(new GridBagLayout());
            //                 GridBagConstraints pn = new GridBagConstraints();
            //                 JComboBox<String> agentes = new JComboBox<String>();
            //                 Agente ag = new Agente();
            //                 List<Agente> listaAg = ag.pegarAgentes();
            //                 agentes.addItem("Selecione um Agente");
            //                 for(int i=0 ; i<listaAg.size(); i ++){
                //                     agentes.addItem(listaAg.get(i).getNome());
                //                 }
            //                 agentes.addItemListener(new ItemListener() {
                //                     @Override
                //                     public void itemStateChanged(ItemEvent ie) {
                    //                         if(agentes.getSelectedIndex() == 1){
                        //                             System.out.println("Rafa");
                        //                         }
                    //                     }
                //                 });
        //                 JLabel lbAgente = new JLabel("Aquiiii:");
        //                 JLabel lbteste = new JLabel("Aquiiii222222:");
        //                 pn.gridx = 20;
        //                 pn.gridy = 2;
        //                 pn.fill = GridBagConstraints.WEST;
        //                 pnAcionamento.add(agentes,pn);
        //                 pn.gridx = 20;
        //                 pn.gridy = 0;
        //                 pnAcionamento.add(lbAgente,pn);
        //
        //              //   pn.weightx =1;
        //                 pn.gridx = 25;
        //                 pn.gridy = 5;
        //                 pnAcionamento.add(lbteste,pn);
        //                 JButton add = new JButton("Adicionar Antenista");
        //                 GridBagConstraints pn = new GridBagConstraints();
        //
        //                 pn.gridy=100;
        //                 pn.gridx=10;
        //                 pn.gridheight=100;
        //                 pn.fill = GridBagConstraints.LINE_END;
        //                pnAcionamento.setLayout(new GridBagLayout());
        //                 add.setSize(155, 25);
        //
        //                 pnAcionamento.add(add,pn);

        }
        repaint();
    }//GEN-LAST:event_cbTipoAcionamentoItemStateChanged

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int resp = Integer.valueOf((String) tbConsultarSinistro.getValueAt(tbConsultarSinistro.getSelectedRow(),0));

        Sinistro sinistro = new Sinistro();
        sinistro = sinistro.bucarSinistro(resp);
        TelaAgentes tela = new TelaAgentes(sinistro);
        tela.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       CardLayout card = (CardLayout) pnConteudo.getLayout();
        card.show(pnConteudo, "consultaSinistro");
        tbConsultarSinistro.setModel(Sinistro.getTableModel());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btSinistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSinistroMouseEntered
      fecharSinistro.stop();
    }//GEN-LAST:event_btSinistroMouseEntered

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        fecharSinistro.stop();      
    }//GEN-LAST:event_jButton7MouseEntered

    private void tfPlacaAgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPlacaAgenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPlacaAgenteActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btAplicar;
    private javax.swing.JButton btAtivarIsca;
    private javax.swing.JButton btCadastroClienteLimpar;
    private javax.swing.JButton btCadastroClienteSalvar;
    private javax.swing.JButton btCalendario;
    private javax.swing.JButton btCliente;
    private javax.swing.JButton btConsultaAlterarCalendario;
    private javax.swing.JButton btConta;
    private javax.swing.JButton btCriar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btHome;
    private javax.swing.JButton btIsca;
    private javax.swing.JButton btLimparSinistro;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvarConsultaAlterar;
    private javax.swing.JButton btSalvarSinistro;
    private javax.swing.JButton btSinistro;
    private javax.swing.JButton btVoltarConsultaAlterar;
    private javax.swing.JButton btX;
    private javax.swing.JComboBox<String> cbCadastroClienteInadimplente;
    private javax.swing.JComboBox<String> cbCadastroClientePessoa;
    private javax.swing.JComboBox<String> cbCadastroClienteStatus;
    private javax.swing.JComboBox<String> cbCadastroClienteUF;
    private javax.swing.JComboBox<String> cbCadastroIscaCliente;
    private javax.swing.JComboBox<String> cbClienteAtivacao;
    private javax.swing.JComboBox<String> cbClienteConsultaAlterar;
    private javax.swing.JComboBox<String> cbClienteSinistro;
    private javax.swing.JComboBox<String> cbFiltro;
    private javax.swing.JComboBox<String> cbOperadora;
    private javax.swing.JComboBox<String> cbOperadoraConsultaAlterar;
    private javax.swing.JComboBox<String> cbStatusConsultaAlterar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JComboBox<String> cbTipoAcionamento;
    private javax.swing.JComboBox<String> cbTipoConsultaAlterar;
    private javax.swing.JComboBox<String> cbTipoOcorrencia;
    private javax.swing.JCheckBox ckBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lbConfirmacao;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbHome1;
    private javax.swing.JLabel lbHome3;
    private javax.swing.JLabel lbHome4;
    private javax.swing.JLabel lbHome7;
    private javax.swing.JLabel lbHome8;
    private javax.swing.JLabel lbIDConsultaAlterar;
    private javax.swing.JLabel lbIconHome1;
    private javax.swing.JLabel lbIconHome3;
    private javax.swing.JLabel lbIconHome4;
    private javax.swing.JLabel lbIconHome7;
    private javax.swing.JLabel lbIconHome8;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbLogoEscrita;
    private javax.swing.JLabel lbMostrarUsuario;
    private javax.swing.JLabel lbMsg;
    private javax.swing.JLabel lbNomeIsca;
    private javax.swing.JLabel lbReside;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPanel pnAcionamento;
    private javax.swing.JPanel pnAtivacao;
    private javax.swing.JPanel pnCadastroCliente;
    private javax.swing.JPanel pnCadastroIsca;
    private javax.swing.JPanel pnCadastroSinistro;
    private javax.swing.JPanel pnCalendario;
    private javax.swing.JPanel pnCliente;
    private javax.swing.JPanel pnCondutor;
    private javax.swing.JPanel pnConsulta;
    private javax.swing.JPanel pnConsultaAlterar;
    private javax.swing.JPanel pnConsultaAlterarCalendario;
    private javax.swing.JPanel pnConta;
    private javax.swing.JPanel pnConteudo;
    private javax.swing.JPanel pnHome;
    private javax.swing.JPanel pnInformacoes;
    private javax.swing.JPanel pnIsca;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnNovoCadastro;
    private javax.swing.JPanel pnOcorrencia;
    private javax.swing.JPanel pnPrincipal;
    private javax.swing.JPanel pnPrincipal2;
    private javax.swing.JPanel pnPrincipalAlterar;
    public javax.swing.JPanel pnPrincipalAtivacao;
    private javax.swing.JPanel pnPrincipalCadastroCliente;
    private javax.swing.JPanel pnPrincipalCadastroIsca;
    private javax.swing.JPanel pnPrincipalMudarSenha;
    private javax.swing.JPanel pnSinistro;
    public javax.swing.JPanel pnTabela;
    private javax.swing.JPanel pnTelaConsultaSinistro;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JPanel pnVeiculo;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextArea taICCID;
    private javax.swing.JTextArea taID;
    private javax.swing.JTextArea taNumeroIsca;
    private javax.swing.JTable tbConsultarSinistro;
    private javax.swing.JTextField tfCPF;
    private javax.swing.JTextField tfCadastroClienteBairro;
    private javax.swing.JTextField tfCadastroClienteCep;
    private javax.swing.JTextField tfCadastroClienteCidade;
    private javax.swing.JTextField tfCadastroClienteComplemento;
    private javax.swing.JTextField tfCadastroClienteCpfCnpj;
    private javax.swing.JTextField tfCadastroClienteEmail;
    private javax.swing.JTextField tfCadastroClienteEndereco;
    private javax.swing.JTextField tfCadastroClienteNome;
    private javax.swing.JTextField tfCalendario;
    private javax.swing.JTextField tfCarreta;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfConfirmacao;
    private javax.swing.JTextField tfConsultaAlterarCalendario;
    private javax.swing.JTextField tfContato;
    private javax.swing.JTextField tfContatoCondutor;
    private javax.swing.JTextField tfCoordenadas;
    private javax.swing.JTextField tfCor;
    private javax.swing.JTextField tfHoraAcionamento;
    private javax.swing.JTextField tfHoraChegadaAgente;
    private javax.swing.JTextField tfHoraOcorrencia;
    private javax.swing.JTextField tfHoraTermino;
    private javax.swing.JTextField tfICCIDConsultaAlterar;
    private javax.swing.JTextField tfInformante;
    private javax.swing.JTextField tfIsca;
    private javax.swing.JTextField tfModelo;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNomeAgente;
    private javax.swing.JTextField tfPesquisa;
    private javax.swing.JTextField tfPlaca;
    private javax.swing.JTextField tfPlacaAgente;
    private javax.swing.JTextField tfReside;
    private javax.swing.JTextField tfSenha;
    private javax.swing.JTextField tfTotalKM;
    private javax.swing.JTextField tfValorCarga;
    private javax.swing.JTextField tfVarredura;
    // End of variables declaration//GEN-END:variables
}
