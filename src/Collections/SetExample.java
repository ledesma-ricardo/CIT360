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
     int count[] = {24,20,5,54,45,20};
     Set<Integer> set = new HashSet<>();
     try{
        for(int i = 0; i<5; i++){
           set.add(count[i]);
        }
        System.out.println(set);
  
        TreeSet<Integer> sortedSet = new TreeSet<>(set);
        System.out.println("Sorted list is:"+" "+ sortedSet);
      

        System.out.println("The First number is : "+
                sortedSet.first());
        
        
        System.out.println("The last last number is: "+
                sortedSet.last());
     }
     catch(Exception e){}
  }
} 
    

