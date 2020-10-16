/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author rafa_
 */
public class Mascara {
    
    public static DefaultFormatterFactory getData(){
        MaskFormatter mask =null;
        try{
            mask = new MaskFormatter("##/##/####");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException e){
            return null;
        }
        return (new DefaultFormatterFactory(mask, mask));
    }
    public static MaskFormatter getTelefone(){
        MaskFormatter mask=null;
        try{
            mask = new MaskFormatter("(##)#.####-####");
            mask.setValidCharacters("0123456789");
           
        } catch (ParseException ex) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mask;
    }
    public static MaskFormatter getHora(){
        MaskFormatter mask = null;
        try {
             mask = new MaskFormatter("##:##");
             mask.setValidCharacters("0123456789");
        } catch (ParseException ex) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mask;
    }
    public static MaskFormatter getPlaca(){
        MaskFormatter mask =null;
        try {
            mask = new MaskFormatter("UUU-#*##");
        } catch (ParseException ex) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mask;
    }
    public static MaskFormatter getcpf(){
        MaskFormatter mask =null;
        try {
            mask = new MaskFormatter("###.###.###-##");
        } catch (ParseException ex) {
            Logger.getLogger(Mascara.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mask;
    }
    
}
