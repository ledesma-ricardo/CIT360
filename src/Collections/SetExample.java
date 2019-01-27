/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;
import java.util.*;

/**
 *
 * @author rledesma
 */
public class SetExample {
    
    public static void main(String args[]) { 
    
        Set<String> nbaStars = new HashSet<>();

        // Check if a HashSet is empty
        System.out.println("Is nbaStars set empty? : " + nbaStars.isEmpty());

        nbaStars.add("Lebron James");
        nbaStars.add("Kevin Durant");
        nbaStars.add("Anthony Davis");
        nbaStars.add("James Harden");

        // Find the size of a HashSet
        System.out.println("Number of NBA Stars in the HashSet " + nbaStars.size());
        // Displeying the HashSet elements
        System.out.println("NBA Stars in the HashSet are: " + nbaStars);

        // Check if the HashSet contains an element
        String cityName = "James Harden";
        if(nbaStars.contains(cityName)) {
            System.out.println(cityName + " is in the NBA Stars set.");
        } else {
            System.out.println(cityName + " is not in the NBA Stars set.");
        }
  }
} 
    

