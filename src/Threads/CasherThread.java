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
public class CasherThread extends Thread {

	private String name;

	private Client client;

	private long initialTime;

    

	// Constructor, getter and setter
        
        

	public CasherThread(String name, Client client, long initialTime) {

		this.name = name;
		this.client = client;
        this.initialTime = initialTime;
	}

    @Override
    public void run() {
        System.out.println("The cashier " + this.name + " BEGINS TO PROCESS THE CUSTOMER'S PURCHASE "
                + this.client.getName() + " IN THE TIME: "
                + (System.currentTimeMillis() - this.initialTime) / 1000
                + "seg");
        
        for (int i = 0; i < this.client.getShoppingCart().length; i++) {
            this.waitBysecond(client.getShoppingCart()[i]);
            System.out.println("Processed the product " + (i + 1)
                    + " of the client " + this.client.getName() + "->Time: "
                    + (System.currentTimeMillis() - this.initialTime) / 1000
                    + "seg");
        }
        
        System.out.println("The cashier " + this.name + " HAS FINISHED PROCESSING "
                + this.client.getName() + " IN THE TIME: "
                + (System.currentTimeMillis() - this.initialTime) / 1000
                + "seg");
    }

	private void waitBysecond(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
