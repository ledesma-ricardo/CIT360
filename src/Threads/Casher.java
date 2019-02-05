/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

/**
 *
 * @author RALedesma
 */



	// Constructor, getter and setter

        public class Casher {

            private String name;

            public Casher(String name) {
                this.name = name;
            }

	public void processPurchase(Client client, long timeStamp) {

		System.out.println("The cashier " + this.name + 
				" BEGINS TO PROCESS THE CUSTOMER'S PURCHASE " + client.getName() + 
				" IN THE TIME: " + (System.currentTimeMillis() - timeStamp) / 1000	+
				"seg");

		for (int i = 0; i < client.getShoppingCart().length; i++) { 
				this.esperarXseconds(client.getShoppingCart()[i]); 
				System.out.println("Processed the product " + (i + 1) +  
				" ->Time: " + (System.currentTimeMillis() - timeStamp) / 1000 + 
				"seg");
		}

		System.out.println("The cashier " + this.name + " HAS FINISHED PROCESSING " + 
				client.getName() + " IN THE TIME: " + 
				(System.currentTimeMillis() - timeStamp) / 1000 + "seg");

	}


	private void esperarXseconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
