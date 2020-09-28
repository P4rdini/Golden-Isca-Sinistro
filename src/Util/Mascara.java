/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.ParseException;
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
    
}
