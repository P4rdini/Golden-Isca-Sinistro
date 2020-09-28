/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;
import java.io.File;
import java.io.InputStream;


/**
 *
 * @author rafa_
 */
public class TestePDFusandoModelo {
    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\rafa_\\OneDrive\\Documentos\\Projeto_Golden\\RelatorioModelo.pdf");
        File outputFile = new File("C:\\Users\\rafa_\\OneDrive\\Documentos\\Projeto_Golden\\MODIFICADO.pdf");
        
        
     //   PdfDocument documento = new PdfDocument(new PdfReader(inputFile), new PdfWriter(outputFile));
        
    }
}
