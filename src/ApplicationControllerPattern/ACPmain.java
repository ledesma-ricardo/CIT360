/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACP;
import java.util.*;
/**
 *
 * @author RALedesma
 */
public class ACPmain {
    public static void main(String[] args) {


    Scanner input = new Scanner(System.in);

        AppController delegate = new AppController();



        delegate.handleCommand("solar", new SolarEnergy());
        delegate.handleCommand("wind", new WindEnergy());
        delegate.handleCommand("water", new WaterEnergy());

        try {

            System.out.println("This app will calculate the cost of your energy system per Kilowatt");

            System.out.println("---Types of Renewable Energies---");
            System.out.println("Solar");
            System.out.println("Wind");
            System.out.println("Water");
            System.out.println("------------");
            System.out.print("Which energy would you like to use?:");
            String command = input.nextLine();
            command = command.toLowerCase();
            System.out.print("What is your average energy use per year?:");
            int amount = input.nextInt();


            HashMap data = new HashMap();
            data.put("amount", amount);
            data.put("solarPrice", .125); //Price per Kilowatt
            data.put("windPrice", .196);
            data.put("waterPrice", .083);

            delegate.handleRequest(command, data);


        } catch (Exception e) {
            System.out.println("Please enter a correct Energy");

        }





    }
}
