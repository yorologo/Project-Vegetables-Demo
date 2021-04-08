package com.example.demo.dao;

import com.example.demo.model.Compra;
import com.example.demo.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Date;
//import java.util.Locale;
//import java.text.SimpleDateFormat;


/**
 * Returns the Database Access Object (DAO) for our Compra class.
 */
@Service
public class CompraDao {

   /*
   * Returns one Compra object or null if not found
   */
    public Compra getByID(Integer id) {
        Compra compra = null;
        //Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            //trans = session.beginTransaction();

            compra = (Compra) session.get(Compra.class, id);

            //trans.commit();
        } catch (HibernateException e) {
            //if (trans != null) { trans.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return compra;
    }


   /*
   * Adds a new Compra object and return the id
   */
    public int add(Compra compra) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        int id = 0;

        try {
            trans = session.beginTransaction();

            id = (int) session.save(compra);

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
   * Updates Compra object
   */
    public void update(Compra compra) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();

            session.update(compra);

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
   * Deletes one Compra record
   */
    public boolean deleteByID(Integer id) {
        boolean deleted = false;
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();

            Compra compra = (Compra) session.get(Compra.class, id);

            if (compra != null) {
                session.delete(compra);
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
   * Returns a list of Compra objects
   */
    public List<Compra> getAll() {
        List<Compra> list = new ArrayList<Compra>();
        //Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            //trans = session.beginTransaction();

            list = session.createQuery("from Compra").list();

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
