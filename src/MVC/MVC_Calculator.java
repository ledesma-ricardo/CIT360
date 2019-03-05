/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;



/**
 *
 * @author RALedesma
 */
public class MVC_Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CalculatorModel mod = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        
        CalculatorController ctrl = new CalculatorController(view, mod);
        ctrl.star();
        view.setVisible(true);
        
    }
    
}
