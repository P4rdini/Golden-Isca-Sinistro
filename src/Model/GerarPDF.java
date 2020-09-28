package Model;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author rafa_
 */
public class GerarPDF {
    List<Image> listaRetrato = new ArrayList<Image>();
    List<Image> listaPaisagem = new ArrayList<Image>();
    List<Agente> agente;
    // instancia da classe sinistro
    Sinistro dados = new Sinistro();
    // Criacao de um documento PDF
    Document documento = new Document();
    // instancia fonte Arial 
    Font fontePadrao = FontFactory.getFont("C:\\Windows\\Fonts\\Calibri.ttf");
    Font fontePadrao2 = FontFactory.getFont("C:\\Windows\\Fonts\\Calibri.ttf");
    Font fonteBranca = FontFactory.getFont(FontFactory.TIMES_BOLD, 20);
    Font fonteTitulo = FontFactory.getFont(FontFactory.TIMES_BOLD, 30);

    // pegando as imagens de background
// pegando as dimensoes da folha A4
    public static final Rectangle d = PageSize.A4.rotate();

    public GerarPDF() {
    }

    public Paragraph Texto(String texto, Font fonte, boolean resp) {
        Paragraph str = new Paragraph();
        str.add(new Chunk(texto, fonte));

        if (resp) {
            str.setAlignment(Element.ALIGN_CENTER);
        }
        return str;
    }

    public Phrase HistoricoAcionamento(PdfWriter escrever, Image imagem, int iterador) throws DocumentException {
        BG(escrever, imagem);
        return new Phrase("\n Historico de Acionamento\n Equipe " + agente.get(iterador).getNome() + " (" + agente.get(iterador).getReside() + ")", fonteTitulo);
        
    }

    public static PdfContentByte BG(PdfWriter escrever, Image imagem) throws DocumentException {
        PdfContentByte telaDados = escrever.getDirectContentUnder();
        imagem.scaleAbsolute(d.getWidth(), d.getHeight());
        imagem.setAbsolutePosition(0, 0);
        telaDados.addImage(imagem);
        return telaDados;
    }

    public GerarPDF(Sinistro dados, List<Agente> agente) {
        this.dados = dados;
        this.agente = agente;
        dados.setChamadoAgentes(6); //// DePOIS TEM QUE TIRAR ESSE CODIGO
        gerarPDF();
    }

//    public PdfPTable tabelaImagens(int qtd) {
//        ArrayList<PdfPCell> celulas = new ArrayList<PdfPCell>();
//        PdfPTable tabela = new PdfPTable(1);
//        switch (qtd) {
//            case 1:
//                tabela = new PdfPTable(1);
//                tabela.setWidthPercentage(50);
//                agente.getImagens().get(0).scaleAbsolute(250, 120);
//                PdfPCell celula = new PdfPCell();
//                celula.setImage(agente.getImagens().get(0));
//                celulas.add(celula);
//                tabela.addCell(celulas.get(0));
//                break;
//            case 2:
//                tabela = new PdfPTable(2);
//                tabela.setWidthPercentage(50);
//                for (int i = 0; i < qtd; i++) {
//                    //   agente.getImagens().get(i).scaleAbsolute(250, 120);
//                    PdfPCell celula2 = new PdfPCell();
//                    celula2.setPaddingBottom(0);
//                    agente.getImagens().get(i).scaleAbsoluteHeight(50);
////                    celula2.setImage(Image.get);
//                    celulas.add(celula2);
//                    tabela.addCell(celulas.get(i));
//                }
//                break;
//        }
//        for (int i = 0; i < qtd; i++) {
//            //    if(agente.getImagens().get(i).getWidth() > agente.getImagens().get(i).getHeight()){
//            PdfPCell celula = new PdfPCell();
//            agente.getImagens().get(0).scaleAbsolute(250, 120);
//            celula.setImage(agente.getImagens().get(0));
//            celulas.add(celula);
//            //    tabela.addCell(celulas.get(i));
//            //  }
//
//        }
//
//        return tabela;
//
//    }
    public float pegarLarguraImagem(int tamanho) {
        int espaco = 3;
        // definindo largura imagem , conta = tamanho tela / quantidade de fotos - espacamento entre as fotos * a quantidade de fotos
        return (d.getWidth() / tamanho) - (espaco * tamanho);
    }

