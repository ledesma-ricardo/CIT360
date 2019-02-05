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
public class Main {
    public static void main(String[] args) {

		Client client1 = new Client("Client 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Client client2 = new Client("Client 2", new int[] { 1, 3, 5, 1, 1 });

		Casher casher1 = new Casher("Casher 1");
		Casher casher2 = new Casher("Casher 2");

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();

		casher1.processPurchase(client1, initialTime);
		casher2.processPurchase(client2, initialTime);
	}
}
