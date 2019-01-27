/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author rledesma
 */
public class MapExample {
    public static void main(String[] args) {
        
       // Creating a HashMap
        
        Map sons = new HashMap();
        
       // Adding new key-value pairs to a HashMap
        sons.put("Albert", "5 years old");
        sons.put("Bemely", "10 years old");
        sons.put("Richard", "14 years old");
        sons.put("Aris", "15 years old");
       
       
       // Printing out the HashMap
        System.out.println("I have " + sons.size() + " sons and they are:");
        
        // Printing out a my sons name and their ages.
        for(Object key: sons.keySet())
        System.out.println(" - " + key + " is " + sons.get(key));
        System.out.println();

        
        //Tree Map
      // Creating a TreeMap
      TreeMap RappersAccount = new TreeMap();
      
      // Put elements to the map
        RappersAccount.put("Dr. Dree", new Double(5023587.34));
        RappersAccount.put("Eminem", new Double(4685321.22));
        RappersAccount.put("Jay Z", new Double(852321.00));
        RappersAccount.put("Drake", new Double(3850.00));
        RappersAccount.put("Ice Cube", new Double(-19.08));
      
      
     // Get a set of the entries
      Set set = RappersAccount.entrySet();
     // Get an iterator
      Iterator i = set.iterator();
     // Loop to Display elements
      System.out.println("Top Rappers Account Balance:");
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(" - " + me.getKey() + ": ");
         System.out.println(me.getValue());
      }
      System.out.println();
     // Deposit 1000 into Drake's account
      double balance = ((Double)RappersAccount.get("Drake")).doubleValue();
      RappersAccount.put("Drake", new Double(balance + 1000));
      System.out.println("Drake's new balance: " +
      RappersAccount.get("Drake"));
        
    }
   
}
