/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Agente;
import Model.GerarPDF;
import Model.Sinistro;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
/**
 *
 * @author Quality
 */
public class teste {
   
    
    public static void main(String[] args) {
        
       
            //
//        int tela=0;
//         JFrame jfTelaSec = new JFrame();
//        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        GraphicsDevice[] devices = ge.getScreenDevices();
//        for (int i = 0; i < devices.length && tela < 0; i++) {
//            tela=i;
//            System.out.println(tela);
//        }
//        if (tela < 0) {
//            System.out.println("nenhum monitor");
//        } else {
//            
//            devices[tela].setFullScreenWindow(jfTelaSec);
//            int width = jfTelaSec.getWidth();
//            int height = jfTelaSec.getHeight();
//            int xx = (int) jfTelaSec.getLocation().getX();
//            int yy = (int) jfTelaSec.getLocation().getY();
//            devices[tela].setFullScreenWindow(null);
//            jfTelaSec.setSize(width, height);
//            jfTelaSec.setLocation(xx, yy);
//            jfTelaSec.setVisible(true);
//        }
//        IscaDAO dao = new IscaDAO();
//        List<Isca> lista = dao.read();
//        List<Isca> listaAtiva = new ArrayList<Isca>();
//        List<Isca> listaCancelar = new ArrayList<Isca>();
//        
//        for (int i=0;i<lista.size();i++)
//        {
//            String status;
//            if (lista.get(i).isStatus())
//            {
//                
//                listaAtiva.add(lista.get(i));
//            }
//          
//        }
//        SimpleDateFormat padrao = new SimpleDateFormat("dd/MM/yyyy");
//        for(int i =0 ; i<listaAtiva.size();i++)
//        {
//            
//           try {
//               Date data  = padrao.parse(listaAtiva.get(i).getDataAtivacao());
//               GregorianCalendar condicional = new GregorianCalendar();
//               
//               condicional.add(Calendar.DAY_OF_MONTH, -31);
//               
//                if (condicional.getTime().getTime()> data.getTime()){
//                    listaCancelar.add(listaAtiva.get(i));
//                }
//               
//           } catch (ParseException ex) {
//               Logger.getLogger(Isca.class.getName()).log(Level.SEVERE, null, ex);
//           }
//        }
//        for(int i=0;i<listaCancelar.size();i++){
//            
//        System.out.println(listaCancelar.get(i).getDataAtivacao());
//        }
//    }
//   System.out.println(javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory());
//    String teste = "11:30";
//        LocalTime horaInicio = LocalTime.of(Integer.valueOf(teste.substring(0, 2)),Integer.valueOf(teste.substring(3, 5)));
//        LocalTime horaFim = LocalTime.of(15, 00);
//        LocalTime resp = horaFim.minusHours(horaInicio.getHour());
//        resp = horaFim.minusMinutes(horaInicio.getMinute());
//        String str = String.valueOf(resp);
//      //  hora.minusMinutes(10);
//        System.out.println(horaInicio);
//          
      //  "jar:file:/"
//            String nomejar="jar:file:/" ;
//           // nomejar = new java.io.File(Isca.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getName();
//            nomejar += new java.io.File(Isca.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getName().toString();
//            String teste = System.getProperty("user.dir");
//        String className = "/"+Isca.class.getName().replace('.','/' )+".class";
//        String className2 = "/"+Isca.class.getName();
//        URL u = Isca.class.getResource(className);
//        String s = "jar:"+u.toString()+".jar!/";
//       
//            System.out.println(className2.toString());






            Sinistro sinistro = new Sinistro();
            Agente agente = new Agente();
            List<Agente> lista = new ArrayList<Agente>();
            List<Image> listaImg = new ArrayList<Image>();
            sinistro = sinistro.bucarSinistro(16);
            agente.setHoraChegada("11:30");
            agente.setHoraFim("11:20");
            agente.setHoraInicio("12:34");
            agente.setNome("Patrick");
            agente.setPlaca("hgf-4566");
            agente.setTotalKM(100);
            
            Image img;
        try {
            img = Image.getInstance("C:\\Users\\rafa_\\OneDrive\\Imagens\\i3.jpg");
            Image img2 = Image.getInstance("C:\\Users\\rafa_\\OneDrive\\Imagens\\i.jpg");
            Image img5 = Image.getInstance("C:\\Users\\rafa_\\OneDrive\\Imagens\\i.jpg");
            Image img3 = Image.getInstance("C:\\Users\\rafa_\\OneDrive\\Imagens\\i2.png");
            Image img4 = Image.getInstance("C:\\Users\\rafa_\\OneDrive\\Imagens\\i2.png");
            Image paisagem = Image.getInstance("C:\\Users\\rafa_\\OneDrive\\Imagens\\bolsonario.jpg");
            Image paisagem2 = Image.getInstance("C:\\Users\\rafa_\\OneDrive\\Imagens\\emma.png");
            Image paisagem3 = Image.getInstance("C:\\Users\\rafa_\\OneDrive\\Imagens\\Dali.gif");
            
//            
//           listaImg.add(paisagem);
//           listaImg.add(paisagem2);
//            listaImg.add(paisagem3);
              listaImg.add(img5);
              listaImg.add(img4);
              listaImg.add(img3);
            listaImg.add(img2);
            listaImg.add(img);
            agente.setImagens(listaImg);
            agente.setTimeLine("lasjdlfkjsadklfsdkal asdkf jklasd kjalsdjflsajd asdf ljljsa ldfja lj");
            lista.add(agente)   ;
            GerarPDF pdf = new GerarPDF(sinistro, lista);
        } catch (BadElementException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }

           
        }
    
}