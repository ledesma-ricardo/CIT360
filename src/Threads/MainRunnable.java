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
public class MainRunnable implements Runnable{
	
	private Client client;
	private Casher casher;
	private long initialTime;
	
	public MainRunnable (Client client, Casher casher, long initialTime){
		this.casher = casher;
		this.client = client;
		this.initialTime = initialTime;
	}

	public static void main(String[] args) {
		
		Client client1 = new Client("Client 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Client client2 = new Client("Client 2", new int[] { 1, 3, 5, 1, 1 });
		
		Casher casher1 = new Casher("Casher 1");
		Casher casher2 = new Casher("Casher 2");
		
		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		
		Runnable process1 = new MainRunnable(client1, casher1, initialTime);
		Runnable process2 = new MainRunnable(client2, casher2, initialTime);
		
		new Thread(process1).start();
		new Thread(process2).start();

	}

	@Override
	public void run() {
		this.casher.processPurchase(this.client, this.initialTime);
	}
    
}
