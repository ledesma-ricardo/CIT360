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
public class CasherRunnable implements Runnable {
    
    private Client client;
    private long initialTime;

	public CasherRunnable(Client client, long initialTime) {
		this.client = client;
		this.initialTime = initialTime;
	}

	@Override
	public void run() {
		System.out.println("The cashier " + Thread.currentThread().getName() 
				+ " BEGINS TO PROCESS THE CUSTOMER'S PURCHASE " + this.client.getName() 
				+ " IN THE TIME: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

		for (int i = 0; i < this.client.getShoppingCart().length; i++) { 			
                    // Se procesa el pedido en X segundos 
                    this.waitBysecond(client.getShoppingCart()[i]);
               	    System.out.println("Processed the product " + (i + 1) + " of " + this.client.getName()+ 
                    "->Time: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
		}

		System.out.println("The cashier " + Thread.currentThread().getName() + " HAS FINISHED PROCESSING " 
				+ this.client.getName() + " IN THE TIME: "
				+ (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

	}

	private void waitBysecond(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
        }
    
}