    public float pegarAlturaImagem(float largura) {
        // definindo altura imagem , conta = vai ser 61% da largura da imagem 
        return (largura / 100) * 61;
    }

    public float posicaoAlturaImagem() {
        // defininfo altura da img na tela , e 18% do tamanho da tela
        return (d.getHeight() / 100) * 18;
    }

    public PdfContentByte ImgTelaPaisagem(PdfWriter escrever, int t, int numeroAgente) throws DocumentException {

        PdfContentByte tela = escrever.getDirectContentUnder();
        float espaco = 5;

        float largura = pegarLarguraImagem(t) + 10;

        for (int i = 0; i < t; i++) {
            switch (t) {
                case 1:

                   // listaPaisagem.get(numeroAgente).getImagens().get(i).scaleAbsolute(500, 300);
                   // listaPaisagem.get(i).scaleAbsolute(500, 300);
                    listaPaisagem.get(i).scaleAbsolute(500, 300);
                    listaPaisagem.get(i).setAbsolutePosition((d.getWidth() / 2) - 250, 100);

                    break;
                case 2:
                    espaco = 5;
//                // definindo largura imagem , conta = tamanho tela / quantidade de fotos - espacamento entre as fotos * a quantidade de fotos
//                float largura_img = (d.getWidth()/tamanho)-(espaco*tamanho);
//                // definindo altura imagem , conta = vai ser 61% da largura da imagem 
//                float altura_img = (largura_img/100)*61;
//                // defininfo altura da img na tela , e 18% do tamanho da tela
//                float alturaTela = (d.getHeight()/100)*18;
                    if (i == 0) {
                        listaPaisagem.get(0).scaleAbsolute(pegarLarguraImagem(t), pegarAlturaImagem(pegarLarguraImagem(t)));
                        listaPaisagem.get(0).setAbsolutePosition(espaco, posicaoAlturaImagem());
                       

                    } else {
                        espaco *= i + 1;
                        listaPaisagem.get(0).scaleAbsolute(pegarLarguraImagem(t), pegarAlturaImagem(pegarLarguraImagem(t)));
                        listaPaisagem.get(0).setAbsolutePosition(espaco + pegarLarguraImagem(t), posicaoAlturaImagem());

                    }
                    break;
                case 3:

                    if (i == 0) {
                        listaPaisagem.get(0).scaleAbsolute(pegarLarguraImagem(3), pegarAlturaImagem(pegarLarguraImagem(3)));
                        listaPaisagem.get(0).setAbsolutePosition(5, posicaoAlturaImagem());
                        espaco = espaco + largura;

                    } else {
                        listaPaisagem.get(0).scaleAbsolute(pegarLarguraImagem(3), pegarAlturaImagem(pegarLarguraImagem(3)));
                        listaPaisagem.get(0).setAbsolutePosition(espaco, posicaoAlturaImagem());
                        espaco = espaco + largura;

                    }

                    break;
                case 4:

                    if (i == 0) {
                        listaPaisagem.get(0).scaleAbsolute((d.getWidth() / 2) - 60, 200);
                        listaPaisagem.get(0).setAbsolutePosition(3, 215);
                        espaco = espaco + ((d.getWidth() / 2) - 20);

                    }
                    if (i > 0 && i < 2) {
                        listaPaisagem.get(0).scaleAbsolute((d.getWidth() / 2) - 60, 200);
                        listaPaisagem.get(0).setAbsolutePosition((d.getWidth() - (d.getWidth() / 2)) + 55, 215);
                        espaco = espaco + ((d.getWidth() / 2) - 15);

                    }

                    if (i > 1) {
                        espaco = 5;
                        listaPaisagem.get(0).scaleAbsolute((d.getWidth() / 2) - 60, 200);
                        listaPaisagem.get(0).setAbsolutePosition(3, 10);
                        espaco = espaco + ((d.getWidth() / 2) - 15);

                    }
                    if (i > 2) {
                        listaPaisagem.get(0).scaleAbsolute((d.getWidth() / 2) - 60, 200);
                        listaPaisagem.get(0).setAbsolutePosition((d.getWidth() - (d.getWidth() / 2)) + 55, 10);
                        espaco = espaco + ((d.getWidth() / 2) - 15);

                    }

                    break;
                case 5:
                    if (i == 0) {
                        listaPaisagem.get(0).scaleAbsolute(pegarLarguraImagem(3), pegarAlturaImagem(pegarLarguraImagem(3)));
                        listaPaisagem.get(0).setAbsolutePosition(5, 200);

                        espaco += 281;
                    } else if (i < 3) {
                        listaPaisagem.get(0).scaleAbsolute(pegarLarguraImagem(3), pegarAlturaImagem(pegarLarguraImagem(3)));
                        listaPaisagem.get(0).setAbsolutePosition(espaco, 200);

                        espaco += 281;
                    } else if (i == 3) {
                        espaco = 0;
                        listaPaisagem.get(0).scaleAbsolute(pegarLarguraImagem(3), pegarAlturaImagem(pegarLarguraImagem(3)));
                        listaPaisagem.get(0).setAbsolutePosition(5, 2);

                        espaco = d.getWidth() - 276;
                    } else {
                        listaPaisagem.get(0).scaleAbsolute(pegarLarguraImagem(3), pegarAlturaImagem(pegarLarguraImagem(3)));
                        listaPaisagem.get(0).setAbsolutePosition(espaco, 2);

                    }
                    break;
                case 6:
                    if (i == 0) {
                        listaPaisagem.get(0).scaleAbsolute(pegarLarguraImagem(3), pegarAlturaImagem(pegarLarguraImagem(3)));
                        listaPaisagem.get(0).setAbsolutePosition(5, 200);

                        espaco += 281;
                    } else if (i < 3) {
                        listaPaisagem.get(0).scaleAbsolute(pegarLarguraImagem(3), pegarAlturaImagem(pegarLarguraImagem(3)));
                        listaPaisagem.get(0).setAbsolutePosition(espaco, 200);

                        espaco += 281;
                    } else if (i == 3) {
                        espaco = 5;
                        listaPaisagem.get(0).scaleAbsolute(pegarLarguraImagem(3), pegarAlturaImagem(pegarLarguraImagem(3)));
                        listaPaisagem.get(0).setAbsolutePosition(5, 5);

                        espaco += 281;
                    } else {
                        listaPaisagem.get(0).scaleAbsolute(pegarLarguraImagem(3), pegarAlturaImagem(pegarLarguraImagem(3)));
                        listaPaisagem.get(0).setAbsolutePosition(espaco, 5);
                        espaco += 281;

                    }
                    break;
            }
            tela.addImage(listaPaisagem.get(0));
            listaPaisagem.remove(listaPaisagem.get(0));
        }

        return tela;
    }
    
    
    
    
    public PdfContentByte ImgTelaRetrato(PdfWriter escrever, int t, int numeroAgente) throws DocumentException {

        PdfContentByte tela = escrever.getDirectContentUnder();
        float espaco = 5;

        float largura = pegarLarguraImagem(t) + 10;

        for (int i = 0; i < t; i++) {
            switch (t) {
                case 1:

                    listaRetrato.get(i).scaleAbsolute(250, 400);
                    listaRetrato.get(i).setAbsolutePosition((d.getWidth() / 2)-125, 15);

                    break;
                case 2:
                    espaco = 5;
//                // definindo largura imagem , conta = tamanho tela / quantidade de fotos - espacamento entre as fotos * a quantidade de fotos
//                float largura_img = (d.getWidth()/tamanho)-(espaco*tamanho);
//                // definindo altura imagem , conta = vai ser 61% da largura da imagem 
//                float altura_img = (largura_img/100)*61;
//                // defininfo altura da img na tela , e 18% do tamanho da tela
//                float alturaTela = (d.getHeight()/100)*18;
                    if (i == 0) {
                        listaRetrato.get(0).scaleAbsolute(250, 400);
                        listaRetrato.get(0).setAbsolutePosition((d.getWidth() / 2)-300, 15);

                    } else {
                       
                        listaRetrato.get(0).scaleAbsolute(250, 400);
                        listaRetrato.get(0).setAbsolutePosition((d.getWidth() / 2)+50, 15);

                    }
                    break;
                case 3:

                    if (i == 0) {
                        listaRetrato.get(0).scaleAbsolute(250, 400);
                        listaRetrato.get(0).setAbsolutePosition((d.getWidth() / 2)-405, 15);
                        espaco = espaco + largura;

                    } else {
                        listaRetrato.get(0).scaleAbsolute(250, 400);
                        listaRetrato.get(0).setAbsolutePosition(10+espaco, 15);
                        espaco = espaco + largura;

                    }

                    break;
                case 4:
                     
                    if (i == 0) {
                        listaRetrato.get(0).scaleAbsolute(200, 400);
                        listaRetrato.get(0).setAbsolutePosition((d.getWidth() / 2)-412, 15);
                        espaco = espaco + largura;

                    }else{
                        listaRetrato.get(0).scaleAbsolute(200, 400);
                        listaRetrato.get(0).setAbsolutePosition(5+espaco,15);
                        espaco = espaco + largura;

                    }

                   

                    break;
                case 5:
                     if (i == 0) {
                        listaRetrato.get(0).scaleAbsolute(165, 400);
                        listaRetrato.get(0).setAbsolutePosition((d.getWidth() / 2)-420, 15);
                        espaco = espaco + largura;

                    }else{
                        listaRetrato.get(0).scaleAbsolute(165, 400);
                        listaRetrato.get(0).setAbsolutePosition(espaco,15);
                        espaco = espaco + largura+5;

                    }
                    break;
                case 6:
                    if (i == 0) {
                        listaRetrato.get(0).scaleAbsolute(pegarLarguraImagem(3), pegarAlturaImagem(pegarLarguraImagem(3)));
                        listaRetrato.get(0).setAbsolutePosition(5, 200);

                        espaco += 281;
                    } else if (i < 3) {
                        listaRetrato.get(0).scaleAbsolute(pegarLarguraImagem(3), pegarAlturaImagem(pegarLarguraImagem(3)));
                        listaRetrato.get(0).setAbsolutePosition(espaco, 200);

                        espaco += 281;
                    } else if (i == 3) {
                        espaco = 5;
                        listaRetrato.get(0).scaleAbsolute(pegarLarguraImagem(3), pegarAlturaImagem(pegarLarguraImagem(3)));
                        listaRetrato.get(0).setAbsolutePosition(5, 5);

                        espaco += 281;
                    } else {
                        listaRetrato.get(0).scaleAbsolute(pegarLarguraImagem(3), pegarAlturaImagem(pegarLarguraImagem(3)));
                        listaRetrato.get(0).setAbsolutePosition(espaco, 5);
                        espaco += 281;

                    }
                    break;
            }
            tela.addImage(listaRetrato.get(0));
            listaRetrato.remove(0);
        }

        return tela;
    }
    
