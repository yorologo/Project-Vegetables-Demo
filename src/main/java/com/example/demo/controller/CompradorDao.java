package com.example.demo.controller;

import com.example.demo.model.Comprador;
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
 * Returns the Database Access Object (DAO) for our Comprador class.
 */
public class CompradorDao {

   /*
   * Returns one Comprador object or null if not found
   */
    public Comprador getByID(Integer id) {
        Comprador comprador = null;
        //Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            //trans = session.beginTransaction();

            Comprador comprador = (Comprador) session.get(Comprador.class, id);

            //trans.commit();
        } catch (HibernateException e) {
            //if (trans != null) { trans.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return comprador;
    }


   /*
   * Adds a new Comprador object and return the id
   */
    public int add(Comprador comprador) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        int id = 0;

        try {
            trans = session.beginTransaction();

            id = (int) session.save(comprador);

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
   * Updates Comprador object
   */
    public void update(Comprador comprador) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();

            session.update(comprador);

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
   * Deletes one Comprador record
   */
    public boolean deleteByID(Integer id) {
        boolean deleted = false;
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();

            Comprador comprador = (Comprador) session.get(Comprador.class, id);

            if (comprador != null) {
                session.delete(comprador);
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
   * Returns a list of Comprador objects
   */
    public List<Comprador> getAll() {
        List<Comprador> list = new ArrayList<Comprador>();
        //Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            //trans = session.beginTransaction();

            list = session.createQuery("from Comprador").list();

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
