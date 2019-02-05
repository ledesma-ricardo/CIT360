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
public class MainThread {
    	public static void main(String[] args) {

		Client client1 = new Client("Client 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Client client2 = new Client("Client 2", new int[] { 1, 3, 5, 1, 1 });

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		CasherThread casher1 = new CasherThread("Casher 1", client1, initialTime);
		CasherThread casher2 = new CasherThread("Casher 2", client2, initialTime);

		casher1.start();
		casher2.start();
	}
}
