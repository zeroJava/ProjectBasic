package testCasesBasic.databasesEngineTest;

import static org.junit.Assert.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.Test;

import basicApplication.dataClass.ActorHibernateBasic;
import basicApplication.databaseEngine.DatabaseSearchEng;

public class DatabaseSearchEngineTest {

	private Configuration configuration;
	private ServiceRegistry serviceRegistry;
	private SessionFactory factory;
	private Session session;

	@Before
	public void setup()
	{
		try
		{
			configuration = new Configuration().configure();
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			factory = configuration.buildSessionFactory(serviceRegistry);
		} 
		catch (HibernateException ex)
		{
			System.out.println("Error");
			System.exit(0);
		}
		
		session = factory.openSession();
	}
	
//	@Test
//	public void testSearchForUserUsingTheID()
//	{
//		DatabaseSearchEng searchEng = new DatabaseSearchEng();
//		searchEng.retrieveAllDataUsingID(session, 1);
//		assertEquals("LANCEL", searchEng);
//		//fail("Not yet implemented");
//	}
	
//	@Test
//	public void testSearchForUserUsingFirstName()
//	{
//		Transaction transaction = session.beginTransaction();
//		DatabaseSearchEng searchEng = new DatabaseSearchEng();
//		ActorHibernateBasic retrieveAllDataUsindFirstName = searchEng.retrieveAllDataUsingFirstName(session, "Lancel");
//		;
//		transaction.commit();
//	}
	
	@Test
	public void testSearchForUserUsingLastName()
	{
		Transaction transaction = session.beginTransaction();
		DatabaseSearchEng searchEng = new DatabaseSearchEng();
		System.out.println(searchEng.retrieveAllDataUsingLastName(session, "MAHOGANY"));
		//assertEquals("201", retrieveAllDataUsingLastName.getID());
		transaction.commit();
		session.close();
	}

}
