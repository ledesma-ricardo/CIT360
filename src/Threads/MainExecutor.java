/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author RALedesma
 */
public class MainExecutor {
    private static final int numCashiers = 2;

    public static void main(String[] args) {

        ArrayList<Client>clients = new ArrayList<Client>();
        clients.add(new Client("Client 1", new int[] { 2, 2, 1, 5, 2 })); // 12 Seg
        clients.add(new Client("Client 2", new int[] { 1, 1, 5, 1, 1 })); //  9 Seg
        clients.add(new Client("Client 3", new int[] { 5, 3, 1, 5, 2 })); // 16 Seg
        clients.add(new Client("Client 4", new int[] { 2, 4, 3, 2, 5 })); // 16 Seg
        clients.add(new Client("Client 5", new int[] { 1, 3, 2, 2, 3 })); // 11 Seg
        clients.add(new Client("Client 6", new int[] { 4, 2, 1, 3, 1 })); // 11 Seg
        clients.add(new Client("Client 7", new int[] { 3, 3, 2, 4, 7 })); // 19 Seg
        clients.add(new Client("Client 8", new int[] { 6, 1, 3, 1, 3 })); // 14 Seg
        // Total time to process all orders = 108 seconds
        
        // Initial processing moment
        long init = System.currentTimeMillis(); 
        
        ExecutorService executor = Executors.newFixedThreadPool(numCashiers);
        for (Client client: clients) {
            Runnable casher = new CasherRunnable(client, init);
            executor.execute(casher);
        }
        // close the Executor
        executor.shutdown();	
        while (!executor.isTerminated()) {
        	
        }
        // Final processing moment
        long fin = System.currentTimeMillis();
        System.out.println("Total processing time: "+(fin-init)/1000+" Seconds");
    }
}
