
import DAO.IscaDAO;
import Model.Isca;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafa_
 */
public class Importacao_BD {
    public static void main(String[] args) {
        
   
               
                    
                    
                    
                    
                    
                    //     FileInputStream clientes = null;
                    
                    
                    
                    try {
                    FileInputStream planilha = null;
                    //    try {
                    File file = new File("C:\\Users\\rafa_\\OneDrive\\Documentos\\NetBeansProjects\\Isca\\test\\1semestre.xlsx");
                    
                    
                    
                        //7832
                        planilha = new FileInputStream(file);
                    XSSFWorkbook workbook = new XSSFWorkbook(planilha);
                    XSSFSheet sheet = workbook.getSheetAt(0);
                    Iterator<Row> rowIterator = sheet.iterator();
                        ArrayList<Row> row = new ArrayList<Row>();
                        
                    ArrayList<Isca> listaIsca = new ArrayList<Isca>();
                        SimpleDateFormat modelo = new SimpleDateFormat("dd/MM/yyyy");
                        String dataCricao = new String();
                        Date dataAtivacao = new Date();
                        dataAtivacao = null;
                    for(int i =0 ; i<5160 ; i++){
                        
                        row.add(rowIterator.next());
                     //   dataCricao = Isca.modeloData(row.get(i).getCell(0).getDateCellValue());
                        String cliente =new String();
//                        if(row.get(i).getCell(1).getStringCellValue().equals(null)){
  //                          cliente=" ";
    //                    }else{
                      
                            if (row.get(i).getCell(0).getStringCellValue() == null){
                                cliente = " ";
                            }else{
                                
                            cliente = row.get(i).getCell(0).getStringCellValue();
                            }
                       
                            String id = new String();
                            System.out.println(row.get(i).getCell(1).getCellType());
      //                  }
                   //    String cliente = new String(row.get(i).getCell(1).getStringCellValue().);
                     
                     //   id = new BigDecimal(row.get(i).getCell(1).getStringCellValue()).toPlainString();
                     if(row.get(i).getCell(1).getCellType() == CellType.STRING){
                        id = row.get(i).getCell(1).getStringCellValue().trim();
                     }else{
                          id = new BigDecimal(row.get(i).getCell(1).getNumericCellValue()).toPlainString();
                     }
                    
                        
                        String plano;
                       if(row.get(i).getCell(2).getCellType() == CellType.NUMERIC){
                            plano = String.valueOf(row.get(i).getCell(2).getNumericCellValue());
                        }else{
                           plano = row.get(i).getCell(2).getStringCellValue();
                        }
                       // String plano = new String(row.get(i).getCell(3).getStringCellValue());
                       String iccid = new String();
                        if(row.get(i).getCell(3).getCellType() == CellType.STRING){
                            iccid = row.get(i).getCell(3).getStringCellValue();
                        }else{
                         
                            
                       iccid = new BigDecimal(row.get(i).getCell(3).getNumericCellValue()).toPlainString();
                        }
                       String operadora ;
                       if(row.get(i).getCell(4).getStringCellValue().equals(null)){
                           operadora = " ";
                       }else{
                           operadora = row.get(i).getCell(4).getStringCellValue();
                       }
                   //    String operadora = new String(row.get(i).getCell(5).getStringCellValue());
                       
                       
                       try{
                       dataAtivacao = row.get(i).getCell(6).getDateCellValue();
                           
                       }catch(NullPointerException e){
                           dataAtivacao = null;
                       }
                       
                       Isca isca = new Isca(true,Integer.valueOf(id), iccid, cliente, null, operadora, plano, dataCricao);
                       
                       IscaDAO dao = new IscaDAO();
                       if(dao.create(isca) != 0){
                           System.out.println("salvo");
                       }else{
                           System.out.println("nao");
                       }
                     //   System.out.println(isca.toString());
                        
                    } } catch (FileNotFoundException ex) {
                        Logger.getLogger(Importacao_BD.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Importacao_BD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
}

  
   
    }

