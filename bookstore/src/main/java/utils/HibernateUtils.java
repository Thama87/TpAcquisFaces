package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		}
		catch (Throwable e) {
			System.err.println("Erreur à la création de la session : " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	public static void shutdown() {
		getSessionFactory().close();
	}
}