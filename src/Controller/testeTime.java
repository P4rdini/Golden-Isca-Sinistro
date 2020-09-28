/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.time.LocalTime;
import jxl.write.DateTime;

/**
 *
 * @author rafa_
 */
public class testeTime {
    public static void main(String[] args) {
        String str ="12:26";
        String str2 ="16:35";
        LocalTime horaInicio  = LocalTime.of(Integer.valueOf(str.substring(0, 2).trim()), Integer.valueOf(str.substring(3, 5).trim()));
                LocalTime horaFim =LocalTime.of(Integer.valueOf(str2.substring(0, 2).trim()), Integer.valueOf(str2.substring(3, 5).trim()));
                LocalTime resp = horaFim.minusHours(horaInicio.getHour());
        System.out.println(resp);
        
    }
}
