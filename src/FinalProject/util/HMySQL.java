package util;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author RAledesma
 */
public class HMySQL {

    // Establish Connection between Hibernate and MySQL
    private SessionFactory sf = HibernateUtil.getSessionFactory();

    public HMySQL() {
    }

    // Method to verify if the user and password exists in the DB
    public boolean VerifyLogin(String hql) {
        boolean bnd = false;
        try {
            if (queryObject(hql) != null) {
                bnd = true;
            }
        } catch (Exception e) {
            System.err.println("SQL injection");
        }
        return bnd;
    }

    public Object queryObject(String hql) {
        Session sesion = sf.openSession();
        Query qry = sesion.createQuery(hql);
        List objectsDB = qry.list();
        sesion.close();
        return (objectsDB.isEmpty() ? null : objectsDB.get(0));
    }

    public List queryObjects(String hql) {
        List list = null;
        Session sesion = null;
        try {
            sesion = sf.openSession();
            Query qry = sesion.createQuery(hql);
            list = qry.list();
            sesion.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean executeTransaction(Object o, Class c, int action) {
        boolean bnd = false;
        Session sesion = null;
        Transaction tx = null;

        try {
            sesion = sf.openSession();
            tx = sesion.beginTransaction();

            switch (action) {
                case 1:
                    sesion.save(c.cast(o));
                    sesion.flush();
                    break;
                case 2:
                    sesion.update(c.cast(o));
                    sesion.flush();
                    break;
                case 4:
                    sesion.delete(c.cast(o));
                    sesion.flush();
                    break;
            }
            tx.commit();
            bnd = true;

        } catch (Exception e) {
            if (tx != null) {
                try {
                    tx.rollback();
                } catch (Exception e2) {
                    System.err.println("error (1):\n" + e2);
                }
            }
            System.err.println("error(2):\n" + e);
        } finally {
            sesion.close();
        }
        return bnd;
    }
}
