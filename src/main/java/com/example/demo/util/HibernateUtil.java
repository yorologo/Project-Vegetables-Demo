package com.example.demo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();

            /* // Create the SessionFactory from annotations
            return new AnnotationConfiguration().configure().
                        addPackage("com.example.demo.model").
                        addAnnotatedClass(Comprador.class).
                        addAnnotatedClass(Vendedor.class).
                        addAnnotatedClass(Compra.class).
                        addAnnotatedClass(Item.class).
                        addAnnotatedClass(Producto.class).
                        addAnnotatedClass(UnidadMedida.class).
                         buildSessionFactory(); */
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
