package com.example.demo.dao;

import com.example.demo.model.UnidadMedida;
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
 * Returns the Database Access Object (DAO) for our UnidadMedida class.
 */
@Service
public class UnidadMedidaDao {

   /*
   * Returns one UnidadMedida object or null if not found
   */
    public UnidadMedida getByID(Integer id) {
        UnidadMedida unidadmedida = null;
        //Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            //trans = session.beginTransaction();

            unidadmedida = (UnidadMedida) session.get(UnidadMedida.class, id);

            //trans.commit();
        } catch (HibernateException e) {
            //if (trans != null) { trans.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return unidadmedida;
    }


   /*
   * Adds a new UnidadMedida object and return the id
   */
    public int add(UnidadMedida unidadmedida) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        int id = 0;

        try {
            trans = session.beginTransaction();

            id = (int) session.save(unidadmedida);

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
   * Updates UnidadMedida object
   */
    public void update(UnidadMedida unidadmedida) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();

            session.update(unidadmedida);

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
   * Deletes one UnidadMedida record
   */
    public boolean deleteByID(Integer id) {
        boolean deleted = false;
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();

            UnidadMedida unidadmedida = (UnidadMedida) session.get(UnidadMedida.class, id);

            if (unidadmedida != null) {
                session.delete(unidadmedida);
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
   * Returns a list of UnidadMedida objects
   */
    public List<UnidadMedida> getAll() {
        List<UnidadMedida> list = new ArrayList<UnidadMedida>();
        //Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            //trans = session.beginTransaction();

            list = session.createQuery("from UnidadMedida").list();

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
