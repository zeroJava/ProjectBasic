package testCasesBasic.databasesEngineTest;

import static org.junit.Assert.*;

import java.util.List;

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

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

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
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		DatabaseSearchEng searchEng = new DatabaseSearchEng();
		List<ActorHibernateBasic> retrieveAllDataUsingLastName = (List<ActorHibernateBasic>) searchEng.retrieveAllDataUsingLastName(session, "MAHOGANY");
		System.out.println(retrieveAllDataUsingLastName);
		System.out.println("kgkjkjgkj");
		//assertEquals("201", retrieveAllDataUsingLastName.getID());
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testt()
	{
		session.clear();
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("findIDByLastName").setString("lastName", "MAHOGANY");
//		ActorHibernateBasic basic = (ActorHibernateBasic) query.uniqueResult();
		System.out.println(query.uniqueResult());
		transaction.commit();
	}
	
	@Test
	public void tetst()
	{
		session.clear();
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Object user = session.get(ActorHibernateBasic.class, 1);
		System.out.println(user);
		System.out.println("syso");
		transaction.commit();
	}

}
