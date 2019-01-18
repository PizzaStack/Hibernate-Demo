package com.revature;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class HibernateMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties());

		SessionFactory factory = config.buildSessionFactory(builder.build());

		Session session = factory.openSession();

//		Artist pizzaParty = new Artist(276, "PizzaParty");
//		session.beginTransaction();
//		session.save(pizzaParty);
//		session.getTransaction().commit();

//		pizzaParty.setName("Bon Jovi");
//		session.beginTransaction();
//		session.update(pizzaParty);
//		session.getTransaction().commit();
//		
//		pizzaParty.setArtistId(277);
//		session.update(pizzaParty);

//		List<Artist> artists = session.createCriteria(Artist.class).list();
//		for (Artist a : artists) {
//			System.out.println(a);
//		}
//		Artist random;
//		random = (Artist) session.get(Artist.class, 150);
//		System.out.println(random);
//		
//		Album album = (Album) session.get(Album.class, 5);
//		System.out.println(album);
//		
//		List<Album> audioslave = session.getNamedQuery("findAlbumByTitle").setString("titleVar", "Audioslave").list();
//		for(Album a : audioslave) {
//			System.out.println(a);
//		}

//		List<Album> filteredAlbums = session.createCriteria(Album.class)
//				.add(Restrictions.between("albumid", 1, 10))
//				.addOrder(Order.asc("title"))
//				.list();

//		for(Album a : filteredAlbums) {
//			System.out.println(a);
//		}

		List<Album> allAlbums = session.createQuery("from Album").list();
		for (Album a : allAlbums) {
			System.out.println(a);
		}

		session.close();
		factory.close();
	}

}
