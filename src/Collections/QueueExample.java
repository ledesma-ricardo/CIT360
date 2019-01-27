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
public class QueueExample {
   public static void main(String[] args) 
  { 
    Queue<Integer> q = new LinkedList<>(); 
  
    // Adding elements {0, 1, 2, 3, 4} to the queue 
    for (int i=0; i<5; i++) 
     q.add(i); 
  
   // Display contents of the queue. 
    System.out.println("Elements of queue-"+q); 
  
   // Removing the head of queue. 
    int removedele = q.remove(); 
    System.out.println("removed element-" + removedele); 
  
    System.out.println(q); 
  
   // Viewing the head of queue 
    int head = q.peek(); 
    System.out.println("head of queue-" + head); 
  
   // Rest all methods of collection interface, 
   // Like size and contains can be used with this 
   // implementation. 
    int size = q.size(); 
    System.out.println("Size of queue-" + size); 
  } 
}
