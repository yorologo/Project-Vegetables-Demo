package com.example.demo.dao;

import com.example.demo.model.Item;
import com.example.demo.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;
//import java.util.Date;
//import java.util.Locale;
//import java.text.SimpleDateFormat;


/**
 * Returns the Database Access Object (DAO) for our Item class.
 */
public class ItemDao {

   /*
   * Returns one Item object or null if not found
   */
    public Item getByID(Integer id) {
        Item item = null;
        //Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            //trans = session.beginTransaction();

            item = (Item) session.get(Item.class, id);

            //trans.commit();
        } catch (HibernateException e) {
            //if (trans != null) { trans.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return item;
    }


   /*
   * Adds a new Item object and return the id
   */
    public int add(Item item) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        int id = 0;

        try {
            trans = session.beginTransaction();

            id = (int) session.save(item);

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
   * Updates Item object
   */
    public void update(Item item) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();

            session.update(item);

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
   * Deletes one Item record
   */
    public boolean deleteByID(Integer id) {
        boolean deleted = false;
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();

            Item item = (Item) session.get(Item.class, id);

            if (item != null) {
                session.delete(item);
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
   * Returns a list of Item objects
   */
    public List<Item> getAll() {
        List<Item> list = new ArrayList<Item>();
        //Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            //trans = session.beginTransaction();

            list = session.createQuery("from Item").list();

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
