/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author RAledesma
 */
public class ValidateData {

 
        public static boolean ValidatePhone( String txt){ 
        return txt.matches("[0-9]{1,10}");
    }
                public static boolean ValidateAge( String txt){ 
        return txt.matches("[0-9]{1,2}");
    }

}
