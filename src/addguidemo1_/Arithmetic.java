/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addguidemo1_;

import java.math.BigDecimal;
import javax.swing.JLabel;

/**
 *
 * @author jsj
 */
public class Arithmetic {
    /**
     * 
     * @param d1
     * @param d2
     * @return 
     */
    public static double add(double d1,double d2){ 
        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
        return bd1.add(bd2).doubleValue(); 
    }
     
     /**
      * 
      * @param d1
      * @param d2
      * @return 
      */
    public static double subtract(double d1,double d2){ 
        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
        return bd1.subtract(bd2).doubleValue(); 
    }
    
    /**
     * 
     * @param d1
     * @param d2
     * @return 
     */
    public static double multiply(double d1,double d2){ 
        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
        return bd1.multiply(bd2).doubleValue(); 
    }
    
    /**
     * 
     * @param d1
     * @param d2
     * @param statusBar
     * @return 
     */
    public static double divide(double d1,double d2, JLabel statusBar) throws ArithmeticException {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
        BigDecimal bd3;
        try {
            bd3 = bd1.divide(bd2, 6, BigDecimal.ROUND_HALF_UP); 
        } catch (ArithmeticException arithmeticException) {
            statusBar.setText(arithmeticException.getClass().toString());
            return Double.NaN;
        }
        return bd3.doubleValue();
    }
    
}
