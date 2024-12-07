package com.klef.jfsd.exam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("Hibernate.cfg.xml").build();
        Metadata md = new MetadataSources().getMetadataBuilder(ssr).build();
        
        SessionFactory sf = md.getSessionFactoryBuilder().build();
        Session s = sf.openSession();
        Transaction t;

        // Create and save Vehicle objects
        Car car = new Car();
        car.setName("Tesla Model S");
        car.setType("Electric");
        car.setMaxSpeed(200);
        car.setColor("Red");
        car.setNumberOfDoors(4);
        t = s.beginTransaction();
        s.save(car);
        t.commit();

        Truck truck = new Truck();
        truck.setName("Volvo FH16");
        truck.setType("Diesel");
        truck.setMaxSpeed(120);
        truck.setColor("Blue");
        truck.setLoadCapacity(25000);
        t = s.beginTransaction();
        s.save(truck);
        t.commit();

        s.close();
        ssr.close();
        sf.close();

        
    }
}
