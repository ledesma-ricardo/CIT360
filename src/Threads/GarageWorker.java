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
public class GarageWorker
{
    public static void main(String[] args)
    {
        System.out.println("We are going to count the vehicles in the garage");
//        System.out.println();
        System.out.println("There are 50 vehicles in the garage to start with!");
//        System.out.println();

        GarageWorker garage = new GarageWorker(50);

        Runnable vehicleEnter = garage.new Enter();

        Runnable vehicleExit = garage.new Exit();

        Thread thread1 = new Thread(vehicleEnter);
        Thread thread2 = new Thread(vehicleExit);

        thread1.start();
        thread2.start();

    }

    public GarageWorker(int initialCarCount)
    {
        counter = initialCarCount;
    }

    public int counter;

    public class Enter implements Runnable
    {
        public Enter()
        {

        }

        public int increaseVehicleCount()
        {
            return ++counter;
        }

        public void run()
        {
            while (counter < 100)
            {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GarageWorker.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("One vehicle entered the garage now there are " + increaseVehicleCount());
                
            }
        }
    }

    public class Exit implements Runnable
    {
        public Exit()
        {

        }

        public int  decreaseVehicleCount()
        {
            return --counter;
        }

        public void run()
        {
            
            while (counter > 0)
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GarageWorker.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("One vehicle left the garage now there are " + decreaseVehicleCount());
            }
        }

    }
}