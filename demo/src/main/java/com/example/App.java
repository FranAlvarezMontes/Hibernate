package com.example;

import java.util.Random;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.entity.Foo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        setupHibernate();


    }

    public static void setupHibernate() {
        
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Foo.class)
                .buildMetadata()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        var tr = session.beginTransaction();
        
        Random rand = new Random();
        int aleatorio = rand.nextInt(1000) + 1; // Genera un número entre 1 y 100 (ambos inclusive)

        Foo foo = new Foo();
        foo.id = aleatorio;
        foo.name = "Nombre1";
        foo.dni = "123456W";
        session.persist(foo);       //Guarda datos en la tabla
        
        
        /* */
        var fooModif = session.get(Foo.class, 44);

        if (null != fooModif){
            //fooModif.dni = "modifDNI2";
            session.remove(fooModif);
            session.persist(fooModif);
        }





        tr.commit();
        session.close();            //Libera los objetos de la memoria de hibernate

    }
}
