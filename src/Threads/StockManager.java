/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RALedesma
 */
public class StockManager
{
    public static void main(String[] args)
    {
        System.out.println("We are going to count the products in the warehouse");
//        System.out.println();
        System.out.println("There are 20 products in the warehouse to start with!");
//        System.out.println();

        StockManager warehouse = new StockManager(20);

        Runnable productEnter = warehouse.new Enter();

        Runnable productExit = warehouse.new Exit();

        Thread thread1 = new Thread(productEnter);
        Thread thread2 = new Thread(productExit);

        thread1.start();
        thread2.start();

    }

    public StockManager(int initialCarCount)
    {
        counter = initialCarCount;
    }

    public int counter;

    public class Enter implements Runnable
    {
        public Enter()
        {

        }

        public int increaseProductCount()
        {
            return ++counter;
        }

        public void run()
        {
            while (counter < 50)
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StockManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("One product entered the warehouse now there are " + increaseProductCount());
                
            }
        }
    }

    public class Exit implements Runnable
    {
        public Exit()
        {

        }

        public int  decreaseProductCount()
        {
            return --counter;
        }

        public void run()
        {
            
            while (counter > 0)
            {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StockManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("One product left the warehouse now there are " + decreaseProductCount());
            }
        }

    }
}
