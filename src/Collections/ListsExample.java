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


public class ListsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 ArrayList<String> AnimalsList = new ArrayList<>();

		  /*Adding new elements to the ArrayList*/
		  AnimalsList.add("Bull");
		  AnimalsList.add("Rabbit");
		  AnimalsList.add("Dog");
		  AnimalsList.add("Cat");
		  AnimalsList.add("Iguana");

		  /* Displaying ArrayList's Values*/
		  System.out.println("Array Created:"+AnimalsList);

		  /*Adding element at the given index*/
		  AnimalsList.add(0, "Lion");
		  AnimalsList.add(1, "Tiger");

		  /*Removing elements from tha ArrayList*/
		  AnimalsList.remove("Stuff");
		  AnimalsList.remove("Rabbit");

		  System.out.println("Current array list is:"+AnimalsList);

		  /*Removing element from the given index*/
		  AnimalsList.remove(1);

		  System.out.println("Current array list is:"+AnimalsList);

	}

}
