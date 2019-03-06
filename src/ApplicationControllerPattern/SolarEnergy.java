/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACP;
import java.text.NumberFormat;
import java.util.HashMap;

/**
 *
 * @author RALedesma
 */
public class SolarEnergy implements ACPhandler{
    public void handleIt(HashMap data)  {

        try {

            HashMap d1 = data;

            System.out.println("Good Choice!");
            HashMap d2 = (HashMap) data;
            int numberAmount = (Integer) d2.get("amount");
            double totalAmount = numberAmount * (Double) d2.get("solarPrice");

            System.out.println();

            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            System.out.println("It will cost you " + formatter.format(totalAmount) + " per year until your system is paid" +
                    " off and then your energy will be free.");

            System.out.println("");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
