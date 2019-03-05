/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author RALedesma
 */
public class CalculatorController implements ActionListener {
    
        private CalculatorView View;
        private CalculatorModel Model;
        
        public CalculatorController(CalculatorView view, CalculatorModel model){
        
            this.View = view;
            this.Model = model;
            this.View.button.addActionListener(this);
              
        }
        
        public void star(){
        
            View.setTitle("MVC Multiplier");
            View.setLocationRelativeTo(null);
        }
    
        public void actionPerformed(ActionEvent e){
        
            Model.setValue1(Integer.parseInt(View.value1.getText()));
            Model.setValue2(Integer.parseInt(View.value2.getText()));
            Model.multiply();
            View.result.setText(String.valueOf(Model.getResult()));
        }


        
}
