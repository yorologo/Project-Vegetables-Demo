package com.example.demo.controller;

import com.example.demo.model.Vendedor;
import com.example.demo.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;
//import java.util.Date;
//import java.util.Locale;
//import java.text.SimpleDateFormat;


/**
 * Returns the Database Access Object (DAO) for our Vendedor class.
 */
public class VendedorDao {

   /*
   * Returns one Vendedor object or null if not found
   */
    public Vendedor getByID(Integer id) {
        Vendedor vendedor = null;
        //Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            //trans = session.beginTransaction();

            vendedor = (Vendedor) session.get(Vendedor.class, id);

            //trans.commit();
        } catch (HibernateException e) {
            //if (trans != null) { trans.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return vendedor;
    }


   /*
   * Adds a new Vendedor object and return the id
   */
    public int add(Vendedor vendedor) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        int id = 0;

        try {
            trans = session.beginTransaction();

            id = (int) session.save(vendedor);

            trans.commit();
        } catch (HibernateException e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }


   /*
   * Updates Vendedor object
   */
    public void update(Vendedor vendedor) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();

            session.update(vendedor);

            trans.commit();
        } catch (HibernateException e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


   /*
   * Deletes one Vendedor record
   */
    public boolean deleteByID(Integer id) {
        boolean deleted = false;
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();

            Vendedor vendedor = (Vendedor) session.get(Vendedor.class, id);

            if (vendedor != null) {
                session.delete(vendedor);
                trans.commit();
                deleted = true;
            }

        } catch (HibernateException e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
            deleted = false;
        } finally {
            session.close();
        }
        return deleted;
    }


   /*
   * Returns a list of Vendedor objects
   */
    public List<Vendedor> getAll() {
        List<Vendedor> list = new ArrayList<Vendedor>();
        //Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            //trans = session.beginTransaction();

            list = session.createQuery("from Vendedor").list();

            //trans.commit();
        } catch (HibernateException e) {
            //if (trans != null) { trans.rollback(); }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
        return list;
    }

}
