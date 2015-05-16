package basicApplication.databaseEngine;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilitiess {
	
	private static SessionFactory sessionFactory;
	
	// HibernateUtilities is the the place where our session-factory is made 
	
	static 
	{
		try 
		{
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch(Throwable ex)
		{
			System.out.println("Error: HibernateUntilities could not configure");
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;	
	}

}