    public Phrase juntaFontes(String str, Font fonte, String str2, Font fonte2) {
        Chunk a = new Chunk(str, fonte);
        Chunk b = new Chunk(str2, fonte2);
        Phrase texto = new Phrase();
        texto.add(a);
        texto.add(b);
        return texto;
    }

    public void gerarPDF() {

        try {
            // pegando as imagens de background 
//            Image TelaInicial = Image.getInstance(String.format("C:\\Users\\rafa_\\OneDrive\\Documentos\\Projeto_Golden\\IMG_Relatorio\\TelaInicial.jpg"));
//            Image Tela1 = Image.getInstance(String.format("C:\\Users\\rafa_\\OneDrive\\Documentos\\Projeto_Golden\\IMG_Relatorio\\Tela1.jpg"));
//            Image Tela2 = Image.getInstance(String.format("C:\\Users\\rafa_\\OneDrive\\Documentos\\Projeto_Golden\\IMG_Relatorio\\Tela2.jpg"));
//            Image TelaFinal = Image.getInstance(String.format("C:\\Users\\rafa_\\OneDrive\\Documentos\\Projeto_Golden\\IMG_Relatorio\\TelaFinal.jpg"));
//            Image dadosSinistro = Image.getInstance(String.format("C:\\Users\\rafa_\\OneDrive\\Documentos\\Projeto_Golden\\IMG_Relatorio\\DadosSinistro.jpg"));
//            Image padrao = Image.getInstance(String.format("C:\\Users\\rafa_\\OneDrive\\Documentos\\Projeto_Golden\\IMG_Relatorio\\Padrao.jpg"));
            FileSystemView system = FileSystemView.getFileSystemView();
            Image TelaInicial = Image.getInstance(getClass().getResource("/Resources/TelaInicial.jpg"));
            Image Tela1 = Image.getInstance(getClass().getResource("/Resources/Tela1.jpg"));
            Image Tela2 = Image.getInstance(getClass().getResource("/Resources/Tela2.jpg"));
            Image TelaFinal = Image.getInstance(getClass().getResource("/Resources/TelaFinal.jpg"));
            Image dadosSinistro = Image.getInstance(getClass().getResource("/Resources/DadosSinistro.jpg"));
            Image padrao = Image.getInstance(getClass().getResource("/Resources/Padrao.jpg"));
            //   String nomeDocumento = javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory()+"\\Sinistro.pdf";
            String nomeDocumento = system.getHomeDirectory().getPath() + File.separator + "Sinistro "+dados.getCliente()+" Data "+dados.getDataCriacao().replaceAll("/", "-")+".pdf";
            JOptionPane.showMessageDialog(null,"Arquivo salvo: "+ nomeDocumento);
            PdfWriter escrever = PdfWriter.getInstance(documento, new FileOutputStream(nomeDocumento));

            documento.setPageSize(PageSize.A4.rotate());
            documento.setMargins(10, 2, 10, 2);
            documento.open();
            BG(escrever, TelaInicial);
            fonteBranca.setColor(BaseColor.WHITE);

            documento.add(Texto("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n     "
                    + "      Cliente: " + dados.getCliente()
                    + "\n\n           Data: " + dados.getDataCriacao()
                    + "\n\n           Objetivo:"
                    + "\n\n           Apresentar todas as ações realizadas que detinham um"
                    + "\n\n           único objetivo de recuperar a carga sinistrada.", fonteBranca, false));
            documento.newPage();
            BG(escrever, Tela1);
            documento.newPage();
            BG(escrever, Tela2);
            documento.newPage();
            BG(escrever, dadosSinistro);
            fontePadrao.setSize(21);
            fontePadrao.setStyle(Font.BOLD);

            documento.add(Texto("\n\n\n\n\n\n\n\nDADOS SINISTRO", fontePadrao, true));
            fontePadrao.setSize(16);
//            documento.add(Texto("\n\n\n    DATA DO SINISTRO : "+Texto(dados.getDataCriacao(), fonteBranca, false)
//                    + "\n    HORARIO QUE FOMOS ACIONADOS : "+dados.getHoraOcorrencia()
//                    + "\n    REGIAO DO SINISTRO : "+dados.getCidade()
//                    + "\n    VEICULO SINISTRADO : "+dados.getPlaca()
//                    + "\n    MODELO : "+dados.getModelo()
//                    + "\n    COR : "+dados.getCor()
//                    + "\n    MOTORISTA : "+dados.getNomeCondutor()
//                    + "\n    ISCA : "+dados.getIsca()
//                    + "\n    INFORMACOES RECEBIDAS :\n  "+dados.getDescricao(), fontePadrao, false));
            String str = String.valueOf(Texto("\n    DATA DO SINISTRO :", fontePadrao, false));
            fontePadrao2.setSize(16);

            documento.add(juntaFontes("\n    DATA DO SINISTRO :", fontePadrao, dados.getDataCriacao(), fontePadrao2));
            documento.add(juntaFontes("\n    HORARIO QUE FOMOS ACIONADOS : ", fontePadrao, dados.HoraOcorrencia, fontePadrao2));
            documento.add(juntaFontes("\n    REGIAO DO SINISTRO : ", fontePadrao, dados.getCidade(), fontePadrao2));
            documento.add(juntaFontes("\n    VEICULO SINISTRADO : ", fontePadrao, dados.getPlaca(), fontePadrao2));
            documento.add(juntaFontes("\n    MODELO : ", fontePadrao, dados.getModelo(), fontePadrao2));
            documento.add(juntaFontes("\n    COR : ", fontePadrao, dados.getCor(), fontePadrao2));
            documento.add(juntaFontes("\n    MOTORISTA : ", fontePadrao, dados.getNomeCondutor(), fontePadrao2));
            documento.add(juntaFontes("\n    ISCA : ", fontePadrao, String.valueOf(dados.getIsca()), fontePadrao2));
            documento.add(Texto("\n    INFORMACOES RECEBIDAS :\n  ", fontePadrao, false));
            documento.add(Texto("   " + dados.getDescricao(), fontePadrao2, false));
            documento.newPage();
            //////// dados acionamento /////////////
            /// tem que terminar 
            BG(escrever, padrao);
            documento.add(Texto("\n\n\n\n\n\n\n\nDADOS SINISTRO\n\n\n", fontePadrao, true));
            PdfPTable tabela = new PdfPTable(6);
            float[] colunas = {10, 10, 10, 10, 10, 30};
            tabela.setWidths(colunas);
            fonteTitulo.setSize(20);
            PdfPCell titulo = new PdfPCell(new Phrase("Sinistro " + dados.getCliente() + " Dia:" + dados.dataCriacao,fonteTitulo));
            titulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
            titulo.setColspan(6);
            tabela.addCell(titulo);
            
            PdfPCell Antenista = new PdfPCell(new Phrase("Antenista"));
            PdfPCell HoraInicio = new PdfPCell(new Phrase("Hora Inicio"));
            PdfPCell HoraFim = new PdfPCell(new Phrase("Hora Fim"));
            PdfPCell Totalhoras = new PdfPCell(new Phrase("Total horas"));
            PdfPCell TotalKM = new PdfPCell(new Phrase("Total KM"));
            PdfPCell varredura = new PdfPCell(new Phrase("Regioes de varredura"));
            Antenista.setHorizontalAlignment(Element.ALIGN_CENTER);
            Antenista.setVerticalAlignment(Element.ALIGN_MIDDLE);
            HoraInicio.setHorizontalAlignment(Element.ALIGN_CENTER);
            HoraInicio.setVerticalAlignment(Element.ALIGN_MIDDLE);
            HoraFim.setHorizontalAlignment(Element.ALIGN_CENTER);
            HoraFim.setVerticalAlignment(Element.ALIGN_MIDDLE);
            Totalhoras.setHorizontalAlignment(Element.ALIGN_CENTER);
            Totalhoras.setVerticalAlignment(Element.ALIGN_MIDDLE);
            TotalKM.setHorizontalAlignment(Element.ALIGN_CENTER);
            TotalKM.setVerticalAlignment(Element.ALIGN_MIDDLE);
            varredura.setHorizontalAlignment(Element.ALIGN_CENTER);
            varredura.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            tabela.addCell(Antenista);
            tabela.addCell(HoraInicio);
            tabela.addCell(HoraFim);
            tabela.addCell(Totalhoras);
            tabela.addCell(TotalKM);
            tabela.addCell(varredura);
            for (int i = 0; i < agente.size(); i++) {
                LocalTime horaInicio = LocalTime.of(Integer.valueOf(agente.get(i).getHoraInicio().substring(0, 2).trim()), Integer.valueOf(agente.get(i).getHoraInicio().substring(3, 5).trim()));
                LocalTime horaFim = LocalTime.of(Integer.valueOf(agente.get(i).getHoraFim().substring(0, 2).trim()), Integer.valueOf(agente.get(i).getHoraFim().substring(3, 5).trim()));
                LocalTime resp = horaFim.minusHours(horaInicio.getHour());
       //         resp = horaFim.minusMinutes(horaInicio.getMinute());
                 
                
                PdfPCell nome = new PdfPCell(new Phrase(agente.get(i).getNome()));
                PdfPCell getHoraInicio = new PdfPCell(new Phrase(agente.get(i).getHoraInicio()));
                PdfPCell getHoraFim = new PdfPCell(new Phrase(agente.get(i).getHoraFim()));
                PdfPCell totalHoras = new PdfPCell(new Phrase(String.valueOf(resp)));
                PdfPCell TotalKMa = new PdfPCell(new Phrase(String.valueOf(agente.get(i).getTotalKM())));
                PdfPCell Varredura = new PdfPCell(new Phrase(agente.get(i).getVarredura()));
                nome.setHorizontalAlignment(Element.ALIGN_CENTER);
                nome.setVerticalAlignment(Element.ALIGN_MIDDLE);
                getHoraInicio.setHorizontalAlignment(Element.ALIGN_CENTER);
                 getHoraInicio.setVerticalAlignment(Element.ALIGN_MIDDLE);
                 getHoraFim.setHorizontalAlignment(Element.ALIGN_CENTER);
                getHoraFim.setVerticalAlignment(Element.ALIGN_MIDDLE);
                totalHoras.setHorizontalAlignment(Element.ALIGN_CENTER);
                totalHoras.setVerticalAlignment(Element.ALIGN_MIDDLE);
                TotalKMa.setHorizontalAlignment(Element.ALIGN_CENTER);
                TotalKMa.setVerticalAlignment(Element.ALIGN_MIDDLE);
                Varredura.setHorizontalAlignment(Element.ALIGN_CENTER);
                Varredura.setVerticalAlignment(Element.ALIGN_MIDDLE);
                 
                 
                tabela.addCell(nome);
                tabela.addCell(getHoraInicio);
                tabela.addCell(getHoraFim);
                tabela.addCell(totalHoras);
                tabela.addCell(TotalKMa);
                tabela.addCell(Varredura);
                
                
                
                
                
                
                
                
                
            }

            documento.add(tabela);
            
                
             
            
            for (int i = 0; i < agente.size(); i++) {
                /////////////////// tem quer terminar /////////////////
                
                documento.newPage();
                fonteTitulo.setSize(30);
                documento.add(HistoricoAcionamento(escrever, padrao, i));
                documento.add(juntaFontes("\n\n Equipe :", fontePadrao, agente.get(i).getNome(), fontePadrao2));
                documento.add(juntaFontes("\n Regiao :", fontePadrao, dados.getCidade(), fontePadrao2));
                documento.add(juntaFontes("\n Motivo :", fontePadrao, dados.getTipoOcorrencia(), fontePadrao2));
                documento.add(juntaFontes("\n Isca :", fontePadrao, String.valueOf(dados.getIsca()), fontePadrao2));
                documento.add(juntaFontes("\n Horario de Acionamento :", fontePadrao, agente.get(i).getHoraInicio(), fontePadrao2));
                documento.add(juntaFontes("\n Horario do termino do acionamento", fontePadrao, agente.get(i).getHoraFim(), fontePadrao2));
                documento.add(Texto("\n Acoes Realizadas :\n\n", fontePadrao, false));
                documento.add(Texto(agente.get(i).getTimeLine(), fontePadrao2, false));
               for (Image imagen : agente.get(i).getImagens()) 
                    {
                        if(imagen.getWidth()<imagen.getHeight())
                        {
                            listaRetrato.add(imagen);
                        }else
                        {
                             listaPaisagem.add(imagen);
                        }
                    }
                
                
                int TamanhoPaisagem = listaPaisagem.size();
                int TamanhoRetrato = listaRetrato.size();
                
                
               if(TamanhoRetrato != 0)
               {
                   documento.newPage();
                documento.add(HistoricoAcionamento(escrever, padrao, i));
                for (int j = TamanhoRetrato; j > 0; j--) 
                {
                    if (TamanhoRetrato > 5) 
                    {
                        ImgTelaRetrato(escrever, 5, i);
                        TamanhoRetrato -= 5;

                        documento.newPage();
                        documento.add(HistoricoAcionamento(escrever, padrao, i));
                    } else 
                    {
                        ImgTelaRetrato(escrever, TamanhoRetrato, i);
                        j =0;
                    }  
                }
                   
               }     
               if(TamanhoPaisagem != 0){
                documento.newPage();
                documento.add(HistoricoAcionamento(escrever, padrao, i));
                for (int j = TamanhoPaisagem; j > 0; j--) 
                {
                    if (TamanhoPaisagem > 6) 
                    {
                        ImgTelaPaisagem(escrever, 6, i);
                        TamanhoPaisagem -= 6;

                        documento.newPage();
                        documento.add(HistoricoAcionamento(escrever, padrao, i));
                    } else 
                    {
                        ImgTelaPaisagem(escrever, TamanhoPaisagem, i);
                        j=0;
                    }  
                }
                   
               }     
                
                
            }
            documento.newPage();
            BG(escrever, TelaFinal);
            Desktop.getDesktop().open(new File(nomeDocumento));

        } catch (BadElementException | IOException e) {
            System.out.println("erro nas imagens ou documento " + e.getMessage());

        } catch (DocumentException ex) {
            Logger.getLogger(GerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            documento.close();
        }
    }
    public static void main(String[] args) {
        List<Missao> a = new ArrayList<Missao>();
        GerarPDF pdf = new GerarPDF();
    }

}
