/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT360_Hibernate;

import java.sql.*;
import java.util.Calendar;
import org.hibernate.Session;

/**
 *
 * @author RALedesma
 */
public class NewActor {
       public static void main(String[] args)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        //Add new Employee object
        Actor actor = new Actor();
        actor.setFirstName("Ricardo");
        actor.setLastName("Ledesma");
//        actor.lastUpdate("gupta");
         
        //Save the employee in database
        session.save(actor);
 
        //Commit the transaction
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
