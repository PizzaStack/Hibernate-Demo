package com.revature;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder()
					.applySettings(config.getProperties());
		
		SessionFactory factory = config.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		
		Artist pizzaParty = new Artist(276, "PizzaParty");
//		session.beginTransaction();
//		session.save(pizzaParty);
//		session.getTransaction().commit();
		
		pizzaParty.setName("Bon Jovi");
		session.beginTransaction();
		session.update(pizzaParty);
		session.getTransaction().commit();
		
		pizzaParty.setArtistId(277);
		session.update(pizzaParty);
		
//		List<Artist> artists = session.createCriteria(Artist.class).list();
//		for (Artist a : artists) {
//			System.out.println(a);
//		}
		Artist random;
		random = (Artist) session.get(Artist.class, 150);
		System.out.println(random);
		
		session.close();
		factory.close();
	}

}
