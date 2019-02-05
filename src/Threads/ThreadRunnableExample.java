/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360;

/**
 *
 * @author RALedesma
 */
public class ThreadRunnableExample implements Runnable {
    
    public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		ThreadRunnableExample thread1 = new ThreadRunnableExample("#19", 500);
		
		@SuppressWarnings("unused")
		ThreadRunnableExample thread2 = new ThreadRunnableExample("#17", 600);
		
		@SuppressWarnings("unused")
		ThreadRunnableExample thread3 = new ThreadRunnableExample("#42", 800);
	}

	private final String name;
	private final int time;

	public ThreadRunnableExample(String name, int time) {
		this.name = name;
		this.time = time;
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {

		try {
			for (int i=0; i<6; i++) {
				System.out.println(name + " counter " + i);

				Thread.sleep(time);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " It finished excution");
	}
}
